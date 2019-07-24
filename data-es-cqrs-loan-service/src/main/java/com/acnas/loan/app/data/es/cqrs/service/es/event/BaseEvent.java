package com.acnas.loan.app.data.es.cqrs.service.es.event;

public class BaseEvent<T> {

    public final T id;

    public BaseEvent(T id) {
        this.id = id;
    }
}