package edu.cvtc.web.servlets;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cvtc.web.comparators.ActorComparator;
import edu.cvtc.web.comparators.DirectorComparator;
import edu.cvtc.web.comparators.LengthComparator;
import edu.cvtc.web.comparators.TitleComparator;
import edu.cvtc.web.comparators.YearComparator;
import edu.cvtc.web.dao.MovieDao;
import edu.cvtc.web.dao.impl.MovieDaoException;
import edu.cvtc.web.dao.impl.MovieDaoImpl;
import edu.cvtc.web.model.Movie;

/**
 * @author Dylan Espie
 *
 */
/**
 * Servlet implementation class ViewAllController
 */
@WebServlet("/ViewAll")
public class ViewAllController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewAllController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Variables
		final MovieDao movieDao = new MovieDaoImpl();
		String target = "view-all.jsp";

		try {

			// List of all movies from database
			final List<Movie> movieList = movieDao.retrieveMovie();

			// If movie list is null create new database
			if (movieList.isEmpty()) {
				System.out.print("We got here!");
				movieDao.populate();
			}
			
			// Gets sort type from navigation drop box
			final String sortType = request.getParameter("sortType");

			// Sorts the movies based on sort type
			if (sortType != null) {
				sortMovie(movieList, sortType);
			}

			// Attach the list to the request object
			request.setAttribute("movieList", movieList);

		} catch (MovieDaoException e) {
			e.printStackTrace();
			throw new IOException("The workbook file has an invalid format");
		}
		
		// Request the view-all
		request.getRequestDispatcher(target).forward(request, response);

	}

	// Uses appropriate comparator with selected sort type
	private void sortMovie(final List<Movie> movieList, String sortType) {
		switch (sortType) {
		case "title":
			Collections.sort(movieList, new TitleComparator());
			break;
		case "director":
			Collections.sort(movieList, new DirectorComparator());
			break;
		case "year":
			Collections.sort(movieList, new YearComparator());
			break;
		case "lengthInMinutes":
			Collections.sort(movieList, new LengthComparator());
			break;
		case "actor":
			Collections.sort(movieList, new ActorComparator());
			break;
		default:
			break;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
