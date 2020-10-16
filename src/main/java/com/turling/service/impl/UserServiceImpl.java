package com.turling.service.impl;

import com.turling.dao.UserMapper;
import com.turling.entity.User;
import com.turling.entity.UserExample;
import com.turling.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(user.getUsername()).andPasswordEqualTo(user.getPassword());
        List<User> users = userMapper.selectByExample(userExample);
        if(users!=null&&users.size()>0){
            return users.get(0);
        }else {
            return null;
        }
    }
}
