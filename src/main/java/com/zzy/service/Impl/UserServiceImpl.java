package com.zzy.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzy.dao.UserMapper;
import com.zzy.pojo.User;
import com.zzy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @CachePut(value="restful",key = "#root.targetClass + #user.id")
    @Override
    public User add(User user) {
        userMapper.insert(user);
        return user;
    }

    @CacheEvict(value="restful",key = "#root.targetClass + #user.id")
    @Override
    public User update(User user) {
        userMapper.updateById(user);
        return user;
    }

    @CacheEvict(value="restful",key = "#root.targetClass + #id")
    @Override
    public boolean delete(String id) {
        userMapper.deleteById(id);
        return true;
    }

    @Cacheable(value = "restful2", key = "#root.targetClass", unless = "#result eq null")
    @Override
    public List<User> selectAll() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        return userMapper.selectList(queryWrapper);
    }

    @Cacheable(value = "restful1", key = "#root.targetClass + #id", unless = "#result eq null")
    @Override
    public Object selectById(String id) {
        return userMapper.selectById(id);
    }
}
