package com.ssm.service.impl;

import com.ssm.dao.UserDao;
import com.ssm.model.User;
import com.ssm.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hspcadmin on 2018/10/26.
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userMapper;

    public User getUser(int id) {
        User a = userMapper.selectByPrimaryKey(id);
        if (a != null) {
            return a;
        }
        return null;
    }

    public int insertAdmin(User user) {
        return userMapper.insert(user);
    }

    public List<User> selectAll(Integer pageNo, Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        map.put("currIndex", (pageNo -1) * pageSize);
        map.put("pageSize", pageNo * pageSize);
        return userMapper.getAllUser(map);
    }
}
