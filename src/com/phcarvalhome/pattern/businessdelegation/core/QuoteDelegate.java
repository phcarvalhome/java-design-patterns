package com.phcarvalhome.pattern.businessdelegation.core;

public class QuoteDelegate {

    private ServiceLocator serviceLocator;
    private IQuoteService quoteService;

    public QuoteDelegate() {
        serviceLocator = new ServiceLocator();
        quoteService = serviceLocator.lookupBRLQuoteService();
    }

    public double getUSDQuote() {
        return quoteService.getUSDQuote();
    }

    public double getEURQuote() {
        return quoteService.getEURQuote();
    }
}
