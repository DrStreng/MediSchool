package domain;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;

@Entity
@NamedQuery(name = "users.all", query = "select u from Users u")
public class Users extends EntityBase {


    private String login;
    private String password;
    private String email;

    public Users(String login, String password, String email) {
        super();
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public Users() {
        // TODO Auto-generated constructor stub
    }

    @Size(min = 2, max = 20)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Size(min = 2, max = 20)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
