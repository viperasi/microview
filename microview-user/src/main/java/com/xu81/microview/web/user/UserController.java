package com.xu81.microview.web.user;

import com.xu81.microview.api.user.entity.User;
import com.xu81.microview.api.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * class description :
 * 统一登录 controller
 *
 * @author IceExtinguish
 * @version 0.0.1
 * @since 2020/11/13
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping(value = "/list")
    public List<User> users() {
        return userService.listAll();
    }

    @GetMapping(value = "/get/{id}")
    public User user(@PathVariable int id) {
        return userService.getById(id);
    }

    @PostMapping(value = "/add")
    public User add(@RequestBody User user) {
        int i = userService.add(user);
        if (i > 0) {
            return user;
        }
        return null;
    }
}
