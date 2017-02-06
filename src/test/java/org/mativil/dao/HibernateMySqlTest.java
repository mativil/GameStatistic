package org.mativil.dao;

import org.mativil.entity.*;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
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

        UserEntity user = new UserEntity();
        user.setLogin("test");
        user.setPassword("123");
        em.persist(user);

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
        heroes.add(new HeroEntity("Мистер Пончик", ctWarrior));
        heroes.add(new HeroEntity("Харамбе", ctWarrior));

        for(HeroEntity hero: heroes)
            em.persist(hero);

        //10 игроков
        List<PlayerEntity> players = new ArrayList<>();
        for(int i = 0 ; i<10;i++)
            players.add(new PlayerEntity("player"+i));

        for(PlayerEntity player: players)
            em.persist(player);


        int gamesCnt = 50;
        //и заданное количество игр
        for(int i = 0; i < gamesCnt; i++)
        {
            LogEntity log = new LogEntity(map1, LocalDateTime.now(), LocalTime.of(0, (int) (Math.random() * 25) + 10, (int) (Math.random() * 59)));
            em.persist(log);
            //формируем команды
            TeamEntity team1 = new TeamEntity(log);
            TeamEntity team2 = new TeamEntity(log);
            if(Math.random() > (Math.random()/4 + 0.37)) {
                team1.setIsWin(true);
                team2.setIsWin(false);
            }
            else {
                team1.setIsWin(false);
                team2.setIsWin(true);

            }

            em.persist(team1);
            em.persist(team2);

            for(int j = 0; j < 5; j++) {
                HeroStatisticEntity heroStat =
                        new HeroStatisticEntity(heroes.get((int) (Math.random() * heroes.size())), players.get(j), (int) (Math.random() * 20), (int) (Math.random() * 20), team1);
                em.persist(heroStat);
            }


            for(int j = 0; j < 5; j++) {
                HeroStatisticEntity heroStat =
                        new HeroStatisticEntity(heroes.get((int) ( Math.random() * heroes.size())), players.get(j+5), (int) (Math.random() * 20), (int) (Math.random() * 20), team2);
                em.persist(heroStat);
            }

        }
        em.getTransaction().commit();
    }

    @Test
    public void test()
    {
    }





    private String getPersistenceProperty(String propertyName) {
        return (String) emf.getProperties().get(propertyName);
    }


}