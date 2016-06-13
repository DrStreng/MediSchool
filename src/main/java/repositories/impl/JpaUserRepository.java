package repositories.impl;

import domain.Users;
import repositories.IRepository;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Dawid_2 on 2014-12-17.
 */
public class JpaUserRepository implements IRepository<Users> {
    private EntityManager em;

    public JpaUserRepository(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    public Users get(int id) {
        return em.find(Users.class, id);
    }

    @Override
    public List<Users> getAll() {
        return em.createNamedQuery("users.all", Users.class).getResultList();
    }

    @Override
    public void add(Users entity) {
        em.persist(entity);
    }

    @Override
    public void delete(Users entity) {
        em.remove(entity);
    }

    @Override
    public void update(Users entity) {
    }
}

