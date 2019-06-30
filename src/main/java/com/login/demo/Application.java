package com.login.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
      
    	SpringApplication app = new SpringApplication (Application.class);
        //app.setDefaultProperties(Collections.singletonMap("server.port", "8443"));
        app.run(args);
    }

}
