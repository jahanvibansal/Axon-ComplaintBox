package com.example.demo.events;

import lombok.Data;

@Data	
public class ComplaintFiledEvent {

	private String company;
	private int id;
	private String message;

	public ComplaintFiledEvent(int id, String company, String message) {
		this.id=id;
		this.company= company;
		this.message=message;
	}

}
