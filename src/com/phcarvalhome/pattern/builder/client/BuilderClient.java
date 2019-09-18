package com.phcarvalhome.pattern.builder.client;

import com.phcarvalhome.pattern.builder.core.IOperationScheduleBuilder;

public class BuilderClient {

    private IOperationScheduleBuilder operationScheduleBuilder;

    public BuilderClient(IOperationScheduleBuilder operationScheduleBuilder) {
        this.operationScheduleBuilder = operationScheduleBuilder;
    }

    public IOperationScheduleBuilder getOperationScheduleBuilder() {
        return operationScheduleBuilder.initialize();
    }
}
