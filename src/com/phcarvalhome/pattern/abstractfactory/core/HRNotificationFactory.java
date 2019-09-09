package com.phcarvalhome.pattern.abstractfactory.core;

import com.phcarvalhome.pattern.abstractfactory.business.vo.NotificationTargetEnum;
import com.phcarvalhome.pattern.abstractfactory.business.vo.NotificationTypeEnum;
import com.phcarvalhome.pattern.abstractfactory.business.vo.Notification;

public class HRNotificationFactory implements INotificationFactory {

    @Override
    public Notification buildMarketOpened() {
        return new Notification(NotificationTargetEnum.DEPARTMENT_HR, NotificationTypeEnum.MARKET_OPENED);
    }

    @Override
    public Notification buildMarketPaused() {
        return new Notification(NotificationTargetEnum.DEPARTMENT_HR, NotificationTypeEnum.MARKET_PAUSED);
    }
}
