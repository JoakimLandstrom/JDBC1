package se.jola.jdbc1.repos;

import java.util.ArrayList;
import java.util.List;

import se.jola.jdbc1.exceptions.RepositoryException;
import se.jola.jdbc1.model.Actor;
import se.jola.jdbc1.model.Movie;

public class MockRepository implements MovieRepository {

	@Override
	public List<Movie> getAllMovies() throws RepositoryException {
		
		List<Movie> list = new ArrayList<>();
		
		list.add(new Movie(1, "Star Wash - En kväll på stjärntvätten", "1337", "Sci fi"));
		list.add(new Movie(1, "Star Wash - En kväll på stjärntvätten", "1337", "Sci fi"));
		list.add(new Movie(1, "Star Wash - En kväll på stjärntvätten", "1337", "Sci fi"));
		list.add(new Movie(1, "Star Wash - En kväll på stjärntvätten", "1337", "Sci fi"));
		
		return list;
	}

	@Override
	public void insertMovie(Movie movie) throws RepositoryException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMovie(Movie movie) throws RepositoryException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMovie(Movie movie) throws RepositoryException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Actor> getAllActors() throws RepositoryException {
		
		List<Actor> list = new ArrayList<>();
		
		list.add(new Actor(1, "Pelle", "Chanslös"));
		list.add(new Actor(1, "Pelle", "Chanslös"));
		list.add(new Actor(1, "Pelle", "Chanslös"));
		
		return list;
	}

	@Override
	public void insertActor(Actor actor) throws RepositoryException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateActor(Actor actor) throws RepositoryException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteActor(Actor actor) throws RepositoryException {
		// TODO Auto-generated method stub
		
	}

}
