package com.phcarvalhome.pattern.objectpool.core;

import com.phcarvalhome.pattern.objectpool.business.NotificationConsumer;

import java.util.ArrayList;
import java.util.List;

public class NotificationConsumerPool {

    private int limit;
    private List<NotificationConsumer> freeResourceList;
    private List<NotificationConsumer> busyResourceList;

    public NotificationConsumerPool(int limit) {
        this.limit = limit;
        freeResourceList = new ArrayList<>();
        busyResourceList = new ArrayList<>();
    }

    public NotificationConsumer getResource(){

        if(freeResourceList.size() == 0){

            if(busyResourceList.size() == limit){
                System.out.println("[POOL]: Recursos esgotados...");
                System.out.println("[POOL]: Livres: " + freeResourceList.size() + " Ocupados: " + busyResourceList.size());

                return null;
            }
            else{
                System.out.println("[POOL]: Criando recurso...");

                return buildResource();
            }
        }else{
            NotificationConsumer notificationConsumer = freeResourceList.remove(0);

            busyResourceList.add(notificationConsumer);
            System.out.println("[POOL]: Recurso ocupado... " + notificationConsumer);
            System.out.println("[POOL]: Livres: " + freeResourceList.size() + " Ocupados: " + busyResourceList.size());

            return notificationConsumer;
        }
    }

    private NotificationConsumer buildResource() {
        String id = "RECURSO " + (freeResourceList.size() + busyResourceList.size());
        NotificationConsumer notificationConsumer = new NotificationConsumer(id);

        busyResourceList.add(notificationConsumer);
        System.out.println("[POOL]: Recurso criado e ocupado... " + notificationConsumer);
        System.out.println("[POOL]: Livres: " + freeResourceList.size() + " Ocupados: " + busyResourceList.size());

        return notificationConsumer;
    }

    public void releaseResource(){
        NotificationConsumer notificationConsumer = busyResourceList.remove(0);

        freeResourceList.add(notificationConsumer);
        System.out.println("[POOL]: Recurso liberado... " + notificationConsumer);
        System.out.println("[POOL]: Livres: " + freeResourceList.size() + " Ocupados: " + busyResourceList.size());
    }
}
