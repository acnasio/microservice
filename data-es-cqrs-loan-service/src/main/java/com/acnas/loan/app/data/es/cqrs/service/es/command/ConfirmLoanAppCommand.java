/*
 * 
 */
package com.acnas.loan.app.data.es.cqrs.service.es.command;

 

import java.util.Objects;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfirmLoanAppCommand.
 */
public class ConfirmLoanAppCommand extends BaseCommand<String>{

     

    /**
     * Instantiates a new confirm loan app command.
     *
     * @param appID the app ID
     */
    public ConfirmLoanAppCommand(String appID) {
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
        final ConfirmLoanAppCommand other = (ConfirmLoanAppCommand) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "ConfirmLoanAppCommand{" +
                "Id='" + id + '\'' +
                '}';
    }
}
