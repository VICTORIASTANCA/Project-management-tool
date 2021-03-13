package mom.sda.projectmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<mom.sda.projectmanagement.entities.TaskNameEntity, Integer> {
}