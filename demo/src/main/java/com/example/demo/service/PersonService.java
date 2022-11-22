package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.person;

@Service
public class PersonService {
	private final PersonDao persondao;
	 
	@Autowired
	public PersonService(@Qualifier("postgres") PersonDao persondao) {
		super();
		this.persondao = persondao;
	}

	public int addPerson(person person) {
		return persondao.insertPerson(person);
	}
	public  List<person> getAllPeople(){
		return persondao.selectAllPeople();
	}
	public Optional<person> getPersonById(UUID id){
		return persondao.selectpersonById(id);
	}
	public int getDeleteById(UUID id) {
		return persondao.deletePeople(id);
	}
	public int updatePerson(UUID id,person person) {
		System.out.println("this is id need/n:"+person.getId());
		return persondao.updatePersonById(id,person);
	}
	
}

