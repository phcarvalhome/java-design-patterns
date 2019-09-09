package com.phcarvalhome.pattern.objectpool.core.client;

import com.phcarvalhome.pattern.objectpool.business.NotificationConsumer;
import com.phcarvalhome.pattern.objectpool.core.NotificationConsumerPool;

public class Client {

    private NotificationConsumerPool notificationConsumerPool;

    public Client(NotificationConsumerPool notificationConsumerPool) {
        this.notificationConsumerPool = notificationConsumerPool;
    }

    public void awaitNotification(int port){
        System.out.println("[CLIENT]: Tentando obter recurso... " + port);

        NotificationConsumer resource = notificationConsumerPool.getResource();

        System.out.println("[CLIENT]: Recurso obtido... Recurso: " + resource + " Relatório: " + port);

        if(resource != null){
            System.out.println("[CLIENT]: >>>>>> Usando recurso... " + port);
            resource.awaitNotification(port);
            System.out.println("[CLIENT]: <<<<<< Liberando recurso... " + port);
            notificationConsumerPool.releaseResource();
        }
    }
}
