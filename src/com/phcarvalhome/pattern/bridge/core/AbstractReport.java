package com.phcarvalhome.pattern.bridge.core;

public abstract class AbstractReport implements IReport {

    private IReportSender sender;

    public AbstractReport(IReportSender sender) {
        this.sender = sender;
    }

    @Override
    public void send(String report) {
        sender.send(report);
    }
}
