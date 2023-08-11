package com.codeup.coffeehouse.controllers;

import com.codeup.coffeehouse.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "html/login"; // The name of your HTML file without the extension
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username, @RequestParam String password) {
        if (userService.authenticate(username, password)) {
            return "redirect:/coffeehome"; // Redirect to the dashboard upon successful login
        } else {
            return "redirect:/login?error"; // Redirect back to the login page with an error parameter
        }
    }
}

