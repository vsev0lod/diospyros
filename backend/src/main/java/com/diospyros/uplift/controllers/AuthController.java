package com.diospyros.uplift.controllers;

import com.diospyros.uplift.dto.LoginDTO;
import com.diospyros.uplift.dto.RegisterDTO;
import com.diospyros.uplift.persistence.entities.Attachment;
import com.diospyros.uplift.persistence.entities.Users;
import com.diospyros.uplift.persistence.repositories.AttachmentRepository;
import com.diospyros.uplift.persistence.repositories.UsersRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private AttachmentRepository attachmentRepository;

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("loginDTO", new LoginDTO());
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(@ModelAttribute LoginDTO loginDTO, HttpSession session) {
        Optional<Users> user = userRepository.findByEmail(loginDTO.getUsername());
        if (user.isPresent() && user.map(Users::getPassword).filter(loginDTO.getPassword()::equals).isPresent()) {
            session.setAttribute("userId", user.get().getId().toString());
            return "redirect:/";
        }
        return "redirect:/auth/login?error"; // return to login with an error
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("registerDTO", new RegisterDTO());
        return "register";
    }

    @PostMapping("/register")
    public String handleRegistration(@ModelAttribute RegisterDTO registerDTO) {
        // 1. Check if the user already exists (by email/username).
        if (userRepository.findByEmail(registerDTO.getEmail()).isPresent()) {
            // Redirect with an error message, user already exists
            return "redirect:/auth/register?error=userexists";
        }

        if (!registerDTO.getPassword().equals(registerDTO.getConfirmPassword())) {
            return "redirect:/auth/register?error=passwordsdontmatch";
        }
        Users newUser = new Users(UUID.randomUUID(), registerDTO.getEmail(), registerDTO.getPassword(),
                BigDecimal.valueOf(5), registerDTO.getUserType(), registerDTO.getUsername(), "", BigDecimal.ZERO);


            userRepository.save(newUser);


        // 5. Redirect to a relevant page (for now, redirect to login after registration)
        return "redirect:/auth/login?success";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/auth/login";
    }
}