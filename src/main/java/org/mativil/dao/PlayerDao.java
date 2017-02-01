package org.mativil.dao;

import org.mativil.entity.PlayerEntity;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Ivan on 29.01.2017.
 */
public interface PlayerDao {
    public void setEntityManager(EntityManager em);

    public void addPlayer(PlayerEntity l);

    public void updatePlayer(PlayerEntity l);

    public List<PlayerEntity> list();

    public PlayerEntity getPlayerById(int id);

    public void removePlayer(int id);
}
