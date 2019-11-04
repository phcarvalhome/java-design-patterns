package com.phcarvalhome.pattern.facade.client;

import com.phcarvalhome.pattern.facade.business.QuoteReportData;
import com.phcarvalhome.pattern.facade.core.QuoteReportFacade;

//TODO change to specific domain name...
public class FacadeClient {

    private QuoteReportFacade facade;

    public FacadeClient() {
        facade = new QuoteReportFacade();
    }

    public QuoteReportData getData() {
        return facade.getData();
    }
}
