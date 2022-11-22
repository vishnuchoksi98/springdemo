package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.model.person;

public interface PersonDao {
 int insertPerson(UUID id,person person);
 default int insertPerson (person person) {
	 UUID id=UUID.randomUUID();
	 System.out.print("name in persob dao : "+person.getName());
	 return insertPerson(id,person);
 }
 Optional<person> selectpersonById(UUID id);
 List<person> selectAllPeople();
 int deletePeople(UUID id);
 int updatePersonById(UUID id,person person);
}
