package ClubApplication;

import java.awt.print.Book;
import java.lang.Thread.State;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class BookingRegister {
	private HashMap<Facility, ArrayList<Booking>> bookings;

	public BookingRegister() {
		bookings = new HashMap<Facility, ArrayList<Booking>>();
	}

	public void addBooking(Member member, Facility facility, java.util.Date date, java.util.Date date2) throws BadBookingException {
		Booking b = new Booking(member, facility, date, date2);
		ArrayList<Booking> bookinglist = bookings.get(facility);
		if (bookinglist == null) {
			bookinglist = new ArrayList<Booking>();
			bookings.put(facility, bookinglist);
		} else {
			Iterator<Booking> i = bookinglist.iterator();
			while (i.hasNext()) {
				Booking other = i.next();
				if (b.overlaps(other)) {
					throw new BadBookingException("New booking overlaps with existing one");
				}
			}
		}
		bookinglist.add(b);
	}

	public ArrayList<Booking> getBookings(Facility facility, Date startDate, Date endDate) {

		ArrayList<Booking> selected = new ArrayList<Booking>();
		ArrayList<Booking> bookingList = bookings.get(facility);
		if (bookingList != null) {
			Iterator<Booking> i = bookingList.iterator();
			while (i.hasNext()) {
				Booking b = i.next();
				boolean earlier = startDate.after(b.getEndDate());
				boolean later = endDate.before(b.getStartDate());
				if (!(earlier || later)) {
					selected.add(b);
				}
			}
		}
		return selected;
	}

	public void removeBooking(Booking booking) {
		ArrayList<Booking> bookingList = bookings.get(booking.getFacility());
		if (bookingList != null) {
			bookingList.remove(booking);
		}
	}
}
