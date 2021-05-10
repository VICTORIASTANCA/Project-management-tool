package mom.sda.projectmanagement.controllers;

import mom.sda.projectmanagement.entities.TaskNameEntity;
import mom.sda.projectmanagement.entities.UserEntity;
import mom.sda.projectmanagement.services.TaskService;
import mom.sda.projectmanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @GetMapping("getTasks")
    public String getTasks(Model model) {
        List<TaskNameEntity> taskList = taskService.getAllTasks();
        model.addAttribute("tasks", taskList);
        return "tasks";
    }

    @GetMapping("/add-task")
    public String addTaskPage(Model model) {
        model.addAttribute("newTask", new TaskNameEntity());
        List<UserEntity> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "add-task";
    }

    @PostMapping("/task/add")
    public String addTask(@ModelAttribute TaskNameEntity newTask) {
        taskService.addTask(newTask);
        return "redirect:/getTasks";
    }

    @GetMapping("/edit-task/{id}")
    public String editTaskPage(Model model, @PathVariable("id") Integer id) {
        TaskNameEntity taskNameEntity = taskService.getTask(id);
        model.addAttribute("taskToBeEdited", taskNameEntity);
        return "edit-task";
    }

    @PostMapping("/task/edit")
    public String editTask(@ModelAttribute TaskNameEntity taskToBeEdited) {
        taskService.editTask(taskToBeEdited);
        return "redirect:/getTasks";
    }

    @GetMapping("/delete-task/{id}")
    public String deleteTask(Model model, @PathVariable("id") Integer id) {
        taskService.deleteTask(id);
        return "redirect:/getTasks";
    }

    @RequestMapping(value = "tasks", method = RequestMethod.GET)
    public String showTaskById(@RequestParam (value = "id", required = false) Integer id, Model model) {
        model.addAttribute("search", taskService.showTaskById(id));
        return "tasks";
    }

}
