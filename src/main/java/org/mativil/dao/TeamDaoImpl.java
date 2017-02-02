package org.mativil.dao;

import org.mativil.entity.TeamEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Ivan on 29.01.2017.
 */
@Component
public class TeamDaoImpl implements TeamDao{
    @PersistenceContext
    protected EntityManager em;

    @Override
    public void addTeam(TeamEntity l) {
        em.persist(l);
    }

    @Override
    public void updateTeam(TeamEntity l) {
        em.merge(l);
    }

    @Override
    public List<TeamEntity> list() {
        List<TeamEntity> list = em.createQuery("from TeamEntity").getResultList();
        return list;
    }

    @Override
    public TeamEntity getTeamById(int id) {
        return em.getReference(TeamEntity.class, id);
    }

    @Override
    public void removeTeam(int id) {
        em.remove(getTeamById(id));
    }
}
