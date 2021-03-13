package mom.sda.projectmanagement.entities;

import javax.persistence.*;

@Entity
@Table(name = "project")
public class ProjectEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
    private String name;
    private String description;
    private String administrator;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = Math.toIntExact(id);
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

    public String getAdministrator() {
        return administrator;
    }

    public void setAdministrator(String administrator) {
        this.administrator = administrator;
    }
}
