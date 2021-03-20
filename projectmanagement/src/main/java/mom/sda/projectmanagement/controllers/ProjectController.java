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
    @GetMapping(path = "edit-project/{id}")
    public String editProject(Model model, @PathVariable("id") int id){
       ProjectEntity projectEntity = projectService.getProject(id);
        model.addAttribute("projectToBeEdit", projectEntity);
        return "edit-project";
    }

    @PostMapping(path = "project/edit")
    public String editProject(@ModelAttribute ProjectEntity projectToBeEdit){
        projectService.editProject(projectToBeEdit);
        return "redirect:/getProject";
    }

    @GetMapping(path = "delete-project/{id}")
    public String delete(Model model, @PathVariable("id") int id){
        projectService.deleteProject(id);
        return "redirect:/getProject";
    }


}
