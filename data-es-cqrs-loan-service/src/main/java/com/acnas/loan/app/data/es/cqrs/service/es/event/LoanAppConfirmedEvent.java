package com.acnas.loan.app.data.es.cqrs.service.es.event;

import java.util.Objects;

public class LoanAppConfirmedEvent extends BaseEvent<String>{

     

    public LoanAppConfirmedEvent(String appId) {
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
        final LoanAppConfirmedEvent other = (LoanAppConfirmedEvent) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "LoanAppConfirmedEvent{" +
                "Id='" + id + '\'' +
                '}';
    }
}
