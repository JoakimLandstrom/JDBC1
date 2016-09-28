package se.jola.jdbc1.repos;

import java.util.List;

import se.jola.jdbc1.exceptions.RepositoryException;
import se.jola.jdbc1.model.Actor;
import se.jola.jdbc1.model.Movie;

public interface MovieRepository {
		
	List<Movie> getAllMovies() throws RepositoryException;
	
	void insertMovie(Movie movie) throws RepositoryException;
	
	void updateMovie(Movie movie) throws RepositoryException; 
	
	void deleteMovie(Movie movie) throws RepositoryException;

	
	List<Actor> getAllActors() throws RepositoryException;
	
	void insertActor(Actor actor) throws RepositoryException;
	
	void updateActor(Actor actor) throws RepositoryException;
	
	void deleteActor(Actor actor) throws RepositoryException;
}
