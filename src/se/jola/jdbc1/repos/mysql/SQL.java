package se.jola.jdbc1.repos.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import se.jola.jdbc1.mapper.ResultMapper;

public final class SQL {

	private final String url;
	private final List<Object> parameters;
	private String query;

	public SQL(String url) {
		this.url = url;
		this.parameters = new ArrayList<>();
	}

	public SQL query(String query) {
		this.query = query;
		return this;
	}

	public SQL parameter(String parameter) {
		parameters.add(parameter);
		return this;
	}

	public SQL parameter(int parameter) {
		parameters.add(parameters);
		return this;
	}

	public void update() throws SQLException {
		try (Connection connection = DriverManager.getConnection(url);
				PreparedStatement statement = preparedStatement(connection)) {

			statement.executeUpdate();

			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException();
		}
	}

	public <T> T single(ResultMapper<T> mapper) throws SQLException {

		try (Connection connection = DriverManager.getConnection(url);
				PreparedStatement statement = preparedStatement(connection);
				ResultSet resultSet = statement.executeQuery()) {

			if (resultSet.next()) {
				connection.commit();
				return mapper.map(resultSet);
			} else {
				throw new SQLException();
			}
		}
	}

	public <T> List<T> many(ResultMapper<T> mapper) throws SQLException {

		List<T> result = new ArrayList<>();

		try (Connection connection = DriverManager.getConnection(url);
				PreparedStatement statement = preparedStatement(connection);
				ResultSet resultSet = statement.executeQuery()) {

			while (resultSet.next()) {
				result.add(mapper.map(resultSet));
			}
			connection.commit();
		} catch (SQLException e) {
			throw new SQLException();
		}

		return result;
	}

	private PreparedStatement preparedStatement(Connection connection) throws SQLException {
		connection.setAutoCommit(false);
		PreparedStatement statement = connection.prepareStatement(query);

		for (int i = 0; i < parameters.size(); i++) {
			statement.setObject(i + 1, parameters.get(i));
		}

		return statement;
	}

}
