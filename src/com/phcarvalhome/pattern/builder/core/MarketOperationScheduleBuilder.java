package com.phcarvalhome.pattern.builder.core;

import com.phcarvalhome.pattern.builder.business.MarketOperationSchedule;
import com.phcarvalhome.pattern.builder.business.vo.RecurrenceTypeEnum;
import com.phcarvalhome.pattern.prototype.core.MarketOperation;
import com.phcarvalhome.pattern.prototype.business.vo.MarketOperationTypeEnum;
import com.phcarvalhome.pattern.prototype.core.Stock;
import com.phcarvalhome.pattern.prototype.business.vo.StockTypeEnum;

import java.time.LocalDate;
import java.time.LocalTime;

public class MarketOperationScheduleBuilder implements IMarketOperationScheduleBuilder {

    private MarketOperationSchedule instance;
    private StockTypeEnum stockType;
    private MarketOperationTypeEnum marketOperationType;
    private int stockQuantity;

    public MarketOperationScheduleBuilder() {
        instance = new MarketOperationSchedule(null);
    }

    @Override
    public MarketOperationScheduleBuilder initialize() {
        instance = new MarketOperationSchedule(null);

        return this;
    }

    @Override
    public MarketOperationScheduleBuilder ofStockType(StockTypeEnum stockType) {
        this.stockType = stockType;

        return this;
    }

    @Override
    public MarketOperationScheduleBuilder ofMarketOperationType(MarketOperationTypeEnum marketOperationType) {
        this.marketOperationType = marketOperationType;

        return this;
    }

    @Override
    public MarketOperationScheduleBuilder ofStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;

        return this;
    }

    @Override
    public MarketOperationScheduleBuilder from(LocalDate startDate) {
        instance.setStartDate(startDate);

        return this;
    }

    @Override
    public MarketOperationScheduleBuilder to(LocalDate endDate) {
        instance.setEndDate(endDate);

        return this;
    }

    @Override
    public MarketOperationScheduleBuilder at(LocalTime scheduledTime) {
        instance.setScheduledTime(scheduledTime);

        return this;
    }

    @Override
    public MarketOperationScheduleBuilder daily() {
        instance.setRecurrenceType(RecurrenceTypeEnum.DAILY);

        return this;
    }

    @Override
    public MarketOperationScheduleBuilder weekly() {
        instance.setRecurrenceType(RecurrenceTypeEnum.WEEKLY);

        return this;
    }

    @Override
    public MarketOperationScheduleBuilder monthly() {
        instance.setRecurrenceType(RecurrenceTypeEnum.MONTHLY);

        return this;
    }

    @Override
    public MarketOperationScheduleBuilder active() {
        instance.setActive(true);

        return this;
    }

    @Override
    public MarketOperationScheduleBuilder inactive() {
        instance.setActive(false);

        return this;
    }

    @Override
    public MarketOperationScheduleBuilder ofNotificationEmail(String notificationEmail) {
        instance.getNotificationEmailList().add(notificationEmail);

        return this;
    }

    @Override
    public MarketOperationSchedule getInstance() {
        Stock stock = buildStock();
        MarketOperation marketOperation = buildMarketOperation(stock);

        instance.setMarketOperation(marketOperation);

        return instance;
    }

    private Stock buildStock() {

        if(stockType == null)
            throw new RuntimeException("The required stockType field is null!");

        return new Stock(stockType);
    }

    private MarketOperation buildMarketOperation(Stock stock) {

        if(marketOperationType == null)
            throw new RuntimeException("The required marketOperationType field is null!");

        if(stockQuantity == 0)
            throw new RuntimeException("The required stockQuantity field is 0!");

        return new MarketOperation(marketOperationType, stock, stockQuantity);
    }
}
