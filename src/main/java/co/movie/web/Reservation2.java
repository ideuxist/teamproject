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

@WebServlet("/reservation2")
public class Reservation2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Reservation2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String date = request.getParameter("seedate");
		ReservationService service = new ReservationService();
		List<ReserDate> list = service.ReserDate();
		List<ReserMovie> list2 = service.ReserMovie(date);
		System.out.println(list);
		System.out.println(list2);
		request.setAttribute("all", list);
		request.setAttribute("all2", list2);
		request.setAttribute("seedate", date);
		request.getRequestDispatcher("reservation/reservation.tiles").forward(request, response);
		
		
		
		
		

	
	}

}
