package com.phcarvalhome.pattern.composite.core;

import com.phcarvalhome.pattern.builder.business.MarketOperationSchedule;

import java.time.LocalDate;

public class SingleMarketOperationScheduleEvent extends AbstractMarketOperationScheduleEvent {

    public SingleMarketOperationScheduleEvent(MarketOperationSchedule schedule,
                                              LocalDate date) {
        super(schedule, date);
    }
}
