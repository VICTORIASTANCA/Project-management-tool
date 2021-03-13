package mom.sda.projectmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SprintRepository extends JpaRepository<mom.sda.projectmanagement.entities.SprintEntity,Integer> {
}
