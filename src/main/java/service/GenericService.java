package service;

import java.util.List;
import entity.HeroEntity;
import org.springframework.stereotype.Service;

/**
 * Created by Ivan on 26.01.2017.
 */

public interface GenericService<T> {
    public void add(T t);
    public void update(T t);
    public List<T> list();
    public HeroEntity getById(Object id);
    public void remove(Object id);
}
