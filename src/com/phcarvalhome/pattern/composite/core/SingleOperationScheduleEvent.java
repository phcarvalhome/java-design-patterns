package com.phcarvalhome.pattern.composite.core;

import com.phcarvalhome.pattern.builder.business.OperationSchedule;

import java.time.LocalDate;

public class SingleOperationScheduleEvent
        extends AbstractOperationScheduleEvent {

    public SingleOperationScheduleEvent(OperationSchedule schedule,
                                              LocalDate date) {
        super(schedule, date);
    }
}
