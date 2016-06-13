package domain;


import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@NamedQuery(name = "student.all", query = "select s from Student s")
public class Student extends EntityBase {

    private String name;
    private String surname;
    private String personalIdentificationNumber;
    private String address;
    private String description;
    private int qualificationOnCorrectiveGymnastics;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schoolClass_id")
    private SchoolClass schoolClass;

    @Size(min = 2, max = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Size(min = 2, max = 20)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPersonalIdentificationNumber() {
        return personalIdentificationNumber;
    }

    public void setPersonalIdentificationNumber(String personalIdentificationNumber) {
        this.personalIdentificationNumber = personalIdentificationNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQualificationOnCorrectiveGymnastics() {
        return qualificationOnCorrectiveGymnastics;
    }

    public void setQualificationOnCorrectiveGymnastics(int qualificationOnCorrectiveGymnastics) {
        this.qualificationOnCorrectiveGymnastics = qualificationOnCorrectiveGymnastics;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }
}
