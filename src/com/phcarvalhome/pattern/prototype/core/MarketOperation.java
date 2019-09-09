package com.phcarvalhome.pattern.prototype.core;

import com.phcarvalhome.pattern.prototype.business.vo.MarketOperationTypeEnum;

public class MarketOperation implements IPrototype<MarketOperation> {

    private MarketOperationTypeEnum type;
    private Stock stock;
    private int stockQuantity;

    public MarketOperation(MarketOperationTypeEnum type, Stock stock, int stockQuantity) {
        this.type = type;
        this.stock = stock;
        this.stockQuantity = stockQuantity;
    }

    @Override
    public MarketOperation copy() {
        return new MarketOperation(type, stock.copy(), stockQuantity);
    }

    public MarketOperationTypeEnum getType() {
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
        return "MarketOperation{" +
                "type=" + type +
                ", stock=" + stock +
                ", stockQuantity=" + stockQuantity +
                '}';
    }
}
