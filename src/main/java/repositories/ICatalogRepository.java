package repositories;

import domain.School;
import domain.SchoolClass;
import domain.Student;
import domain.Users;

public interface ICatalogRepository {

    public IRepository<SchoolClass> getSchoolClassRepo();
    public IRepository<School> getSchoolRepo();
    public IRepository<Student> getStudRepo();
    public IRepository<Users> getUserRepo();


}
