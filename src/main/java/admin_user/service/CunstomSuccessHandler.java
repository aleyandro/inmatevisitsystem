package admin_user.service;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CunstomSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		var authourities = authentication.getAuthorities();
		var roles = authourities.stream().map(r -> r.getAuthority()).findFirst();
		
		if (roles.orElse("").equals("ADMIN")) {
			response.sendRedirect("/AdminFrontpage");
		} else if (roles.orElse("").equals("USER")) {
			response.sendRedirect("/visitorBookingPage");
		} else {
			response.sendRedirect("/error");
		}
		
		
		
	}
		
		
		
	}


