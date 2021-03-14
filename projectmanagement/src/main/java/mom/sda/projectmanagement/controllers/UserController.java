
package mom.sda.projectmanagement.controller;


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

}


