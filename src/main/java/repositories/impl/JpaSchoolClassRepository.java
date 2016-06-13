package repositories.impl;

import domain.SchoolClass;
import repositories.IRepository;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Dawid_2 on 2014-12-17.
 */
public class JpaSchoolClassRepository implements IRepository<SchoolClass> {

    private EntityManager em;

    public JpaSchoolClassRepository(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    public SchoolClass get(int id) {
        return em.find(SchoolClass.class, id);
    }

    @Override
    public List<SchoolClass> getAll() {
        return em.createNamedQuery("schoolClass.all", SchoolClass.class).getResultList();
    }

    @Override
    public void add(SchoolClass entity) {
        em.persist(entity);
    }

    @Override
    public void delete(SchoolClass entity) {
        em.remove(entity);
    }

    @Override
    public void update(SchoolClass schoolClass) {
    }
}
