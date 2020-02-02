package com.example.demo.events;

import lombok.Data;

@Data
public class RejectComplaintEvent {
	int id;

	public RejectComplaintEvent(int id) {
		this.id= id;
	}
}
