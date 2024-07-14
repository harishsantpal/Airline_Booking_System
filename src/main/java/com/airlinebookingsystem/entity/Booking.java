package com.airlinebookingsystem.entity;

import java.util.Set;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "User ID is mandatory")
	private Long userId;
	
	@NotNull(message = "Flight ID is mandatory")
	private String flightId;
	
	@NotBlank(message = "Status is mandatory")
	private String status;
	
	@ElementCollection
	private Set<Integer> seats;
	
//	getter and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Integer> getSeats() {
		return seats;
	}

	public void setSeats(Set<Integer> seats) {
		this.seats = seats;
	}
	
	
	
	

}
