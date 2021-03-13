package mom.sda.projectmanagement.controllers;

import mom.sda.projectmanagement.entities.TaskNameEntity;
import mom.sda.projectmanagement.repositories.TaskRepository;
import mom.sda.projectmanagement.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/task/list")
    public ModelAndView getTasks() {
        ModelAndView modelAndView = new ModelAndView("tasks");
        modelAndView.addObject("taskList", taskRepository.findAll());
        return modelAndView;
    }

    @GetMapping("/task/add")
    public ModelAndView addTask() {
        ModelAndView modelAndView = new ModelAndView("task-form");
        modelAndView.addObject("task", new TaskNameEntity());
        return modelAndView;
    }

    @PostMapping("/task/save")
    public ModelAndView saveTask(@ModelAttribute("task") TaskNameEntity taskNameEntity, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("redirect:/task/list");
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("task-form");
            modelAndView.addObject("task", taskNameEntity);
            return modelAndView;
        }
   }

    @GetMapping("/task/edit/{id}")
    public ModelAndView editTask(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("task-form");
        modelAndView.addObject("task", taskRepository.findById(id).get());
        return modelAndView;
    }

    @GetMapping("/task/delete/{id}")
    public ModelAndView deleteTask(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/task/list");
        taskRepository.deleteById(id);
        return modelAndView;
    }
}
