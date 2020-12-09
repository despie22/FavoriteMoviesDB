/**
 * 
 */
package edu.cvtc.web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import edu.cvtc.web.dao.MovieDao;
import edu.cvtc.web.model.Movie;
import edu.cvtc.web.util.DBUtility;

/**
 * @author Dylan Espie
 *
 */
public class MovieDaoImpl implements MovieDao {

	// Constants for DOA
	private static final String DROP_TABLE_MOVIE = "drop table if exists movie;";
	private static final String CREATE_TABLE_MOVIE = "create table movie(id integer primary key autoincrement, title text, director text, lengthInMinutes integer, actor text, year integer);";
	private static final String SELECT_ALL_FROM_MOVIE = "select * from movie;";
	
	// Populates a database
	// Deletes table and creates a new fresh table
	@Override
	public void populate() throws MovieDaoException {
		
		// Variables
		// Database objects
		Connection connection = null;
		Statement statement = null;
		
		try {
			
			// Assign with createConnection method from DBUtility class
			connection = DBUtility.createConnection();
			
			// Assign sql create statement
			statement = connection.createStatement();

			// Set timeout duration
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			
			// Drops and creates new movie table
			statement.executeUpdate(DROP_TABLE_MOVIE);
			statement.executeUpdate(CREATE_TABLE_MOVIE);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new MovieDaoException("Error: Unable to populate database");
		} finally {
			DBUtility.closeConnections(connection, statement);
		}
	}

	// Retrieve movies from database
	// Creates new array list with all saved movies
	@Override
	public List<Movie> retrieveMovie() throws MovieDaoException {

		final List <Movie> movieList = new ArrayList<>();
		
		// Variables
		// Database objects
		Connection connection = null;
		Statement statement = null;
		
		try {
			
			// Assign with createConnection method from DBUtility class
			connection = DBUtility.createConnection();
			
			// Assign as a sql create statement and set timeout duration
			statement = connection.createStatement();
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			
			// Assign all movies in the database
			final ResultSet resultSet = statement.executeQuery(SELECT_ALL_FROM_MOVIE);
			
			// Loop through each movie
			while (resultSet.next()) {
				
				// Initialize the data to create a movie object
				final String title = resultSet.getString("title");
				final String director = resultSet.getString("director");
				final int lengthInMinutes = resultSet.getInt("lengthInMinutes");
				final String actor = resultSet.getString("actor");
				final int year = resultSet.getInt("year");
				
				// Create a new Movie object and add it to our movie list
				movieList.add(new Movie(title, director, lengthInMinutes, actor, year));
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new MovieDaoException("Error: Unable to retrieve movie");
		}
		
		// Return the movie list
		return movieList;
	}

	// Add new movie to the database
	@Override
	public void insertMovie(Movie movie) throws MovieDaoException {
		
		// Variables
		// Database objects
		Connection connection = null;
		PreparedStatement insertStatement = null;
		
		try {
			
			// Assign with createConnection method from DBUtility class
			connection = DBUtility.createConnection();
			
			// The question marks are parameter stand-ins for data that will be provided below
			final String sqlStatement = "insert into movie (title, director, lengthInMinutes, actor, year) values (?,?,?,?,?)";
			insertStatement = connection.prepareStatement(sqlStatement);
			
			// Get the data from the movie object and assign it to our prepared statement
			insertStatement.setString(1, movie.getTitle());
			insertStatement.setString(2, movie.getDirector());
			insertStatement.setInt(3, movie.getLengthInMinutes());
			insertStatement.setString(4, movie.getActor());
			insertStatement.setInt(5, movie.getYear());
			
			// Set timeout duration
			insertStatement.setQueryTimeout(DBUtility.TIMEOUT);
			
			// Insert movie into the database
			insertStatement.executeUpdate();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new MovieDaoException("Error: unable to add Movie to the database");
		}
		
		
	}

}
