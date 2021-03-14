package mom.sda.projectmanagement.repositories;

import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<mom.sda.projectmanagement.entities.ProjectEntity, Integer> {
}
