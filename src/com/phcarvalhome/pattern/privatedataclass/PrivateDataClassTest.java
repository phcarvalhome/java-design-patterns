package com.phcarvalhome.pattern.privatedataclass;

import com.phcarvalhome.pattern.privatedataclass.core.User;
import com.phcarvalhome.pattern.prototype.core.Operation;
import com.phcarvalhome.pattern.prototype.business.vo.OperationTypeEnum;
import com.phcarvalhome.pattern.prototype.core.Stock;
import com.phcarvalhome.pattern.prototype.business.vo.StockTypeEnum;

public class PrivateDataClassTest {

    public static void main(String[] args) {
//        getPassword();
//        changeUserPasswordWithSuccess();
//        changeUserPasswordWithFail();
//        addOperationWithSuccess();
//        addOperationWithFail();
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

    private static void addOperationWithSuccess() {
        System.out.println(">>> TEST BEGINNING >>> addOperationWithSuccess");

        User user = new User("phcarvalhome@gmail.com",
                "123456",
                "0675-0",
                "48889-5");

        System.out.println("--- Built user: " + user);

        Stock stock = new Stock(StockTypeEnum.BBAS3);
        Operation operation = new Operation(OperationTypeEnum.BUY, stock, 20);

        user.addOperation(operation);

        System.out.println("--- Operation list: " + user.getOperationList());
        System.out.println(">>> TEST END >>> addOperationWithSuccess");
    }

    private static void addOperationWithFail() {
        System.out.println(">>> TEST BEGINNING >>> addOperationWithFail");

        User user = new User("phcarvalhome@gmail.com",
                "123456",
                "0675-0",
                "48889-5");

        System.out.println("--- Built user: " + user);

        Stock stock = new Stock(StockTypeEnum.BBAS3);
        Operation operation = new Operation(OperationTypeEnum.BUY, stock, 20);

        user.getOperationList().add(operation);

        System.out.println("--- Operation list: " + user.getOperationList());
        System.out.println(">>> TEST END >>> addOperationWithFail");
    }
}
