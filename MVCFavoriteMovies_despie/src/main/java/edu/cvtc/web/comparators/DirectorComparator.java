package edu.cvtc.web.comparators;

import java.util.Comparator;

import edu.cvtc.web.model.Movie;

/**
 * @author Dylan Espie
 *
 */

public class DirectorComparator implements Comparator<Movie> {

	// Compares directors passed in
	@Override
	public int compare(Movie movie1, Movie movie2) {
		return movie1.getDirector().compareTo(movie2.getDirector());
	}

}
