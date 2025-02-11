package admin_user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import admin_user.model.Booking;
import admin_user.service.BookingService;

@Controller
public class ApprovedBookingsController {
	
	@Autowired
    private BookingService bookingService;

   
	@GetMapping("/approved-bookings")
    public String showApprovedBookings(Model model) {
        List<Booking> approvedBookings = bookingService.getApprovedBookings();
        model.addAttribute("bookings", approvedBookings);
        return "approved-bookings"; // Show only approved bookings
    }
    

}
