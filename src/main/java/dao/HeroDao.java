package dao;

import entity.HeroEntity;

import java.util.List;

/**
 * Created by MI on 25.01.2017.
 */



public interface HeroDao {

    public void save(HeroEntity h);

    public void update(HeroEntity h);

    public List<HeroEntity> list();

    public HeroEntity getHeroById(int id);

    public void removeHero(int id);
}
