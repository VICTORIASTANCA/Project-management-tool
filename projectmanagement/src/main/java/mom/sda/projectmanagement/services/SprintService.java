package mom.sda.projectmanagement.services;

import mom.sda.projectmanagement.entities.SprintEntity;
import mom.sda.projectmanagement.repositories.SprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void deleteSprint(Integer id) {
        sprintRepository.deleteById(id);
    }

    public SprintRepository getSprintRepository() {
        return sprintRepository;
    }

    public void setSprintRepository(SprintRepository sprintRepository) {
        this.sprintRepository = sprintRepository;
    }

    public SprintEntity getSprint(int id) {
        Optional<SprintEntity> sprintEntityOptional =  sprintRepository.findById(id);
        SprintEntity sprintEntity = sprintEntityOptional.get();
        return sprintEntity;
    }
}
