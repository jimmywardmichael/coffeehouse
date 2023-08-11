package com.codeup.coffeehouse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {

    @GetMapping("/coffeehome")
    public String homePage() {
        return "coffeehome"; // Assuming "home" is the name of your Thymeleaf template (home.html)
    }
}

