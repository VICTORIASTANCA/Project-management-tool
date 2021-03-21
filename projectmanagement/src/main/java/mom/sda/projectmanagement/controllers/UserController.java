
package mom.sda.projectmanagement.controllers;
import mom.sda.projectmanagement.entities.UserEntity;
import mom.sda.projectmanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "getUsers")
    public String getBooks(Model model) {
        List<UserEntity> userList = userService.getAllUsers();
        model.addAttribute("users", userList);
        return "users";
    }

    @GetMapping(path = "add-user")
    public String addUserPage(Model model) {
        model.addAttribute("newUser", new UserEntity());

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