package org.mativil.dao;

import org.mativil.entity.MapEntity;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Ivan on 29.01.2017.
 */
public interface MapDao {
    public void setEntityManager(EntityManager em);

    public void addMap(MapEntity l);

    public void updateMap(MapEntity l);

    public List<MapEntity> list();

    public MapEntity getMapById(int id);

    public void removeMap(int id);
}
