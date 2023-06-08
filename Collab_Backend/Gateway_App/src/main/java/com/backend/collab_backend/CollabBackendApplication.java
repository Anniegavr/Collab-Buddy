package com.backend.collab_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@SpringBootApplication
public class CollabBackendApplication {

  public static void main(String[] args) {
    SpringApplication.run(CollabBackendApplication.class, args);
  }

}
