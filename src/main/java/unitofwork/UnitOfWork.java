package unitofwork;

import domain.EntityBase;
import domain.EntityState;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UnitOfWork implements IUnitOfWork {

    Connection connection;
    private Map<EntityBase, IUnitOfWorkRepository> entities =
            new HashMap<EntityBase, IUnitOfWorkRepository>();

    public UnitOfWork(Connection connection) {
        this.connection = connection;
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void commit() {

        try {
            for (EntityBase entity : entities.keySet()) {
                switch (entity.getState()) {
                    case Changed:
                        entities.get(entity).persistUpdate(entity);
                        break;

                    case Deleted:
                        entities.get(entity).persistDelete(entity);
                        break;
                    case New:
                        entities.get(entity).persistAdd(entity);
                        break;
                    case UnChanged:
                        break;
                    default:
                        break;
                }
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void rollback() {
        entities.clear();
    }

    @Override
    public void markAsNew(EntityBase entity, IUnitOfWorkRepository repository) {
        entity.setState(EntityState.New);
        entities.put(entity, repository);

    }

    @Override
    public void markAsChanged(EntityBase entity, IUnitOfWorkRepository repository) {
        entity.setState(EntityState.Changed);
        entities.put(entity, repository);

    }

    @Override
    public void markAsDeleted(EntityBase entity, IUnitOfWorkRepository repository) {
        entity.setState(EntityState.Deleted);
        entities.put(entity, repository);
    }

}
