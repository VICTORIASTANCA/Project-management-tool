package mom.sda.projectmanagement.service;

import mom.sda.projectmanagement.entities.ProjectEntity;
import mom.sda.projectmanagement.entities.SprintEntity;
import mom.sda.projectmanagement.repositories.SprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SprintService {
    @Autowired
    private SprintRepository sprintRepository;
    public void addSprint (SprintEntity sprintEntity){
        sprintRepository.save(sprintEntity);
    }

    public List<SprintEntity> getAllSprint(){
        return sprintRepository.findAll();
    }

    public void editSprint(SprintEntity editSprint) {
       sprintRepository.save(editSprint);
    }

    




}
