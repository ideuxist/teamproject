package co.reservation.service;

import java.util.List;

import co.reservation.dao.ReservationDAO;
import co.reservation.vo.Movie;
import co.reservation.vo.Screening;


public class ReservationService {
	ReservationDAO dao = new ReservationDAO();
	
	public List<Screening> choiceDate(){
		return dao.dateChoice();
		
	}

	public List<Movie> choiceMoive(String date) {
		return dao.movieChoice(date);
	}

	public List<Screening> choiceRound(String date,String title) {
		// TODO Auto-generated method stub
		return dao.roundChoice(date,title);
	} 
}
		
