/*
 * 
 */
package com.acnas.loan.app.data.es.cqrs.service.es.projection;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.acnas.loan.app.data.es.cqrs.service.es.value.object.LoanAppStatus;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class AppliedLoanAppProjection.
 */
@Entity

/**
 * Instantiates a new applied loan app projection.
 */
@Data
public class AppliedLoanAppProjection {

	/** The order id. */
	@Id
    private  String orderId;
	
	/** The product. */
	@Column
    private  String product;
	
	/** The order status. */
	@Column
    private LoanAppStatus orderStatus;
	
	/** The customer name. */
	@Column
	private String customerName;

     

    
    /**
     * Sets the order confirmed.
     */
    public void setOrderConfirmed() {
        this.orderStatus = LoanAppStatus.CONFIRMED;
    }

    /**
     * Sets the order ful filled.
     */
    public void setOrderFulFilled() {
        this.orderStatus = LoanAppStatus.FULFILLED;
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(orderId, product, orderStatus, customerName);
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
        final AppliedLoanAppProjection other = (AppliedLoanAppProjection) obj;
        return Objects.equals(this.orderId, other.orderId)
                && Objects.equals(this.product, other.product)
                && Objects.equals(this.orderStatus, other.orderStatus)
                && Objects.equals(this.customerName, other.customerName);
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "OrderedProduct{" +
                "orderId='" + orderId + '\'' +
                ", product='" + product + '\'' +
                ", orderStatus=" + orderStatus +
                 ", customerName=" + customerName +
                '}';
    }
}
