package mom.sda.projectmanagement.entities;

import javax.persistence.*;



    @Entity
    @Table(name="user")

    public class UserEntity {

        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private Integer Id;
        private String Login;
        private String Password;
        private String email;
        private String displayed_name;

        public Integer getId() {
            return Id;
        }

        public void setId(Integer id) {
            Id = id;
        }

        public String getLogin() {
            return Login;
        }

        public void setLogin(String login) {
            Login = login;
        }

        public String getPassword() {
            return Password;
        }

        public void setPassword(String password) {
            Password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getDisplayed_name() {
            return displayed_name;
        }

        @Override
        public String toString() {
            return "UserEntity{" +
                    "Id=" + Id +
                    ", Login='" + Login + '\'' +
                    ", Password='" + Password + '\'' +
                    ", email='" + email + '\'' +
                    ", displayed_name='" + displayed_name + '\'' +
                    '}';
        }

        public void setDisplayed_name(String displayed_name) {
            this.displayed_name = displayed_name;


        }
    }



        





