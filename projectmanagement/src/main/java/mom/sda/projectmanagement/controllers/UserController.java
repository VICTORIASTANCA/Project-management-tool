
package mom.sda.projectmanagement.controllers;


import mom.sda.projectmanagement.entities.ProjectEntity;
import mom.sda.projectmanagement.entities.SprintEntity;
import mom.sda.projectmanagement.entities.TaskNameEntity;
import mom.sda.projectmanagement.repositories.UserRepository;
import mom.sda.projectmanagement.services.ProjectService;
import mom.sda.projectmanagement.services.SprintService;
import mom.sda.projectmanagement.services.TaskService;
import mom.sda.projectmanagement.services.UserService;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private  UserService userService;
    @Autowired
    private UserRepository userRepository;


    public UserController()  {

    }
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public ModelAndView hello(HttpServletResponse response) throws IOException {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        return mv;
    }

    // Get All Users
    @RequestMapping(value = "/allUsers", method = RequestMethod.POST)
    public ModelAndView displayAllUser() {
        System.out.println("User Page Requested : All Users");
        ModelAndView mv = new ModelAndView();

        List userList = userService.getAllUsers();
        mv.addObject("userList", userList);
        mv.setViewName("allUsers");
        return mv;
    }
    // add user
    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public ModelAndView displayNewUserForm() {
        ModelAndView mv = new ModelAndView("addUser");
        mv.addObject("headerMessage", "Add User Details");
        mv.addObject("user", new User());
        return mv;
    }


    // edit user
    @RequestMapping(value = "/editUser/{id}", method = RequestMethod.GET)
    public ModelAndView displayEditUserForm(@PathVariable Integer id) {
        ModelAndView mv = new ModelAndView("/editUser");
        User user = userService.editUser();
        mv.addObject("headerMessage", "Edit User Details");
        mv.addObject("user", user);
        return mv;
    }



    //delete user
    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUserById(@PathVariable Integer id) {
        boolean isDeleted = userService.deleteUser(id);
        System.out.println("User deletion respone: " + isDeleted);
        ModelAndView mv = new ModelAndView("redirect:/home");
        return mv;

    }

    @Controller
    public static class TaskController {

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

    @Controller
    public static class SprintController {
        @Autowired
        private SprintService sprintService;

        @GetMapping(path = "getSprint")
        public String getSprint(Model model) {
            List<SprintEntity> sprintList = sprintService.getAllSprint();
            model.addAttribute("sprint", sprintList);
            return "sprint";
        }
    }

    @Controller
    public static class ProjectController {

        @Autowired
        private ProjectService projectService;

        @GetMapping(path = "getProject")
        public String getProject(Model model) {
            List<ProjectEntity> projectList = projectService.gettAllProject();
            model.addAttribute("project", projectList);
            return "project";
        }


    }
}


