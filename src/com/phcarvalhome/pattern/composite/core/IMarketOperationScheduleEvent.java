package com.phcarvalhome.pattern.composite.core;

import com.phcarvalhome.pattern.prototype.business.vo.MarketOperationTypeEnum;
import com.phcarvalhome.pattern.prototype.business.vo.StockTypeEnum;

import java.time.LocalDate;
import java.time.LocalTime;

public interface IMarketOperationScheduleEvent {

    LocalDate getStartDate();

    LocalDate getEndDate();

    LocalTime getScheduledTime();

    MarketOperationTypeEnum getOperationType();

    int getStockQuantity();

    StockTypeEnum getStockType();

    double getPrice();
}
