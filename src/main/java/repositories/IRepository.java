package repositories;

import domain.EntityBase;

import java.util.List;

public interface IRepository<TEntity extends EntityBase> {

    public TEntity get(int id);
    public List<TEntity> getAll();
    public void add(TEntity entity);
    public void delete(TEntity entity);
    public void update(TEntity entity);

}