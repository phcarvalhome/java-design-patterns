package com.phcarvalhome.pattern.bridge.core;

import com.phcarvalhome.pattern.prototype.core.MarketOperation;

import java.util.List;

public class XMLMarketOperationReport extends AbstractReport {

    public XMLMarketOperationReport(IReportSender sender) {
        super(sender);
    }

    @Override
    public String generate(List<MarketOperation> marketOperationList) {
        StringBuilder reportBuilder = new StringBuilder();

        marketOperationList
                .forEach(marketOperation -> reportBuilder
                        .append("<MarketOperation>\n")
                        .append("   <Type>" + marketOperation.getType() + "</Type>\n")
                        .append("   <StockQuantity>" + marketOperation.getStockQuantity() + "</StockQuantity>\n")
                        .append("   <Stock>\n")
                        .append("       <Type>" + marketOperation.getStock().getType() + "</StockType>\n")
                        .append("       <Price>" + marketOperation.getStock().getPrice() + "</Price>\n")
                        .append("   </Stock>\n")
                        .append("</MarketOperation>\n"));

        return reportBuilder.toString();
    }
}
