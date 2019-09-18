package com.phcarvalhome.pattern.builder.core;

import com.phcarvalhome.pattern.builder.business.OperationSchedule;
import com.phcarvalhome.pattern.prototype.business.vo.OperationTypeEnum;
import com.phcarvalhome.pattern.prototype.business.vo.StockTypeEnum;

import java.time.LocalDate;
import java.time.LocalTime;

public interface IOperationScheduleBuilder {

    OperationScheduleBuilder initialize();

    OperationScheduleBuilder ofStockType(StockTypeEnum stockType);

    OperationScheduleBuilder ofOperationType(OperationTypeEnum operationType);

    OperationScheduleBuilder ofStockQuantity(int stockQuantity);

    OperationScheduleBuilder from(LocalDate startDate);

    OperationScheduleBuilder to(LocalDate endDate);

    OperationScheduleBuilder at(LocalTime scheduledTime);

    OperationScheduleBuilder daily();

    OperationScheduleBuilder weekly();

    OperationScheduleBuilder monthly();

    OperationScheduleBuilder active();

    OperationScheduleBuilder inactive();

    OperationScheduleBuilder ofNotificationEmail(String notificationEmail);

    OperationSchedule getInstance();
}
