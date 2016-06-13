package repositories.impl;

import domain.School;
import domain.SchoolClass;
import domain.Student;
import domain.Users;
import repositories.ICatalogRepository;
import repositories.IRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Stateless
public class RepositoryCatalog implements ICatalogRepository {

    @Inject
    private EntityManager em;

    @Override
    public IRepository<School> getSchoolRepo() {
        return new JpaSchoolRepository(em);
    }

    @Override
    public IRepository<Users> getUserRepo() {
        return new JpaUserRepository(em);
    }
    @Override
    public IRepository<SchoolClass> getSchoolClassRepo() {
        return new JpaSchoolClassRepository(em);
    }

    @Override
    public IRepository<Student> getStudRepo() {
        return new JpaStudentRepository(em);
    }


}
