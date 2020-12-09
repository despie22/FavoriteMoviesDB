/**
 * 
 */
package edu.cvtc.web.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import edu.cvtc.web.model.Movie;

/**
 * @author Dylan Espie
 *
 */

// UNUSED IN PROGRAM!! !!USE TO CREATE MOVIE LIST FROM INCLUDED SPREADSHEET
public class WorkbookUtility {

	public static final String INPUT_FILE = "assets/MovieList.xlsx";

	public static List<Movie> retrieveMovieFromWorkbook(final File inputFile) throws InvalidFormatException, IOException {
		
		final List<Movie> movieList = new ArrayList<>();
		
		//NOTES: create a Workbook from the input file
		final Workbook workbook = WorkbookFactory.create(inputFile);
		
		final Sheet sheet = workbook.getSheetAt(0);
		
		//NOTES: iterate over each row in the Worksheet from the Workbook
		for (final Row row : sheet	 ) {
			final Cell titleCell = row.getCell(0);
			final Cell directorCell = row.getCell(1);
			final Cell lengthInMinutesCell = row.getCell(2);
			final Cell actorCell = row.getCell(3);
			final Cell yearCell = row.getCell(4);
			
			//NOTES: crate a new Person object for each Row in the Worksheet			
			final Movie movie = new Movie(
					titleCell.getStringCellValue().trim(),
					directorCell.getStringCellValue().trim(), 
					(int) lengthInMinutesCell.getNumericCellValue(), 
					actorCell.getStringCellValue().trim(),
					(int) yearCell.getNumericCellValue());
					
			
			movieList.add(movie);
		}
		
		return movieList;
		
	}
	
}
