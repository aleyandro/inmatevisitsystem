package admin_user.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import admin_user.dto.BookingDto;
import admin_user.dto.UserDto;
import admin_user.service.BookingService;

@Controller
@RequestMapping("/booking")

public class BookingController {
	
		@Autowired
	 	 private  BookingService bookingService;

	     
	    
	    
	    @PostMapping("/approveBooking")
	    public String approveBooking(@RequestParam("bookingId") Long bookingId) {
	        bookingService.approveBooking(bookingId);
	        return "redirect:/admins"; // Redirect back to the admin dashboard
	    }
	    
	    @PostMapping("/rejectBooking")
	    public String rejectBooking(@RequestParam("bookingId") Long bookingId) {
	        bookingService.rejectBooking(bookingId);
	        return "redirect:/admins"; // Redirect back to the admin dashboard
	    }

}
