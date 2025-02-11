package admin_user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import admin_user.model.Booking;
import admin_user.service.BookingService;

@Controller
public class AdminMoreDetailsController {
	
	@Autowired
    private BookingService bookingService;

	@GetMapping("/AdminMoreDetails")
    public String showAdminMoreDetailsPage() {
        return "AdminMoreDetails"; // This returns book.html from the templates directory
    }
	
	  @GetMapping("/admin/booking/{bookingId}")
	    public String getBookingDetails(@PathVariable Long bookingId, Model model) {
	        Booking booking = bookingService.findBookingById(bookingId);
	        model.addAttribute("booking", booking);
	        return "AdminMoreDetails";
	    }
}
