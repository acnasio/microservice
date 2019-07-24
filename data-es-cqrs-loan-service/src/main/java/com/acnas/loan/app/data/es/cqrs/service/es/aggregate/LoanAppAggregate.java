package com.acnas.loan.app.data.es.cqrs.service.es.aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import com.acnas.loan.app.data.es.cqrs.service.es.command.ConfirmLoanAppCommand;
import com.acnas.loan.app.data.es.cqrs.service.es.command.FulfillLoanAppCommand;
import com.acnas.loan.app.data.es.cqrs.service.es.command.CreateLoanAppCommand;
import com.acnas.loan.app.data.es.cqrs.service.es.event.LoanAppConfirmedEvent;
import com.acnas.loan.app.data.es.cqrs.service.es.event.LoanAppFulfilledEvent;
import com.acnas.loan.app.data.es.cqrs.service.es.event.LoanAppPlacedEvent;

import lombok.Data;

@Aggregate
@Data
public class LoanAppAggregate {

    @AggregateIdentifier
    private String loanAppID;
    private String customerName;
    private String product;
    private String status;
    private boolean appConfirmed;

    @CommandHandler
    public LoanAppAggregate(CreateLoanAppCommand command) {
        apply(new LoanAppPlacedEvent(command.getId(), command.getProduct(), command.getCustomerName()));
    }

    @CommandHandler
    public void handle(ConfirmLoanAppCommand command) {
        apply(new LoanAppConfirmedEvent(loanAppID));
    }

    @CommandHandler
    public void handle(FulfillLoanAppCommand command) {
        if (!appConfirmed) {
            throw new IllegalStateException("Cannot confirm the status of the loan application now ");
        }

        apply(new LoanAppFulfilledEvent(loanAppID));
    }

    @EventSourcingHandler
    public void on(LoanAppPlacedEvent event) {
        this.loanAppID = event.getId();
        appConfirmed = false;
    }

    @EventSourcingHandler
    public void on(LoanAppConfirmedEvent event) {
    	appConfirmed = true;
    }

    protected LoanAppAggregate() {
         
    }

}