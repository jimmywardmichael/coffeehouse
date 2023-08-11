package com.codeup.coffeehouse.controllers;

import com.codeup.coffeehouse.models.User;
import com.codeup.coffeehouse.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/signup")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User()); // Use your User class here
        return "signup"; // Return the name of your signup HTML file
    }

    @PostMapping("/signup")
    public String processSignUp(User user) {
        userService.signUp(user);
        return "redirect:/login"; // Redirect to the login page after successful sign-up
    }
}
