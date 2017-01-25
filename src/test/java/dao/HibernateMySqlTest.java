package dao;

import entity.*;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HibernateMySqlTest extends Assert {
    // Определяет подключение к БД - какую БД сейчас использовать?
    private static EntityManagerFactory emf;
    private static EntityManager em;

    @BeforeClass
    public static void setUpClass() {
        //emf = Persistence.createEntityManagerFactory("Unit-tests-MySQL");
        emf = Persistence.createEntityManagerFactory("Unit-tests-MySQL");
        em = emf.createEntityManager();
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Close EntityManagerFactory");
        emf.close();
    }

    /**
     * Добавляем одного пользователя, находим его по id
     */
    @Test
    public void testSystem(){
        em.getTransaction().begin();

        //Добавим 4 типа героев
        HeroTypeEntity ctWarrior = new HeroTypeEntity("Боец");
        HeroTypeEntity ctSupport = new HeroTypeEntity("Поддержка");
        HeroTypeEntity ctTank = new HeroTypeEntity("Танк");
        HeroTypeEntity ctSpec = new HeroTypeEntity("Специалист");
        em.persist(ctWarrior);
        em.persist(ctSupport);
        em.persist(ctTank);
        em.persist(ctSpec);

        //одну карту
        MapEntity map1 = new MapEntity("Карта1");

        em.persist(map1);

        //10 уникальных героев
        List<HeroEntity> heroes = new ArrayList<HeroEntity>();
        heroes.add(new HeroEntity("Назибо", ctSpec));
        heroes.add(new HeroEntity("Ли-Ли", ctSupport));
        heroes.add(new HeroEntity("Рейнор", ctWarrior));
        heroes.add(new HeroEntity("Квазимодо", ctWarrior));
        heroes.add(new HeroEntity("Братуха-борцуха", ctTank));
        heroes.add(new HeroEntity("Лейтенант Моралес", ctSupport));
        heroes.add(new HeroEntity("Штучка-дрючка", ctWarrior));
        heroes.add(new HeroEntity("Базилио", ctSpec));
        heroes.add(new HeroEntity("Антоха", ctSupport));
        heroes.add(new HeroEntity("Бесполезный дворф", ctTank));

        for(HeroEntity hero: heroes)
            em.persist(hero);

        //10 игроков
        List<PlayerEntity> players = new ArrayList<>();
        for(int i = 0 ; i<10;i++)
            players.add(new PlayerEntity("player"+i));

        for(PlayerEntity player: players)
            em.persist(player);


        int gamesCnt = 1000;
        //и заданное количество игр
        for(int i = 0; i < gamesCnt; i++)
        {
            //формируем команды
            TeamEntity team1 = new TeamEntity();
            em.persist(team1);
            for(int j = 0; j < 5; j++) {
                HeroStatisticEntity heroStat =
                        new HeroStatisticEntity(heroes.get((int) (Math.random() * 10)), players.get(j), (int) (Math.random() * 20), (int) (Math.random() * 20), team1);
                em.persist(heroStat);
            }

            TeamEntity team2 = new TeamEntity();
            em.persist(team2);
            for(int j = 0; j < 5; j++) {
                HeroStatisticEntity heroStat =
                        new HeroStatisticEntity(heroes.get((int) (Math.random() * 10)), players.get(j+5), (int) (Math.random() * 20), (int) (Math.random() * 20), team2);
                em.persist(heroStat);
            }

            //и лог
            LogEntity log;
            if(Math.random() > 0.5)
                log = new LogEntity(team1, team2);
            else
                log = new LogEntity(team2, team1);

            em.persist(log);
        }


        em.getTransaction().commit();
    }

    @Test
    public void testMyHeroDao()
    {
        HeroDaoImpl dao = new HeroDaoImpl();
        //dao.setSessionFactory();
    }





    private String getPersistenceProperty(String propertyName) {
        return (String) emf.getProperties().get(propertyName);
    }


}