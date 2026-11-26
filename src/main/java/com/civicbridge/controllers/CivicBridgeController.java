package com.civicbridge.controllers;

import com.civicbridge.models.Request;
import com.civicbridge.models.User;
import com.civicbridge.models.data.RequestRepo;
import com.civicbridge.models.data.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/request")
public class CivicBridgeController {

    @Autowired
    private RequestRepo requestRepo;

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/{id}")
    public String getRequestById(@PathVariable int id, Model model) {
        Request request = (Request) requestRepo.findRequestById(id);
        model.addAttribute("request", request);
        return "view";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("request", new Request());
        return "add";
    }

    @PostMapping("/add")
    public String addRequest(@ModelAttribute Request request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = userRepo.findByUsername(currentPrincipalName).orElse(null);

        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + currentPrincipalName);
        }

        request.setUser(user);

        System.out.println("Request created: " + request.getTitle() + ", user: " + user.getUsername());

        requestRepo.save(request);

        return "redirect:/request";
    }

    @PostMapping("/update/{id}")
    public String updateTask(@PathVariable int id, @ModelAttribute("request") Request requestDetails) {
        Request request = (Request) requestRepo.findRequestById(id);
        request.setTitle(requestDetails.getTitle());
        request.setDescription(requestDetails.getDescription());
        request.setCurrentStatus(requestDetails.getCurrentStatus());
        request.setPriority(requestDetails.getPriority());
        request.setLocationAddress(requestDetails.getLocationAddress());
        requestRepo.save(request);
        return "redirect:/request";
    }

    @PostMapping("/{id}/delete")
    public String deleteRequest(@PathVariable int id) {
        requestRepo.deleteById(id);
        return "redirect:/request";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable int id, Model model) {
        Request request = (Request) requestRepo.findRequestById(id);
        model.addAttribute("request", request);
        return "edit";
    }

    private User getCurrentUser() {
        String username = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        return userRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

}
