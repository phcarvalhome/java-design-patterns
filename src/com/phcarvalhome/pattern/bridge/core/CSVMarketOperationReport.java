package com.phcarvalhome.pattern.bridge.core;

import com.phcarvalhome.pattern.prototype.core.MarketOperation;

import java.util.List;

public class CSVMarketOperationReport extends AbstractReport {

    public CSVMarketOperationReport(IReportSender sender) {
        super(sender);
    }

    @Override
    public String generate(List<MarketOperation> marketOperationList) {
        StringBuilder reportBuilder = new StringBuilder("Market Operation Type, Stock Quantity, Stock Type, Stock Price\n");

        marketOperationList
                .forEach(marketOperation -> reportBuilder
                        .append(marketOperation.getType() + ", ")
                        .append(marketOperation.getStockQuantity() + ", ")
                        .append(marketOperation.getStock().getType() + ", ")
                        .append(marketOperation.getStock().getPrice() + "\n"));

        return reportBuilder.toString();
    }
}
