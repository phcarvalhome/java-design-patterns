package com.phcarvalhome.pattern.prototype.client;

import com.phcarvalhome.pattern.prototype.core.IPrototype;

public class PrototypeClient<T> {

    IPrototype<T> prototype;

    public PrototypeClient(IPrototype<T> prototype) {
        this.prototype = prototype;
    }

    public T getPrototypeCopy(){
        return prototype.copy();
    }
}
