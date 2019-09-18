package com.phcarvalhome.pattern.builder.core;

import com.phcarvalhome.pattern.builder.business.OperationSchedule;
import com.phcarvalhome.pattern.builder.business.vo.RecurrenceTypeEnum;
import com.phcarvalhome.pattern.prototype.core.Operation;
import com.phcarvalhome.pattern.prototype.business.vo.OperationTypeEnum;
import com.phcarvalhome.pattern.prototype.core.Stock;
import com.phcarvalhome.pattern.prototype.business.vo.StockTypeEnum;

import java.time.LocalDate;
import java.time.LocalTime;

public class OperationScheduleBuilder implements IOperationScheduleBuilder {

    private OperationSchedule instance;
    private StockTypeEnum stockType;
    private OperationTypeEnum operationType;
    private int stockQuantity;

    public OperationScheduleBuilder() {
        instance = new OperationSchedule(null);
    }

    @Override
    public OperationScheduleBuilder initialize() {
        instance = new OperationSchedule(null);

        return this;
    }

    @Override
    public OperationScheduleBuilder ofStockType(StockTypeEnum stockType) {
        this.stockType = stockType;

        return this;
    }

    @Override
    public OperationScheduleBuilder ofOperationType(OperationTypeEnum operationType) {
        this.operationType = operationType;

        return this;
    }

    @Override
    public OperationScheduleBuilder ofStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;

        return this;
    }

    @Override
    public OperationScheduleBuilder from(LocalDate startDate) {
        instance.setStartDate(startDate);

        return this;
    }

    @Override
    public OperationScheduleBuilder to(LocalDate endDate) {
        instance.setEndDate(endDate);

        return this;
    }

    @Override
    public OperationScheduleBuilder at(LocalTime scheduledTime) {
        instance.setScheduledTime(scheduledTime);

        return this;
    }

    @Override
    public OperationScheduleBuilder daily() {
        instance.setRecurrenceType(RecurrenceTypeEnum.DAILY);

        return this;
    }

    @Override
    public OperationScheduleBuilder weekly() {
        instance.setRecurrenceType(RecurrenceTypeEnum.WEEKLY);

        return this;
    }

    @Override
    public OperationScheduleBuilder monthly() {
        instance.setRecurrenceType(RecurrenceTypeEnum.MONTHLY);

        return this;
    }

    @Override
    public OperationScheduleBuilder active() {
        instance.setActive(true);

        return this;
    }

    @Override
    public OperationScheduleBuilder inactive() {
        instance.setActive(false);

        return this;
    }

    @Override
    public OperationScheduleBuilder ofNotificationEmail(String notificationEmail) {
        instance.getNotificationEmailList().add(notificationEmail);

        return this;
    }

    @Override
    public OperationSchedule getInstance() {
        Stock stock = buildStock();
        Operation operation = buildOperation(stock);

        instance.setOperation(operation);

        return instance;
    }

    private Stock buildStock() {

        if(stockType == null)
            throw new RuntimeException("The required stockType field is null!");

        return new Stock(stockType);
    }

    private Operation buildOperation(Stock stock) {

        if(operationType == null)
            throw new RuntimeException("The required operationType field is null!");

        if(stockQuantity == 0)
            throw new RuntimeException("The required stockQuantity field is 0!");

        return new Operation(operationType, stock, stockQuantity);
    }
}
