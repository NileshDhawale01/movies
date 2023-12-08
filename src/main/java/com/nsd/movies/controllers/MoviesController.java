package com.nsd.movies.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MoviesController {

	@GetMapping("/all")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Map<Object, Object>> getAllMovies(){
		Map<Object, Object> map = new HashMap<>();
		map.put("Movies", "This is the movies data");
		map.put("success", true);
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('USER')")
	public ResponseEntity<Map<Object, Object>> getMoviesById(@PathVariable Integer id){
		Map<Object, Object> map = new HashMap<>();
		map.put("Movie", "this is the movie.");
		map.put("success", true);
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
	@GetMapping("/movie/{name}")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
	public ResponseEntity<Map<Object, Object>> getMoviesByName(@PathVariable String name){
		Map<Object, Object> map = new HashMap<>();
		map.put("Movies", "list of movies");
		map.put("success", true);
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
}
