package admin_user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"admin_user", "admin_user_configurations"})
public class InmatevisitApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(InmatevisitApplication.class, args);
	}
	
	
	

}
