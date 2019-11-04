package com.phcarvalhome.pattern.businessdelegation.client;

import com.phcarvalhome.pattern.businessdelegation.core.QuoteDelegate;

//TODO change to specific domain name...
public class BusinessDelegationClient {

    private QuoteDelegate quoteDelegate;

    public BusinessDelegationClient() {
        quoteDelegate = new QuoteDelegate();
    }

    public double convertToUSD(double amount){
        return amount * quoteDelegate.getUSDQuote();
    }

    public double convertToEUR(double amount){
        return amount * quoteDelegate.getEURQuote();
    }
}
