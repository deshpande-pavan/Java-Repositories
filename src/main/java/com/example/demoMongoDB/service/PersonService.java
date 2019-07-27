package com.example.demoMongoDB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoMongoDB.model.Person;
import com.example.demoMongoDB.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public Person createPerson(String firstName, String lastName, int age) {
		return personRepository.save(new Person(firstName.trim(), lastName.trim(), age));
	}

	public List<Person> getAll() {
		return personRepository.findAll();
	}

	public Person getByFirstName(String firstName) {
		return personRepository.findByFirstName(firstName.trim());
	}

	public Person update(String firstName, String lastName, int age) {
		Person nperson = personRepository.findByFirstName(firstName.trim());
		nperson.setAge(age);
		nperson.setLastName(lastName.trim());
		return personRepository.save(nperson);
	}

	public void deleteAll() {
		personRepository.deleteAll();
	}

	public void delete(String firstName) {
		Person dperson = personRepository.findByFirstName(firstName.trim());
		personRepository.delete(dperson);
	}
}
