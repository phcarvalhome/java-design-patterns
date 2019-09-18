package com.phcarvalhome.pattern.composite.core;

import com.phcarvalhome.pattern.builder.business.OperationSchedule;
import com.phcarvalhome.pattern.builder.business.vo.RecurrenceTypeEnum;
import com.phcarvalhome.pattern.prototype.business.vo.OperationTypeEnum;
import com.phcarvalhome.pattern.prototype.business.vo.StockTypeEnum;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class AbstractOperationScheduleEvent implements IOperationScheduleEvent{

    private OperationSchedule schedule;
    private LocalDate date;

    protected AbstractOperationScheduleEvent(OperationSchedule schedule, LocalDate date) {
        this.schedule = schedule;
        this.date = date;
    }

    public static IOperationScheduleEvent from(OperationSchedule schedule){

        if(schedule.getRecurrenceType().equals(RecurrenceTypeEnum.NONE))
            return new SingleOperationScheduleEvent(schedule, schedule.getStartDate());
        else
            return recurrenceFrom(schedule);
    }

    private static IOperationScheduleEvent recurrenceFrom(OperationSchedule schedule) {

        if(schedule.getRecurrenceType().equals(RecurrenceTypeEnum.DAILY))
            return dailyFrom(schedule, schedule.getStartDate());
        else if(schedule.getRecurrenceType().equals(RecurrenceTypeEnum.WEEKLY))
            return weeklyFrom(schedule, schedule.getStartDate());
        else if(schedule.getRecurrenceType().equals(RecurrenceTypeEnum.MONTHLY))
            return monthlyFrom(schedule, schedule.getStartDate());

        throw new RuntimeException("The schedule parameter is invalid!");
    }

    private static IOperationScheduleEvent dailyFrom(OperationSchedule schedule, LocalDate date){

        //TODO Instead here, validate date and recurrence in schedule builder...
//        if(date.isAfter(schedule.getEndDate()))
//            throw new RuntimeException("The date parameter is invalid!");

        if(date.isEqual(schedule.getEndDate()))
            return new SingleOperationScheduleEvent(schedule, date);

        return new CompositeOperationScheduleEvent(schedule, date, dailyFrom(schedule, date.plusDays(1)));
    }

    private static IOperationScheduleEvent weeklyFrom(OperationSchedule schedule, LocalDate date){

        if(schedule.getEndDate().isBefore(date.plusWeeks(1)))
            return new SingleOperationScheduleEvent(schedule, date);

        return new CompositeOperationScheduleEvent(schedule, date, weeklyFrom(schedule, date.plusWeeks(1)));
    }

    private static IOperationScheduleEvent monthlyFrom(OperationSchedule schedule, LocalDate date){

        if(schedule.getEndDate().isBefore(date.plusMonths(1)))
            return new SingleOperationScheduleEvent(schedule, date);

        return new CompositeOperationScheduleEvent(schedule, date, monthlyFrom(schedule, date.plusMonths(1)));
    }

    @Override
    public OperationSchedule getSchedule() {
        return schedule;
    }

    @Override
    public LocalDate getDate() {
        return date;
    }

    @Override
    public LocalTime getScheduledTime() {
        return schedule.getScheduledTime();
    }

    @Override
    public OperationTypeEnum getOperationType() {
        return schedule.getOperation().getType();
    }

    @Override
    public int getStockQuantity() {
        return schedule.getOperation().getStockQuantity();
    }

    @Override
    public StockTypeEnum getStockType() {
        return schedule.getOperation().getStock().getType();
    }

    @Override
    public double getPrice() {
        return schedule.getOperation().getStock().getPrice();
    }
}
