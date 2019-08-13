package com.ssm.service;

import com.ssm.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hspcadmin on 2018/9/26.
 */
@Service
public interface UserService {

    public User getUser(int id);

    public int insertAdmin(User user);

    public List<User> selectAll(Integer pageNo, Integer pageSize);

}
