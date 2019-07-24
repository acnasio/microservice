/*
 * 
 */
package com.acnas.loan.app.data.es.cqrs.service.es.event;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseEvent.
 *
 * @param <T> the generic type
 */
public class BaseEvent<T> {

    /** The id. */
    public final T id;

    /**
     * Instantiates a new base event.
     *
     * @param id the id
     */
    public BaseEvent(T id) {
        this.id = id;
    }
}