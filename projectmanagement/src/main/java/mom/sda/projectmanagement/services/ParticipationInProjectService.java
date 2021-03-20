package mom.sda.projectmanagement.services;


import mom.sda.projectmanagement.entities.ParticipationInProjectEntity;
import mom.sda.projectmanagement.repositories.ParticipationInProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipationInProjectService {
    @Autowired
    private ParticipationInProjectRepository participationInProjectRepository;

    public void addParticipationInProject(ParticipationInProjectEntity participationInProjectEntity){
    participationInProjectRepository.save(participationInProjectEntity);
}
   public List<ParticipationInProjectEntity> getAllParticipationInProject(){
        return participationInProjectRepository.findAll();
   }

   public void editParticipationInProject (ParticipationInProjectEntity editParticipationInProject){
        participationInProjectRepository.save(editParticipationInProject);
   }

   public void deleteParticipationInProject(Integer id){
       participationInProjectRepository.deleteById(id);
   }

   public ParticipationInProjectRepository getParticipationInProjectRepository(){
        return participationInProjectRepository;
   }

    public void setParticipationInProjectRepository(ParticipationInProjectRepository participationInProjectRepository) {
        this.participationInProjectRepository = participationInProjectRepository;
    }
}