package admin_user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import admin_user.dto.BookingDto;
import admin_user.service.BookingService;

@Controller
public class BookController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/book")
    public String showBookingForm(@ModelAttribute("bookingDto") BookingDto bookingDto) {
        return "book";
    }

    @PostMapping("/book")
    public String submitBookingForm(@ModelAttribute("bookingDto") BookingDto bookingDto, Model model) {
        try {
            bookingService.saveBooking(bookingDto);
            return "redirect:/booking-confirmation";
        } catch (IllegalArgumentException e) {
            // Add the error message to the model and return the booking form
            model.addAttribute("error", e.getMessage());
            return "book";
        }
    }

    @GetMapping("/booking-confirmation")
    public String bookingConfirmation() {
        return "booking-confirmation";
    }
}
