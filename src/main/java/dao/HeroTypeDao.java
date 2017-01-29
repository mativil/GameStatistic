package dao;

import entity.HeroTypeEntity;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Ivan on 29.01.2017.
 */
public interface HeroTypeDao {
    public void setEntityManager(EntityManager em);

    public void addHeroType(HeroTypeEntity h);

    public void updateHeroType(HeroTypeEntity h);

    public List<HeroTypeEntity> list();

    public HeroTypeEntity geHeroTypeById(int id);

    public void removeHeroType(int id);
}
