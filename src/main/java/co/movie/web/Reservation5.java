package co.movie.web;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.movie.service.ReservationService;



@WebServlet("/reservation5")
public class Reservation5 extends HttpServlet { 
	private static final long serialVersionUID = 1L;
       
    public Reservation5() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("date");
		String movie = request.getParameter("movie");
		String round = request.getParameter("round");
		
		ReservationService service = new ReservationService();
		List<ReserSeat> list = service.ReserSeat();
		request.getRequestDispatcher("reservation/reservation.tiles").forward(request, response);
		
		
		
		
		
		

	
	}

}
