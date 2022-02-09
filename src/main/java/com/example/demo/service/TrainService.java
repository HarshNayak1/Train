package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.model.Train;
import com.example.demo.repository.TrainRepository;

@Service
public class TrainService {

	@Autowired
	TrainRepository trainRepository;

	public void saveTrain(Train train) {
		trainRepository.save(train);
	}

	public void updateTrain(Train train) {
		trainRepository.save(train);
	}

	public Optional<Train> getTrain(int tid) {
		return trainRepository.findById(tid);
	}

	public List<Train> getAllTrains() {
		return trainRepository.findAll();
	}

	public void deleteTrain(int tid) {
		trainRepository.deleteById(tid);
	}

}
