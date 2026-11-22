package com.civicbridge.controllers;

import com.civicbridge.models.User;
import com.civicbridge.models.data.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
public class CivicBridgeLoginController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public String signup(@ModelAttribute("user")User user, @RequestParam("confirmPassword") String confirmPassword) {
        if (!user.getPassword().equals(confirmPassword)) {
            return "redirect:/signup?error=passwordDidNotMatch";
        }

        if (userRepo.existsByUsername(user.getUsername())) {
            return "redirect:/signup?error=usernameNotAvailable";
        }

        String password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);

        //Default registration role
        user.setUserRole("RESIDENT");

        //Activate new account
        user.setActive(true);

        //Set creation date
        user.setCreatedDate(LocalDateTime.now());

        userRepo.save(user);

        return "redirect:/login";
    }

    @GetMapping("/signup")
    public String registerUser(Model model) {
        model.addAttribute("title", "register");
        model.addAttribute("user", new User());
        return "User/signup";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "User/login";
    }

    @GetMapping("/CivicBridge_App_Demo.html")
    public String showDashboard() {
        return "User/CivicBridge_App_Demo";
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable int userId) {
        userRepo.deleteById(userId);
    }
}
