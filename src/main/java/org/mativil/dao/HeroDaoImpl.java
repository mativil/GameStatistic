package org.mativil.dao;

import org.mativil.entity.HeroEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by MI on 25.01.2017.
 */
@Component
public class HeroDaoImpl implements HeroDao{
    @PersistenceContext
    protected EntityManager em;

    @Override
    public void addHero(HeroEntity h) {
        em.persist(h);
    }

    @Override
    public void updateHero(HeroEntity h) {
        em.merge(h);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<HeroEntity> list() {
        List<HeroEntity> heroList = em.createQuery("from HeroEntity").getResultList();
        return heroList;
    }

    @Override
    public HeroEntity getHeroById(int id) {
        return em.find(HeroEntity.class, id);
    }

    @Override
    public void removeHero(int id) {
        em.remove(em.getReference(HeroEntity.class, id));
    }
}
