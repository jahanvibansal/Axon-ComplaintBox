package com.example.demo.command;

import org.axonframework.commandhandling.RoutingKey;

import lombok.Data;

@Data
public class FileComplaintCommand {
	 @RoutingKey  int id;	
	String company, message;
	Status status;
	
	public FileComplaintCommand(int id,String company, String message) {
		this.id= id;
		this.status= Status.NEW;
		this.company = company;
		this.message = message;
	
	}

	public enum Status{
		NEW, APROVED, REJECTED
	}
}
