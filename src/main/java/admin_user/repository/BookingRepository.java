package admin_user.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import admin_user.model.Booking;
import admin_user.model.BookingStatus;

public interface BookingRepository extends JpaRepository<Booking, Long> {
	
	//long countByVisitDateAndVisitTime(LocalDate localDate, LocalTime visitTime);

	long countByVisitDateAndVisitTime(LocalDate visitDate, LocalTime visitTime);
	 List<Booking> findByStatus(BookingStatus status); // This should now work correctly
	// List<Booking> findByStatus(BookingStatus status);

}
