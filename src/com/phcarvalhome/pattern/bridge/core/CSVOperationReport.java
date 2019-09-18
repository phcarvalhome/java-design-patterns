package com.phcarvalhome.pattern.bridge.core;

import com.phcarvalhome.pattern.prototype.core.Operation;

import java.util.List;

public class CSVOperationReport extends AbstractReport {

    public CSVOperationReport(IReportSender sender) {
        super(sender);
    }

    @Override
    public String generate(List<Operation> operationList) {
        StringBuilder reportBuilder = new StringBuilder("Operation Type, Stock Quantity, Stock Type, Stock Price\n");

        operationList
                .forEach(operation -> reportBuilder
                        .append(operation.getType() + ", ")
                        .append(operation.getStockQuantity() + ", ")
                        .append(operation.getStock().getType() + ", ")
                        .append(operation.getStock().getPrice() + "\n"));

        return reportBuilder.toString();
    }
}
