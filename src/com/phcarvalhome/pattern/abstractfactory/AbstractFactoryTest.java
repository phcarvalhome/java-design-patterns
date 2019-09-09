package com.phcarvalhome.pattern.abstractfactory;

import com.phcarvalhome.pattern.abstractfactory.client.AbstractFactoryClient;
import com.phcarvalhome.pattern.abstractfactory.core.HRNotificationFactory;
import com.phcarvalhome.pattern.abstractfactory.core.ITNotificationFactory;
import com.phcarvalhome.pattern.abstractfactory.business.vo.Notification;

public class AbstractFactoryTest {

    public static void main(String[] args) {
        buildMarketOpenedNotificationForIT();
        buildMarketPausedNotificationForIT();
        buildMarketOpenedNotificationForHR();
        buildMarketPausedNotificationForHR();
    }

    private static void buildMarketOpenedNotificationForIT() {
        System.out.println(">>> TEST BEGINNING >>> buildMarketOpenedNotificationForIT");

        ITNotificationFactory factory = new ITNotificationFactory();
        AbstractFactoryClient abstractFactoryClient = new AbstractFactoryClient(factory);
        Notification notification = abstractFactoryClient.buildMarketOpened();

        System.out.println("--- Built notification: " + notification);
        System.out.println(">>> TEST END >>> buildMarketOpenedNotificationForIT");
    }

    private static void buildMarketPausedNotificationForIT() {
        System.out.println(">>> TEST BEGINNING >>> buildMarketPausedNotificationForIT");

        ITNotificationFactory factory = new ITNotificationFactory();
        AbstractFactoryClient abstractFactoryClient = new AbstractFactoryClient(factory);
        Notification notification = abstractFactoryClient.buildMarketPaused();

        System.out.println("--- Built notification: " + notification);
        System.out.println(">>> TEST END >>> buildMarketPausedNotificationForIT");
    }

    private static void buildMarketOpenedNotificationForHR() {
        System.out.println(">>> TEST BEGINNING >>> buildMarketOpenedNotificationForHR");

        HRNotificationFactory factory = new HRNotificationFactory();
        AbstractFactoryClient abstractFactoryClient = new AbstractFactoryClient(factory);
        Notification notification = abstractFactoryClient.buildMarketOpened();

        System.out.println("--- Built notification: " + notification);
        System.out.println(">>> TEST END >>> buildMarketOpenedNotificationForHR");
    }

    private static void buildMarketPausedNotificationForHR() {
        System.out.println(">>> TEST BEGINNING >>> buildMarketPausedNotificationForHR");

        HRNotificationFactory factory = new HRNotificationFactory();
        AbstractFactoryClient abstractFactoryClient = new AbstractFactoryClient(factory);
        Notification notification = abstractFactoryClient.buildMarketPaused();

        System.out.println("--- Built notification: " + notification);
        System.out.println(">>> TEST END >>> buildMarketPausedNotificationForHR");
    }
}
