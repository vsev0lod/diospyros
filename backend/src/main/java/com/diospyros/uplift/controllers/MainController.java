package com.diospyros.uplift.controllers;

import com.diospyros.uplift.persistence.entities.Users;
import com.diospyros.uplift.persistence.repositories.UsersRepository;
import com.diospyros.uplift.services.TaskService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private UsersRepository userRepository;
    @Autowired
    private TaskService taskService;

    @Value("${google.maps.api.key}")
    private String googleMapsApiKey;
    @GetMapping("/")
    public String mainPage(Model model, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId == null) {
            // Handle the case where there is no logged-in user
            return "redirect:/auth/login";
        }
        Users user = userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
        model.addAttribute("user", user);
        model.addAttribute("tasks", taskService.findAll());
        model.addAttribute("googleMapsApiKey", googleMapsApiKey);
        return "index";
    }
}