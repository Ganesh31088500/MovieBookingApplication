package com.ganesh.MovieBooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.MovieBooking.dto.MovieBookingDTO;
import com.ganesh.MovieBooking.exception.MovieBookingException;
import com.ganesh.MovieBooking.serviice.MovieBookingService;

@RestController
@RequestMapping("/api")
public class MovieBookingController {

	
	@Autowired
	private MovieBookingService bookingService;
	
	@Autowired
	private Environment environment;
	@PostMapping("/movie")
	public ResponseEntity<String> addMovie(@RequestBody MovieBookingDTO bookingDTO) throws MovieBookingException{
		Integer bookingId=bookingService.addMovie(bookingDTO);
		String successMessage=environment.getProperty("Movie id is added : "+bookingId);
		return new ResponseEntity<String>(successMessage,HttpStatus.CREATED);
	}
	
	@GetMapping("/movies/{bookingId}")
	public ResponseEntity<MovieBookingDTO> getMovieById(@PathVariable("bookingId") Integer bookingId  )  throws MovieBookingException{
		MovieBookingDTO bookingDTO=bookingService.getMovieById(bookingId);
		return new ResponseEntity<MovieBookingDTO>(bookingDTO,HttpStatus.OK);
	}
	@GetMapping("/movies")
	public ResponseEntity<List<MovieBookingDTO>> getMovies() throws MovieBookingException{
		List<MovieBookingDTO> bookingDTO=bookingService.getAllMovie();
		return new ResponseEntity<>(bookingDTO,HttpStatus.OK);
	}
	
	@PutMapping("/movies/{bookingId}")
	public ResponseEntity<String> updateMovie(@PathVariable("bookingId") Integer bookingId,@RequestBody MovieBookingDTO  bookingDTO) throws MovieBookingException{
	MovieBookingDTO bookingDTO2=	bookingService.updateMovie(bookingId, bookingDTO.getMovieName(), bookingDTO.getNoOfSeats(), bookingDTO.getDate(), bookingDTO.getTime());
		String successMessage=environment.getProperty("Updated successfully")+bookingDTO2;
		return new ResponseEntity<>(successMessage,HttpStatus.OK);
	}
	
	@DeleteMapping("/movies/{bookingId}")
	public ResponseEntity<String> deleteMovie(@PathVariable("bookingId") Integer bookingId) throws MovieBookingException{
		bookingService.deleteMovie(bookingId);
		String successMessage=environment.getProperty("Deleted Successfully");
		return new ResponseEntity<>(successMessage,HttpStatus.OK);
		
	}
	
	@GetMapping("/movie/{id}")
	public ResponseEntity<MovieBookingDTO>  getMovieByIds(@PathVariable("id") Integer id) throws MovieBookingException{
		MovieBookingDTO bookingDTO=bookingService.getBookById(id);
		return new ResponseEntity<>(bookingDTO,HttpStatus.OK);
	}
	
}
