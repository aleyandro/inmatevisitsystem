package admin_user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DisclaimerController {
	
	@GetMapping("/disclaimer")
    public String showdisclaimerPage() {
        return "disclaimer"; // This returns book.html from the templates directory
    }
	

}
