package com.example.demo.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import com.example.demo.command.FileComplaintCommand.Status;

import lombok.Data;

@Data
public class ApproveComplaintCommand {
	@TargetAggregateIdentifier
	int id;
	Status status;
	public ApproveComplaintCommand(int id) {
	this.id= id;
	this.status= Status.APROVED;
}
}
