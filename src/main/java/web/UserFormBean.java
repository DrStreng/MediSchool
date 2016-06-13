package web;

import domain.Users;
import repositories.ICatalogRepository;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Transactional
@Named("userBean")
public class UserFormBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private ListDataModel<Users> users = new ListDataModel<Users>();

    @Inject
    private ICatalogRepository catalog;
    private Users user = new Users();


    public ListDataModel<Users> getUsers() {
        users.setWrappedData(catalog.getUserRepo().getAll());
        return users;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String saveUser() {
        catalog.getUserRepo().add(user);
        user = new Users();
        return "home";
    }

    public String logowanie() {
        List<Users> users = catalog.getUserRepo().getAll();

        for (Users u : users) {
            if (u.getLogin().equals(user.getLogin())
                    && u.getPassword().equals(user.getPassword())) {
                saveToSession();
            }
        }
        return "home?faces-redirect=true";
    }

    private void saveToSession() {
        FacesContext fc = FacesContext.getCurrentInstance();

        HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);

        if (user.getLogin() != null && !user.getLogin().equals("")) {
            session.setAttribute("user", user);
        }
    }

    public String logout() {
        deleteFromSession();
        return "home?faces-redirect=true";
    }

    private void deleteFromSession() {
        FacesContext fc = FacesContext.getCurrentInstance();

        HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);

        if (user.getLogin() != null && !user.getLogin().equals("")) {
            session.removeAttribute("user");
        }
    }

    public String editUser() {
        user = users.getRowData();
        return "editUser";
    }

    public String editAll() {
        Users s = catalog.getUserRepo().get(user.getId());
        s.setLogin(user.getLogin());
        s.setEmail(user.getEmail());
        return "http://localhost:8080/MediSchool_war_exploded/home.jsf";
    }
}