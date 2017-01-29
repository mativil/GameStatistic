package dao;

import entity.MapEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Ivan on 29.01.2017.
 */
@Component
public class MapDaoImpl implements MapDao{
    @PersistenceContext
    protected EntityManager em;

    @Override
    public void setEntityManager(EntityManager em)
    {
        this.em = em;
    }

    @Override
    public void addMap(MapEntity l) {
        em.persist(l);
    }

    @Override
    public void updateMap(MapEntity l) {
        em.merge(l);
    }

    @Override
    public List<MapEntity> list() {
        List<MapEntity> list = em.createQuery("from MapEntity").getResultList();
        return list;
    }

    @Override
    public MapEntity getMapById(int id) {
        return em.getReference(MapEntity.class, id);
    }

    @Override
    public void removeMap(int id) {
        em.remove(getMapById(id));
    }


}
