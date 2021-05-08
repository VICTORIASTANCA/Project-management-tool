package mom.sda.projectmanagement.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "project")
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
//    private String administrator;

    public Integer getId() {
        return id;
    }

    @OneToMany
    public List<SprintEntity> sprintEntities;

    @ManyToOne
    private UserEntity userEntity;

    public List<SprintEntity> getSprintEntities() {
        return sprintEntities;
    }

    public void setSprintEntities(List<SprintEntity> sprintEntities) {
        this.sprintEntities = sprintEntities;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity user) {
        this.userEntity = user;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}