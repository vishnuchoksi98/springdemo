package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.demo.model.person;
@Repository("postgres")
public class PostAccessDataService implements PersonDao{

	@Override
	public int insertPerson(UUID id, person person) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Optional<person> selectpersonById(UUID id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<person> selectAllPeople() {
		// TODO Auto-generated method stub
		return List.of(new person(UUID.randomUUID(),"FROM POSTGRES DB"));
	}

	@Override
	public int deletePeople(UUID id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatePersonById(UUID id, person person) {
		// TODO Auto-generated method stub
		return 0;
	}

}
