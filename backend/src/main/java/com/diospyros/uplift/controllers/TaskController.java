package com.diospyros.uplift.controllers;

import com.diospyros.uplift.Status;
import com.diospyros.uplift.dto.NewTaskDTO;
import com.diospyros.uplift.persistence.entities.Task;
import com.diospyros.uplift.persistence.entities.Users;
import com.diospyros.uplift.persistence.repositories.TaskRepository;
import com.diospyros.uplift.persistence.repositories.UsersRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UsersRepository userRepository;

    @Value("${google.maps.api.key}")
    private String googleMapsApiKey;

    @GetMapping("/{id}")
    public String taskPage(@PathVariable String id, Model model, HttpSession session) {
        String userId = session.getAttribute("userId").toString();
        if (userId == null) {
            return "redirect:/auth/login";
        }
        Users user = userRepository.findById(UUID.fromString(userId)).orElseThrow(IllegalArgumentException::new);
        model.addAttribute("user", user);
        model.addAttribute("googleMapsApiKey", googleMapsApiKey);
        Task task = taskRepository.findById(UUID.fromString(id)).orElseThrow(IllegalArgumentException::new);
        model.addAttribute("task", task);
        return "task";
    }

    @GetMapping("/new")
    public String newTask(Model model, HttpSession session) {
        String userId = session.getAttribute("userId").toString();
        if (userId == null) {
            return "redirect:/auth/login";
        }

        Users user = userRepository.findById(UUID.fromString(userId)).orElseThrow(IllegalArgumentException::new);
        model.addAttribute("googleMapsApiKey", googleMapsApiKey);
        model.addAttribute("user", user);
        model.addAttribute("task", new NewTaskDTO());
        return "tasknew";
    }

    @PostMapping("/new")
    public String handleTaskCreation(@ModelAttribute NewTaskDTO task,
                                     @RequestParam("photos") MultipartFile[] photos,
                                     @RequestParam("latitude") String latitude,
                                     @RequestParam("longitude") String longitude,
                                     HttpSession session) {

        String userId = session.getAttribute("userId").toString();
        if (userId == null) {
            return "redirect:/auth/login";
        }

        // Save the photos and set their references to the task (you would need to implement this part)
        saveUploadedPhotos(task, photos);

        // Set the current user as the creator of the task
        Users user = userRepository.findById(UUID.fromString(userId)).orElseThrow(IllegalArgumentException::new);

        Task newTask = Task.builder().
                title(task.getTitle())
                .description(task.getDescription())
                .createdAt(LocalDate.now())
                .creatorId(UUID.fromString(userId))
                .taskType(task.getTaskType())
                .tag(user.getUserType())
                .reward(BigDecimal.valueOf(100))
                .location(latitude + "," + longitude)
                .status(Status.DEFINED.toString())
                .build();

        taskRepository.save(newTask);

        return "redirect:/";  // Redirect to index or wherever you wish after a successful task creation
    }

    private void saveUploadedPhotos(NewTaskDTO task, MultipartFile[] photos) {

    }
}
