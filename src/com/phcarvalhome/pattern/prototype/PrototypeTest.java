package com.phcarvalhome.pattern.prototype;

import com.phcarvalhome.pattern.prototype.core.Operation;
import com.phcarvalhome.pattern.prototype.business.vo.OperationTypeEnum;
import com.phcarvalhome.pattern.prototype.core.Stock;
import com.phcarvalhome.pattern.prototype.business.vo.StockTypeEnum;
import com.phcarvalhome.pattern.prototype.client.PrototypeClient;

public class PrototypeTest {

    public static void main(String[] args) {
        duplicateOperationForBBAS3();
    }

    private static void duplicateOperationForBBAS3() {
        System.out.println(">>> TEST BEGINNING >>> duplicateOperationForBBAS3");

        Stock stock = new Stock(StockTypeEnum.BBAS3);
        Operation prototype = new Operation(OperationTypeEnum.BUY, stock, 10);

        System.out.println("--- Original operation: " + prototype);

        PrototypeClient<Operation> prototypeClient = new PrototypeClient(prototype);
        Operation prototypeCopy = prototypeClient.getPrototypeCopy();

        System.out.println("--- Copied operation: " + prototypeCopy);
        System.out.println(">>> TEST END >>> duplicateOperationForBBAS3");
    }
}