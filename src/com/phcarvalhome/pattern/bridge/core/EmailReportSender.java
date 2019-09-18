package com.phcarvalhome.pattern.bridge.core;

public class EmailReportSender implements IReportSender {

    @Override
    public void send(String report) {
        System.out.println("--- Sent to email!");
    }
}
