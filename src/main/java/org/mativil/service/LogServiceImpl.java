package org.mativil.service;

import org.mativil.dao.LogDao;
import org.mativil.entity.LogEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ivan on 26.01.2017.
 */
@Service
public class LogServiceImpl implements GenericService<LogEntity> {
    private LogDao logDao;

    public void setLogDao(LogDao logDao)
    {
        this.logDao = logDao;
    }
    @Override
    @Transactional
    public void add(LogEntity h) {
        this.logDao.addLog(h);
    }

    @Override
    @Transactional
    public void update(LogEntity h) {
        this.logDao.updateLog(h);
    }

    @Override
    @Transactional
    public List<LogEntity> list() {
        return this.logDao.list();
    }

    @Override
    @Transactional
    public LogEntity getById(Object id) {
        return this.logDao.getLogById((int)id);
    }

    @Override
    @Transactional
    public void remove(Object id) {
        this.logDao.removeLog((int)id);
    }
}
