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

        CharacterTypeEntity ctWarrior = new CharacterTypeEntity("Боец");
        CharacterTypeEntity ctSupport = new CharacterTypeEntity("Поддержка");
        CharacterTypeEntity ctTank = new CharacterTypeEntity("Танк");
        CharacterTypeEntity ctSpec = new CharacterTypeEntity("Специалист");
        em.persist(ctWarrior);
        em.persist(ctSupport);
        em.persist(ctTank);
        em.persist(ctSpec);

        MapEntity map1 = new MapEntity("Карта1");

        em.persist(map1);

        List<CharacterEntity> characters = new ArrayList<CharacterEntity>();
        characters.add(new CharacterEntity("Назибо", ctSpec));
        characters.add(new CharacterEntity("Ли-Ли", ctSupport));
        characters.add(new CharacterEntity("Рейнор", ctWarrior));
        characters.add(new CharacterEntity("Квазимодо", ctWarrior));
        characters.add(new CharacterEntity("Братуха-борцуха", ctTank));
        characters.add(new CharacterEntity("Лейтенант Моралес", ctSupport));
        characters.add(new CharacterEntity("Штучка-дрючка", ctWarrior));
        characters.add(new CharacterEntity("Базилио", ctSpec));
        characters.add(new CharacterEntity("Антоха", ctSupport));
        characters.add(new CharacterEntity("Бесполезный дворф", ctTank));



        List<PlayerEntity> players = new LinkedList<>();
        for(int i = 0 ; i<10;i++)
            players.add(new PlayerEntity("player"+i));


        for(int i = 0; i < 10; i++)
        {
            List<CharacterStatisticEntity> charstats = new ArrayList<>();
            for(int j = 0; j < 5; j++) {
                CharacterStatisticEntity charStat =
                        new CharacterStatisticEntity(characters.get((int) (Math.random() * 10)), players.get(j), (int) (Math.random() * 20), (int) (Math.random() * 20));
                charstats.add(charStat);
            }
            TeamEntity team1 = new TeamEntity(charstats);

            charstats = new ArrayList<>();
            for(int j = 0; j < 5; j++) {
                CharacterStatisticEntity charStat =
                        new CharacterStatisticEntity(characters.get((int) (Math.random() * 10)), players.get(j+5), (int) (Math.random() * 20), (int) (Math.random() * 20));
                charstats.add(charStat);
            }
            team1.setCharacterStatisticEntityList(charstats);
            em.persist(team1);

            TeamEntity team2 = new TeamEntity(charstats);
            LogEntity log = new LogEntity(team1, team2);


            for(CharacterEntity character : characters)
                em.persist(character);

            for(PlayerEntity player : players)
                em.persist(player);

            for(CharacterStatisticEntity cse : team1.getCharacterStatisticEntityList()) {
                em.persist(cse);
                System.out.println(cse.getId());
            }

            team2.setCharacterStatisticEntityList(charstats);

            for(CharacterStatisticEntity cse : team2.getCharacterStatisticEntityList())
                em.persist(cse);

            em.persist(team2);
            em.persist(log);
        }


        em.getTransaction().commit();
    }





    private String getPersistenceProperty(String propertyName) {
        return (String) emf.getProperties().get(propertyName);
    }


}