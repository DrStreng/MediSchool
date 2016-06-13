package repositories.impl;

import domain.School;
import repositories.IRepository;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Dawid_2 on 2015-01-06.
 */
public class JpaSchoolRepository implements IRepository<School> {

    private EntityManager em;

    public JpaSchoolRepository(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    public School get(int id) {
        return em.find(School.class, id);
    }

    @Override
    public List<School> getAll() {
        return em.createNamedQuery("school.all", School.class).getResultList();
    }

    @Override
    public void add(School entity) {
        em.persist(entity);
    }

    @Override
    public void delete(School entity) {
        em.remove(entity);
    }

    @Override
    public void update(School school) {
    }
}
