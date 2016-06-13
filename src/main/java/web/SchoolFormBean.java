package web;

import domain.School;
import repositories.ICatalogRepository;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;

@SessionScoped
@Transactional
@Named("schoolBean")
public class SchoolFormBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private ListDataModel<School> schools = new ListDataModel<School>();

    private School school = new School();

    @Inject
    private ICatalogRepository catalog;


    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public String saveSchool() {
        catalog.getSchoolRepo().add(school);
        school = new School();
        return "schools";
    }

    public ListDataModel<School> getSchools() {
        schools.setWrappedData(catalog.getSchoolRepo().getAll());
        return schools;
    }

    public String deleteSchool() {
        School school = schools.getRowData();
        School schoolToDelete = catalog.getSchoolRepo().get(school.getId());
        catalog.getSchoolRepo().delete(schoolToDelete);
        return "schools";
    }

    public String editSchool() {
        school = schools.getRowData();
        return "editSchool";
    }

    public String editAll() {
        School s = catalog.getSchoolRepo().get(school.getId());
        s.setCity(school.getCity());
        s.setSchoolName(school.getSchoolName());
        s.setAddress(school.getAddress());
        return "schools";
    }
}

