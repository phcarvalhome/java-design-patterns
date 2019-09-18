package com.phcarvalhome.pattern.bridge.core;

import com.phcarvalhome.pattern.prototype.core.Operation;

import java.util.List;

public class XMLOperationReport extends AbstractReport {

    public XMLOperationReport(IReportSender sender) {
        super(sender);
    }

    @Override
    public String generate(List<Operation> operationList) {
        StringBuilder reportBuilder = new StringBuilder();

        operationList
                .forEach(operation -> reportBuilder
                        .append("<Operation>\n")
                        .append("   <Type>" + operation.getType() + "</Type>\n")
                        .append("   <StockQuantity>" + operation.getStockQuantity() + "</StockQuantity>\n")
                        .append("   <Stock>\n")
                        .append("       <Type>" + operation.getStock().getType() + "</StockType>\n")
                        .append("       <Price>" + operation.getStock().getPrice() + "</Price>\n")
                        .append("   </Stock>\n")
                        .append("</Operation>\n"));

        return reportBuilder.toString();
    }
}
