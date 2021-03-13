package mom.sda.projectmanagement.service;

import mom.sda.projectmanagement.entities.ProjectEntity;
import mom.sda.projectmanagement.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    private void addProject(ProjectEntity projectEntity){
        projectRepository.save(projectEntity);
    }
}
