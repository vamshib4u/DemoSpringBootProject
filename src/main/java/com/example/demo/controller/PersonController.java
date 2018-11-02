package com.example.demo.controller;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Person;
import com.example.demo.service.ExcuteCommand;
import com.example.demo.service.PersonService;


@RestController
@RequestMapping("/persons")
public class PersonController {
	
	@Autowired
	PersonService ps;
	@Autowired
	ExcuteCommand excuteCmd;
	
	@RequestMapping(method = RequestMethod.GET)
	public Hashtable<String, Person> getAll() {
		return ps.getAll();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Person getPerson(@PathVariable("id") String id) {
		System.out.println("id:: "+id);
		return ps.getPerson(id);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public boolean removePerson(@PathVariable("id") String id) {
		return ps.removePerson(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addPerson(@RequestBody Person person) {
		ps.addPerson(person);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean udpatePerson(@RequestBody Person person) {
		return ps.updatePerson(person);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void excuteCmd() {
		excuteCmd.excuteCmdScript();
	}
}
