package mv.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mv.service.MovieService;

public class MovieHistoryControl implements Control {
	
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		MovieService service = new MovieService();
		service.movieHistory(id);

	}

}
