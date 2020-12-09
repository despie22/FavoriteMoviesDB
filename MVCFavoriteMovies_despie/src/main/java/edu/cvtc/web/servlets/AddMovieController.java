package edu.cvtc.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.base.Strings;

import edu.cvtc.web.dao.MovieDao;
import edu.cvtc.web.dao.impl.MovieDaoException;
import edu.cvtc.web.dao.impl.MovieDaoImpl;
import edu.cvtc.web.model.Movie;

/**
 * Servlet implementation class AddMovieController
 */
@WebServlet("/AddMovie")
public class AddMovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMovieController() {
        super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String target = null;
		
		try {
			
			// Movie object variables
			final String title = request.getParameter("title");
			final String director = request.getParameter("director");
			final String lengthInMinutesString = request.getParameter("lengthInMinutes");
			final String actor = request.getParameter("actor");
			final String yearString = request.getParameter("year");
			
			// Check if fields are empty
			if(Strings.isNullOrEmpty(title)
					|| Strings.isNullOrEmpty(director)
					|| Strings.isNullOrEmpty(lengthInMinutesString)
					|| Strings.isNullOrEmpty(actor)
					|| Strings.isNullOrEmpty(yearString)){
				
				request.setAttribute("message", "You must complete all fields to submit the form.");
				target = "error.jsp";
				
			} 
			else if (!isInteger(lengthInMinutesString)
					|| !isInteger(yearString)) {
				
				request.setAttribute("message", "Length and Year need to be numbers greater than 0.");
				target = "error.jsp";
				
			} else {
				
				// Strings to Integers
				final int lengthInMinutes = Integer.parseInt(lengthInMinutesString);
				final int year = Integer.parseInt(yearString);
				
				final MovieDao movieDao = new MovieDaoImpl();
				
				// Create Movie object with variables
				final Movie movie = new Movie(title, director, lengthInMinutes, actor, year);
				
				// Insert movie into the database
				movieDao.insertMovie(movie);
				
				target = "success.jsp";
			}
			
		} catch (MovieDaoException e) {
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			target = "error.jsp";
		}
		
		request.getRequestDispatcher(target).forward(request, response);
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	// Integer check
	public static boolean isInteger(String str) {
	    if (str == null) {
	        return false;
	    }
	    int length = str.length();
	    if (length == 0) {
	        return false;
	    }
	    int i = 0;
	    if (str.charAt(0) == '-') {
	        if (length == 1) {
	            return false;
	        }
	        i = 1;
	    }
	    for (; i < length; i++) {
	        char c = str.charAt(i);
	        if (c < '0' || c > '9') {
	            return false;
	        }
	    }
	    return true;
	}

}
