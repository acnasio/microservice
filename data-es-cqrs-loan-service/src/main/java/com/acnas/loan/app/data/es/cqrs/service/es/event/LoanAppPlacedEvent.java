package com.acnas.loan.app.data.es.cqrs.service.es.event;

import java.util.Objects;

public class LoanAppPlacedEvent extends BaseEvent<String> {

     
    private final String product;
     
    private final String customerName;
     

    public LoanAppPlacedEvent(String loanAppID, String product, String customerName) {
        super(loanAppID);
        this.product = product;
        this.customerName = customerName;
    }

    public String getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }
    
    public String getCustomer() {
        return customerName;
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, product, customerName);
    }

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

    @Override
    public String toString() {
        return "LoanAppPlacedEvent{" +
                "id='" + id + '\'' +
                ", product='" + product + '\'' +
                ", customerName='" + customerName + '\'' +
                
                '}';
    }
}