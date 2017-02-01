package org.mativil.dao;

import org.mativil.entity.HeroStatisticEntity;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Ivan on 29.01.2017.
 */
public interface HeroStatisticDao {
    public void setEntityManager(EntityManager em);

    public void addHeroStatistic(HeroStatisticEntity h);

    public void updateHeroStatistic(HeroStatisticEntity h);

    public List<HeroStatisticEntity> list();

    public HeroStatisticEntity getHeroStatisticById(int id);

    public void removeHeroStatistic(int id);
}
