package com.collab.buddy.CollabBuddy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class CollabBuddyApplication(exclude = AdminServerHazelcastAutoConfiguration.class) {

	public static void main(String[] args) {
		SpringApplication.run(CollabBuddyApplication.class, args);
	}

}
