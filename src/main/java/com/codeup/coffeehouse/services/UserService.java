package com.codeup.coffeehouse.services;

import com.codeup.coffeehouse.models.User;
import com.codeup.coffeehouse.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class UserService {

    private UserRepository userRepository;


    private BCryptPasswordEncoder passwordEncoder;


    public boolean authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return true;
        }
        return false;
    }

    public User signUp(User user) {
        // Check if username or email already exists
        if (userRepository.findByUsername(user.getUsername()) != null
                || userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Username or email already exists");
        }

        // Encode the password before storing it
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }
}



