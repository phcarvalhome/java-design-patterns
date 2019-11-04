package com.phcarvalhome.pattern.businessdelegation.core;

//TODO adapt to object pool implementation...
public class ServiceLocator {

    public IQuoteService lookupBRLQuoteService(){
        return new BRLQuoteService();
    }
}
