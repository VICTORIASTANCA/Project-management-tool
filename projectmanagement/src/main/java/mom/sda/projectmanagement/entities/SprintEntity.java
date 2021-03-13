package mom.sda.projectmanagement.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sprint")
public class SprintEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date dateFrom;
    private Date dateDo;
    private String plannedStoryPoints;

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateDo() {
        return dateDo;
    }

    public void setDateDo(Date dateDo) {
        this.dateDo = dateDo;
    }

    public String getPlannedStoryPoints() {
        return plannedStoryPoints;
    }

    public void setPlannedStoryPoints(String plannedStoryPoints) {
        this.plannedStoryPoints = plannedStoryPoints;
    }
}
