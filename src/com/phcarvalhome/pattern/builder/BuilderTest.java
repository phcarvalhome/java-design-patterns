package com.phcarvalhome.pattern.builder;

import com.phcarvalhome.pattern.builder.business.MarketOperationSchedule;
import com.phcarvalhome.pattern.builder.client.BuilderClient;
import com.phcarvalhome.pattern.builder.core.MarketOperationScheduleBuilder;
import com.phcarvalhome.pattern.prototype.business.vo.MarketOperationTypeEnum;
import com.phcarvalhome.pattern.prototype.business.vo.StockTypeEnum;

import java.time.LocalDate;
import java.time.LocalTime;

public class BuilderTest {

    public static void main(String[] args) {
        buildMarketOperationScheduleForNextWeekInAfternoonInEveryDayOnActivation();
        buildMarketOperationScheduleForThisYearInEveryMonthOnDeactivationWithNotification();
    }

    private static void buildMarketOperationScheduleForNextWeekInAfternoonInEveryDayOnActivation() {
        System.out.println(">>> TEST BEGINNING >>> buildMarketOperationScheduleForNextWeekInAfternoonInEveryDayOnActivation");

        MarketOperationScheduleBuilder builder = new MarketOperationScheduleBuilder();
        BuilderClient builderClient = new BuilderClient(builder);

        MarketOperationSchedule marketOperationSchedule = builderClient.getMarketOperationScheduleBuilder()
                .ofStockType(StockTypeEnum.PETR4)
                .ofMarketOperationType(MarketOperationTypeEnum.SELL)
                .ofStockQuantity(10)
                .from(LocalDate.now().plusWeeks(1))
                .to(LocalDate.now().plusWeeks(2))
                .at(LocalTime.of(14, 0))
                .daily()
                .active()
                .getInstance();

        System.out.println("--- Built market operation schedule: " + marketOperationSchedule);
        System.out.println(">>> TEST END >>> buildMarketOperationScheduleForNextWeekInAfternoonInEveryDayOnActivation");
    }

    private static void buildMarketOperationScheduleForThisYearInEveryMonthOnDeactivationWithNotification() {
        System.out.println(">>> TEST BEGINNING >>> buildMarketOperationScheduleForThisYearInEveryMonthOnDeactivationWithNotification");

        MarketOperationScheduleBuilder builder = new MarketOperationScheduleBuilder();
        BuilderClient builderClient = new BuilderClient(builder);

        MarketOperationSchedule marketOperationSchedule = builderClient.getMarketOperationScheduleBuilder()
                .ofStockType(StockTypeEnum.VALE3)
                .ofMarketOperationType(MarketOperationTypeEnum.BUY)
                .ofStockQuantity(100)
                .from(LocalDate.now())
                .to(LocalDate.now().plusYears(1))
                .monthly()
                .inactive()
                .ofNotificationEmail("phcarvalhome@gmail.com")
                .ofNotificationEmail("phcarvalhome@outlook.com")
                .getInstance();

        System.out.println("--- Built market operation schedule: " + marketOperationSchedule);
        System.out.println(">>> TEST END >>> buildMarketOperationScheduleForThisYearInEveryMonthOnDeactivationWithNotification");
    }
}