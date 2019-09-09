package com.phcarvalhome.pattern.prototype.core;

import com.phcarvalhome.pattern.prototype.business.vo.StockTypeEnum;

import java.util.Random;

public class Stock implements IPrototype<Stock> {

    private StockTypeEnum type;
    private double price;

    public Stock(StockTypeEnum type) {
        this.type = type;
        this.price = calculatePrice();
    }

    private double calculatePrice() {
        double baseValue = 20;
        double range = 5;

        return baseValue + (new Random().nextDouble() * (range));
    }

    @Override
    public Stock copy() {
        return new Stock(this.type);
    }

    public StockTypeEnum getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "type=" + type +
                ", price=" + price +
                '}';
    }
}
