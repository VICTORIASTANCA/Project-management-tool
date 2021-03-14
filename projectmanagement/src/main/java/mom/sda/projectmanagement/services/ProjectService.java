package mom.sda.projectmanagement.services;

import mom.sda.projectmanagement.entities.ProjectEntity;
import mom.sda.projectmanagement.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public void addProject(ProjectEntity projectEntity) {
        projectRepository.save(projectEntity);
    }


    public List<ProjectEntity> gettAllProject() {
        return projectRepository.findAll();
    }

    public void editProject(ProjectEntity editProject) {
        projectRepository.save(editProject);
    }

    public void deleteProject(Integer id) {
        projectRepository.deleteById(id);
    }


    public ProjectRepository getProjectRepository() {
        return projectRepository;
    }

    public void setProjectRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
}
