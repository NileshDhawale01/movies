package com.nsd.movies.repositoryes;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nsd.movies.entities.MoviesMaster;

public interface MoviesRepo extends JpaRepository<MoviesMaster, Integer> {

	Optional<MoviesMaster> findByMoviename(String moviename);
}
