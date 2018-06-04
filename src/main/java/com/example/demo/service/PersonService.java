package com.example.demo.service;

import java.util.Hashtable;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Person;


@Service
public class PersonService {
	
	private Hashtable<String, Person> persons = new Hashtable<>();
	
	public PersonService() {
		Person p1 = new Person(1, "Vamshidhar", "Kurapati", 30);
		Person p2 = new Person(2, "Manasa", "Nunna", 26);
		Person p3 = new Person(3, "Aaryahi", "Kurapati", 1);
		persons.put("1", p1);
		persons.put("2", p2);
		persons.put("3", p3);
	}
	
	public Person getPerson(String id) {
		if(persons.containsKey(id)) {
			return persons.get(id);
		}
		return null;
	}
	
	public Hashtable<String, Person> getAll() {
		return persons;
	}
	
	public boolean removePerson(String id){
		if(persons.containsKey(id)) {
			persons.remove(id);
			return true;
		}
		return false;
	}
	
	public void addPerson(Person person) {
		persons.put(String.valueOf(persons.size()+1), person);
	}
	
	public boolean updatePerson(Person person) {
		Person p = persons.get(person.getId());
		if(p != null) {
			p.setAge(person.getAge());
			p.setFirstName(person.getFirstName());
			p.setLastName(person.getLastName());
			p.setId(person.getId());
			persons.remove(person.getId());
			persons.put(String.valueOf(person.getId()), person);
			return true;
		}
		return false;
	}

}
