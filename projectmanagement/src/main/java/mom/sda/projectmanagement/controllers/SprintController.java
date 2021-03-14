package mom.sda.projectmanagement.controllers;

import mom.sda.projectmanagement.entities.SprintEntity;
import mom.sda.projectmanagement.services.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
