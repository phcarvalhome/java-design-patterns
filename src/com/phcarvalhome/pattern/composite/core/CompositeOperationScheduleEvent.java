package com.phcarvalhome.pattern.composite.core;

import com.phcarvalhome.pattern.builder.business.OperationSchedule;

import java.time.LocalDate;

public class CompositeOperationScheduleEvent
        extends AbstractOperationScheduleEvent {

    private IOperationScheduleEvent nextEvent;

    public CompositeOperationScheduleEvent(OperationSchedule schedule,
                                                 LocalDate date,
                                                 IOperationScheduleEvent nextEvent) {
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
