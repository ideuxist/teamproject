package co.movie.vo;

public class ReserMovie {
	private String title;

	public ReserMovie() {
	}

	public ReserMovie(String title) {
		super();
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "ReserMovie [title=" + title + "]";
	}

}
