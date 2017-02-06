package org.mativil.dao;

import org.mativil.entity.UserEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Ivan on 05.02.2017.
 */
@Component
public class UserDaoImpl implements UserDao{
    @PersistenceContext
    protected EntityManager em;

    @Override
    public void register(UserEntity convert) {
        em.persist(convert);
    }
}
