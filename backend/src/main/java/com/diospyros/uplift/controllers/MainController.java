package com.diospyros.uplift.controllers;

import com.diospyros.uplift.persistence.entities.Users;
import com.diospyros.uplift.persistence.repositories.TaskRepository;
import com.diospyros.uplift.persistence.repositories.UsersRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

@Controller
public class MainController {

    @Autowired
    private UsersRepository userRepository;
    @Autowired
    private TaskRepository taskRepository;

    @Value("${google.maps.api.key}")
    private String googleMapsApiKey;

    @GetMapping("/")
    public String mainPage(Model model, HttpSession session) {
        Object userId = session.getAttribute("userId");
        if (userId == null) {
            // Handle the case where there is no logged-in user
            return "redirect:/auth/login";
        }
        Users user = userRepository.findById(UUID.fromString(userId.toString())).orElseThrow(IllegalArgumentException::new);
        model.addAttribute("user", user);
        model.addAttribute("tasks", taskRepository.findAll());
        model.addAttribute("googleMapsApiKey", googleMapsApiKey);
        return "index";
    }
}