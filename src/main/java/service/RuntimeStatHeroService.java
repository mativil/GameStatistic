package service;

import dao.HeroDao;
import dao.HeroStatisticDao;
import dao.LogDao;
import dao.TeamDao;
import entity.HeroEntity;
import entity.HeroStatisticEntity;
import entity.LogEntity;
import entity.TeamEntity;

import java.util.*;

/**
 * Created by Ivan on 29.01.2017.
 */
public class RuntimeStatHeroService{
    public static class Results
    {
        private double avgKills;
        private double avgDeaths;
        private int gamesCnt;

        public double getAvgKills() {
            return avgKills;
        }

        public void setAvgKills(double avgKills) {
            this.avgKills = avgKills;
        }

        public double getAvgDeaths() {
            return avgDeaths;
        }

        public void setAvgDeaths(double avgDeaths) {
            this.avgDeaths = avgDeaths;
        }

        public int getGamesCnt() {
            return gamesCnt;
        }

        public void setGamesCnt(int gamesCnt) {
            this.gamesCnt = gamesCnt;
        }

        public Results(double avgKills, double avgDeaths, int gamesCnt) {
            this.avgKills = avgKills;
            this.avgDeaths = avgDeaths;
            this.gamesCnt = gamesCnt;
        }
    }
    private Map<HeroEntity, Results> result;

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

    //@Override
    public Map<HeroEntity, Results> getStatisticMap() {
        //if(result == null)
            calculateStatistic();
        return result;
    }

    public void calculateStatistic()
    {
        result = new TreeMap<HeroEntity, Results>();

        for(HeroEntity hero : heroDao.list())
        {
            Set<LogEntity> logSet = new HashSet<LogEntity>();
            int avgKills = 0;
            int avgDeaths = 0;
            int gamesCnt = 0;
            for(HeroStatisticEntity heroStat : hero.getHeroStatInfo())
            {
                avgKills+=heroStat.getKillsCount();
                avgDeaths+=heroStat.getDeathsCount();

                LogEntity log = heroStat.getTeam().getWinLogEntity();
                //для подсчета общего количества пофиг. Просто нужны уникальные
                logSet.add(log);
                //если игрок победил
                if(log.getwinTeam() == heroStat.getTeam())
                {

                }

            }

            Results results = new Results((double) avgKills/hero.getHeroStatInfo().size(),
                    (double) avgDeaths/hero.getHeroStatInfo().size(), logSet.size());
            result.put(hero, results);

        }
    }
}
