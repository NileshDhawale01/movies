package com.nsd.movies.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nsd.movies.dto.Movies;
import com.nsd.movies.services.MoviesService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MoviesController {

	@Autowired
	private MoviesService moviesService;

	@GetMapping("/all")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Map<Object, Object>> getAllMovies() {
		Map<Object, Object> map = new HashMap<>();
		map.put("Movies", moviesService.getAllMovies());
		map.put("success", true);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('USER')")
	public ResponseEntity<Map<Object, Object>> getMoviesById(@PathVariable Integer id) {
		Map<Object, Object> map = new HashMap<>();
		map.put("Movie", moviesService.getMovieById(id));
		map.put("success", true);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@GetMapping("/movie/{name}")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
	public ResponseEntity<Map<Object, Object>> getMoviesByName(@PathVariable String name) {
		Map<Object, Object> map = new HashMap<>();
		map.put("Movies", moviesService.getMovieByName(name));
		map.put("success", true);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@PostMapping("/save")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Map<Object, Object>> saveMovie(@RequestBody Movies movies) {
		Map<Object, Object> map = new HashMap<>();
		map.put("Data", moviesService.saveMovie(movies));
		map.put("success", true);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
}
