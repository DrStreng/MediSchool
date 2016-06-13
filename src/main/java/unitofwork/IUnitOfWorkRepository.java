package unitofwork;

import domain.EntityBase;

public interface IUnitOfWorkRepository {

    public void persistAdd(EntityBase entity);

    public void persistUpdate(EntityBase entity);

    public void persistDelete(EntityBase entity);
}
