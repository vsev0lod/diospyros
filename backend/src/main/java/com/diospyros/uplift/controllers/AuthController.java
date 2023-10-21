package com.diospyros.uplift.controllers;

import com.diospyros.uplift.dto.LoginDTO;
import com.diospyros.uplift.persistence.entities.Users;
import com.diospyros.uplift.persistence.repositories.UsersRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsersRepository userRepository;

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("loginDTO", new LoginDTO());
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(@ModelAttribute LoginDTO loginDTO, HttpSession session) {
        Optional<Users> user = userRepository.findByEmail(loginDTO.getUsername());
        if (user.isPresent() && user.map(Users::getPassword).filter(loginDTO.getPassword()::equals).isPresent()) { //
            session.setAttribute("userId", user.get().getId());
            return "redirect:/";
        }
        return "redirect:/auth/login?error"; // return to login with an error
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/auth/login";
    }
}