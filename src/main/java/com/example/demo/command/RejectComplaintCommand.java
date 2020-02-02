package com.example.demo.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import com.example.demo.command.FileComplaintCommand.Status;

import lombok.Data;

@Data
public class RejectComplaintCommand {
	Status status;
	@TargetAggregateIdentifier
	int id;

	public RejectComplaintCommand(int id) {
		this.id = id;
		this.status = Status.REJECTED;
	}
}
