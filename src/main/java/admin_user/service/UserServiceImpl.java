package admin_user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import admin_user.dto.UserDto;
import admin_user.model.User;
import admin_user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    @Override
    public User save(UserDto userDto) {
        // Automatically assign "USER" role
        User user = new User(
            userDto.getEmail(),
            passwordEncoder.encode(userDto.getPassword()),
            "USER", // Default role
            userDto.getFullname()
        );

        User savedUser = userRepository.save(user);

        // Send confirmation email
        String subject = "Registration Confirmation";
        String body = String.format(
            "Hello %s,\n\nYou have successfully registered.\n\nEmail: %s\n\nBest Regards,\nInmate Visit Booking System",
            userDto.getFullname(),
            userDto.getEmail()
        );

        emailService.sendRegistrationConfirmation(userDto.getEmail(), subject, body);

        return savedUser;
    }
}
