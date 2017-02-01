package org.mativil.dao;

import org.mativil.entity.HeroTypeEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by MI on 25.01.2017.
 */
//@Repository
@Component
public class HeroTypeDaoImpl implements HeroTypeDao{
    @PersistenceContext
    protected EntityManager em;

    public void setEntityManager(EntityManager em)
    {
        this.em = em;
    }

    @Override
    public void addHeroType(HeroTypeEntity h) {
        em.persist(h);
    }

    @Override
    public void updateHeroType(HeroTypeEntity h) {
        em.merge(h);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<HeroTypeEntity> list() {
        List<HeroTypeEntity> heroList = em.createQuery("from HeroEntity").getResultList();
        return heroList;
    }

    @Override
    public HeroTypeEntity geHeroTypeById(int id) {
        return em.getReference(HeroTypeEntity.class, id);
    }

    @Override
    public void removeHeroType(int id) {
        em.remove(em.getReference(HeroTypeEntity.class, id));
    }
}
