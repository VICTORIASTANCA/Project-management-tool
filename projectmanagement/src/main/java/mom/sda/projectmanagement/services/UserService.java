package mom.sda.projectmanagement.services;
import mom.sda.projectmanagement.entities.UserEntity;
import mom.sda.projectmanagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service

       public class UserService {

    @Autowired
    private UserRepository userRepository;


    public void addUser(UserEntity newUser) {
        userRepository.save(newUser);
    }

    public void editUser(UserEntity editedUser) {
        userRepository.save(editedUser);

    }


    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();

    }

    public void deleteUser( long id) {
        userRepository.deleteById(id);




    }


    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public UserRepository getUserRepository() {
        return userRepository;

    }

    public UserEntity getUserEntity(long id) {
        Optional<UserEntity> userEntityOptional =  userRepository.findById(id);
        UserEntity userEntity = userEntityOptional.get();
        return userEntity;

    }

}










