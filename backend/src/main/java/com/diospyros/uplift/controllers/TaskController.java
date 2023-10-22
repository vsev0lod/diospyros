package com.diospyros.uplift.controllers;

import com.diospyros.uplift.Status;
import com.diospyros.uplift.dto.NewTaskDTO;
import com.diospyros.uplift.persistence.entities.Attachment;
import com.diospyros.uplift.persistence.entities.Solution;
import com.diospyros.uplift.persistence.entities.Task;
import com.diospyros.uplift.persistence.entities.Users;
import com.diospyros.uplift.persistence.repositories.AttachmentRepository;
import com.diospyros.uplift.persistence.repositories.SolutionRepository;
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

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private SolutionRepository solutionRepository;

    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private AttachmentRepository attachmentRepository;

    @Value("${google.maps.api.key}")
    private String googleMapsApiKey;

    @GetMapping("/{id}")
    public String taskPage(@PathVariable String id, Model model, HttpSession session) {
        Object userId = session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/auth/login";
        }
        Users user = userRepository.findById(UUID.fromString(userId.toString())).orElseThrow(IllegalArgumentException::new);
        model.addAttribute("user", user);
        model.addAttribute("googleMapsApiKey", googleMapsApiKey);
        Task task = taskRepository.findById(UUID.fromString(id)).orElseThrow(IllegalArgumentException::new);
        model.addAttribute("task", task);
//        model.addAttribute("taskId", task.getId().toString());

        try {
            Solution solution = solutionRepository.findByTaskId(UUID.fromString(id));
            if (solution != null) {
                model.addAttribute("solution", solution);
            }
        } catch (Exception e) {

        }

        return "task";
    }

    @GetMapping("/{taskId}/solution")
    public String showCreatedSolution(@PathVariable String taskId, Model model) {
        Task task = taskRepository.findById(UUID.fromString(taskId)).orElseThrow(IllegalArgumentException::new);
        Solution solution = solutionRepository.findByTaskId(UUID.fromString(taskId));
        model.addAttribute("task", task);
        model.addAttribute("solution", solution);

        return "solutionDisplay"; // This is the name of your Thymeleaf template
    }

    @GetMapping("/new")
    public String newTask(Model model, HttpSession session) {
        Object userId = session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/auth/login";
        }

        Users user = userRepository.findById(UUID.fromString(userId.toString())).orElseThrow(IllegalArgumentException::new);
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

        Object userId = session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/auth/login";
        }

        Users user = userRepository.findById(UUID.fromString(userId.toString())).orElseThrow(IllegalArgumentException::new);

        Task newTask = Task.builder().
                title(task.getTitle())
                .id(UUID.randomUUID())
                .description(task.getDescription())
                .createdAt(LocalDate.now())
                .creatorId(UUID.fromString(userId.toString()))
                .taskType(task.getTaskType())
                .tag(user.getUserType())
                .reward(BigDecimal.valueOf(100))
                .location(latitude + "," + longitude)
                .status(Status.DEFINED.toString())
                .build();
//        saveUploadedPhotos(newTask.getId(), photos);
        taskRepository.save(newTask);

        return "redirect:/";  // Redirect to index or wherever you wish after a successful task creation
    }

    private void saveUploadedPhotos(UUID taskID, MultipartFile[] photos) {
        try {
            if (photos != null) {
                for (MultipartFile photo : photos) {
                    attachmentRepository.save(new Attachment(UUID.randomUUID(), taskID, photo.getBytes()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

