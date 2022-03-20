package com.example.demo;

import Enteties.Person;
import Enteties.Residence;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import services.PersonService;

import java.sql.Date;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		PersonService personService = new PersonService();
		Person person = personService.getPersonById(1);
//		Residence residence = new Residence(person,"Moscow, Smolmaya st. 10", new Date());
		System.out.println(person);
	}

}
