package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ComplaintBoxApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComplaintBoxApplication.class, args);
	}

	/*
	 * @Bean
	 * 
	 * @Primary
	 * 
	 * public EventBus eventBus(EventStorageEngine eventStorageEngine) {
	 * 
	 * return new EmbeddedEventStore(eventStorageEngine);
	 * 
	 * }
	 * 
	 * 
	 * 
	 * A non-persistent event bus to push messages from our query model.
	 * 
	 * @Bean
	 * 
	 * @Qualifier("queryUpdates")
	 * 
	 * public EventBus queryUpdateEventBus() {
	 * 
	 * return new SimpleEventBus();
	 * 
	 * }
	 * 
	 */

}
