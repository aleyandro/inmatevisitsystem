package admin_user_configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import admin_user.service.CunstomSuccessHandler;
import admin_user.service.CustomerUserDetailsService;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Autowired
    CunstomSuccessHandler customSuccessHandler;

    @Autowired
    CustomerUserDetailsService customerUserDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(c -> c.disable())
            .authorizeHttpRequests(request -> request
                // Admin-specific pages
                .requestMatchers("/AdminFrontpage", "/admins", "/AdminMoredetails","/approved-bookings").hasAuthority("ADMIN")
                // User-specific pages
                .requestMatchers("/visitorBookingPage").hasAuthority("USER")
                // Public pages and resources
                .requestMatchers(
                    "/registration",
                    "/css/**",
                    "/images/**" // Permit all requests to the "images" folder
                ).permitAll()
                // All other requests require authentication
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/logins")
                .loginProcessingUrl("/logins")
                .successHandler(customSuccessHandler)
                .permitAll()
            )
            .logout(form -> form
            	    .invalidateHttpSession(true) // Invalidate the HTTP session
            	    .clearAuthentication(true)   // Clear authentication information
            	    .deleteCookies("JSESSIONID") // Delete session cookie
            	    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            	    .logoutSuccessUrl("/login?logout") // Redirect to the login page after logout
            	    .permitAll()
            	);


        return http.build();
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customerUserDetailsService).passwordEncoder(passwordEncoder());
    }
}
