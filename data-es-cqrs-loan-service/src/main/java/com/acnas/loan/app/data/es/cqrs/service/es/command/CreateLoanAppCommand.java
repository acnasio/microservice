package com.acnas.loan.app.data.es.cqrs.service.es.command;

import java.util.Objects;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateLoanAppCommand extends BaseCommand<String>{

     
    private final String product;
    private final String customerName;

    public CreateLoanAppCommand(String appID, String product,String customerName) {
    	super(appID);
        
        this.product = product;
        this.customerName = customerName;
    }

    public String getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }
    
    public String getCustomerName() {
        return customerName;
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, product);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final CreateLoanAppCommand other = (CreateLoanAppCommand) obj;
        return Objects.equals(this.id, other.id)
                && Objects.equals(this.product, other.product) && Objects.equals(this.customerName, other.customerName);
    }

    @Override
    public String toString() {
        return "CreateLoanAppCommand{" +
                "id='" + id + '\'' +
                ", product='" + product + '\'' +
                 ", customerName='" + customerName + '\'' +
                '}';
    }
}