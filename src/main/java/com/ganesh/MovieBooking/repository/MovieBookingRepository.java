package com.ganesh.MovieBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.MovieBooking.entity.MovieBooking;

public interface MovieBookingRepository extends JpaRepository<MovieBooking, Integer> {

}
