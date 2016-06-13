package web;

import domain.Student;
import repositories.ICatalogRepository;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;

@SessionScoped
@Transactional
@Named("studentBean")
public class StudentFormBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private ListDataModel<Student> students = new ListDataModel<Student>();

    private Student student = new Student();

    @Inject
    private ICatalogRepository catalog;


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String saveStudent() {
        catalog.getStudRepo().add(student);
        student = new Student();
        return "students";
    }

    public ListDataModel<Student> getStudents() {
        students.setWrappedData(catalog.getStudRepo().getAll());
        return students;
    }

    public String deleteStudent() {
        Student student = students.getRowData();
        Student studentToDelete = catalog.getStudRepo().get(student.getId());
        catalog.getStudRepo().delete(studentToDelete);
        return "students";
    }

    public String editStudent() {
        student = students.getRowData();
        return "editStudent";
    }

    public String editAll() {
        Student s = catalog.getStudRepo().get(student.getId());
        s.setName(student.getName());
        s.setSurname(student.getSurname());
        s.setDescription(student.getDescription());
        s.setAddress(student.getAddress());
        s.setPersonalIdentificationNumber(student.getPersonalIdentificationNumber());
        return "students";
    }
}


