package com.phcarvalhome.pattern.singleton;

import com.phcarvalhome.pattern.abstractfactory.business.vo.Notification;
import com.phcarvalhome.pattern.abstractfactory.core.INotificationFactory;
import com.phcarvalhome.pattern.singleton.core.DepartmentNotificationFactoryBatch;

import java.util.List;

public class SingletonTest {

    public static void main(String[] args) {
        buildMarketOpenedNotificationForDepartmentBatch();
    }

    private static void buildMarketOpenedNotificationForDepartmentBatch() {
        System.out.println(">>> TEST BEGINNING >>> buildMarketOpenedNotificationForDepartmentBatch");

        DepartmentNotificationFactoryBatch singleton = DepartmentNotificationFactoryBatch.getSingleton();
        List<INotificationFactory> departmentNotificationFactoryList = singleton.getList();

        for(INotificationFactory departmentNotificationFactory: departmentNotificationFactoryList){
            Notification notification = departmentNotificationFactory.buildMarketOpened();

            System.out.println("--- Built notification: " + notification);
        }

        System.out.println(">>> TEST END >>> buildMarketOpenedNotificationForDepartmentBatch");
    }
}
