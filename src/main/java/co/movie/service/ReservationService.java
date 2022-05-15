package co.movie.service;

import java.util.List;

import co.movie.dao.ReservationDAO;
import co.movie.vo.ReserDate;
import co.movie.vo.ReserMovie;
import co.movie.vo.ReserRound;

public class ReservationService {
	ReservationDAO dao = new ReservationDAO();
	
	public List<ReserDate> ReserDate() {
		return dao.getDate();
	}
	
	public List<ReserMovie> ReserMovie(String date) {
		return dao.getTitle(date);
	}

	public List<ReserRound> ReserRound(String movie,String date) {
		// TODO Auto-generated method stub
		return dao.getRound(movie,date);
	}
}
