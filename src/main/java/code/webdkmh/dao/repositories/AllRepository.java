package code.webdkmh.dao.repositories;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

public class AllRepository {

    @Autowired
    private EntityManager entityManager;

    public <T, ID> T findById(Class<T> type, ID id) {
        entityManager.getMetamodel().getEntities();
        return entityManager.find(type, id);

    }
}