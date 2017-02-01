package org.mativil.service;

import org.mativil.dao.HeroDao;
import org.mativil.entity.HeroEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by Ivan on 26.01.2017.
 */
@Service
public class HeroServiceImpl implements GenericService<HeroEntity> {

    @Qualifier("heroDaoImpl")
    @Autowired
    private HeroDao heroDao;

    @Override
    @Transactional
    public void add(HeroEntity h) {
        this.heroDao.addHero(h);
    }

    @Override
    @Transactional
    public void update(HeroEntity h) {
        this.heroDao.updateHero(h);
    }

    @Override
    @Transactional
    public List<HeroEntity> list() {
        return this.heroDao.list();
    }

    @Override
    @Transactional
    public HeroEntity getById(Object id) {
        return this.heroDao.getHeroById((int)id);
    }

    @Override
    @Transactional
    public void remove(Object id) {
        this.heroDao.removeHero((int)id);
    }
}
