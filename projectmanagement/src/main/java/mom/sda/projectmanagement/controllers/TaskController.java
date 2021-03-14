package mom.sda.projectmanagement.controllers;

import mom.sda.projectmanagement.entities.TaskNameEntity;
import mom.sda.projectmanagement.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("getTasks")
    public String getTasks(Model model) {
        List<TaskNameEntity> taskList = taskService.getAllTasks();
        model.addAttribute("tasks", taskList);
        return "tasks";
    }

    @GetMapping("add-task")
    public String addTaskPage(Model model) {
        model.addAttribute("newTask", new TaskNameEntity());
        return "add-task";
    }

    @PostMapping("book/add")
    public String addTask(@ModelAttribute TaskNameEntity newTask) {
        taskService.addTask(newTask);
        return "redirect:/getTasks";
    }

}
