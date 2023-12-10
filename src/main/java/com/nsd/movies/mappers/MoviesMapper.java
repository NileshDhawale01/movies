package com.nsd.movies.mappers;

import static com.nsd.movies.utils.CollectionUtil.newList;
import static com.nsd.movies.utils.FunctionUtil.evalMapper;
import static com.nsd.movies.utils.FunctionUtil.evalMapperCollection;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import com.nsd.movies.dto.Movies;
import com.nsd.movies.entities.MoviesMaster;

public class MoviesMapper {

	private MoviesMapper() {}
	
	public static final Function<MoviesMaster, Optional<Movies>> toMovie = e->evalMapper(e, Movies.class);
	
	public static final Function<Movies, Optional<MoviesMaster>> toMoviesMaster = e->evalMapper(e, MoviesMaster.class);
	
	public static final Function<Collection<MoviesMaster>, List<Movies>> toMovies = e->newList(evalMapperCollection(e, Movies.class));
	
	public static final Function<Collection<Movies>, List<MoviesMaster>> toMoviesMasters = e->newList(evalMapperCollection(e, MoviesMaster.class));
}
