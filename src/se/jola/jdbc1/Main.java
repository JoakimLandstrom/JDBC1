package se.jola.jdbc1;

import java.util.List;

import se.jola.jdbc1.api.MovieService;
import se.jola.jdbc1.model.Movie;
import se.jola.jdbc1.repos.mysql.SQLMovieRepository;

public class Main {

	public static void main(String[] args) {

		MovieService movieService = new MovieService(new SQLMovieRepository());

		Movie movie1 = new Movie(2, "Back to the Future IV", "2016", "Sci fi");
		
		movieService.updateMovie(movie1);
		
		List<Movie> list = movieService.getAllMovies();
		
		for (Movie movie : list) {
			System.out.println(movie.getTitle() + " " + movie.getProductionYear() + " " + movie.getGenre());
		}
		
	}

}
