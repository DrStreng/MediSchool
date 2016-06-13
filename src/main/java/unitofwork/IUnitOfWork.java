package unitofwork;

import domain.EntityBase;

public interface IUnitOfWork {

    public void commit();

    public void rollback();

    public void markAsNew(EntityBase entity, IUnitOfWorkRepository repository);

    public void markAsChanged(EntityBase entity, IUnitOfWorkRepository repository);

    public void markAsDeleted(EntityBase entity, IUnitOfWorkRepository repository);

}