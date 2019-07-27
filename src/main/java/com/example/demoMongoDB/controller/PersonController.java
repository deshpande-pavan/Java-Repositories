package com.example.demoMongoDB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoMongoDB.model.Person;
import com.example.demoMongoDB.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;

	@PostMapping(value = "/create")
	public @ResponseBody Person create(@RequestBody Person nPerson) {
		Person p = personService.createPerson(nPerson.getFirstName(), nPerson.getLastName(), nPerson.getAge());
		return p;
	}

	@PostMapping(value = "/get")
	public @ResponseBody Person getPerson(@RequestBody String firstName) {
		return personService.getByFirstName(firstName);
	}

	@GetMapping(value = "/getAll")
	public List<Person> getAllPersons() {
		return personService.getAll();
	}

	@PostMapping(value = "/update")
	public @ResponseBody Person updateByFN(@RequestBody Person nPerson) {
		return personService.update(nPerson.getFirstName(), nPerson.getLastName(), nPerson.getAge());
	}

	@DeleteMapping(value = "/delete")
	public String delete(@RequestBody String firstName) {
		personService.delete(firstName);
		return "deleted " + firstName;
	}

	@DeleteMapping(value = "/deleteAll")
	public String deleteAllPersons() {
		personService.deleteAll();
		return "deleted All";
	}
}
