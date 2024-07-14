package com.airlinebookingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airlinebookingsystem.entity.Flight;
import com.airlinebookingsystem.service.FlightService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/flights")
@Validated
public class FlightController {
	
	@Autowired
	private FlightService flightService;
	
	@PostMapping
	public ResponseEntity<Flight> addFlight(@Valid @RequestBody Flight flight){
		Flight addedFlight=flightService.addFlight(flight);
		return new ResponseEntity<>(addedFlight,HttpStatus.CREATED);
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<Flight>> searchFlights(@RequestParam String departure, @RequestParam String arrival){
		List<Flight> flights=flightService.searchFlights(departure, arrival);
		return new ResponseEntity<>(flights, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Flight>> gelAllFlights(){
		List<Flight> flights=flightService.getAllFlights();
		return new ResponseEntity<>(flights, HttpStatus.OK);
	}

}
