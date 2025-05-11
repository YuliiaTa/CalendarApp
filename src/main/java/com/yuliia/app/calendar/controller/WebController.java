package com.yuliia.app.calendar.controller;

import com.yuliia.app.calendar.service.CustomUserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String home() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(@AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
        if (userDetails != null) {
            model.addAttribute("username", userDetails.getName());
            model.addAttribute("email", userDetails.getUsername());
        } else {
            model.addAttribute("username", "Guest");
        }
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}