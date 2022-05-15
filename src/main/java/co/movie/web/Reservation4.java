package co.movie.web;


import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/reservation4")
public class Reservation4 extends HttpServlet { 
	private static final long serialVersionUID = 1L;
       
    public Reservation4() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String round = request.getParameter("seeround");
		String date = request.getParameter("date");
		String movie = request.getParameter("movie");
		System.out.println(round);
		System.out.println("안되노");
		request.setAttribute("round", round);
		request.setAttribute("date", date);
		request.setAttribute("movie", movie);
		request.getRequestDispatcher("reservation/reservation.tiles").forward(request, response);
		
		
		
		
		

	
	}

}
