package com.sapient.users;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "User Service REST API Documentation",
		description = "Sapient User Service REST API Documentation", version = "v1", contact = @Contact(name = "Ravinder Singh")))
public class UsersApplication {

public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
	}

}
