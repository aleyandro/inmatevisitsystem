package admin_user.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminFrontpageController {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@GetMapping("/AdminFrontpage")
    public String showAdminFrontPage(Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
        return "AdminFrontpage"; // This returns visitorBookingPage.html from the templates directory
    }

}
