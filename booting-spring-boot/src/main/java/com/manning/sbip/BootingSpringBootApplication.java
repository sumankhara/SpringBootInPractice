package com.manning.sbip;

import com.manning.sbip.listeners.ApplicationStartingEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.time.LocalDateTime;

@SpringBootApplication
public class BootingSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(BootingSpringBootApplication.class);
		springApplication.setWebApplicationType(WebApplicationType.SERVLET);
		springApplication.addListeners(new ApplicationStartingEventListener());
		springApplication.run(args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void applicationReadyEvent(ApplicationReadyEvent applicationReadyEvent) {
		System.out.println("Application Ready Event generated at " + LocalDateTime.now());
	}
}
