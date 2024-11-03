package com.ganesh.MovieBooking.serviice;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ganesh.MovieBooking.dto.ContactServiceDTO;
import com.ganesh.MovieBooking.dto.MovieBookingDTO;
import com.ganesh.MovieBooking.entity.MovieBooking;
import com.ganesh.MovieBooking.exception.MovieBookingException;
import com.ganesh.MovieBooking.repository.MovieBookingRepository;

@Service
public class MovieBookingService {

	
	@Autowired
	private MovieBookingRepository  bookingRepository;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	RestTemplate restTemplate;//webClient
	
	public Integer addMovie(MovieBookingDTO bookingDTO) throws MovieBookingException {
		
		MovieBooking booking=new MovieBooking();
		booking.setBookingId(bookingDTO.getBookingId());
		booking.setMovieName(bookingDTO.getMovieName());
		booking.setNoOfSeats(bookingDTO.getNoOfSeats());
		booking.setDate(bookingDTO.getDate());
		booking.setTime(bookingDTO.getTime());
		MovieBooking booking2=bookingRepository.save(booking);
		return booking2.getBookingId();
	}
	public MovieBookingDTO getMovieById(Integer id) throws MovieBookingException{
		MovieBooking booking=bookingRepository.findById(id).get();
				MovieBookingDTO bookingDTO=mapper.map(booking, MovieBookingDTO.class);
		return bookingDTO;
	}
	
	public List<MovieBookingDTO> getAllMovie() throws MovieBookingException{
		Iterable<MovieBooking> iterable=bookingRepository.findAll();
		List<MovieBookingDTO>  bookingDTOs=new ArrayList<>();
		iterable.forEach( t -> {
			MovieBookingDTO booking=new MovieBookingDTO();
			booking.setBookingId(t.getBookingId());
			booking.setMovieName(t.getMovieName());
			booking.setNoOfSeats(t.getNoOfSeats());
			booking.setDate(t.getDate());
			booking.setTime(t.getTime());
			bookingDTOs.add(booking);
		}
				
				);
		return bookingDTOs;
	}
	
//	private Integer bookingId;
//	private String movieName;
//	private int noOfSeats;
//	private LocalDate date;
//private LocalTime time;
	public MovieBookingDTO updateMovie(Integer bookingId,String movieName,int noOfseats,LocalDate date,LocalTime time) throws MovieBookingException {
		MovieBooking booking=bookingRepository.findById(bookingId).get();
		MovieBooking booking2=new  MovieBooking();
		if(booking2==null) {
			throw new MovieBookingException("Booking id not found");
			
		}
		booking2.setMovieName(movieName);
		booking2.setNoOfSeats(noOfseats);
		booking2.setDate(date);
		booking2.setTime(time);
		MovieBookingDTO bookingDTO=mapper.map(booking2, MovieBookingDTO.class);
		return bookingDTO;
	}
	public void deleteMovie(Integer bookingId) throws MovieBookingException{
		MovieBooking booking=bookingRepository.findById(bookingId).get();
		MovieBooking booking2=new MovieBooking();
		if(booking2==null) {
			throw new MovieBookingException("Movie id is deleted");
		}
		bookingRepository.deleteById(bookingId);
	}
	
	public MovieBookingDTO getBookById(Integer id) throws MovieBookingException{
		MovieBooking booking=bookingRepository.findById(id).get();
		MovieBookingDTO bookingDTO=mapper.map(booking, MovieBookingDTO.class);
		ContactServiceDTO contactServiceDTO=new ContactServiceDTO();
		contactServiceDTO=restTemplate.getForObject("http://localhost:5001/contact/{id}", ContactServiceDTO.class,id);
		bookingDTO.setContactServiceDTO(contactServiceDTO);
		return bookingDTO;
	}
	
}
