package com.xu81.microview.api.user.service;

import com.xu81.microview.api.user.entity.User;

import java.util.List;

public interface UserService {

    List<User> listAll();

    User getById(int id);

    int add(User user);
}
