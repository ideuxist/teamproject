package co.movie.vo;


public class ReserDate{
	
	private String date;

	public ReserDate() {
		
	}
	
	public ReserDate(String date) {
		super();
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ReserDate [date=" + date + "]";
	}
	
	
	
	
}
