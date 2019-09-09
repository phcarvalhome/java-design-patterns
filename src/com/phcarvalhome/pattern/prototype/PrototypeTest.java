package com.phcarvalhome.pattern.prototype;

import com.phcarvalhome.pattern.prototype.core.MarketOperation;
import com.phcarvalhome.pattern.prototype.business.vo.MarketOperationTypeEnum;
import com.phcarvalhome.pattern.prototype.core.Stock;
import com.phcarvalhome.pattern.prototype.business.vo.StockTypeEnum;
import com.phcarvalhome.pattern.prototype.client.PrototypeClient;

public class PrototypeTest {

    public static void main(String[] args) {
        duplicateMarketOperationForBBAS3();
    }

    private static void duplicateMarketOperationForBBAS3() {
        System.out.println(">>> TEST BEGINNING >>> duplicateMarketOperationForBBAS3");

        Stock stock = new Stock(StockTypeEnum.BBAS3);
        MarketOperation prototype = new MarketOperation(MarketOperationTypeEnum.BUY, stock, 10);

        System.out.println("--- Original market operation: " + prototype);

        PrototypeClient<MarketOperation> prototypeClient = new PrototypeClient(prototype);
        MarketOperation prototypeCopy = prototypeClient.getPrototypeCopy();

        System.out.println("--- Copied market operation: " + prototypeCopy);
        System.out.println(">>> TEST END >>> duplicateMarketOperationForBBAS3");
    }
}