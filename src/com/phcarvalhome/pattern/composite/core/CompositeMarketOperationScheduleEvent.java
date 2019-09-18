package com.phcarvalhome.pattern.composite.core;

import com.phcarvalhome.pattern.builder.business.MarketOperationSchedule;

import java.time.LocalDate;

public class CompositeMarketOperationScheduleEvent extends AbstractMarketOperationScheduleEvent {

    private IMarketOperationScheduleEvent nextEvent;

    public CompositeMarketOperationScheduleEvent(MarketOperationSchedule schedule,
                                                 LocalDate date,
                                                 IMarketOperationScheduleEvent nextEvent) {
        super(schedule, date);
        this.nextEvent = nextEvent;
    }

    @Override
    public int getStockQuantity() {
        return super.getStockQuantity() + nextEvent.getStockQuantity();
    }

    @Override
    public double getPrice() {
        return super.getPrice() + nextEvent.getPrice();
    }
}
