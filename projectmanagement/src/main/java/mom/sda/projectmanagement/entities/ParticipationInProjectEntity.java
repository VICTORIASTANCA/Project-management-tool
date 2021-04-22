package mom.sda.projectmanagement.entities;

import javax.persistence.*;

@Entity
@Table(name="participation")

public class ParticipationInProjectEntity {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private ProjectEntity project;
    @OneToOne
    private UserEntity user;
}
    //private String project;
   // private String user;
//one to one
    //project entity project
    //one to one
    //user to user


