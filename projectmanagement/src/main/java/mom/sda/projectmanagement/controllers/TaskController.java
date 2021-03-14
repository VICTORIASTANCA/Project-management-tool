package mom.sda.projectmanagement.controllers;

import mom.sda.projectmanagement.entities.TaskNameEntity;
import mom.sda.projectmanagement.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
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

    @PostMapping("task/add")
    public String addTask(@ModelAttribute TaskNameEntity newTask) {
        taskService.addTask(newTask);
        return "redirect:/getTasks";
    }

}
