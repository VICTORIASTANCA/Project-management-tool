package mom.sda.projectmanagement.services;


import mom.sda.projectmanagement.entities.UserEntity;
import mom.sda.projectmanagement.repositories.UserRepository;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

      @Service

       public class UserService {
       @Autowired
       private UserRepository userRepository;


          public void addUser(UserEntity newUser){
           userRepository.save(newUser);
    }

         public List<UserEntity> getAllUsers(){
         return userRepository.findAll();

          }
          public boolean deleteUser(Integer id){
           userRepository.deleteById(id);
              return false;
          }



          public void setUserRepository(UserRepository userRepository){
          this.userRepository=userRepository;
          }

          public UserRepository getUserRepository() {
              return userRepository;
          }

          public User editUser() {
          return userRepository.save();

              }

      }




