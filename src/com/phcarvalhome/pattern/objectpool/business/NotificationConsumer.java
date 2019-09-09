package com.phcarvalhome.pattern.objectpool.business;

import java.net.Socket;

public class NotificationConsumer {

    private String id;
    private Socket socket;

    public NotificationConsumer(String id) {
        this.id = id;
    }

    public void awaitNotification(int port){

        try {
            System.out.println("[GENERATOR]: Gerando relatório... Relatório: " + port + " Recurso: " + this);
            Thread.sleep(30 * 1000);
            System.out.println("[GENERATOR]: Relatório gerado... Relatório: " + port + " Recurso: " + this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
