package com.airlinebookingsystem.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.airlinebookingsystem.entity.Flight;
import com.airlinebookingsystem.repository.FlightRepository;

@Service
public class FlightService {
	
	@Autowired
	private FlightRepository flightRepository;
	
	public List<Flight> searchFlights(String departure, String arrival){
		return flightRepository.findByDepartureAndArrival(departure, arrival);
	}
	
	public Flight addFlight(Flight flight) {
		flight.setId(generateCustomFlightId());
		flight.setAvailableSeats(generateAvailableSeats(flight.getTotalSeats()));
		return flightRepository.save(flight);
	}

	private Set<Integer> generateAvailableSeats(int totalSeats) {
		
		Set<Integer> seats=new HashSet<>();
		for(int i=1;i<=totalSeats;i++) {
			seats.add(i);
		}
		return seats;
	}

	private String generateCustomFlightId() {
		// TODO Auto-generated method stub
		
		int randomThreeDigitNumber=(int)(Math.random()*900)+100;
		return "AIR"+randomThreeDigitNumber;
		
	}

	
	public List<Flight> getAllFlights() {
		// TODO Auto-generated method stub
		return flightRepository.findAll();
	}

}
