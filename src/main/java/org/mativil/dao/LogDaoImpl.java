package org.mativil.dao;

import org.mativil.entity.LogEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Ivan on 29.01.2017.
 */
@Component
public class LogDaoImpl implements LogDao{
    @PersistenceContext
    protected EntityManager em;

    @Override
    public void setEntityManager(EntityManager em)
    {
        this.em = em;
    }

    @Override
    public void addLog(LogEntity l) {
        em.persist(l);
    }

    @Override
    public void updateLog(LogEntity l) {
        em.merge(l);
    }

    @Override
    public List<LogEntity> list() {
        List<LogEntity> list = em.createQuery("from LogEntity").getResultList();
        return list;
    }

    @Override
    public LogEntity getLogById(int id) {
        return em.getReference(LogEntity.class, id);
    }

    @Override
    public void removeLog(int id) {
        em.remove(getLogById(id));
    }


}
