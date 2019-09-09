package com.phcarvalhome.pattern.builder.core;

import com.phcarvalhome.pattern.builder.business.MarketOperationSchedule;
import com.phcarvalhome.pattern.prototype.business.vo.MarketOperationTypeEnum;
import com.phcarvalhome.pattern.prototype.business.vo.StockTypeEnum;

import java.time.LocalDate;
import java.time.LocalTime;

public interface IMarketOperationScheduleBuilder {

    MarketOperationScheduleBuilder initialize();

    MarketOperationScheduleBuilder ofStockType(StockTypeEnum stockType);

    MarketOperationScheduleBuilder ofMarketOperationType(MarketOperationTypeEnum marketOperationType);

    MarketOperationScheduleBuilder ofStockQuantity(int stockQuantity);

    MarketOperationScheduleBuilder from(LocalDate startDate);

    MarketOperationScheduleBuilder to(LocalDate endDate);

    MarketOperationScheduleBuilder at(LocalTime scheduledTime);

    MarketOperationScheduleBuilder daily();

    MarketOperationScheduleBuilder weekly();

    MarketOperationScheduleBuilder monthly();

    MarketOperationScheduleBuilder active();

    MarketOperationScheduleBuilder inactive();

    MarketOperationScheduleBuilder ofNotificationEmail(String notificationEmail);

    MarketOperationSchedule getInstance();
}
