package com.phcarvalhome.pattern.businessdelegation;

import com.phcarvalhome.pattern.builder.business.OperationSchedule;
import com.phcarvalhome.pattern.builder.client.BuilderClient;
import com.phcarvalhome.pattern.builder.core.OperationScheduleBuilder;
import com.phcarvalhome.pattern.prototype.business.vo.OperationTypeEnum;
import com.phcarvalhome.pattern.prototype.business.vo.StockTypeEnum;

import java.time.LocalDate;
import java.time.LocalTime;

public class BusinessDelegationTest {

    public static void main(String[] args) {
        buildOperationScheduleForNextWeekInAfternoonInEveryDayOnActivation();
        buildOperationScheduleForThisYearInEveryMonthOnDeactivationWithNotification();
    }

    private static void buildOperationScheduleForNextWeekInAfternoonInEveryDayOnActivation() {
        System.out.println(">>> TEST BEGINNING >>> buildOperationScheduleForNextWeekInAfternoonInEveryDayOnActivation");

        OperationScheduleBuilder builder = new OperationScheduleBuilder();
        BuilderClient builderClient = new BuilderClient(builder);
        OperationSchedule operationSchedule = builderClient.getOperationScheduleBuilder()
                .ofStockType(StockTypeEnum.PETR4)
                .ofOperationType(OperationTypeEnum.SELL)
                .ofStockQuantity(10)
                .from(LocalDate.now().plusWeeks(1))
                .to(LocalDate.now().plusWeeks(2))
                .at(LocalTime.of(14, 0))
                .daily()
                .active()
                .getInstance();

        System.out.println("--- Built operation schedule: " + operationSchedule);
        System.out.println(">>> TEST END >>> buildOperationScheduleForNextWeekInAfternoonInEveryDayOnActivation");
    }

    private static void buildOperationScheduleForThisYearInEveryMonthOnDeactivationWithNotification() {
        System.out.println(">>> TEST BEGINNING >>> buildOperationScheduleForThisYearInEveryMonthOnDeactivationWithNotification");

        OperationScheduleBuilder builder = new OperationScheduleBuilder();
        BuilderClient builderClient = new BuilderClient(builder);
        OperationSchedule operationSchedule = builderClient.getOperationScheduleBuilder()
                .ofStockType(StockTypeEnum.VALE3)
                .ofOperationType(OperationTypeEnum.BUY)
                .ofStockQuantity(100)
                .from(LocalDate.now())
                .to(LocalDate.now().plusYears(1))
                .monthly()
                .inactive()
                .ofNotificationEmail("phcarvalhome@gmail.com")
                .ofNotificationEmail("phcarvalhome@outlook.com")
                .getInstance();

        System.out.println("--- Built operation schedule: " + operationSchedule);
        System.out.println(">>> TEST END >>> buildOperationScheduleForThisYearInEveryMonthOnDeactivationWithNotification");
    }
}