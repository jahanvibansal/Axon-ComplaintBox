package com.example.demo.events;

import lombok.Data;

@Data
public class ApproveComplaintEvent {
	int id;

	public ApproveComplaintEvent(int id) {
		this.id= id;
	}
}
