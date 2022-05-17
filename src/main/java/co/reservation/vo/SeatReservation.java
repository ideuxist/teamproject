package co.reservation.vo;

public class SeatReservation {

	private int seatReservationId;
	private int screeningId;
	private int seatId;
	private int reserSeat;

	public SeatReservation() {
		super();
	}

	public SeatReservation(int seatReservationId, int screeningId, int seatId, int reserSeat) {
		super();
		this.seatReservationId = seatReservationId;
		this.screeningId = screeningId;
		this.seatId = seatId;
		this.reserSeat = reserSeat;
	}

	public int getSeatReservationId() {
		return seatReservationId;
	}

	public void setSeatReservationId(int seatReservationId) {
		this.seatReservationId = seatReservationId;
	}

	public int getScreeningId() {
		return screeningId;
	}

	public void setScreeningId(int screeningId) {
		this.screeningId = screeningId;
	}

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public int getReserSeat() {
		return reserSeat;
	}

	public void setReserSeat(int reserSeat) {
		this.reserSeat = reserSeat;
	}

	@Override
	public String toString() {
		return "SeatReservation [seatReservationId=" + seatReservationId + ", screeningId=" + screeningId + ", seatId="
				+ seatId + ", reserSeat=" + reserSeat + "]";
	}

}
