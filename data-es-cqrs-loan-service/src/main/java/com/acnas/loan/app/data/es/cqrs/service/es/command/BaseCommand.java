/*
 * 
 */
package com.acnas.loan.app.data.es.cqrs.service.es.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseCommand.
 *
 * @param <T> the generic type
 */
public class BaseCommand<T> {

    /** The id. */
    @TargetAggregateIdentifier
    public final T id;

    /**
     * Instantiates a new base command.
     *
     * @param id the id
     */
    public BaseCommand(T id) {
        this.id = id;
    }
}