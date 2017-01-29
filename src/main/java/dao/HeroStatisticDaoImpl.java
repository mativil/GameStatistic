package dao;

import entity.HeroStatisticEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Ivan on 29.01.2017.
 */
@Component
public class HeroStatisticDaoImpl implements HeroStatisticDao{
    @PersistenceContext
    protected EntityManager em;

    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Override
    public void addHeroStatistic(HeroStatisticEntity h) {
        em.persist(h);
    }

    @Override
    public void updateHeroStatistic(HeroStatisticEntity h) {
        em.merge(h);
    }

    @Override
    public List<HeroStatisticEntity> list() {
        List<HeroStatisticEntity> list = em.createQuery("from HeroStatisticEntity").getResultList();
        return list;
    }

    @Override
    public HeroStatisticEntity getHeroStatisticById(int id) {
        return em.getReference(HeroStatisticEntity.class, id);
    }

    @Override
    public void removeHeroStatistic(int id) {
        em.remove(getHeroStatisticById(id));
    }
}
