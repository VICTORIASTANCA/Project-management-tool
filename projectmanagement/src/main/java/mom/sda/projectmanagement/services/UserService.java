package mom.sda.projectmanagement.services;
import mom.sda.projectmanagement.entities.UserEntity;
import mom.sda.projectmanagement.repositories.UserRepository;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service

public class UserService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
     Optional<UserEntity>  userOptional= userRepository.findByUsername(s);
     if(userOptional.isPresent()){
         UserEntity user = userOptional.get();


         String username = user.getUsername();
         String password = user.getPassword();
         List<GrantedAuthority> listaDeRoluri = Arrays.asList( new SimpleGrantedAuthority(user.getRole()));
         UserDetails userDetails = new org.springframework.security.core.userdetails.User(username, password, listaDeRoluri);
         return userDetails;
     }
        throw new UsernameNotFoundException("user not found!");
    }

 public void addCustomer (UserEntity user){
        user.setRole("ROLE_CUSTOMER");
        String password= user.getPassword();
        String encodePassword = passwordEncoder.encode(password);
        user.setPassword(encodePassword);
        userRepository.save(user);
 }
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

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










