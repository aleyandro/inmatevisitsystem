package admin_user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import admin_user.model.Booking;
import admin_user.service.BookingService;

@Controller
public class AdminController {
	
		@Autowired
	    private BookingService bookingService;

	    @GetMapping("/admins")
	    public String showAdminPage(Model model) {
	        List<Booking> bookings = bookingService.getAllBookings();
	        model.addAttribute("bookings", bookings);
	        return "admins"; // Renders admins.html
	    }
	    @PostMapping("/approve-booking/{id}")
	    public String approveBooking(@PathVariable Long id) {
	        bookingService.approveBooking(id);
	        return "redirect:/admins"; // Redirect back to admin page
	    }

	    
	   

}
