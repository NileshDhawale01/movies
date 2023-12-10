package com.nsd.movies.services.impl;

import static com.nsd.movies.mappers.MoviesMapper.*;
import static com.nsd.movies.mappers.MoviesMapper.toMovies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nsd.movies.dto.Movies;
import com.nsd.movies.entities.MoviesMaster;
import com.nsd.movies.repositoryes.MoviesRepo;
import com.nsd.movies.services.MoviesService;

@Service
public class MoviesServiceImpl implements MoviesService{

	@Autowired
	private MoviesRepo moviesRepo;
	
	@Override
	public List<Movies> getAllMovies() {
		return toMovies.apply(moviesRepo.findAll());
	}

	@Override
	public Movies getMovieByName(String name) {
		return toMovie.apply(moviesRepo.findByMoviename(name).get()).orElseThrow(()->new RuntimeException());
	}

	@Override
	public Movies getMovieById(Integer id) {
		return toMovie.apply(moviesRepo.findById(id).get()).orElseThrow(()-> new RuntimeException());
	}

	@Override
	public Movies saveMovie(Movies movies) {
		MoviesMaster master = toMoviesMaster.apply(movies).get();
		return toMovie.apply(moviesRepo.save(master)).get();
	}

}
