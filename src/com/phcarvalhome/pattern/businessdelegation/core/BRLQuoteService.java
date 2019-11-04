package com.phcarvalhome.pattern.businessdelegation.core;

import java.util.Random;

public class BRLQuoteService implements IQuoteService {

    @Override
    public double getUSDQuote() {
        double baseValue = 3;
        double range = 2;

        return baseValue + (new Random().nextDouble() * (range));
    }

    @Override
    public double getEURQuote() {
        double baseValue = 4;
        double range = 2;

        return baseValue + (new Random().nextDouble() * (range));
    }
}
