/*
 * 
 */
package com.acnas.loan.app.data.es.cqrs.service.es.event;

import java.util.Objects;

// TODO: Auto-generated Javadoc
/**
 * The Class LoanAppPlacedEvent.
 */
public class LoanAppPlacedEvent extends BaseEvent<String> {

     
    /** The product. */
    private final String product;
     
    /** The customer name. */
    private final String customerName;
     

    /**
     * Instantiates a new loan app placed event.
     *
     * @param loanAppID the loan app ID
     * @param product the product
     * @param customerName the customer name
     */
    public LoanAppPlacedEvent(String loanAppID, String product, String customerName) {
        super(loanAppID);
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
     * Gets the customer.
     *
     * @return the customer
     */
    public String getCustomer() {
        return customerName;
    }


    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, product, customerName);
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
        final LoanAppPlacedEvent other = (LoanAppPlacedEvent) obj;
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
        return "LoanAppPlacedEvent{" +
                "id='" + id + '\'' +
                ", product='" + product + '\'' +
                ", customerName='" + customerName + '\'' +
                
                '}';
    }
}