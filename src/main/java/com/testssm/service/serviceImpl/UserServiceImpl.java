package com.testssm.service.serviceImpl;

import com.testssm.dao.IUserDao;
import com.testssm.entity.User;
import com.testssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public void insert(User user) {
       userDao.insert(user);
    }
}
