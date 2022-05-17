package co.reservation.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.bag.SynchronizedSortedBag;

import co.reservation.service.ReservationService;
import co.reservation.vo.Movie;
import co.reservation.vo.Screening;

@WebServlet("/screeningChoice")
public class ScreeningChoice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ScreeningChoice() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			dohandle(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		dohandle(request,response); 
	} 

	protected void dohandle(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("choice");
		System.out.println(action);
		
		if (action.equals("choiceDate")){
			ReservationService service = new ReservationService();
			List<Screening> dateList = service.choiceDate();
			System.out.println(dateList);
			request.setAttribute("seeDate", dateList);
			request.getRequestDispatcher("reservation/reservation.tiles").forward(request, response);
		
		} else if(action.equals("currentMovie")) {
			String date = request.getParameter("selectedDate");
			ReservationService service = new ReservationService();
			List<Movie> movieList = service.choiceMoive(date);
			System.out.println(movieList);
			System.out.println(date);
			request.setAttribute("selectedDate", date);
			request.setAttribute("movieList", movieList);
			request.getRequestDispatcher("reservation/reservation.tiles").forward(request, response);
		
		}else if (action.equals("round")) {
			String date = request.getParameter("selectedDate");
			String movie = request.getParameter("selectedMovie");
			ReservationService service = new ReservationService();
			List<Screening> screening = service.choiceRound(date,movie);
			System.out.println(screening);
			request.setAttribute("selectedDate", date);
			request.setAttribute("selectedMovie", movie);
			request.setAttribute("round", screening);
			request.getRequestDispatcher("reservation/reservation.tiles").forward(request, response);
			
		}else if (action.equals("searchSeat")) {
			String date = request.getParameter("date");
			String movie = request.getParameter("movie");
			String startTime = request.getParameter("time");
			
		}
		
	}
}
