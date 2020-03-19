package com.zzy.service;

import com.zzy.pojo.User;


import java.util.List;

public interface UserService {

    User add(User user);

    User update(User user);

    boolean delete(String id);

    List<User> selectAll();

    Object selectById(String id);
}
