package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBookMvcThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBookMvcThymeleafApplication.class, args);
	}

}

// Step 1 - home

// Step 2 - register

// Step 3 - get the data and give it to service

// Step 4 - user exists / username exists check in serive package from repo

// Step 5 - from service it will go to repo to check and then service will give response and then serive will give response to front controller

// Step 6 - in repo we are using jdbc template not jpa for database which can be h2 or mysql

// Step 7 - login process....from login.html it will post and then authentication will hapen from /authenticate and then fetch values via @RequestParam and bind it with variables

// Step 8 - first it will check in service from home controller if user exists

// Step 9 - service will check if user exists in repo and then back to home controller it will return if user exists and then session will get created and redirect to success.html page or else it will redirect to error.html page in which it display error/user not found
//			so for createing a session and passing the username to succes page and in succes page we are printing the username we can either directly create a session and give the username to success page or else we can use redirect/succes in which in the currect and same controller file it will search for postmapping(/success) where we first check if session is created then pass and in it return the username to sucess...we can use both methods 

// Step 10 - so now in new success.html file, using thymeleaf tag we can use data/names from other files directly and then we can print succesful and we can now add a new task or just simply logout also

// Step 11 - 
