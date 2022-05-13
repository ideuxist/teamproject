package co.movie.reservation;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reservation")
public class Reservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Reservation() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	ReserInfo reserInfo = new ReserInfo();
	String date = request.getParameter("seeDate");
	String movie = request.getParameter("movie");
	String round = request.getParameter("round");
	String theater = request.getParameter("movie");
	
	reserInfo.setReserDate(date);
	reserInfo.setSelMovie(movie);
	reserInfo.setRound(round);
	reserInfo.setTheater(theater);
	
	request.setAttribute("reserInfo", reserInfo);
	request.getRequestDispatcher("/view/seat.jsp").forward(request, response);
	
	
	}

}
