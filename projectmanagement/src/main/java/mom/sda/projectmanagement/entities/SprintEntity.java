package mom.sda.projectmanagement.entities;

import org.apache.catalina.LifecycleState;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "sprint")
public class SprintEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateFrom;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateTo;
    private Integer plannedStoryPoints;

    @OneToMany
     public List<TaskNameEntity> taskNameEntities;

    public List<TaskNameEntity> getTaskNameEntities() {
        return taskNameEntities;
    }

    public void setTaskNameEntities(List<TaskNameEntity> taskNameEntities) {
        this.taskNameEntities = taskNameEntities;
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

    public void setDateTo(Date dateDo)
    {
        this.dateTo = dateDo;
    }

    public Integer getPlannedStoryPoints() {

        return plannedStoryPoints;
    }

    public void setPlannedStoryPoints(Integer plannedStoryPoints) {

        this.plannedStoryPoints = plannedStoryPoints;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
