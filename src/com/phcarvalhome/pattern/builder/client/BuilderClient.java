package com.phcarvalhome.pattern.builder.client;

import com.phcarvalhome.pattern.builder.core.IMarketOperationScheduleBuilder;

public class BuilderClient {

    private IMarketOperationScheduleBuilder marketOperationScheduleBuilder;

    public BuilderClient(IMarketOperationScheduleBuilder marketOperationScheduleBuilder) {
        this.marketOperationScheduleBuilder = marketOperationScheduleBuilder;
    }

    public IMarketOperationScheduleBuilder getMarketOperationScheduleBuilder() {
        return marketOperationScheduleBuilder.initialize();
    }
}
