package admin_user.service;

import java.util.List;

import admin_user.dto.BookingDto;
import admin_user.model.Booking;
import admin_user.model.BookingStatus;

public interface BookingService {
	
	void saveBooking(BookingDto bookingDto);
	List<Booking> getAllBookings();  // New method to retrieve bookings
	Booking findBookingById(Long id);
	void approveBooking(Long bookingId); // New method for approving booking
    void rejectBooking(Long bookingId);  // New method for rejecting booking
    List<Booking> getBookingsByStatus(BookingStatus status); // New method for filtering by status
    //boolean isTimeSlotAvailable(String visitTime);
	List<Booking> getPendingBookings();
	List<Booking> getApprovedBookings();

}
