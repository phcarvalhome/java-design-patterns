package com.phcarvalhome.pattern.facade.business;

public class QuoteReportData {

    double brlUSDQuote;
    double brlEURQuote;
    double cadUSDQuote;
    double cadEURQuote;
    double jpyUSDQuote;
    double jpyEURQuote;

    public QuoteReportData(double brlUSDQuote,
                           double brlEURQuote,
                           double cadUSDQuote,
                           double cadEURQuote,
                           double jpyUSDQuote,
                           double jpyEURQuote) {
        this.brlUSDQuote = brlUSDQuote;
        this.brlEURQuote = brlEURQuote;
        this.cadUSDQuote = cadUSDQuote;
        this.cadEURQuote = cadEURQuote;
        this.jpyUSDQuote = jpyUSDQuote;
        this.jpyEURQuote = jpyEURQuote;
    }

    public double getBrlUSDQuote() {
        return brlUSDQuote;
    }

    public double getBrlEURQuote() {
        return brlEURQuote;
    }

    public double getCadUSDQuote() {
        return cadUSDQuote;
    }

    public double getCadEURQuote() {
        return cadEURQuote;
    }

    public double getJpyUSDQuote() {
        return jpyUSDQuote;
    }

    public double getJpyEURQuote() {
        return jpyEURQuote;
    }

    @Override
    public String toString() {
        return "QuoteReportTuple{" +
                "brlUSDQuote=" + brlUSDQuote +
                ", brlEURQuote=" + brlEURQuote +
                ", cadUSDQuote=" + cadUSDQuote +
                ", cadEURQuote=" + cadEURQuote +
                ", jpyUSDQuote=" + jpyUSDQuote +
                ", jpyEURQuote=" + jpyEURQuote +
                '}';
    }
}
