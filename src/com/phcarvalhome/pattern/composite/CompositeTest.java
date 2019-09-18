package com.phcarvalhome.pattern.composite;

import com.phcarvalhome.pattern.builder.business.MarketOperationSchedule;
import com.phcarvalhome.pattern.builder.client.BuilderClient;
import com.phcarvalhome.pattern.builder.core.MarketOperationScheduleBuilder;
import com.phcarvalhome.pattern.composite.core.AbstractMarketOperationScheduleEvent;
import com.phcarvalhome.pattern.composite.core.IMarketOperationScheduleEvent;
import com.phcarvalhome.pattern.prototype.business.vo.MarketOperationTypeEnum;
import com.phcarvalhome.pattern.prototype.business.vo.StockTypeEnum;

import java.time.LocalDate;
import java.time.LocalTime;

public class CompositeTest {

    public static void main(String[] args) {
        buildMarketOperationScheduleEventForNextTwoDaysInEveryDay();
        buildMarketOperationScheduleEventForNextTreeWeeksInEveryWeek();
        buildMarketOperationScheduleEventForNextFourMonthsInEveryMonth();
    }

    private static void buildMarketOperationScheduleEventForNextTwoDaysInEveryDay() {
        System.out.println(">>> TEST BEGINNING >>> buildMarketOperationScheduleEventForNextTwoDaysInEveryDay");

        MarketOperationScheduleBuilder builder = new MarketOperationScheduleBuilder();
        BuilderClient builderClient = new BuilderClient(builder);
        MarketOperationSchedule marketOperationSchedule = builderClient.getMarketOperationScheduleBuilder()
                .ofStockType(StockTypeEnum.PETR4)
                .ofMarketOperationType(MarketOperationTypeEnum.BUY)
                .ofStockQuantity(10)
                .from(LocalDate.now())
                .to(LocalDate.now().plusDays(2))
                .at(LocalTime.of(14, 0))
                .daily()
                .active()
                .getInstance();

        System.out.println("--- Built market operation schedule: " + marketOperationSchedule);

        IMarketOperationScheduleEvent marketOperationScheduleEvent = AbstractMarketOperationScheduleEvent.from(marketOperationSchedule);

        System.out.println("--- Market operation schedule event stock quantity: " + marketOperationScheduleEvent.getStockQuantity());
        System.out.println("--- Market operation schedule event price: " + marketOperationScheduleEvent.getPrice());
        System.out.println(">>> TEST END >>> buildMarketOperationScheduleEventForNextTwoDaysInEveryDay");
    }

    private static void buildMarketOperationScheduleEventForNextTreeWeeksInEveryWeek() {
        System.out.println(">>> TEST BEGINNING >>> buildMarketOperationScheduleEventForNextTreeWeeksInEveryWeek");

        MarketOperationScheduleBuilder builder = new MarketOperationScheduleBuilder();
        BuilderClient builderClient = new BuilderClient(builder);
        MarketOperationSchedule marketOperationSchedule = builderClient.getMarketOperationScheduleBuilder()
                .ofStockType(StockTypeEnum.PETR4)
                .ofMarketOperationType(MarketOperationTypeEnum.BUY)
                .ofStockQuantity(10)
                .from(LocalDate.now())
                .to(LocalDate.now().plusWeeks(3))
                .at(LocalTime.of(14, 0))
                .weekly()
                .active()
                .getInstance();

        System.out.println("--- Built market operation schedule: " + marketOperationSchedule);

        IMarketOperationScheduleEvent marketOperationScheduleEvent = AbstractMarketOperationScheduleEvent.from(marketOperationSchedule);

        System.out.println("--- Market operation schedule event stock quantity: " + marketOperationScheduleEvent.getStockQuantity());
        System.out.println("--- Market operation schedule event price: " + marketOperationScheduleEvent.getPrice());
        System.out.println(">>> TEST END >>> buildMarketOperationScheduleEventForNextTreeWeeksInEveryWeek");
    }

    private static void buildMarketOperationScheduleEventForNextFourMonthsInEveryMonth() {
        System.out.println(">>> TEST BEGINNING >>> buildMarketOperationScheduleEventForNextFourMonthsInEveryMonth");

        MarketOperationScheduleBuilder builder = new MarketOperationScheduleBuilder();
        BuilderClient builderClient = new BuilderClient(builder);
        MarketOperationSchedule marketOperationSchedule = builderClient.getMarketOperationScheduleBuilder()
                .ofStockType(StockTypeEnum.PETR4)
                .ofMarketOperationType(MarketOperationTypeEnum.BUY)
                .ofStockQuantity(10)
                .from(LocalDate.now())
                .to(LocalDate.now().plusMonths(4))
                .at(LocalTime.of(14, 0))
                .monthly()
                .active()
                .getInstance();

        System.out.println("--- Built market operation schedule: " + marketOperationSchedule);

        IMarketOperationScheduleEvent marketOperationScheduleEvent = AbstractMarketOperationScheduleEvent.from(marketOperationSchedule);

        System.out.println("--- Market operation schedule event stock quantity: " + marketOperationScheduleEvent.getStockQuantity());
        System.out.println("--- Market operation schedule event price: " + marketOperationScheduleEvent.getPrice());
        System.out.println(">>> TEST END >>> buildMarketOperationScheduleEventForNextFourMonthsInEveryMonth");
    }
}