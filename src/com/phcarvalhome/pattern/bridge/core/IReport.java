package com.phcarvalhome.pattern.bridge.core;

import com.phcarvalhome.pattern.prototype.core.MarketOperation;

import java.util.List;

public interface IReport {

    String generate(List<MarketOperation> marketOperationList);

    void send(String report);
}
