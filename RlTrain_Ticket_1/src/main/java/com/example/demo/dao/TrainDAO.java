package com.example.demo.dao;

import java.util.List;

import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.example.demo.model.*;

@Table(name="train")

@Repository
public class TrainDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String TABLE_NAME = "train";

	public void addTrain(Train trains) {

		String insertSQL = "INSERT INTO " + TABLE_NAME + " (tid, tname, tsource, tdest,tprice,tarrival,tdept) VALUES(?,?,?,?)";

		jdbcTemplate.update(insertSQL, trains.getTid(), trains.getTname(), trains.getTname(),
				trains.getTsource(), trains.getTdest(), trains.getTprice(), trains.getTarrival(), trains.getTdept());

	}

	public void updateTrain(Train trains) {

		String updateSQL = "UPDATE " + TABLE_NAME + " SET tid=?, tname=?, tsource=?, tdest=?,tprice=?,tarrival=?,tdept=? WHERE tid=?";

		jdbcTemplate.update(updateSQL, trains.getTid(), trains.getTname(), trains.getTname(),
				trains.getTsource(), trains.getTdest(), trains.getTprice(), trains.getTarrival(), trains.getTdept());
	}

	public void deleteTrain(int tid) {

		String deleteSQL = "DELETE FROM " + TABLE_NAME + " WHERE tid=?";

		
		jdbcTemplate.update(deleteSQL, tid);

	}

	public Train getTrain(int tid) {
		String selectById = "SELECT * FROM " + TABLE_NAME + " WHERE tid=?";

		Train trains = jdbcTemplate.queryForObject(selectById, new Object[] { tid },
				new BeanPropertyRowMapper<>(Train.class));

		return trains;

	}

	public List<Train> getAllTrains() {

		String selectAll = "SELECT * FROM " + TABLE_NAME;

		List<Train> trains = jdbcTemplate.query(selectAll, new BeanPropertyRowMapper<>(Train.class));

		return trains;

	}

}