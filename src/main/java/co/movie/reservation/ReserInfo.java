package co.movie.reservation;


public class ReserInfo {
	private String reserDate;
	private String selMovie;
	private String round;
	private String theater;
	
	
	public String getRound() {
		return round;
	}

	public void setRound(String round) {
		this.round = round;
	}

	public String getTheater() {
		return theater;
	}

	public void setTheater(String theater) {
		this.theater = theater;
	}

	public ReserInfo() {}
	

	
	public ReserInfo(String reserDate, String selMovie, String round, String theater) {
		super();
		this.reserDate = reserDate;
		this.selMovie = selMovie;
		this.round = round;
		this.theater = theater;
	}

	public String getReserDate() {
		return reserDate;
	}
	public void setReserDate(String reserDate) {
		this.reserDate = reserDate;
	}
	public String getSelMovie() {
		return selMovie;
	}
	public void setSelMovie(String selMovie) {
		this.selMovie = selMovie;
	}
	public String getSelTheater() {
		return round;
	}
	public void setSelTheater(String selTheater) {
		this.round = selTheater;
	}
	
	
}
