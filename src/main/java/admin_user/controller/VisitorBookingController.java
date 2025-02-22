package admin_user.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VisitorBookingController {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@GetMapping("/visitorBookingPage")
    public String showvisitorPage(Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
        return "visitorBookingPage"; // This returns visitorBookingPage.html from the templates directory
    }

}
