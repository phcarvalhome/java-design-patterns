package com.phcarvalhome.pattern.bridge;

import com.phcarvalhome.pattern.bridge.core.EmailReportSender;
import com.phcarvalhome.pattern.bridge.core.IReport;
import com.phcarvalhome.pattern.bridge.core.IReportSender;
import com.phcarvalhome.pattern.bridge.core.XMLMarketOperationReport;
import com.phcarvalhome.pattern.prototype.business.vo.MarketOperationTypeEnum;
import com.phcarvalhome.pattern.prototype.business.vo.StockTypeEnum;
import com.phcarvalhome.pattern.prototype.core.MarketOperation;
import com.phcarvalhome.pattern.prototype.core.Stock;

import java.util.ArrayList;
import java.util.List;

public class BridgeTest {

    public static void main(String[] args) {
        generateMarketOperationReportInXMLAndToEmail();
    }

    private static void generateMarketOperationReportInXMLAndToEmail() {
        System.out.println(">>> TEST BEGINNING >>> generateMarketOperationReportInXMLAndToEmail");

        IReportSender reportSender = new EmailReportSender();
        IReport report = new XMLMarketOperationReport(reportSender);
        List<MarketOperation> marketOperationList = buildMarketOperationList();
        String generatedReport = report.generate(marketOperationList);

        System.out.println("--- Generated report: " + generatedReport);
        report.send(generatedReport);
        System.out.println(">>> TEST END >>> generateMarketOperationReportInXMLAndToEmail");
    }

    private static List<MarketOperation> buildMarketOperationList() {
        List<MarketOperation> marketOperationList = new ArrayList<>();
        MarketOperation marketOperation1 = new MarketOperation(
                MarketOperationTypeEnum.BUY, new Stock(StockTypeEnum.VALE3), 10);
        MarketOperation marketOperation2 = new MarketOperation(
                MarketOperationTypeEnum.BUY, new Stock(StockTypeEnum.PETR4), 20);
        MarketOperation marketOperation3 = new MarketOperation(
                MarketOperationTypeEnum.BUY, new Stock(StockTypeEnum.BBAS3), 30);

        marketOperationList.add(marketOperation1);
        marketOperationList.add(marketOperation2);
        marketOperationList.add(marketOperation3);

        return marketOperationList;
    }
}