package admin_user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {
	
	@RequestMapping("/error")
    public String handleError() {
        return "error"; // Map to error.html in templates
    }

}
