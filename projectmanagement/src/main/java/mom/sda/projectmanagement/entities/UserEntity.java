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
    private String username;
    private String role;

    @OneToMany(mappedBy = "user")
    private List<TaskNameEntity> tasks;
    public UserEntity (List<TaskNameEntity> tasks ) {
        for (TaskNameEntity taskNameEntity : this.tasks = tasks) {
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayed_name() {
        return displayed_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<TaskNameEntity> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskNameEntity> tasks) {
        this.tasks = tasks;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void setDisplayed_name(String displayed_name) {
        this.displayed_name = displayed_name;
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
}