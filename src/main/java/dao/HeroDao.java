package dao;

import entity.HeroEntity;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by MI on 25.01.2017.
 */



public interface HeroDao {

    public void setEntityManager(EntityManager em);

    public void addHero(HeroEntity h);

    public void updateHero(HeroEntity h);

    public List<HeroEntity> list();

    public HeroEntity getHeroById(int id);

    public void removeHero(int id);
}
