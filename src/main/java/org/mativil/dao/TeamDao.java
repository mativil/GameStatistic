package org.mativil.dao;

import org.mativil.entity.TeamEntity;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Ivan on 29.01.2017.
 */
public interface TeamDao {
    public void setEntityManager(EntityManager em);

    public void addTeam(TeamEntity l);

    public void updateTeam(TeamEntity l);

    public List<TeamEntity> list();

    public TeamEntity getTeamById(int id);

    public void removeTeam(int id);
}
