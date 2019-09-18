package com.phcarvalhome.pattern.prototype.core;

import com.phcarvalhome.pattern.prototype.business.vo.OperationTypeEnum;

public class Operation implements IPrototype<Operation> {

    private OperationTypeEnum type;
    private Stock stock;
    private int stockQuantity;

    public Operation(OperationTypeEnum type, Stock stock, int stockQuantity) {
        this.type = type;
        this.stock = stock;
        this.stockQuantity = stockQuantity;
    }

    @Override
    public Operation copy() {
        return new Operation(type, stock.copy(), stockQuantity);
    }

    public OperationTypeEnum getType() {
        return type;
    }

    public Stock getStock() {
        return stock;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "type=" + type +
                ", stock=" + stock +
                ", stockQuantity=" + stockQuantity +
                '}';
    }
}
