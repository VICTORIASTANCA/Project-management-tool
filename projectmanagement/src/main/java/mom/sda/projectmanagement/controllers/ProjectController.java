package mom.sda.projectmanagement.controllers;

import mom.sda.projectmanagement.entities.ProjectEntity;
import mom.sda.projectmanagement.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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


}
