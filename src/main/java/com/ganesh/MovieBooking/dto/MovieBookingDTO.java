package com.ganesh.MovieBooking.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;


public class MovieBookingDTO {
	private Integer bookingId;
	private String movieName;
	private int noOfSeats;
	private LocalDate date;
private LocalTime time;
private ContactServiceDTO contactServiceDTO;

	public ContactServiceDTO getContactServiceDTO() {
	return contactServiceDTO;
}
public void setContactServiceDTO(ContactServiceDTO contactServiceDTO) {
	this.contactServiceDTO = contactServiceDTO;
}
	@Override
public String toString() {
	return "MovieBooking [bookingId=" + bookingId + ", movieName=" + movieName + ", noOfSeats=" + noOfSeats + ", date="
			+ date + ", time=" + time + "]";
}
	@Override
public int hashCode() {
	return Objects.hash(bookingId, date, movieName, noOfSeats, time);
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
