package com.airlinebookingsystem.entity;

import java.util.Set;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Flight {
	
	@Id
	private String id;
	
	@NotBlank(message = "Flight Number is Mandatory!")
	private String flightNumber;
	
	@NotBlank(message = "Departure location is mandatory!")
	private String departure;
	
	@NotBlank(message = "Arrival location is mandatory!")
	private String arrival;
	
	@NotNull(message = "Price is mandatory!")
	private Double price;
	
	@NotNull(message = "Total seats are mandatory!")
	private Integer totalSeats;
	
	@ElementCollection
	private Set<Integer> availableSeats;
	
	
//	getter and setters

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(Integer totalSeats) {
		this.totalSeats = totalSeats;
	}

	public Set<Integer> getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(Set<Integer> availableSeats) {
		this.availableSeats = availableSeats;
	}
	
	
	

}
