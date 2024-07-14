package com.airlinebookingsystem.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airlinebookingsystem.entity.Booking;
import com.airlinebookingsystem.entity.Flight;
import com.airlinebookingsystem.repository.BookingRepository;
import com.airlinebookingsystem.repository.FlightRepository;


@Service
public class BookingService {
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private FlightRepository flightRepository;
	
	public Booking createBooking(Booking booking) throws Exception{
		Optional<Flight> flightOpt=flightRepository.findById(booking.getFlightId());
		if(!flightOpt.isPresent()) {
			throw new Exception("Flight not found!");
		}
		
		
		Flight flight=flightOpt.get();
		Set<Integer> availableSeats=flight.getAvailableSeats();
		for(Integer seat: booking.getSeats()) {
			if(!availableSeats.contains(seat)) {
				throw new Exception("Seat "+seat+" is not available!");
			}
		}
		
		availableSeats.removeAll(booking.getSeats());
		flight.setAvailableSeats(availableSeats);
		flightRepository.save(flight);
		
		booking.setStatus("CONFIRMED");
		return bookingRepository.save(booking);
		
	}
	
	public List<Booking> getUserBookings(Long userId){
		return bookingRepository.findByUserId(userId);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void cancelBooking(Long bookingId) throws Exception {
		
		Optional<Booking> bookingOpt=bookingRepository.findById(bookingId);
		if(!bookingOpt.isPresent()) {
			throw new Exception("Booking not found!");
		}
		
		Booking booking=bookingOpt.get();
		Optional<Flight> flightOpt=flightRepository.findById(booking.getFlightId());
		if(!flightOpt.isPresent()) {
			throw new Exception("Flight not found!");
		}
		
		Flight flight=flightOpt.get();
		Set<Integer> availableSeats=flight.getAvailableSeats();
		
//		add seats back to available seats
		availableSeats.addAll(booking.getSeats());
		flight.setAvailableSeats(availableSeats);
		flightRepository.save(flight);
		
		bookingRepository.deleteById(bookingId);
	}

}
