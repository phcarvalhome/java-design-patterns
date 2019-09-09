package com.phcarvalhome.pattern.abstractfactory.core;

import com.phcarvalhome.pattern.abstractfactory.business.vo.Notification;

public interface INotificationFactory {

    Notification buildMarketOpened();

    Notification buildMarketPaused();
}
