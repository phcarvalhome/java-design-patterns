package com.phcarvalhome.pattern.privatedataclass;

import com.phcarvalhome.pattern.privatedataclass.core.User;
import com.phcarvalhome.pattern.prototype.core.MarketOperation;
import com.phcarvalhome.pattern.prototype.business.vo.MarketOperationTypeEnum;
import com.phcarvalhome.pattern.prototype.core.Stock;
import com.phcarvalhome.pattern.prototype.business.vo.StockTypeEnum;

public class BuilderTest {

    public static void main(String[] args) {
//        getPassword();
//        changeUserPasswordWithSuccess();
//        changeUserPasswordWithFail();
//        addMarketOperationWithSuccess();
//        addMarketOperationWithFail();
    }

    private static void getPassword() {
        System.out.println(">>> TEST BEGINNING >>> getPassword");

        User user = new User("phcarvalhome@gmail.com",
                "123456",
                "0675-0",
                "48889-5");

        System.out.println("--- Built user: " + user);

        String password = user.getPassword();

        System.out.println("--- Password: " + password);
        System.out.println(">>> TEST END >>> getPassword");
    }

    private static void changeUserPasswordWithSuccess() {
        System.out.println(">>> TEST BEGINNING >>> changeUserPasswordWithSuccess");

        User user = new User("phcarvalhome@gmail.com",
                "123456",
                "0675-0",
                "48889-5");

        System.out.println("--- Built user: " + user);

        user.changePassword("123456", "abcdef");

        System.out.println("--- Password: " + user.getPassword());
        System.out.println(">>> TEST END >>> changeUserPasswordWithSuccess");
    }

    private static void changeUserPasswordWithFail() {
        System.out.println(">>> TEST BEGINNING >>> changeUserPasswordWithFail");

        User user = new User("phcarvalhome@gmail.com",
                "123456",
                "0675-0",
                "48889-5");

        System.out.println("--- Built user: " + user);

        user.changePassword("654321", "abcdef");

        System.out.println("--- Password: " + user.getPassword());
        System.out.println(">>> TEST END >>> changeUserPasswordWithFail");
    }

    private static void addMarketOperationWithSuccess() {
        System.out.println(">>> TEST BEGINNING >>> addMarketOperationWithSuccess");

        User user = new User("phcarvalhome@gmail.com",
                "123456",
                "0675-0",
                "48889-5");

        System.out.println("--- Built user: " + user);

        Stock stock = new Stock(StockTypeEnum.BBAS3);
        MarketOperation marketOperation = new MarketOperation(MarketOperationTypeEnum.BUY, stock, 20);

        user.addMarketOperation(marketOperation);

        System.out.println("--- Market operation list: " + user.getMarketOperationList());
        System.out.println(">>> TEST END >>> addMarketOperationWithSuccess");
    }

    private static void addMarketOperationWithFail() {
        System.out.println(">>> TEST BEGINNING >>> addMarketOperationWithFail");

        User user = new User("phcarvalhome@gmail.com",
                "123456",
                "0675-0",
                "48889-5");

        System.out.println("--- Built user: " + user);

        Stock stock = new Stock(StockTypeEnum.BBAS3);
        MarketOperation marketOperation = new MarketOperation(MarketOperationTypeEnum.BUY, stock, 20);

        user.getMarketOperationList().add(marketOperation);

        System.out.println("--- Market operation list: " + user.getMarketOperationList());
        System.out.println(">>> TEST END >>> addMarketOperationWithFail");
    }
}
