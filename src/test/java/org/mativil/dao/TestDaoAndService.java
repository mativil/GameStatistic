package org.mativil.dao;

import org.mativil.entity.*;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mativil.service.LogServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TestDaoAndService extends Assert {
    // Определяет подключение к БД - какую БД сейчас использовать?
    private static EntityManagerFactory emf;
    private static EntityManager em;

    @BeforeClass
    public static void setUpClass() {
        //emf = Persistence.createEntityManagerFactory("Unit-tests-MySQL");
        emf = Persistence.createEntityManagerFactory("Production-MySQL");
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

        LogServiceImpl logService = new LogServiceImpl();
        LogDaoImpl logDao = new LogDaoImpl();
        logService.setLogDao(logDao);

        //Добавим 4 типа героев
        List<LogEntity> logs = logService.list();

        System.out.println(logs.size());

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