package mom.sda.projectmanagement.controllers;

import mom.sda.projectmanagement.entities.ProjectEntity;
import mom.sda.projectmanagement.services.ProjectService;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping(path = "getProject")
    public String getProject(Model model) {
        List<ProjectEntity> projectList = projectService.gettAllProject();
        model.addAttribute("project", projectList);
        return "project";
    }
    @GetMapping(path = "add-project")
    public String addProjectPage(Model model) {
        model.addAttribute("newProject", new ProjectEntity());
        return "add-project";
    }

    @PostMapping(path = "project/add")
    public String addProject(@ModelAttribute ProjectEntity newProject){
        projectService.addProject(newProject);
        return "redirect:/getProject";
    }
    

}
