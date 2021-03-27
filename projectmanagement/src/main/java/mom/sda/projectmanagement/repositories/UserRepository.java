package mom.sda.projectmanagement.repositories;

import mom.sda.projectmanagement.entities.UserEntity;
import org.apache.tomcat.jni.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

public Optional<UserEntity> findByUsername(String username);
}
