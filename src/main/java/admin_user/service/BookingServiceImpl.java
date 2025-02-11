package admin_user.service;

import java.time.LocalTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import admin_user.dto.BookingDto;
import admin_user.model.Booking;
import admin_user.model.BookingStatus;
import admin_user.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private EmailService emailService;

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public void saveBooking(BookingDto bookingDto) {
        LocalTime visitTime = bookingDto.getVisitTime();
        long bookingCount = bookingRepository.countByVisitDateAndVisitTime(bookingDto.getVisitDate(), visitTime);

        if (bookingCount >= 2) {
            throw new IllegalArgumentException("The selected time slot (" + visitTime + ") is fully booked. Please choose a different time.");
        }

        Booking book = new Booking(); // Corrected
        book.setVisitorNamesurname(bookingDto.getVisitorNamesurname());
        book.setIdentityNumber(bookingDto.getIdentityNumber());
        book.setAddressInfull(bookingDto.getAddressInfull());
        book.setRelationship(bookingDto.getRelationship());
        book.setCentre(bookingDto.getCentre());
        book.setVisitorEmail(bookingDto.getVisitorEmail());
        book.setVisitorPhone(bookingDto.getVisitorPhone());
        book.setInmateName(bookingDto.getInmateName());
        book.setInmateRegistration(bookingDto.getInmateRegistration());
        book.setVisitDate(bookingDto.getVisitDate());
        book.setVisitTime(visitTime);
        book.setMessage(bookingDto.getMessage());
        book.setStatus(BookingStatus.NEW); // Corrected

        bookingRepository.save(book);

        String subject = "Booking Confirmation";
        String body = String.format(
            "Hello %s,\n\nYour booking details are as follows, pending approval. We will notify you upon approval/rejection.\n\n" +
            "Visit Date: %s\nVisit Time: %s\n\n%s\n\nBest Regards,\nInmate Visit Booking System",
            bookingDto.getVisitorNamesurname(),
            bookingDto.getVisitDate(),
            bookingDto.getVisitTime(),
            bookingDto.getMessage().isEmpty() ? "No additional information provided." : "Additional details: " + bookingDto.getMessage()
        );

        emailService.sendRegistrationConfirmation(bookingDto.getVisitorEmail(), subject, body);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
    
    @Override
    public List<Booking> getPendingBookings() {
        return bookingRepository.findByStatus(BookingStatus.NEW);
    }

    @Override
    public List<Booking> getApprovedBookings() {
        return bookingRepository.findByStatus(BookingStatus.APPROVED);
    }

    @Override
    public Booking findBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public void approveBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid booking ID"));

        booking.setStatus(BookingStatus.APPROVED); // Corrected
        bookingRepository.save(booking);

        String subject = "Booking Approved";
        String body = String.format(
            "Hello %s,\n\nYour booking for %s on %s at %s has been approved.\n\n%s\n\nBest Regards,\nInmate Visit Booking System",
            booking.getVisitorNamesurname(),
            booking.getCentre(),
            booking.getVisitDate(),
            booking.getVisitTime(),
            booking.getMessage().isEmpty() ? "No additional information provided." : "Additional details: " + booking.getMessage()
        );

        emailService.sendRegistrationConfirmation(booking.getVisitorEmail(), subject, body);
    }

    @Override
    public void rejectBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid booking ID"));

        booking.setStatus(BookingStatus.REJECTED); // Corrected
        bookingRepository.save(booking);

        String subject = "Booking Rejected";
        String body = String.format(
            "Hello %s,\n\nYour booking for %s on %s at %s has been rejected.\n\nBest Regards,\nInmate Visit Booking System",
            booking.getVisitorNamesurname(),
            booking.getCentre(),
            booking.getVisitDate(),
            booking.getVisitTime()
        );

        emailService.sendRegistrationConfirmation(booking.getVisitorEmail(), subject, body);
    }

    @Override
    public List<Booking> getBookingsByStatus(BookingStatus status) {
        return bookingRepository.findByStatus(status);
    }
}
