package com.example.demo;

import Enteties.Person;
import Enteties.Residence;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import services.PersonService;
import services.ResidenceService;

import java.sql.Date;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		PersonService personService = new PersonService();
		ResidenceService residenceService = new ResidenceService();
		Person person = personService.getPersonById(1);
		Residence residence_1 = new Residence(person,"Moscow, Smolmaya st. 10", Date.valueOf("2022-03-20"));
		Residence residence_2 = new Residence(person, "Moscow, Arbat st. 4", Date.valueOf("2022-01-01"), Date.valueOf("2022-03-20"));
		residenceService.addResidence(residence_1);
		residenceService.addResidence(residence_2);
		System.out.println(person);
	}

}
