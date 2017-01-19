package dao;

import entity.*;
import entity.UserAlreadyExistsException;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

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
    public void testOneUser() throws Exception {
        String userName = "admin";
        em.getTransaction().begin();
        try {
            if (findByLogin(userName) != null) {
                throw new UserAlreadyExistsException();
            }
            User user = new User();
            user.setLogin(userName);
            em.persist(user);

            // Печатаем всех пользователей
            for (User u : em.createNamedQuery(User.ALL_USERS, User.class).getResultList()) {
                System.out.println(u.getId() + " login = " + u.getLogin());
            }

            // Это первый сохранённый пользователь, его id 1
            User user1 = em.find(User.class, 1);
            assertEquals(userName, user1.getLogin());
        } finally {
            em.getTransaction().commit();
        }
    }

    @Test
    public void addHeroes() throws Exception {
        String heroName1 = "Nazeebo";
        String heroName2 = "Raynor";
        em.getTransaction().begin();
        try {
            Hero hero1 = new Hero();
            hero1.setName(heroName1);
            hero1.setDescription("Отважный герой Назибо. Специалист дальнего боя");
            Hero hero2 = new Hero();
            hero2.setName(heroName2);
            hero2.setDescription("Отважный герой Джим Рейнор. Боец дальнего боя");
            em.persist(hero1);
            em.persist(hero2);

            // Печатаем всех героев
            for(Hero h : em.createNamedQuery(Hero.ALL_HEROES, Hero.class).getResultList())
                System.out.println(h.getId() + " "+ h.getName() + " "+h.getDescription());
            }
            catch(Exception e) {
                //Вставило действительно двух героев
                assertEquals(2, em.createNamedQuery(Hero.ALL_HEROES, Hero.class).getResultList().size());
        } finally {
            em.getTransaction().commit();
        }
    }

    /**
     * Получение пользователя по логину из БД
     *
     * @param login логин
     * @return Пользователь или null если пользователь не найден
     */
    private User findByLogin(String login) {
        try {
            return (User) em.createQuery(
                    "SELECT u FROM User u WHERE u.login = :login").
                    setParameter("login", login).getSingleResult();
        } catch (NoResultException ignored) {
            return null;
        }
    }

    private String getPersistenceProperty(String propertyName) {
        return (String) emf.getProperties().get(propertyName);
    }

    @Test
    public void testGetConnectionProperties() {
        String database = getPersistenceProperty("javax.persistence.jdbc.url");
        String dbUser = getPersistenceProperty("javax.persistence.jdbc.user");
        // Невозможно получить пароль в явном виде
        String dbPassword = getPersistenceProperty("javax.persistence.jdbc.password");
        System.out.println("database = " + database);
        System.out.println("dbUser = " + dbUser);
        System.out.println("dbPassword = " + dbPassword);
    }
}