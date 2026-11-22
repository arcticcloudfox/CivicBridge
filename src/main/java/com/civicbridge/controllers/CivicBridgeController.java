package com.civicbridge.controllers;

import com.civicbridge.models.data.RequestRepo;
import com.civicbridge.models.data.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/request")
public class CivicBridgeController {

    @Autowired
    private RequestRepo requestRepo;

    @Autowired
    private UserRepo userRepo;



}
