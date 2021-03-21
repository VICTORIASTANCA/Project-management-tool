package mom.sda.projectmanagement.entities;

import javax.persistence.*;

@Entity
@Table(name="participation")

public class ParticipationInProjectEntity {
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


