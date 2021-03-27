
package mom.sda.projectmanagement.controllers;
import mom.sda.projectmanagement.entities.TaskNameEntity;
import mom.sda.projectmanagement.entities.UserEntity;
import mom.sda.projectmanagement.services.TaskService;
import mom.sda.projectmanagement.services.UserService;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;
    private String login;


    @GetMapping(path = "/login")
    public String getLoginPage() {
        return login;
    }
   @GetMapping(path = "/register")
    public String getRegisterPage(Model model){
        model.addAttribute("user", new UserEntity());
        return"register";

    }

      @PostMapping(path="register/add")
      public String register(@ModelAttribute UserEntity user){
      userService.addCustomer(user);
        return "redirect:/login";
      }


    @GetMapping(path = "getUsers")
    public String getUsers(Model model) {
        List<UserEntity> userList = userService.getAllUsers();
        model.addAttribute("user", userList);
        return "user";
    }

    @GetMapping(path = "add-user")
    public String addUserPage(Model model) {
        model.addAttribute("newUser", new UserEntity());
        List<TaskNameEntity> taskNameEntities = taskService.getAllTasks();
        model.addAttribute("tasks", taskNameEntities);
        return "add-user";
    }

    @PostMapping(path = "user/add")
    public String addUser(@ModelAttribute UserEntity newUser) {
        userService.addUser(newUser);
        return "redirect:/getUsers";
    }


    @GetMapping(path = "edit-user/{id}")
    public String editUserPage(Model model, @PathVariable("id") long id) {
        UserEntity userEntity = userService.getUserEntity(id);
        model.addAttribute("userToBeEdit", userEntity);
        return "edit-user";
    }

    @PostMapping(path = "user/edit")
    public String editUser(@ModelAttribute UserEntity userToBeEdit) {
        userService.editUser(userToBeEdit);
        return "redirect:/getUsers";

    }

    @GetMapping(path = "delete-user/{id}")
    public String delete(Model model, @PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/getUsers";

    }
}