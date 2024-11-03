package com.ganesh.MovieBooking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import jakarta.persistence.*;
@Entity
public class MovieBooking {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookingId;
	private String movieName;
	private int noOfSeats;
	private LocalDate date;
private LocalTime time;


	@Override
public String toString() {
	return "MovieBooking [bookingId=" + bookingId + ", movieName=" + movieName + ", noOfSeats=" + noOfSeats + ", date="
			+ date + ", time=" + time + "]";
}
	@Override
public int hashCode() {
	return Objects.hash(bookingId, date, movieName, noOfSeats, time);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	MovieBooking other = (MovieBooking) obj;
	return Objects.equals(bookingId, other.bookingId) && Objects.equals(date, other.date)
			&& Objects.equals(movieName, other.movieName) && noOfSeats == other.noOfSeats
			&& Objects.equals(time, other.time);
}
	public int getNoOfSeats() {
	return noOfSeats;
}
public void setNoOfSeats(int noOfSeats) {
	this.noOfSeats = noOfSeats;
}
public LocalTime getTime() {
	return time;
}
public void setTime(LocalTime time) {
	this.time = time;
}
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}

	
	
}
