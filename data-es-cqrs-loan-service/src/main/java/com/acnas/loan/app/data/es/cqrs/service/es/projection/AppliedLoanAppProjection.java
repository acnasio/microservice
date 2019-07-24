package com.acnas.loan.app.data.es.cqrs.service.es.projection;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.acnas.loan.app.data.es.cqrs.service.es.value.object.LoanAppStatus;

import lombok.Data;

@Entity
@Data
public class AppliedLoanAppProjection {

	@Id
    private  String orderId;
	@Column
    private  String product;
	@Column
    private LoanAppStatus orderStatus;
	@Column
	private String customerName;

     

    
    public void setOrderConfirmed() {
        this.orderStatus = LoanAppStatus.CONFIRMED;
    }

    public void setOrderFulFilled() {
        this.orderStatus = LoanAppStatus.FULFILLED;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, product, orderStatus, customerName);
    }

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
