package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.demo.model.person;

import ch.qos.logback.core.filter.Filter;
@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao{
	
	private static List<person> DB = new ArrayList<>();
	
	@Override
	public int insertPerson(UUID id, person person) {
		// TODO Auto-generated method stub
		DB.add(new person(id,person.getName()));
		System.out.print("name is : "+person.getName());
		return 1;
	}

	@Override
	public List<person> selectAllPeople() {
		// TODO Auto-generated method stub
		
		return DB;
	}

	@Override
	public Optional<person> selectpersonById(UUID id) {
		// TODO Auto-generated method stub
		return DB.stream().filter(person->person.getId().equals(id)).findFirst();
	}

	@Override
	public int deletePeople(UUID id) {
		Optional<person> personMaybe = selectpersonById(id);
		if(personMaybe.isEmpty()) {
			return 0;
		}
			DB.remove(personMaybe.get());
			return 1;
	}

	@Override
	public int updatePersonById(UUID id, person update) {
			return selectpersonById(id)
					.map(person-> {
						int indexOfPersonToDelete = DB.indexOf(person);
						if(indexOfPersonToDelete>=0) {
							DB.set(indexOfPersonToDelete, new  person(id,update.getName()));
							return 1;
						}
						return 0;
					}).orElse(0);
	}

}
