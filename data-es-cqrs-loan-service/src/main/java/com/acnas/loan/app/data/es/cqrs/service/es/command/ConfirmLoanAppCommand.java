package com.acnas.loan.app.data.es.cqrs.service.es.command;

 

import java.util.Objects;

public class ConfirmLoanAppCommand extends BaseCommand<String>{

     

    public ConfirmLoanAppCommand(String appID) {
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
        final ConfirmLoanAppCommand other = (ConfirmLoanAppCommand) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "ConfirmLoanAppCommand{" +
                "Id='" + id + '\'' +
                '}';
    }
}
