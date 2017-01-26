package service;

import dao.HeroDao;
import entity.HeroEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation;
import java.util.List;

/**
 * Created by Ivan on 26.01.2017.
 */
@Service
public class HeroServiceImpl implements HeroService{
    private HeroDao heroDao;

    public void setHeroDao(HeroDao heroDao)
    {
        this.heroDao = heroDao;
    }
    @Override
    @Transactional
    public void addHero(HeroEntity h) {
        this.heroDao.addHero(h);
    }

    @Override
    @Transactional
    public void updateHero(HeroEntity h) {
        this.heroDao.updateHero(h);
    }

    @Override
    @Transactional
    public List<HeroEntity> listHeroes() {
        return this.heroDao.list();
    }

    @Override
    @Transactional
    public HeroEntity getHeroById(int id) {
        return this.heroDao.getHeroById(id);
    }

    @Override
    @Transactional
    public void removeHero(int id) {
        this.heroDao.removeHero(id);
    }
}
