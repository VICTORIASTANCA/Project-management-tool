package mom.sda.projectmanagement.controllers;

import mom.sda.projectmanagement.entities.*;
import mom.sda.projectmanagement.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomePageController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private ParticipationInProjectService participationInProjectService;

    @Autowired
    private SprintService sprintService;

    @GetMapping(path = "/")
    public String getHomePage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UserEntity userEntity = userService.getUserByUsername(username);
        model.addAttribute("loggedUser", userEntity.getDisplayed_name());
        return "homepage";
    }

}
