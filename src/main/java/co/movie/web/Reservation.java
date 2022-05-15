package co.movie.web;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.movie.service.ReservationService;
import co.movie.vo.ReserDate;

@WebServlet("/reservation")
public class Reservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Reservation() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReservationService service = new ReservationService();
		List<ReserDate> list = service.ReserDate();
		request.setAttribute("all", list);
		System.out.println(list);
		request.getRequestDispatcher("reservation/reservation.tiles").forward(request, response);
		response.getWriter().print(list);
//		Gson gson = new GsonBuilder().create();
//		response.getWriter().print(gson.toJson(list));		
		
		
		
		

	
	}

}
