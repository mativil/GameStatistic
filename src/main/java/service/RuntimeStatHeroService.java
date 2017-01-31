package service;

import dao.HeroDao;
import dao.HeroStatisticDao;
import dao.LogDao;
import dao.TeamDao;
import entity.HeroEntity;
import entity.HeroStatisticEntity;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Ivan on 29.01.2017.
 */
public class RuntimeStatHeroService{

        public static class Results
        {
            private double avgKills;
            private double avgDeaths;
            private double gamesCnt;
            private double popularity;

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

            public double getGamesCnt() {
                return gamesCnt;
            }

            public void setGamesCnt(int gamesCnt) {
                this.gamesCnt = gamesCnt;
            }

            public double getPopularity() {
                return popularity;
            }

            public void setPopularity(double popularity) {
                this.popularity = popularity;
            }

            public Results(double avgKills, double avgDeaths, double gamesCnt, double popularity) {
                this.avgKills = avgKills;
                this.avgDeaths = avgDeaths;
                this.gamesCnt = gamesCnt;
                this.popularity = popularity;
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
        if(result == null)
            calculateStatistic();
        return result;
    }

    public void calculateStatistic()
    {
        result = new TreeMap<HeroEntity, Results>();

        for(HeroEntity hero : heroDao.list())
        {
            int avgKills = 0;
            int avgDeaths = 0;
            int totalHeroCnt = 0;
            int totalHeroPopularityCnt = 0;
            int winHeroCnt = 0;

            //Чтобы проверять, что герой встречается >1 раза в игре и не считать это
            int prevId = 0;
            for(HeroStatisticEntity heroStat : hero.getHeroStatInfo()) {

                avgKills += heroStat.getKillsCount();
                avgDeaths += heroStat.getDeathsCount();

                if(prevId != heroStat.getTeam().getLog().getId())
                    totalHeroPopularityCnt++;

                totalHeroCnt++;
                if (heroStat.getTeam().getIsWin())
                    winHeroCnt++;
                prevId = heroStat.getTeam().getLog().getId();
            }

            double resAvgKills = (double)avgKills / hero.getHeroStatInfo().size();
            double resAvgDeaths = (double) avgDeaths / hero.getHeroStatInfo().size();
            double resHeroWinPersent = ((double)winHeroCnt)/totalHeroCnt * 100;
            double resPopularity = (double)totalHeroPopularityCnt/logDao.list().size() * 100;

            Results results = new Results(resAvgKills, resAvgDeaths, resHeroWinPersent, resPopularity);
            result.put(hero, results);
        }
    }
}
