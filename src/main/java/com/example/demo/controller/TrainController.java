package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Train;
import com.example.demo.repository.TrainRepository;
import com.example.demo.service.TrainService;

@Controller
public class TrainController {
	
	@Autowired
	private TrainService trainService;
	
	@GetMapping("/addTrain")
	public String getAddTrainPage() {
		return "addTrain";
	}

	@PostMapping("/addTrain")
	public String addTrain(Train train) {

		// save Product in DB
		trainService.saveTrain(train);

		return "redirect:/addTrain.html";

	}
	
	@GetMapping("/GetTrains.html")
	public ModelAndView getAllTrains() {

		List<Train> allTrain = trainService.getAllTrains();

		ModelAndView modelAndView = new ModelAndView("GetTrains");
		modelAndView.addObject("allTrain", allTrain);

		return modelAndView;
	}
	
	@GetMapping("/trainsBook.html")
	public ModelAndView getAllTrain() {

		List<Train> allTrain = trainService.getAllTrains();

		ModelAndView modelAndView = new ModelAndView("trainsBook.html");
		modelAndView.addObject("allTrain", allTrain);

		return modelAndView;
	}

	@GetMapping("/deleteTrain/{tid}")
	public String deleteTrain(@PathVariable int tid) {
		trainService.deleteTrain(tid);

		return "redirect:/GetTrains.html";
	}

	@GetMapping("/updateTrain/{tid}")
	public ModelAndView updateTrain(@PathVariable int tid) {


		Train existingTrain = trainService.getTrain(tid).orElseGet(null);

		ModelAndView modelAndView = new ModelAndView("updateTrain.html");
		modelAndView.addObject("train", existingTrain);

		return modelAndView;
	}

	@PostMapping("/updateTrain")
	public String doEditTrain(Train train) {

		trainService.updateTrain(train);

		return "redirect:/GetTrains.html";
	}

	
}