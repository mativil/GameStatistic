package dao;

import entity.HeroEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by MI on 25.01.2017.
 */
//@Repository
public class HeroDaoImpl implements HeroDao{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void addHero(HeroEntity h) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(h);
        tx.commit();
        session.close();
    }

    @Override
    public void updateHero(HeroEntity h) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(h);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<HeroEntity> list() {
        Session session = this.sessionFactory.getCurrentSession();
        List<HeroEntity> heroList = session.createQuery("from HeroEntity").list();
        return heroList;
    }

    @Override
    public HeroEntity getHeroById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        HeroEntity h = (HeroEntity)session.load(HeroEntity.class, new Integer(id));
        return h;
    }

    @Override
    public void removeHero(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        HeroEntity h = (HeroEntity)session.load(HeroEntity.class, new Integer(id));
        if(h != null)
            session.delete(h);
    }
}
