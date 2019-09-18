package com.phcarvalhome.pattern.bridge.core;

public class GoogleDriveReportSender implements IReportSender {

    @Override
    public void send(String report) {
        System.out.println("--- Sent to Google Drive!");
    }
}
