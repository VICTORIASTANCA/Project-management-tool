package mom.sda.projectmanagement.service;

import mom.sda.projectmanagement.entities.SprintEntity;
import mom.sda.projectmanagement.repositories.SprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SprintService {
    @Autowired
    private SprintRepository sprintRepository;
    public void addSprint (SprintEntity sprintEntity){
        sprintRepository.save(sprintEntity);
    }
}
