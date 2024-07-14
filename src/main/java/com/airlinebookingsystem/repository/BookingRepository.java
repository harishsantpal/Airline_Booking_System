package com.airlinebookingsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airlinebookingsystem.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
	
	List<Booking> findByUserId(Long userId);

}
