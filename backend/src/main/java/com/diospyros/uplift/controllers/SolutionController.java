package com.diospyros.uplift.controllers;

import com.diospyros.uplift.Status;
import com.diospyros.uplift.dto.SolutionDTO;
import com.diospyros.uplift.persistence.entities.Solution;
import com.diospyros.uplift.persistence.entities.Task;
import com.diospyros.uplift.persistence.entities.Users;
import com.diospyros.uplift.persistence.repositories.SolutionRepository;
import com.diospyros.uplift.persistence.repositories.TaskRepository;
import com.diospyros.uplift.persistence.repositories.UsersRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Controller
@RequestMapping("/solution")
public class SolutionController {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private SolutionRepository solutionRepository;
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/{taskId}")
    public String showSolution(@PathVariable String taskId) {

        return "solutionDisplay"; // This is the name of your Thymeleaf template
    }
    @GetMapping("/{taskId}/create")
    public String showCreateSolutionForm(@PathVariable String taskId, Model model) {

        Task task = taskRepository.findById(UUID.fromString(taskId)).orElseThrow(IllegalArgumentException::new);
        model.addAttribute("task", task);
        return "createSolution"; // This is the name of your Thymeleaf template
    }

    @PostMapping("/{taskId}/create")
    public String handleSolutionSubmission(@ModelAttribute SolutionDTO solutionDTO,
                                           @PathVariable String taskId,
                                           RedirectAttributes redirectAttributes, HttpSession session) {

        Task task = taskRepository.findById(UUID.fromString(taskId)).orElseThrow(IllegalArgumentException::new);

        // Process the description
        String description = solutionDTO.getDescription();

        // Process the uploaded photos
//        MultipartFile[] photos = solutionDTO.getPhotos();
//        for (MultipartFile photo : photos) {
//            try {
//                byte[] bytes = photo.getBytes();
//                // Store the bytes in the database or somewhere else as needed
//                // You can also add logic for checking the file type, size, etc.
//            } catch (IOException e) {
//                e.printStackTrace();
//                redirectAttributes.addFlashAttribute("errorMessage", "Failed to upload photos. Please try again.");
//                return "redirect:/solution/{taskId}/create";
//            }
//        }

        Object userId = session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/auth/login";
        }
//        Users user = usersRepository.findById(UUID.fromString(userId.toString())).orElseThrow(IllegalArgumentException::new);


        Solution solution = Solution.builder()
                .id(UUID.randomUUID())
                .creatorId(UUID.fromString(userId.toString()))
                .taskId(UUID.fromString(taskId))
                .description(solutionDTO.getDescription() == null? "Sample description" : solutionDTO.getDescription())
                .build();

        solutionRepository.save(solution);

        // You can add additional logic to store the description and photos into the database

        redirectAttributes.addFlashAttribute("successMessage", "Solution created successfully.");
//        return "redirect:/"; // Redirect to the home page or any other page after successful submission
        return "redirect:/task/"+ taskId.toString() + "/solution"; // Redirect to the home page or any other page after successful submission
    }
}