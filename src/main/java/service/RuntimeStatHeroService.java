package service;

import dao.HeroDao;
import dao.HeroStatisticDao;
import dao.LogDao;
import dao.TeamDao;
import entity.HeroEntity;
import entity.HeroStatisticEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Ivan on 29.01.2017.
 */
public class RuntimeStatHeroService implements RuntimeStatService<HeroEntity, Integer>{
    private Map<HeroEntity, Integer> result;

    private LogDao logDao;

    private TeamDao teamDao;

    private HeroStatisticDao heroStatisticDao;

    private HeroDao heroDao;

    public void setLogDao(LogDao logDao) {
        this.logDao = logDao;
    }

    public void setTeamDao(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    public void setHeroStatisticDao(HeroStatisticDao heroStatisticDao) {
        this.heroStatisticDao = heroStatisticDao;
    }

    public void setHeroDao(HeroDao heroDao) {
        this.heroDao = heroDao;
    }

    @Override
    public Map<HeroEntity, Integer> getStatisticMap() {
        result = new TreeMap<HeroEntity, Integer>();

        for(HeroEntity hero : heroDao.list())
        {
            int avg = 0;
            for(HeroStatisticEntity heroStat : hero.getHeroStatInfo())
            {
                avg+=heroStat.getKillsCount();
            }
                avg/=hero.getHeroStatInfo().size();
            result.put(hero, avg);
        }
        return result;
    }
}
