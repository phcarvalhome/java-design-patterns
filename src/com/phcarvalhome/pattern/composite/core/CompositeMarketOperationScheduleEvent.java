package com.phcarvalhome.pattern.composite.core;

import com.phcarvalhome.pattern.builder.business.MarketOperationSchedule;
import com.phcarvalhome.pattern.prototype.business.vo.MarketOperationTypeEnum;
import com.phcarvalhome.pattern.prototype.business.vo.StockTypeEnum;

import java.time.LocalDate;
import java.time.LocalTime;

public class CompositeMarketOperationScheduleEvent implements IMarketOperationScheduleEvent {

    private IMarketOperationScheduleEvent nextEvent;
    private MarketOperationSchedule schedule;

    public CompositeMarketOperationScheduleEvent(IMarketOperationScheduleEvent nextEvent,
                                                 MarketOperationSchedule schedule) {
        this.nextEvent = nextEvent;
        this.schedule = schedule;
    }

    @Override
    public LocalDate getStartDate() {
        return schedule.getStartDate();
    }

    @Override
    public LocalDate getEndDate() {
        return schedule.getEndDate();
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
        return schedule.getMarketOperation().getStockQuantity() + nextEvent.getStockQuantity();
    }

    @Override
    public StockTypeEnum getStockType() {
        return schedule.getMarketOperation().getStock().getType();
    }

    @Override
    public double getPrice() {
        return schedule.getMarketOperation().getStock().getPrice() + nextEvent.getPrice();
    }

    public IMarketOperationScheduleEvent getNextEvent() {
        return nextEvent;
    }

    public MarketOperationSchedule getSchedule() {
        return schedule;
    }

    @Override
    public String toString() {
        return "SingleMarketOperationScheduleEvent{" +
                "event=" + nextEvent +
                ", schedule=" + schedule +
                '}';
    }
}
