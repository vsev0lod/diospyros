package com.diospyros.uplift.controllers;

import com.diospyros.uplift.dto.NewTaskDTO;
import com.diospyros.uplift.dto.TaskDTO;
import com.diospyros.uplift.persistence.entities.Users;
import com.diospyros.uplift.persistence.repositories.UsersRepository;
import com.diospyros.uplift.services.TaskService;
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

@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private UsersRepository userRepository;

    @Value("${google.maps.api.key}")
    private String googleMapsApiKey;

    @GetMapping("/{id}")
    public String taskPage(@PathVariable Integer id, Model model, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/auth/login";
        }
        Users user = userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
        model.addAttribute("user", user);
        model.addAttribute("googleMapsApiKey", googleMapsApiKey);
        TaskDTO task = taskService.findById(id);
        model.addAttribute("task", task);
        return "task";
    }

    @GetMapping("/new")
    public String newTask(Model model, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/auth/login";
        }

        Users user = userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
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
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/auth/login";
        }

        // Save the photos and set their references to the task (you would need to implement this part)
        saveUploadedPhotos(task, photos);

        // Set the current user as the creator of the task
        Users user = userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
        task.setCreatorId(user.getId());
        task.setTag(user.getUserType());
        task.setLatitude(latitude);
        task.setLongtitude(longitude);
        task.setReward(100);
        taskService.create(task);

        return "redirect:/";  // Redirect to index or wherever you wish after a successful task creation
    }

    private void saveUploadedPhotos(NewTaskDTO task, MultipartFile[] photos) {

    }
}
