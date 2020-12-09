/**
 * 
 */
package edu.cvtc.web.comparators;

import java.util.Comparator;

import edu.cvtc.web.model.Movie;

/**
 * @author Dylan Espie
 *
 */
public class LengthComparator implements Comparator<Movie> {

	// Compares length passed in
	@Override
	public int compare(Movie movie1, Movie movie2) {
		return movie1.getLengthInMinutes().compareTo(movie2.getLengthInMinutes());
	}

}
