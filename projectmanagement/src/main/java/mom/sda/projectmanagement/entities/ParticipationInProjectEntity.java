package mom.sda.projectmanagement.entities;

import javax.persistence.*;

@Entity
@Table(name="participation")

public class ParticipationInProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String project;
    private String user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;


    }

    @Override
    public String toString() {
        return "ParticipationInProjectEntity{" +
                "id=" + id +
                ", project='" + project + '\'' +
                ", user='" + user + '\'' +
                '}';
    }

}





