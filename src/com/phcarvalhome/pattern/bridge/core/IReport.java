package com.phcarvalhome.pattern.bridge.core;

import com.phcarvalhome.pattern.prototype.core.Operation;

import java.util.List;

public interface IReport {

    String generate(List<Operation> operationList);

    void send(String report);
}
