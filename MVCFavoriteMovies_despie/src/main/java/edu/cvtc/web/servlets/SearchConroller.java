package edu.cvtc.web.servlets;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import edu.cvtc.web.dao.MovieDao;
import edu.cvtc.web.dao.impl.MovieDaoException;
import edu.cvtc.web.dao.impl.MovieDaoImpl;
import edu.cvtc.web.model.Movie;

/**
 * @author Dylan Espie
 *
 */
/**
 * Servlet implementation class SearchConroller
 */
@WebServlet("/Search")
public class SearchConroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {

			String target = null;
			
			final MovieDao movieDao = new MovieDaoImpl();
			
			// Fills List with database movies
			final List<Movie> movieList = movieDao.retrieveMovie();
			
			// List of moves that match search results
			List<Movie> filteredMovie = null;
			
			// Gets users search
			final String search = request.getParameter("search");
			
			// Gets drop box selection
			String searchList = request.getParameter("dropBox");
			
			// If the search is bank returns null filteredMovie
			// else uses drop box selection and adds movie to filtered list if it matches search
			// Movie is added if it contains a letter or just part of the name. IE 'pulp' returns 'Pulp Fiction'
			if (search.trim().equals("")) {
				
			} else if (searchList.equals("title")) {
				filteredMovie = movieList
						.stream()
						.filter((movie) -> movie.getTitle().toLowerCase().contains(search.toLowerCase()))
						.collect(Collectors.toList());
				
			} else if (searchList.equals("director")) {
				filteredMovie = movieList
						.stream()
						.filter((movie) -> movie.getDirector().toLowerCase().contains(search.toLowerCase()))
						.collect(Collectors.toList());
				
			} else if (searchList.equals("year")) {
				filteredMovie = movieList
						.stream()
						.filter((movie) -> Integer.toString(movie.getYear()).contains(search))
						.collect(Collectors.toList());
				
			} else if (searchList.equals("actor")) {
				filteredMovie = movieList
						.stream()
						.filter((movie) -> movie.getActor().toLowerCase().contains(search.toLowerCase()))
						.collect(Collectors.toList());
			}			
			
			// Attach the list to the request object
			request.setAttribute("movieList", filteredMovie);
			
			target = "view-all.jsp";
			
			request.getRequestDispatcher(target).forward(request, response);

		} catch (MovieDaoException e) {
			e.printStackTrace();
			throw new IOException("The workbook file has an invalid format");
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
