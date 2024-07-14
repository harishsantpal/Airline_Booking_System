package com.airlinebookingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airlinebookingsystem.entity.Booking;
import com.airlinebookingsystem.service.BookingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bookings")
@Validated
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@PostMapping
	public ResponseEntity<Booking> createBooking(@Valid @RequestBody Booking booking){
		try {
			Booking createBooking=bookingService.createBooking(booking);
			return new ResponseEntity<>(createBooking,HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Booking>> getUserBookings(@PathVariable Long userId){
		List<Booking> bookings=bookingService.getUserBookings(userId);
		return new ResponseEntity<>(bookings,HttpStatus.OK);
	}
	
	@DeleteMapping("/{bookingId}")
	public ResponseEntity<Void> cancelBooking(@PathVariable Long bookingId){
		try {
			bookingService.cancelBooking(bookingId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}

}
