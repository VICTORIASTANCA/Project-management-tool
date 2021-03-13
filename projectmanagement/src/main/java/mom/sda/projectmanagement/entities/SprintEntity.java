package mom.sda.projectmanagement.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "sprint")
public class SprintEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date dateFrom;
    private Date dateTo;
    private Integer plannedStoryPoints;


    @OneToMany
    private List<
            TaskNameEntity> tasks = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<TaskNameEntity> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskNameEntity> tasks) {
        this.tasks = tasks;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Integer getPlannedStoryPoints() {
        return plannedStoryPoints;
    }

    public void setPlannedStoryPoints(Integer plannedStoryPoints) {
        this.plannedStoryPoints = plannedStoryPoints;
    }
}
