package org.mativil.service;

import org.mativil.dao.UserDao;
import org.mativil.dto.UserRegistrationDTO;
import org.mativil.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Ivan on 05.02.2017.
 */
@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserDao dao;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public void registerUser(UserRegistrationDTO dto) {
        dao.register(convert(dto));
    }

    private UserEntity convert(UserRegistrationDTO dto) {
        UserEntity user = new UserEntity();
        user.setLogin(dto.getLogin());
        user.setPassword(encoder.encode(dto.getPassword()));

        return user;
    }
}
