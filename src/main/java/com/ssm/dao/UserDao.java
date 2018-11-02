package com.ssm.dao;

import com.ssm.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    List<User> getAllUser();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}