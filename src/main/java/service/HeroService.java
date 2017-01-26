package service;

import java.util.List;
import entity.HeroEntity;

/**
 * Created by Ivan on 26.01.2017.
 */
public interface HeroService {
    public void addHero(HeroEntity h);
    public void updateHero(HeroEntity h);
    public List<HeroEntity> listHeroes();
    public HeroEntity getHeroById(int id);
    public void removeHero(int id);

}
