package services;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class EMProducer {

    @PersistenceContext(name = "connect")
    @Produces
    private EntityManager em;
}