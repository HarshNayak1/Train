package com.example.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Passenger;
import com.example.demo.service.PassengerService;


@Controller
public class PassengerController {

	@Autowired
	private PassengerService passengerService;

	@GetMapping("/addPassenger")
	public String getAddPassengerPage() {
		return "addPassenger";
	}

	@PostMapping("/addPassenger")
	public String addPassenger(Passenger passenger) {

		// save Product in DB
		passengerService.savePassenger(passenger);

		return "redirect:/showPassenger.html";

	}
	@GetMapping("/showPassenger.html")
	public ModelAndView getAllPassengers() {

		List<Passenger> allPassenger = passengerService.getAllPassengers();

		ModelAndView modelAndView = new ModelAndView("showPassenger.html");
		modelAndView.addObject("allPassenger", allPassenger);

		return modelAndView;
	}

	@GetMapping("/deletePassenger/{pid}")
	public String deletePassenger(@PathVariable int pid) {
		passengerService.deletePassenger(pid);

		return "redirect:/showPassenger.html";
	}

	@GetMapping("/updatePassenger/{pid}")
	public ModelAndView updatePassenger(@PathVariable int pid) {


		Passenger existingPassenger = passengerService.getPassenger(pid).orElseGet(null);

		ModelAndView modelAndView = new ModelAndView("updatePassenger.html");
		modelAndView.addObject("passenger", existingPassenger);

		return modelAndView;
	}

	@PostMapping("/updatePassenger")
	public String doEditPassenger(Passenger passenger) {

		passengerService.updatePassenger(passenger);

		return "redirect:/showPassenger.html";
	}

	
}
