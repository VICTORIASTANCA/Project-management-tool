package mom.sda.projectmanagement.repositories;

import mom.sda.projectmanagement.entities.ParticipationInProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipationInProjectRepository  extends JpaRepository<ParticipationInProjectEntity, Long> {
}
