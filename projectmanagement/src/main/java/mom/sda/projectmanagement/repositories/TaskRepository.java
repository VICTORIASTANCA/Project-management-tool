package mom.sda.projectmanagement.repositories;

import mom.sda.projectmanagement.entities.TaskNameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskNameEntity, Integer> {
}
