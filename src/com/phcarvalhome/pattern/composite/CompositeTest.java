package com.phcarvalhome.pattern.composite;

import com.phcarvalhome.pattern.builder.business.OperationSchedule;
import com.phcarvalhome.pattern.builder.client.BuilderClient;
import com.phcarvalhome.pattern.builder.core.OperationScheduleBuilder;
import com.phcarvalhome.pattern.composite.core.AbstractOperationScheduleEvent;
import com.phcarvalhome.pattern.composite.core.IOperationScheduleEvent;
import com.phcarvalhome.pattern.prototype.business.vo.OperationTypeEnum;
import com.phcarvalhome.pattern.prototype.business.vo.StockTypeEnum;

import java.time.LocalDate;
import java.time.LocalTime;

public class CompositeTest {

    public static void main(String[] args) {
        buildOperationScheduleEventForNextTwoDaysInEveryDay();
        buildOperationScheduleEventForNextTreeWeeksInEveryWeek();
        buildOperationScheduleEventForNextFourMonthsInEveryMonth();
    }

    private static void buildOperationScheduleEventForNextTwoDaysInEveryDay() {
        System.out.println(">>> TEST BEGINNING >>> buildOperationScheduleEventForNextTwoDaysInEveryDay");

        OperationScheduleBuilder builder = new OperationScheduleBuilder();
        BuilderClient builderClient = new BuilderClient(builder);
        OperationSchedule operationSchedule = builderClient.getOperationScheduleBuilder()
                .ofStockType(StockTypeEnum.PETR4)
                .ofOperationType(OperationTypeEnum.BUY)
                .ofStockQuantity(10)
                .from(LocalDate.now())
                .to(LocalDate.now().plusDays(2))
                .at(LocalTime.of(14, 0))
                .daily()
                .active()
                .getInstance();

        System.out.println("--- Built operation schedule: " + operationSchedule);

        //TODO add um client...
        IOperationScheduleEvent operationScheduleEvent = AbstractOperationScheduleEvent.from(operationSchedule);

        System.out.println("--- Operation schedule event stock quantity: " + operationScheduleEvent.getStockQuantity());
        System.out.println("--- Operation schedule event price: " + operationScheduleEvent.getPrice());
        System.out.println(">>> TEST END >>> buildOperationScheduleEventForNextTwoDaysInEveryDay");
    }

    private static void buildOperationScheduleEventForNextTreeWeeksInEveryWeek() {
        System.out.println(">>> TEST BEGINNING >>> buildOperationScheduleEventForNextTreeWeeksInEveryWeek");

        OperationScheduleBuilder builder = new OperationScheduleBuilder();
        BuilderClient builderClient = new BuilderClient(builder);
        OperationSchedule operationSchedule = builderClient.getOperationScheduleBuilder()
                .ofStockType(StockTypeEnum.PETR4)
                .ofOperationType(OperationTypeEnum.BUY)
                .ofStockQuantity(10)
                .from(LocalDate.now())
                .to(LocalDate.now().plusWeeks(3))
                .at(LocalTime.of(14, 0))
                .weekly()
                .active()
                .getInstance();

        System.out.println("--- Built operation schedule: " + operationSchedule);

        IOperationScheduleEvent operationScheduleEvent = AbstractOperationScheduleEvent.from(operationSchedule);

        System.out.println("--- Operation schedule event stock quantity: " + operationScheduleEvent.getStockQuantity());
        System.out.println("--- Operation schedule event price: " + operationScheduleEvent.getPrice());
        System.out.println(">>> TEST END >>> buildOperationScheduleEventForNextTreeWeeksInEveryWeek");
    }

    private static void buildOperationScheduleEventForNextFourMonthsInEveryMonth() {
        System.out.println(">>> TEST BEGINNING >>> buildOperationScheduleEventForNextFourMonthsInEveryMonth");

        OperationScheduleBuilder builder = new OperationScheduleBuilder();
        BuilderClient builderClient = new BuilderClient(builder);
        OperationSchedule operationSchedule = builderClient.getOperationScheduleBuilder()
                .ofStockType(StockTypeEnum.PETR4)
                .ofOperationType(OperationTypeEnum.BUY)
                .ofStockQuantity(10)
                .from(LocalDate.now())
                .to(LocalDate.now().plusMonths(4))
                .at(LocalTime.of(14, 0))
                .monthly()
                .active()
                .getInstance();

        System.out.println("--- Built operation schedule: " + operationSchedule);

        IOperationScheduleEvent operationScheduleEvent = AbstractOperationScheduleEvent.from(operationSchedule);

        System.out.println("--- Operation schedule event stock quantity: " + operationScheduleEvent.getStockQuantity());
        System.out.println("--- Operation schedule event price: " + operationScheduleEvent.getPrice());
        System.out.println(">>> TEST END >>> buildOperationScheduleEventForNextFourMonthsInEveryMonth");
    }
}