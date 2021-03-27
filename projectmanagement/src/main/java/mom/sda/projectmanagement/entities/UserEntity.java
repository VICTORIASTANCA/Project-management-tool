package mom.sda.projectmanagement.entities;

import org.springframework.scheduling.config.Task;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class UserEntity<tasks> {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;
    private String login;
    private String password;
    private String email;
    private String displayed_name;

    @OneToMany(mappedBy = "user")
    private List<TaskNameEntity> tasks;


   public UserEntity (List<TaskNameEntity> tasks ) {
       for (TaskNameEntity taskNameEntity : this.tasks = tasks) {
        }
    }

    public UserEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisplayed_name() {
        return displayed_name;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", displayed_name='" + displayed_name + '\'' +
                '}';
    }

    public void setDisplayed_name(String displayed_name) {
        this.displayed_name = displayed_name;

    }


}
