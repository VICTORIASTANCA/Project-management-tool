package mom.sda.projectmanagement.controllers;

import mom.sda.projectmanagement.entities.ParticipationInProjectEntity;
import mom.sda.projectmanagement.entities.UserEntity;
import mom.sda.projectmanagement.services.ParticipationInProjectService;
import mom.sda.projectmanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ParticipationInProjectController {
    // @PostMapping("/{projectId}/{userid}")

    @Autowired
    private ParticipationInProjectService participationInProjectService;



    @Autowired
   private UserService userService;


    @GetMapping(path = "getParticipationInProject")
    public String getParticipationInProject(Model model) {
        List<ParticipationInProjectEntity> participationInProjectList = participationInProjectService.getAllParticipationInProject();
        model.addAttribute("participationInProject", participationInProjectList);
        return "participationInProject";
    }

    @GetMapping(path = "add-participationInProject")
    public String AddParticipationInProjectPage(Model model) {
        model.addAttribute("newParticipationInProject", new ParticipationInProjectEntity());
        List<UserEntity> userEntities = userService.getAllUsers();
        model.addAttribute("user", userEntities);
        return "add-participationInProject";
    }

    @PostMapping(path = "ParticipationInProject/add")
    public <newParticipationInProject> String AddParticipationInProject(@ModelAttribute ParticipationInProjectEntity newParticipationInProject) {
        participationInProjectService.addParticipationInProject(newParticipationInProject);
        return "redirect:/getParticipationInProject";
    }


    @GetMapping(path = "edit-participationInProject/{id}")
    public String  editParticipationInProjectPage(Model model, @PathVariable("id") long id){
        ParticipationInProjectEntity participationInProjectEntity = participationInProjectService.getParticipationInProject(id);
        model.addAttribute("participationInProjectToBeEdited",  participationInProjectEntity);
        return "edit-participationInProject";
    }

    @PostMapping(path = "participationInProject/edit")
    public String editParticipationInProject(@ModelAttribute  ParticipationInProjectEntity participationInProjectToBeEdited ){
        participationInProjectService.editParticipationInProject(participationInProjectToBeEdited);
        return "redirect:/getParticipationInProject";
    }

    @GetMapping(path = "delete-participationInProject/{id}")
    public String deleteParticipationInProject(Model model, @PathVariable("id") long id){
        participationInProjectService.deleteParticipationInProject(id);
        return "redirect:/getParticipationInproject";
    }

}



