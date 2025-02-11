package admin_user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VisitorRejection {
	
	@GetMapping("/visitorRejection")
    public String showvisitorRejectionPage() {
        return "visitorRejection"; // This returns book.html from the templates directory
    }

}
