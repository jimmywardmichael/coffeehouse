package com.codeup.coffeehouse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/")
public class HomeController {

    @GetMapping("/coffeehome")
    @ResponseBody
    public String homePage() {
        return "coffeehome"; // Assuming "home" is the name of your Thymeleaf template (home.html)
    }
}

