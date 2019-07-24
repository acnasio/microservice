/*
 * 
 */
package com.acnas.loan.app.data.es.cqrs.service.es.command;

import java.util.Objects;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

// TODO: Auto-generated Javadoc
/**
 * The Class CreateLoanAppCommand.
 */
public class CreateLoanAppCommand extends BaseCommand<String>{

     
    /** The product. */
    private final String product;
    
    /** The customer name. */
    private final String customerName;

    /**
     * Instantiates a new creates the loan app command.
     *
     * @param appID the app ID
     * @param product the product
     * @param customerName the customer name
     */
    public CreateLoanAppCommand(String appID, String product,String customerName) {
    	super(appID);
        
        this.product = product;
        this.customerName = customerName;
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
     * Gets the product.
     *
     * @return the product
     */
    public String getProduct() {
        return product;
    }
    
    /**
     * Gets the customer name.
     *
     * @return the customer name
     */
    public String getCustomerName() {
        return customerName;
    }


    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, product);
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
        final CreateLoanAppCommand other = (CreateLoanAppCommand) obj;
        return Objects.equals(this.id, other.id)
                && Objects.equals(this.product, other.product) && Objects.equals(this.customerName, other.customerName);
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "CreateLoanAppCommand{" +
                "id='" + id + '\'' +
                ", product='" + product + '\'' +
                 ", customerName='" + customerName + '\'' +
                '}';
    }
}