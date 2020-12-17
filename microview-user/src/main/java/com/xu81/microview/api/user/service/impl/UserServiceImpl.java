package com.xu81.microview.api.user.service.impl;

import com.xu81.microview.api.user.entity.User;
import com.xu81.microview.api.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public List<User> listAll() {
        List<User> lists = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User g = new User();
            g.setId(i);
            g.setName("User-" + i);
            lists.add(g);
        }
        return lists;
    }

    @Override
    public User getById(int id) {
        User g = new User();
        g.setId(id);
        g.setName("User-" + id);
        return g;
    }

    @Override
    public int add(User User) {
        return 1;
    }
}
