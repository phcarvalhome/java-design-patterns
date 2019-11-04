package com.phcarvalhome.pattern.facade.core;

import com.phcarvalhome.pattern.businessdelegation.core.BRLQuoteService;
import com.phcarvalhome.pattern.businessdelegation.core.CADQuoteService;
import com.phcarvalhome.pattern.businessdelegation.core.JPYQuoteService;
import com.phcarvalhome.pattern.facade.business.QuoteReportData;

public class QuoteReportFacade {

    private BRLQuoteService brlQuoteService;
    private CADQuoteService cadQuoteService;
    private JPYQuoteService jpyQuoteService;

    public QuoteReportData getData(){
        return new QuoteReportData(brlQuoteService.getUSDQuote(),
                brlQuoteService.getEURQuote(),
                cadQuoteService.getUSDQuote(),
                cadQuoteService.getEURQuote(),
                jpyQuoteService.getUSDQuote(),
                jpyQuoteService.getEURQuote());
    }
}
