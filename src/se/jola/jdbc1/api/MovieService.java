package se.jola.jdbc1.api;

import java.util.List;

import se.jola.jdbc1.exceptions.RepositoryException;
import se.jola.jdbc1.exceptions.ServiceException;
import se.jola.jdbc1.model.Actor;
import se.jola.jdbc1.model.Movie;
import se.jola.jdbc1.repos.MovieRepository;

public final class MovieService {

	private final MovieRepository repository;

	public MovieService(MovieRepository repo) {
		repository = repo;
	}

	public List<Actor> getAllActors() {

		try {
			return repository.getAllActors();

		} catch (RepositoryException e) {
			throw new ServiceException("Couldnt get all actors", e);
		}
	}

	public List<Movie> getAllMovies() {
		try {
			return repository.getAllMovies();

		} catch (RepositoryException e) {
			throw new ServiceException("Couldnt get all movies", e);
		}
	}

	public void insertMovie(Movie movie) {
		try {
			repository.insertMovie(movie);
		} catch (RepositoryException e) {
			throw new ServiceException("Couldnt insert movie", e);
		}
	}

	public void updateMovie(Movie movie) {
		try {
			repository.updateMovie(movie);
		} catch (RepositoryException e) {
			throw new ServiceException("Couldnt update movie", e);
		}
	}

	public void deleteMovie(Movie movie) {
		try {
			repository.deleteMovie(movie);
		} catch (RepositoryException e) {
			throw new ServiceException("Couldnt delete movie", e);
		}
	}
}
