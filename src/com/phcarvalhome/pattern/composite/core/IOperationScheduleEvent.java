package com.phcarvalhome.pattern.composite.core;

import com.phcarvalhome.pattern.builder.business.OperationSchedule;
import com.phcarvalhome.pattern.prototype.business.vo.OperationTypeEnum;
import com.phcarvalhome.pattern.prototype.business.vo.StockTypeEnum;

import java.time.LocalDate;
import java.time.LocalTime;

public interface IOperationScheduleEvent {

    OperationSchedule getSchedule();

    LocalDate getDate();

    LocalTime getScheduledTime();

    OperationTypeEnum getOperationType();

    int getStockQuantity();

    StockTypeEnum getStockType();

    double getPrice();
}
