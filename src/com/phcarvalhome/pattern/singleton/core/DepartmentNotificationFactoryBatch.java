package com.phcarvalhome.pattern.singleton.core;

import com.phcarvalhome.pattern.abstractfactory.core.HRNotificationFactory;
import com.phcarvalhome.pattern.abstractfactory.core.INotificationFactory;
import com.phcarvalhome.pattern.abstractfactory.core.ITNotificationFactory;

import java.util.ArrayList;
import java.util.List;

public class DepartmentNotificationFactoryBatch {

    private static DepartmentNotificationFactoryBatch singleton;

    public static DepartmentNotificationFactoryBatch getSingleton(){

        if(singleton == null)
            singleton = new DepartmentNotificationFactoryBatch();

        return singleton;
    }

    private List<INotificationFactory> list;

    private DepartmentNotificationFactoryBatch() {
        buildList();
    }

    private void buildList() {
        list = new ArrayList<>();
        list.add(new HRNotificationFactory());
        list.add(new ITNotificationFactory());
    }

    public List<INotificationFactory> getList() {
        return list;
    }
}
