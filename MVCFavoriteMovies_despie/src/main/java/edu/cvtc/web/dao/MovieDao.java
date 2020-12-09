/**
 * 
 */
package edu.cvtc.web.dao;

import java.util.List;

import edu.cvtc.web.dao.impl.MovieDaoException;
import edu.cvtc.web.model.Movie;

/**
 * @author Dylan Espie
 *
 */
public interface MovieDao {

	// Each data access object must include
	// Populate data method
	void populate() throws MovieDaoException;

	// Retrieve data method
	List<Movie> retrieveMovie() throws MovieDaoException;

	// Insert new data method
	void insertMovie(Movie movie) throws MovieDaoException;

}
