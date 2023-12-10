package com.nsd.movies.services;

import java.util.List;

import com.nsd.movies.dto.Movies;

public interface MoviesService {


	List<Movies> getAllMovies();
	
	Movies getMovieByName(String name);
	
	Movies getMovieById(Integer id);
	
	Movies saveMovie(Movies movies);
}
