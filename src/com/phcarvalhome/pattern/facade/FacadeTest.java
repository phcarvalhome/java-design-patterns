package com.phcarvalhome.pattern.facade;

import com.phcarvalhome.pattern.facade.client.FacadeClient;

public class FacadeTest {

    public static void main(String[] args) {
        printQuoteReportData();
    }

    private static void printQuoteReportData() {
        System.out.println(">>> TEST BEGINNING >>> printQuoteReportData");

        FacadeClient facadeClient = new FacadeClient();

        System.out.println("--- BRL/USD quote: " + facadeClient.getData().getBrlUSDQuote());
        System.out.println("--- BRL/EUR quote: " + facadeClient.getData().getBrlEURQuote());
        System.out.println("--- CAD/USD quote: " + facadeClient.getData().getCadUSDQuote());
        System.out.println("--- CAD/EUR quote: " + facadeClient.getData().getCadEURQuote());
        System.out.println("--- JPY/USD quote: " + facadeClient.getData().getJpyUSDQuote());
        System.out.println("--- JPY/EUR quote: " + facadeClient.getData().getJpyEURQuote());

        System.out.println(">>> TEST END >>> printQuoteReportData");
    }
}