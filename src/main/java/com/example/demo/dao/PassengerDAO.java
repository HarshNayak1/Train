package com.example.demo.dao;

import java.util.List;

import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Passenger;
import com.example.demo.model.*;

@Table(name="passenger")

@Repository
public class PassengerDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String TABLE_NAME = "passenger";

	public void addPassenger(Passenger passengers) {

		String insertSQL = "INSERT INTO " + TABLE_NAME + " (pid, age, gender, name) VALUES(?,?,?,?)";

		jdbcTemplate.update(insertSQL, passengers.getPid(), passengers.getName(), passengers.getGender(),
				passengers.getAge());

	}


	public void updatePassenger(Passenger passengers) {

		String updateSQL = "UPDATE " + TABLE_NAME + " SET age=?, gender=?, name=? WHERE pid=?";

		jdbcTemplate.update(updateSQL, passengers.getPid(), passengers.getName(), passengers.getGender(),
				passengers.getAge());

	}

	public void deletePassenger(int id) {

		String deleteSQL = "DELETE FROM " + TABLE_NAME + " WHERE pid=?";

		
		jdbcTemplate.update(deleteSQL, id);

	}

	public Passenger getPassenger(int pid) {
		String selectById = "SELECT * FROM " + TABLE_NAME + " WHERE pid=?";

		Passenger passengers = jdbcTemplate.queryForObject(selectById, new Object[] { pid },
				new BeanPropertyRowMapper<>(Passenger.class));

		return passengers;

	}

	public List<Passenger> getAllPassengers() {

		String selectAll = "SELECT * FROM " + TABLE_NAME;

		List<Passenger> passengers = jdbcTemplate.query(selectAll, new BeanPropertyRowMapper<>(Passenger.class));

		return passengers;

	}

}