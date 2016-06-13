package repositories.impl;


import domain.Student;
import repositories.IRepository;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Dawid_2 on 2014-12-17.
 */
public class JpaStudentRepository implements IRepository<Student> {

    private EntityManager em;

    public JpaStudentRepository(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    public Student get(int id) {
        return em.find(Student.class, id);
    }

    @Override
    public List<Student> getAll() {
        return em.createNamedQuery("student.all", Student.class).getResultList();
    }

    @Override
    public void add(Student entity) {
        em.persist(entity);
    }

    @Override
    public void delete(Student entity) {
        em.remove(entity);
    }

    @Override
    public void update(Student entity) {
    }
}
