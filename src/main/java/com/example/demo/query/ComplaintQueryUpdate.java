package com.example.demo.query
;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.ComplaintQueryRepository;
import com.example.demo.dto.ComplaintQueryObject;
import com.example.demo.events.ComplaintFiledEvent;

@Component
public class ComplaintQueryUpdate {

	@Autowired ComplaintQueryRepository rep;
	@EventHandler
	public void on(ComplaintFiledEvent event) {
		System.out.println("event being saved in rep"+ event.getId());
		rep.save(new ComplaintQueryObject(event.getId(),event.getCompany(), event.getMessage()));
	}
}
