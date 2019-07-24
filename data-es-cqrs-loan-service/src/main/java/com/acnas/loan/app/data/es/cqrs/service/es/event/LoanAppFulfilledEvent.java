package com.acnas.loan.app.data.es.cqrs.service.es.event;

import java.util.Objects;

public class LoanAppFulfilledEvent extends BaseEvent<String> {

     

    public LoanAppFulfilledEvent(String appId) {
        super(appId);
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
        final LoanAppFulfilledEvent other = (LoanAppFulfilledEvent) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "LoanAppFulfilledEvent{" +
                "Id='" + id + '\'' +
                '}';
    }
}