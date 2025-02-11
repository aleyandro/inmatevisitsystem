package admin_user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/logins")
    public String showloginPage() {
        return "logins"; // This returns logins.html from the templates directory
    }

}
