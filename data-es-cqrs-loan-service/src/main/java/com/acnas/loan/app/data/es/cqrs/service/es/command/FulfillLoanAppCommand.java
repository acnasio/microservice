/*
 * 
 */
package com.acnas.loan.app.data.es.cqrs.service.es.command;

import java.util.Objects;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

// TODO: Auto-generated Javadoc
/**
 * The Class FulfillLoanAppCommand.
 */
public class FulfillLoanAppCommand extends BaseCommand<String>{

     

    /**
     * Instantiates a new fulfill loan app command.
     *
     * @param appID the app ID
     */
    public FulfillLoanAppCommand(String appID) {
    	super(appID);
        
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Equals.
     *
     * @param obj the obj
     * @return true, if successful
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final FulfillLoanAppCommand other = (FulfillLoanAppCommand) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "FulfillLoanAppCommand{" +
                "id='" + id + '\'' +
                '}';
    }
}