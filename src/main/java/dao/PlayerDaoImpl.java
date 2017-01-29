package dao;

import entity.PlayerEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Ivan on 29.01.2017.
 */
@Component
public class PlayerDaoImpl implements PlayerDao{
    @PersistenceContext
    protected EntityManager em;

    @Override
    public void setEntityManager(EntityManager em)
    {
        this.em = em;
    }

    @Override
    public void addPlayer(PlayerEntity l) {
        em.persist(l);
    }

    @Override
    public void updatePlayer(PlayerEntity l) {
        em.merge(l);
    }

    @Override
    public List<PlayerEntity> list() {
        List<PlayerEntity> list = em.createQuery("from PlayerEntity").getResultList();
        return list;
    }

    @Override
    public PlayerEntity getPlayerById(int id) {
        return em.getReference(PlayerEntity.class, id);
    }

    @Override
    public void removePlayer(int id) {
        em.remove(getPlayerById(id));
    }
}
