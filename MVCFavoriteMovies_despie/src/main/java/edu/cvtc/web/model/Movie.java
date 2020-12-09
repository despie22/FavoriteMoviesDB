/**
 * 
 */
package edu.cvtc.web.model;

import java.io.Serializable;

/**
 * @author Dylan
 *
 */
public class Movie implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Object fields
	private String title;
	private String director;
	private Integer lengthInMinutes;
	private String actor;
	private Integer year;
	
	public Movie() {
		
	}
	
	// Movie constructor
	public Movie(final String title, final String director, final int lengthInMinutes, final String actor, final int year) {
		this.title = title;
		this.director = director;
		this.lengthInMinutes = lengthInMinutes;
		this.actor = actor;
		this.year = year;
	}

	// Getters and Setters
	public String getTitle() {
		return title;
	}

	public String getDirector() {
		return director;
	}

	public Integer getLengthInMinutes() {
		return lengthInMinutes;
	}

	public String getActor() {
		return actor;
	}

	public Integer getYear() {
		return year;
	}

	// toString (Unused)
	@Override
	public String toString() {
		return "Movie [title=" + title + ", director=" + director + ", lengthInMinutes=" + lengthInMinutes + ", actor="
				+ actor + ", year=" + year + "]";
	}
	
}
