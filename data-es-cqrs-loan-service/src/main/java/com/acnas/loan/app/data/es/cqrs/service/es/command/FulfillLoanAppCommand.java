package com.acnas.loan.app.data.es.cqrs.service.es.command;

import java.util.Objects;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class FulfillLoanAppCommand extends BaseCommand<String>{

     

    public FulfillLoanAppCommand(String appID) {
    	super(appID);
        
    }

    public String getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

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

    @Override
    public String toString() {
        return "FulfillLoanAppCommand{" +
                "id='" + id + '\'' +
                '}';
    }
}