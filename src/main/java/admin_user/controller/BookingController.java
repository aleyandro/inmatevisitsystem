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
import admin_user.model.Booking;
import admin_user.model.BookingStatus;
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
	    
	 // New method to update the Inmate's Unit Number
	    @PostMapping("/updateUnitNumber")
	    public String updateUnitNumber(@RequestParam("bookingId") Long bookingId, 
	                                   @RequestParam("unitNumber") String unitNumber) {
	        Booking booking = bookingService.findBookingById(bookingId);
	        if (booking != null) {
	            booking.setInmateUnitNumber(unitNumber);
	            // Ensure this matches the entity field name
	            booking.setStatus(BookingStatus.APPROVED);
	            bookingService.saveBooking(booking); // Save the updated booking (using the method that accepts a Booking object)
	        }
	        return "redirect:/admins"; // Redirect to the admin dashboard after update
	    }



}
