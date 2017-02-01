package org.mativil.dao;

import org.mativil.entity.LogEntity;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Ivan on 29.01.2017.
 */
public interface LogDao {
    public void setEntityManager(EntityManager em);

    public void addLog(LogEntity l);

    public void updateLog(LogEntity l);

    public List<LogEntity> list();

    public LogEntity getLogById(int id);

    public void removeLog(int id);
}
