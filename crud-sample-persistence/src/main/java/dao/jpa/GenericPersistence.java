package dao.jpa;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class GenericPersistence {

    protected EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext(unitName = "PostgresDS")
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
