package com.phcarvalhome.pattern.builder.business;

import com.phcarvalhome.pattern.builder.business.vo.RecurrenceTypeEnum;
import com.phcarvalhome.pattern.prototype.core.MarketOperation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class MarketOperationSchedule {

    private MarketOperation marketOperation;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime scheduledTime;
    private RecurrenceTypeEnum recurrenceType;
    private boolean active;
    private List<String> notificationEmailList;

    public MarketOperationSchedule(MarketOperation marketOperation) {
        this.marketOperation = marketOperation;
        startDate = LocalDate.now();
        endDate = LocalDate.now();
        scheduledTime = LocalTime.now();
        recurrenceType = RecurrenceTypeEnum.NONE;
        active = true;
        notificationEmailList = new ArrayList<>();
    }

    public MarketOperation getMarketOperation() {
        return marketOperation;
    }

    public void setMarketOperation(MarketOperation marketOperation) {
        this.marketOperation = marketOperation;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalTime getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(LocalTime scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public RecurrenceTypeEnum getRecurrenceType() {
        return recurrenceType;
    }

    public void setRecurrenceType(RecurrenceTypeEnum recurrenceType) {
        this.recurrenceType = recurrenceType;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<String> getNotificationEmailList() {
        return notificationEmailList;
    }

    @Override
    public String toString() {
        return "MarketOperationSchedule{" +
                "marketOperation=" + marketOperation +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", scheduledTime=" + scheduledTime +
                ", recurrenceType=" + recurrenceType +
                ", active=" + active +
                ", notificationEmailList=" + notificationEmailList +
                '}';
    }
}
