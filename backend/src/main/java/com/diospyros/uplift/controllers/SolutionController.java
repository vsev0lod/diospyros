package com.diospyros.uplift.controllers;

import com.diospyros.uplift.dto.SolutionDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequestMapping("/solution")
public class SolutionController {

    @GetMapping("/create")
    public String showCreateSolutionForm() {
        return "solutionCreate"; // This is the name of your Thymeleaf template
    }

    @PostMapping("/create")
    public String handleSolutionSubmission(@ModelAttribute SolutionDTO solutionDTO, 
                                           RedirectAttributes redirectAttributes) {
        // Process the description
        String description = solutionDTO.getDescription();

        // Process the uploaded photos
        MultipartFile[] photos = solutionDTO.getPhotos();
        for (MultipartFile photo : photos) {
            try {
                byte[] bytes = photo.getBytes();
                // Store the bytes in the database or somewhere else as needed
                // You can also add logic for checking the file type, size, etc.
            } catch (IOException e) {
                e.printStackTrace();
                redirectAttributes.addFlashAttribute("errorMessage", "Failed to upload photos. Please try again.");
                return "redirect:/solution/create";
            }
        }

        // You can add additional logic to store the description and photos into the database

        redirectAttributes.addFlashAttribute("successMessage", "Solution created successfully.");
        return "redirect:/"; // Redirect to the home page or any other page after successful submission
    }
}