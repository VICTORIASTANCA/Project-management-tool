package mom.sda.projectmanagement.entities;

import org.apache.tomcat.jni.User;
import org.hibernate.usertype.UserType;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import javax.persistence.*;

@Entity
@Table(name = "Tasks")

public class TaskNameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private int sprint;
    private double weight;
    private int storyPoints;
    @Enumerated(EnumType.STRING)
    private State progress;
    private String assignedPerson;

    public enum State {
        TO_DO, ONGOING, BACKLOG, DONE, POSTPONED
    }

    @ManyToOne
    @JoinColumn(name = "id")
    private UserEntity user;

    public UserEntity userEntity() {
        return user;
    }

    public Integer getId() {
        return id;
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

    public int getSprint() {
        return sprint;
    }

    public void setSprint(int sprint) {
        this.sprint = sprint;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getStoryPoints() {
        return storyPoints;
    }

    public void setStoryPoints(int storyPoints) {
        this.storyPoints = storyPoints;
    }

    public State getProgress() {
        return progress;
    }

    public void setProgress(State progress) {
        this.progress = progress;
    }

    public String getAssignedPerson() {
        return assignedPerson;
    }

    public void setAssignedPerson(String assignedPerson) {
        this.assignedPerson = assignedPerson;
    }
}
