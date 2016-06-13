package domain;


import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(name = "school.all", query = "select s from School s")
public class School extends EntityBase {

    private String address;
    private String city;
    private String schoolName;

    @OneToMany(mappedBy = "school", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<SchoolClass> schools;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public List<SchoolClass> getSchools() {
        return schools;
    }

    public void setSchools(List<SchoolClass> schools) {
        this.schools = schools;
    }
}
