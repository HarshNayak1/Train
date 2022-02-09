package com.example.demo.controller;
 

import java.util.Date;
import java.util.Optional;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Passenger;
import com.example.demo.model.Ticket;
import com.example.demo.model.Train;
import com.example.demo.service.TrainService;




@Controller
public class HomeController {
	
	@GetMapping("/")
    public String root() {
        return "index";
    }

	
	@GetMapping("/login.html")
    public String login(Model model) {
        return "login";
    }
	@GetMapping("/alogin.html")
    public String alogin(Model model) {
        return "alogin";
    }
	 @GetMapping("/registration.html")
	    public String getSignUpPage(){
	        return "registration";
	    }
	 @GetMapping("/aregistration.html")
	    public String getaSignUpPage(){
	        return "aregistration";
	    }
	 @GetMapping("/userlogin.html")
	    public String getUserLoginPage(){
	        return "userlogin";
	    }
	 @GetMapping("/userSignUp.html")
	    public String getUserSignUpPage(){
	        return "userSignUp";
	    }
	 @GetMapping("/trains.html")
	    public String getDisplayTrainPage(){
	        return "trains";
	    }
	 @GetMapping("/src_des.html")
	    public String getsrcdesPage(){
	        return "src_des";
	    }
	 @GetMapping("/TicketBooking.html")
	    public String getTicketBookingPage(){
	        return "TicketBooking";
	    }
	 @GetMapping("/pppassengers.html")
	    public String getpppassengersPage(){
	        return "pppassengers";
	    }
	 @GetMapping("/paymentpage.html")
	    public String getPaymentPage(){
	        return "paymentpage";
	    }
	 @GetMapping("/finalticket.html")
	    public String getFinalTicketPage(){
	        return "finalticket";
	    }
	 @GetMapping("/adminLogin.html")
	    public String getAdminLoginPage(){
	        return "adminLogin";
	    }
	 @GetMapping("/index.html")
	    public String getIndexPage(){
	        return "index";
	    }
	 @GetMapping("/Passenger.html")
	    public String getPassengerPage(){
	        return "Passenger";
	    }
	 @GetMapping("/addPassenger.html")
		public String getaddPassengerPage() {
			return "addPassenger";
		}
	 
	 @PostMapping("/showPassenger.html")
		public String getshowPassengerPage() {
			return "showPassenger";
		}
		@GetMapping("/updatePassenger")
		public String getPassengersPage() {
			return "updatePassenger";
		}
	 @GetMapping("/Train.html")
	    public String getTrainPage(){
	        return "Train";
	    }
	 @GetMapping("/addTrain.html")
	    public String getAddTrainPage(){
	        return "addTrain";
	    }
	 @PostMapping("/GetTrains.html")
		public String getTrainssPage() {
			return "GetTrains";
		}
		@GetMapping("/updateTrain.html")
		public String getupdateTrainPage() {
			return "updateTrain";
		}
		
		@PostMapping("/trainsBook.html")
		public String getupdatesTrainPage() {
			return "trainsBook.html";
		}
		@GetMapping("/bookTrain/pnr.html")
		public String getTestPage() {
		return "pnr";
		}
	
	 @GetMapping("/Ticket.html")
	    public String getTicketPage(){
	        return "Ticket";
	    }

	 @GetMapping("/bookticket.html")
	    public String getBookTicketPage(){
	        return "bookticket";
	    }
	 @GetMapping("/getticket.html")
	    public String getTicketsPage(){
	        return "getticket";
	    }
	 @Autowired
		private TrainService trainService;

		@GetMapping("/bookTrain/{tid}")
		public ModelAndView getBookTrainPage(@PathVariable int tid) {

			Optional<Train> trainOptional = trainService.getTrain(tid);

			ModelAndView modelAndView = new ModelAndView("bookTrain");

			if (trainOptional.isPresent()) {
				Train train = trainOptional.get();
				modelAndView.addObject("train", train);
			}

			return modelAndView;
		}

		@PostMapping("/bookTrain/{tid}")
		public ModelAndView doBooking(Passenger passenger, String travelDate, @PathVariable int tid) {

			Optional<Train> trainOptional = trainService.getTrain(tid);

			ModelAndView modelAndView = new ModelAndView("printTicket");

			if (trainOptional.isPresent()) {
				Train train = trainOptional.get();

				DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");

				DateTime dateTime = DateTime.parse(travelDate, formatter);

				int date = dateTime.getDayOfMonth();
				int month = dateTime.getMonthOfYear()-1;
				int year = dateTime.getYear();

				Ticket ticket = new Ticket(new Date(year, month, date), train);

				ticket.addPassenger(passenger.getName(), passenger.getAge(), passenger.getGender());
				
				ticket.getTotalFare();

				modelAndView.addObject("ticket", ticket);

			}

			return modelAndView;
		}

}
