package com.phcarvalhome.pattern.abstractfactory.business.vo;

import java.time.LocalDateTime;

public class Notification {

    private NotificationTargetEnum target;
    private NotificationTypeEnum type;
    private LocalDateTime creationDateTime;

    public Notification(NotificationTargetEnum target, NotificationTypeEnum type) {
        this.target = target;
        this.type = type;
        this.creationDateTime = LocalDateTime.now();
    }

    public NotificationTargetEnum getTarget() {
        return target;
    }

    public NotificationTypeEnum getType() {
        return type;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "target=" + target +
                ", type=" + type +
                ", creationDateTime=" + creationDateTime +
                '}';
    }
}
