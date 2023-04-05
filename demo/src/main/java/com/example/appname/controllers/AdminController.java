package com.example.appname.controllers;

import com.example.appname.models.AdminData;
import com.example.appname.models.ReceivedData;
import com.example.appname.models.User;
import com.example.appname.services.AdminDataService;
import com.example.appname.services.ReceivedDataService;
import com.example.appname.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private ReceivedDataService receivedDataService;

    @Autowired
    private AdminDataService adminDataService;

    @GetMapping("/admin")
    public String adminPage(Model model) {
        // Get all users
        Iterable<User> users = userService.findAllUsers();
        model.addAttribute("users", users);

        // Get all received data
        List<ReceivedData> receivedDataList = receivedDataService.getAllReceivedData();
        model.addAttribute("receivedDataList", receivedDataList);

        // Get all admin data
        List<AdminData> adminDataList = adminDataService.getAllAdminData();
        model.addAttribute("adminDataList", adminDataList);

        return "admin";
    }

    @GetMapping("/admin/user/{userId}")
    public String userDetails(@PathVariable int userId, Model model) {
        User user = userService.findUserById(userId);
        model.addAttribute("user", user);

        List<ReceivedData> receivedDataList = receivedDataService.findReceivedDataByUserId(userId);
        model.addAttribute("receivedDataList", receivedDataList);

        return "user-detail";
    }
}
