package com.phcarvalhome.pattern.composite.core;

import com.phcarvalhome.pattern.builder.business.MarketOperationSchedule;
import com.phcarvalhome.pattern.prototype.business.vo.MarketOperationTypeEnum;
import com.phcarvalhome.pattern.prototype.business.vo.StockTypeEnum;

import java.time.LocalDate;
import java.time.LocalTime;

public interface IMarketOperationScheduleEvent {

    MarketOperationSchedule getSchedule();

    LocalDate getDate();

    LocalTime getScheduledTime();

    MarketOperationTypeEnum getOperationType();

    int getStockQuantity();

    StockTypeEnum getStockType();

    double getPrice();
}
