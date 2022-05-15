package co.movie.vo;

public class ReserRound {

private int round;
private String title;

public String getTitle() {
	return title;
}

public ReserRound() {}

public void setTitle(String title) {
	this.title = title;
}

public ReserRound(int round, String title) {
	super();
	this.round = round;
	this.title = title;
}



public ReserRound(int round) {
	super();
	this.round = round;
}


public int getRound() {
	return round;
}

public void setRound(int round) {
	this.round = round;
}

@Override
public String toString() {
	return "ReserRound [round=" + round + ", title=" + title + "]";
}






}
