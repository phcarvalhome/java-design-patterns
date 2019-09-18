package com.phcarvalhome.pattern.abstractfactory.client;

import com.phcarvalhome.pattern.abstractfactory.business.vo.Notification;
import com.phcarvalhome.pattern.abstractfactory.core.INotificationFactory;

public class AbstractFactoryClient {

    private INotificationFactory marketNotificationFactory; //TODO tirar esse market daqui e deixar genérico...

    public AbstractFactoryClient(INotificationFactory marketNotificationFactory) {
        this.marketNotificationFactory = marketNotificationFactory;
    }

    public Notification buildMarketOpened() {
        Notification notification = marketNotificationFactory.buildMarketOpened();

        return notification;
    }

    public Notification buildMarketPaused() {
        Notification notification = marketNotificationFactory.buildMarketPaused();

        return notification;
    }
}
