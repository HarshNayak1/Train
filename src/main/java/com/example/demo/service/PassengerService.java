package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Passenger;
import com.example.demo.repository.PassengerRepository;
import com.example.demo.dao.*;

@Service
public class PassengerService {

	@Autowired
	PassengerRepository passengerRepository;

	public void savePassenger(Passenger passenger) {
		passengerRepository.save(passenger);
	}

	public void updatePassenger(Passenger passenger) {
		passengerRepository.save(passenger);
	}

	public Optional<Passenger> getPassenger(int pid) {
		return passengerRepository.findById(pid);
	}

	public List<Passenger> getAllPassengers() {
		return passengerRepository.findAll();
	}

	public void deletePassenger(int pid) {
		passengerRepository.deleteById(pid);
	}

}
