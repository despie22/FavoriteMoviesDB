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
public class TitleComparator implements Comparator<Movie> {

	// Compares titles passed in
	@Override
	public int compare(Movie movie1, Movie movie2) {
		return movie1.getTitle().compareTo(movie2.getTitle());
	}

}
