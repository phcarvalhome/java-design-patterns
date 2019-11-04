package com.phcarvalhome.pattern.businessdelegation.core;

import java.util.Random;

public class CADQuoteService implements IQuoteService {

    @Override
    public double getUSDQuote() {
        double baseValue = 1;
        double range = 2;

        return baseValue + (new Random().nextDouble() * (range));
    }

    @Override
    public double getEURQuote() {
        double baseValue = 2;
        double range = 2;

        return baseValue + (new Random().nextDouble() * (range));
    }
}
