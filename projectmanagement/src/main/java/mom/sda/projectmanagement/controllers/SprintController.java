package mom.sda.projectmanagement.controllers;

import mom.sda.projectmanagement.entities.SprintEntity;
import mom.sda.projectmanagement.services.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SprintController {
    @Autowired
    private SprintService sprintService;

    @GetMapping(path = "getSprint")
    public String getSprint(Model model) {
        List<SprintEntity> sprintList = sprintService.getAllSprint();
        model.addAttribute("sprint", sprintList);
        return "sprint";
    }

    @GetMapping(path = "add-sprint")
    public String addSprintPage(Model model) {
        model.addAttribute("newSprint", new SprintEntity());
        return "add-sprint";
    }

    @PostMapping(path = "sprint/add")
    public String addSprint(@ModelAttribute SprintEntity newSprint){
        sprintService.addSprint(newSprint);
        return "redirect:/getSprint";
    }


}
