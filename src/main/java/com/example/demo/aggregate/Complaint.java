package com.example.demo.aggregate;

import static  org.axonframework.modelling.command.AggregateLifecycle.apply;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import com.example.demo.command.ApproveComplaintCommand;
import com.example.demo.command.FileComplaintCommand;
import com.example.demo.command.FileComplaintCommand.Status;
import com.example.demo.command.RejectComplaintCommand;
import com.example.demo.events.ApproveComplaintEvent;
import com.example.demo.events.ComplaintFiledEvent;
import com.example.demo.events.RejectComplaintEvent;

@Aggregate
public class Complaint {
	@AggregateIdentifier
	int id;
	Status status;
	String message, company;

	public Complaint() {
		//required by axon 
	}
	
	// The Command Handlers should decide whether the Aggregate is in the correct state. If yes, an Event is published. If not, the Command might be ignored or an exception could be thrown, depending on the needs of the domain.
	@CommandHandler
	public Complaint(FileComplaintCommand command) {
		//agregate created for every command.
			//store events : can do validations/decision making, fire events
	//	Assert.hasLength((command.getCompany());
		System.out.println("command received"+ command.getId());
		//referenced from outside.
		apply(new ComplaintFiledEvent(command.getId(),command.getCompany(), command.getMessage()));
		//axon will save events in jpa. will automatically create table to save events
	}
	
	@CommandHandler
	public void rejectComplaint(RejectComplaintCommand command) {
		//agregate created for every command.
			//store events : can do validations/decision making, fire events
	//	Assert.hasLength((command.getCompany());
		System.out.println("command received"+ command.getId());
		//referenced from outside.
		apply(new RejectComplaintEvent(command.getId()));
		//axon will save events in jpa. will automatically create table to save events
	}
	
	@CommandHandler
	public void approveComplaint(ApproveComplaintCommand command) {
		//agregate created for every command.
			//store events : can do validations/decision making, fire events
	//	Assert.hasLength((command.getCompany());
		System.out.println("command received"+ command.getId());
		//referenced from outside.
		apply(new ApproveComplaintEvent(command.getId()));
		//axon will save events in jpa. will automatically create table to save events
	}
	
	//will only handle events within this aggregate lifecycle. Used to rehydrate it's own lfecycle using own events,
	@EventSourcingHandler
	public void on(ComplaintFiledEvent event) {
		//invoked by apply method or loading complaints from db..
	System.out.println("event fired"+ event.getId());
		this.id= event.getId();
		this.status= Status.NEW;
		this.message= event.getMessage();
		this.company= event.getCompany();
		//must not have business logic. Used for recording past. No validations here.
	}
	
	//State changes should not occur in any Command Handling function. The Event Sourcing Handlers should be the only methods where the Aggregate's state is updated. Failing to do so means the Aggregate would miss state changes when it is being sourced from it's events.
	@EventSourcingHandler
	public void on(RejectComplaintEvent event) {
		//invoked by apply method or loading complaints from db..
		System.out.println("event fired"+ event.getId());
		this.id= event.getId();
		this.status= Status.REJECTED;
		//must not have business logic. Used for recording past. No validations here.
	}
	@EventSourcingHandler
	public void on(ApproveComplaintEvent event) {
		//invoked by apply method or loading complaints from db..
		System.out.println("event fired"+ event.getId());
		this.id= event.getId();
		this.status= Status.APROVED;
		//must not have business logic. Used for recording past. No validations here.
	}
}
//An Aggregate cannot handle events from other sources then itself. 
