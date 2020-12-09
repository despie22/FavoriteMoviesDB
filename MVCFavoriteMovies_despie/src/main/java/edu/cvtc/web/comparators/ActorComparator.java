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
public class ActorComparator implements Comparator<Movie> {

	// Compares actors passed in
	@Override
	public int compare(Movie movie1, Movie movie2) {
		return movie1.getActor().compareTo(movie2.getActor());
	}

}
