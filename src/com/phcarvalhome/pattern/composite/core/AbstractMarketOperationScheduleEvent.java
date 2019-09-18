package com.phcarvalhome.pattern.composite.core;

import com.phcarvalhome.pattern.builder.business.MarketOperationSchedule;
import com.phcarvalhome.pattern.builder.business.vo.RecurrenceTypeEnum;
import com.phcarvalhome.pattern.prototype.business.vo.MarketOperationTypeEnum;
import com.phcarvalhome.pattern.prototype.business.vo.StockTypeEnum;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class AbstractMarketOperationScheduleEvent implements IMarketOperationScheduleEvent{

    private MarketOperationSchedule schedule;
    private LocalDate date;

    protected AbstractMarketOperationScheduleEvent(MarketOperationSchedule schedule, LocalDate date) {
        this.schedule = schedule;
        this.date = date;
    }

    public static IMarketOperationScheduleEvent from(MarketOperationSchedule schedule){

        if(schedule.getRecurrenceType().equals(RecurrenceTypeEnum.NONE))
            return new SingleMarketOperationScheduleEvent(schedule, schedule.getStartDate());
        else
            return recurrenceFrom(schedule);
    }

    private static IMarketOperationScheduleEvent recurrenceFrom(MarketOperationSchedule schedule) {

        if(schedule.getRecurrenceType().equals(RecurrenceTypeEnum.DAILY))
            return dailyFrom(schedule, schedule.getStartDate());
        else if(schedule.getRecurrenceType().equals(RecurrenceTypeEnum.WEEKLY))
            return weeklyFrom(schedule, schedule.getStartDate());
        else if(schedule.getRecurrenceType().equals(RecurrenceTypeEnum.MONTHLY))
            return monthlyFrom(schedule, schedule.getStartDate());

        throw new RuntimeException("The schedule parameter is invalid!");
    }

    private static IMarketOperationScheduleEvent dailyFrom(MarketOperationSchedule schedule, LocalDate date){

        //TODO Instead here, validate date and recurrence in schedule builder...
//        if(date.isAfter(schedule.getEndDate()))
//            throw new RuntimeException("The date parameter is invalid!");

        if(date.isEqual(schedule.getEndDate()))
            return new SingleMarketOperationScheduleEvent(schedule, date);

        return new CompositeMarketOperationScheduleEvent(schedule, date, dailyFrom(schedule, date.plusDays(1)));
    }

    private static IMarketOperationScheduleEvent weeklyFrom(MarketOperationSchedule schedule, LocalDate date){

        if(schedule.getEndDate().isBefore(date.plusWeeks(1)))
            return new SingleMarketOperationScheduleEvent(schedule, date);

        return new CompositeMarketOperationScheduleEvent(schedule, date, weeklyFrom(schedule, date.plusWeeks(1)));
    }

    private static IMarketOperationScheduleEvent monthlyFrom(MarketOperationSchedule schedule, LocalDate date){

        if(schedule.getEndDate().isBefore(date.plusMonths(1)))
            return new SingleMarketOperationScheduleEvent(schedule, date);

        return new CompositeMarketOperationScheduleEvent(schedule, date, monthlyFrom(schedule, date.plusMonths(1)));
    }

    @Override
    public MarketOperationSchedule getSchedule() {
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
    public MarketOperationTypeEnum getOperationType() {
        return schedule.getMarketOperation().getType();
    }

    @Override
    public int getStockQuantity() {
        return schedule.getMarketOperation().getStockQuantity();
    }

    @Override
    public StockTypeEnum getStockType() {
        return schedule.getMarketOperation().getStock().getType();
    }

    @Override
    public double getPrice() {
        return schedule.getMarketOperation().getStock().getPrice();
    }
}
