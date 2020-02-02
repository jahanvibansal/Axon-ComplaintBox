package com.example.demo.api;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.command.FileComplaintCommand;
import com.example.demo.dao.ComplaintQueryRepository;
import com.example.demo.dto.ComplaintQueryObject;

@RestController
@RequestMapping("/complaints")
public  class ComplaintResource {

	@Autowired CommandGateway gateway;//to send commands.
	@Autowired
	ComplaintQueryRepository rep;

	@GetMapping//08040103000
	public List<ComplaintQueryObject> getComplaints() {
		return rep.findAll();
	}
	
	@GetMapping(path = "/{id}")
	public Optional<ComplaintQueryObject> getComplaintById(@PathVariable int id) {
		return rep.findById(id);
	}
	
	@PostMapping
	public CompletableFuture<Object> fileComplaint(@RequestBody Map<String, String> request) {
		// rep.save(complaint);
		  int orderId = (int)(Math.random()*1000);
		return gateway.send(new FileComplaintCommand(orderId,request.get("company"), request.get("message")));
		//commands are executed in diff model than queries.aggregates. 
	}
}