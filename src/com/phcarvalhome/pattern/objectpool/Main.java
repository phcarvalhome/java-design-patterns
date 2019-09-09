package com.phcarvalhome.pattern.objectpool;

import com.phcarvalhome.pattern.objectpool.core.client.Client;
import com.phcarvalhome.pattern.objectpool.core.NotificationConsumerPool;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        Client client = new Client(new NotificationConsumerPool(3));

        for(int counter = 1; counter <= 100; counter++){
            System.out.println("\n******************** ITERAÇÃO " + counter + " ********************\n");

            System.out.println("[MAIN]: Gerando relatório... " + counter);

            AtomicInteger atomicInteger = new AtomicInteger(counter);

            new Thread(() -> client.awaitNotification(atomicInteger.get())).start();

            try {
                Thread.sleep(5 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
