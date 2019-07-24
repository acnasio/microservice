/*
 * 
 */
package com.acnas.loan.app.data.es.cqrs.service.es.event;

import java.util.Objects;

// TODO: Auto-generated Javadoc
/**
 * The Class LoanAppConfirmedEvent.
 */
public class LoanAppConfirmedEvent extends BaseEvent<String>{

     

    /**
     * Instantiates a new loan app confirmed event.
     *
     * @param appId the app id
     */
    public LoanAppConfirmedEvent(String appId) {
        super(appId);
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
        final LoanAppConfirmedEvent other = (LoanAppConfirmedEvent) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "LoanAppConfirmedEvent{" +
                "Id='" + id + '\'' +
                '}';
    }
}
