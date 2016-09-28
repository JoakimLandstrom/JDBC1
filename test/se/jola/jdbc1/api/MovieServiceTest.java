package se.jola.jdbc1.api;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import se.jola.jdbc1.model.Actor;
import se.jola.jdbc1.model.Movie;
import se.jola.jdbc1.repos.MockRepository;

public class MovieServiceTest {

	private final MockRepository repo = new MockRepository();
	private MovieService movieService = new MovieService(repo);
	
	@Test
	public void getAllMoviesShouldReturnAListWithMovies() {
		
		List<Movie> list = movieService.getAllMovies();
		
		assertTrue(list.size() >= 1);
	}
	
	@Test
	public void getAllActorsShouldReturnAListWithActors(){
		
		List<Actor> list = movieService.getAllActors();
		
		assertTrue(list.size()>= 1);
	}
}
