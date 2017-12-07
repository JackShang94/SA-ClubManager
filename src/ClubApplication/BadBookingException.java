package ClubApplication;

public class BadBookingException extends Exception {
	public BadBookingException() {
	}

	public BadBookingException(String msg) {
		super(msg);
	}
}
