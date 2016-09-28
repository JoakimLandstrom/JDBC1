package se.jola.jdbc1.repos.mysql;

import java.sql.SQLException;
import java.util.List;

import se.jola.jdbc1.exceptions.RepositoryException;
import se.jola.jdbc1.mapper.ResultMapper;
import se.jola.jdbc1.model.Actor;
import se.jola.jdbc1.model.Movie;
import se.jola.jdbc1.repos.MovieRepository;

public final class SQLMovieRepository implements MovieRepository {

	private final String url = "jdbc:mysql://localhost:3306/MovieDatabase?user=root&password=root&useSSL=false";

	private ResultMapper<Actor> actorMapper = (a -> new Actor(a.getInt("actorId"), a.getString("firstName"), a.getString("lastName")));
	private ResultMapper<Movie> movieMapper = (m -> new Movie(m.getInt("movieId"), m.getString("title"),
			m.getString("productionYear"), m.getString("name")));

	@Override
	public List<Actor> getAllActors() throws RepositoryException {

		try {

			return new SQL(url).query("select * from Actor").many(actorMapper);
		} catch (SQLException e) {
			throw new RepositoryException("Cant fetch actors");
		}

	}

	@Override
	public List<Movie> getAllMovies() throws RepositoryException {

		try {
			return new SQL(url).query("select movieId, title,productionYear, Genre.name from Movie "
					+ "join Genre on Movie.genreId = Genre.genreId").many(movieMapper);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RepositoryException("Couldnt fetch movies");
		}

	}

	@Override
	public void insertMovie(Movie movie) throws RepositoryException {

		try {
			new SQL(url)
					.query("insert into Movie set title=?, productionYear=?,"
							+ "genreId = (select genreId from Genre where name like ?)")
					.parameter(movie.getTitle()).parameter(movie.getProductionYear()).parameter(movie.getGenre())
					.update();

		} catch (SQLException e) {
			throw new RepositoryException("Can't insert movie");
		}

	}

	public void updateMovie(Movie movie) throws RepositoryException {

		try {
			new SQL(url)
					.query("update Movie set title=?, productionYear=?,"
							+ " genreId = (select genreId from Genre where name like ?) where movieId=?")
					.parameter(movie.getTitle()).parameter(movie.getProductionYear()).parameter(movie.getGenre())
					.parameter(movie.getId()).update();
		} catch (SQLException e) {
			throw new RepositoryException("Can't delete movie");
		}

	}

	public void deleteMovie(Movie movie) throws RepositoryException {

		try {
			new SQL(url).query("delete from Movie where movieId = ?").parameter(movie.getId()).update();
		} catch (SQLException e) {
			throw new RepositoryException("Can't delete movie");
		}
	}

	@Override
	public void insertActor(Actor actor) throws RepositoryException {

		try {
			new SQL(url).query("insert into Actor set firstName = ?, lastName = ?").parameter(actor.getFirstName())
					.parameter(actor.getLastName()).update();
		} catch (SQLException e) {
			throw new RepositoryException("Can't insert Actor!");
		}
	}

	@Override
	public void updateActor(Actor actor) throws RepositoryException {

		try {
			new SQL(url).query("update Actor set firstName = ?, lastName = ? where actorId = ?")
					.parameter(actor.getFirstName()).parameter(actor.getLastName()).parameter(actor.getActorId())
					.update();
		} catch (SQLException e) {
			throw new RepositoryException("Can't create new Actor");
		}
	}

	@Override
	public void deleteActor(Actor actor) throws RepositoryException {

		try {
			new SQL(url).query("delete from Actor where actorId = ?").parameter(actor.getActorId())
			.update();
		} catch (SQLException e) {
			throw new RepositoryException("Can't delete Actor");
		}
	}
}
