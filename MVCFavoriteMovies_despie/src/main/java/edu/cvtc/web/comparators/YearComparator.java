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
public class YearComparator implements Comparator<Movie> {

	// Compares years passed in
	@Override
	public int compare(Movie movie1, Movie movie2) {
		return movie1.getYear().compareTo(movie2.getYear());
	}

}
