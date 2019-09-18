package com.phcarvalhome.pattern.bridge;

import com.phcarvalhome.pattern.bridge.core.EmailReportSender;
import com.phcarvalhome.pattern.bridge.core.IReport;
import com.phcarvalhome.pattern.bridge.core.IReportSender;
import com.phcarvalhome.pattern.bridge.core.XMLOperationReport;
import com.phcarvalhome.pattern.prototype.business.vo.OperationTypeEnum;
import com.phcarvalhome.pattern.prototype.business.vo.StockTypeEnum;
import com.phcarvalhome.pattern.prototype.core.Operation;
import com.phcarvalhome.pattern.prototype.core.Stock;

import java.util.ArrayList;
import java.util.List;

public class BridgeTest {

    public static void main(String[] args) {
        generateOperationReportInXMLAndToEmail();
    }

    private static void generateOperationReportInXMLAndToEmail() {
        System.out.println(">>> TEST BEGINNING >>> generateOperationReportInXMLAndToEmail");

        //TODO add um client? rever client question in all patterns..
        //TODO add test in main methods beginning...
        IReportSender reportSender = new EmailReportSender();
        IReport report = new XMLOperationReport(reportSender);
        List<Operation> operationList = buildOperationList();
        String generatedReport = report.generate(operationList);

        System.out.println("--- Generated report: " + generatedReport);
        report.send(generatedReport);
        System.out.println(">>> TEST END >>> generateOperationReportInXMLAndToEmail");
    }

    private static List<Operation> buildOperationList() {
        List<Operation> operationList = new ArrayList<>();
        Operation operation1 = new Operation(
                OperationTypeEnum.BUY, new Stock(StockTypeEnum.VALE3), 10);
        Operation operation2 = new Operation(
                OperationTypeEnum.BUY, new Stock(StockTypeEnum.PETR4), 20);
        Operation operation3 = new Operation(
                OperationTypeEnum.BUY, new Stock(StockTypeEnum.BBAS3), 30);

        operationList.add(operation1);
        operationList.add(operation2);
        operationList.add(operation3);

        return operationList;
    }
}