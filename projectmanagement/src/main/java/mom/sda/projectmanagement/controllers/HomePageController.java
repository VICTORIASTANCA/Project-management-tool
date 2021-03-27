package mom.sda.projectmanagement.controllers;

import mom.sda.projectmanagement.entities.ProjectEntity;
import mom.sda.projectmanagement.entities.UserEntity;
import mom.sda.projectmanagement.services.ProjectService;
import mom.sda.projectmanagement.services.TaskService;
import mom.sda.projectmanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomePageController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

    @GetMapping(path = "/")
    public String getHomePage(Model model) {
        List<ProjectEntity> projectList = projectService.gettAllProject();
        model.addAttribute("project", projectList);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UserEntity userEntity = userService.getUserByUsername(username);

        model.addAttribute("loggedUser", userEntity.getDisplayed_name());
        return "project";
    }

}


