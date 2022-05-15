package co.movie.web;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.movie.service.ReservationService;
import co.movie.vo.ReserDate;
import co.movie.vo.ReserMovie;
import co.movie.vo.ReserRound;

@WebServlet("/reservation3")
public class Reservation3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Reservation3() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String movie = request.getParameter("seemovie");
		String date = request.getParameter("date");
		System.out.println(movie);
		System.out.println(date); 
		ReservationService service = new ReservationService();
		List<ReserDate> list = service.ReserDate();
		request.setAttribute("all", list);
		List<ReserMovie> list2 = service.ReserMovie(date);
		request.setAttribute("all2", list2);
		List<ReserRound> list3 = service.ReserRound(movie,date);
		System.out.println(list3);
		request.setAttribute("all3", list3);
		request.setAttribute("date", date);
		request.setAttribute("movie", movie);
		request.getRequestDispatcher("reservation/reservation.tiles").forward(request, response);
		
		
		
		
		

	
	}

}
