package mom.sda.projectmanagement.service;


import mom.sda.projectmanagement.entities.UserEntity;
import mom.sda.projectmanagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserService {
    @Autowired


    private UserRepository userRepository;

    public void addUser (UserEntity newUser){

        userRepository.save(newUser);
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
        List<UserEntity>getAllUsers(){
            return UserRepository.findAll();
            public void deleteUser(long id);
            userRepository.deleteUser



        }
    }

