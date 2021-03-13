package mom.sda.projectmanagement.entities;

import javax.persistence.*;

@Entity
@Table(name = "Tasks")

public class TaskNameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String Name;
    private String Description;
    private int Sprint;
    private double Weight;
    private int StoryPoints;
    private State Progress;
    private String AssignedPerson;

    public static enum State {
        TO_DO, ONGOING, BACKLOG, DONE, POSTPONED
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getSprint() {
        return Sprint;
    }

    public void setSprint(int sprint) {
        Sprint = sprint;
    }

    public double getWeight() {
        return Weight;
    }

    public void setWeight(double weight) {
        Weight = weight;
    }

    public int getStoryPoints() {
        return StoryPoints;
    }

    public void setStoryPoints(int storyPoints) {
        StoryPoints = storyPoints;
    }

    public State getProgress() {
        return Progress;
    }

    public void setProgress(State progress) {
        Progress = progress;
    }

    public String getAssignedPerson() {
        return AssignedPerson;
    }

    public void setAssignedPerson(String assignedPerson) {
        AssignedPerson = assignedPerson;
    }
}
