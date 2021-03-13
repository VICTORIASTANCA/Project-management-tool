package mom.sda.projectmanagement.entities;

import javax.persistence.*;



    @Entity
    @Table(name="user")

    public class UserEntity {

        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private long id;

        private String login;
        private String password;
        private String email;
        private String displayed_name;



        





