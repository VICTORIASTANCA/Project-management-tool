package mom.sda.projectmanagement.controllers;

import mom.sda.projectmanagement.entities.ProjectEntity;
import mom.sda.projectmanagement.entities.UserEntity;
import mom.sda.projectmanagement.services.ProjectService;
import mom.sda.projectmanagement.services.UserService;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Access;
import javax.persistence.ManyToOne;
import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    public ProjectService getProjectService() {
        return projectService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }


    @GetMapping(path = "getProject")
    public String getProject(Model model) {
        List<ProjectEntity> projectList = projectService.getAllProject();
        model.addAttribute("project", projectList);
        return "project";
    }

    @GetMapping(path = "add-project")
    public String addProjectPage(Model model) {
        model.addAttribute("newProject", new ProjectEntity());
        List<UserEntity> userEntities = userService.getAllUsers();
        model.addAttribute("user", userEntities);
        return "add-project";
    }

    @PostMapping(path = "project/add")
    public String addProject(@ModelAttribute ProjectEntity newProject) {
        projectService.addProject(newProject);
        return "redirect:/getProject";
    }

    @GetMapping(path = "edit-project/{id}")
    public String editProject(Model model, @PathVariable("id") int id) {
        ProjectEntity projectEntity = projectService.getProject(id);
        model.addAttribute("projectToBeEdit", projectEntity);
        List<UserEntity> userEntities = userService.getAllUsers();
        model.addAttribute("user", userEntities);
        return "edit-project";
    }

    @PostMapping(path = "project/edit")
    public String editProject(@ModelAttribute ProjectEntity projectToBeEdit) {
        projectService.editProject(projectToBeEdit);
        return "redirect:/getProject";
    }

    @GetMapping(path = "delete-project/{id}")
    public String delete(Model model, @PathVariable("id") int id) {
        projectService.deleteProject(id);
        return "redirect:/getProject";
    }


}
