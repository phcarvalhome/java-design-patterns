package com.phcarvalhome.pattern.composite.core;

import com.phcarvalhome.pattern.builder.business.MarketOperationSchedule;
import com.phcarvalhome.pattern.prototype.business.vo.MarketOperationTypeEnum;
import com.phcarvalhome.pattern.prototype.business.vo.StockTypeEnum;

import java.time.LocalDate;
import java.time.LocalTime;

public class SingleMarketOperationScheduleEvent implements IMarketOperationScheduleEvent {

    private MarketOperationSchedule schedule;

    public SingleMarketOperationScheduleEvent(MarketOperationSchedule schedule) {
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

    public MarketOperationSchedule getSchedule() {
        return schedule;
    }

    @Override
    public String toString() {
        return "SingleMarketOperationScheduleEvent{" +
                "schedule=" + schedule +
                '}';
    }
}
