package com.springmvc.service;

import com.springmvc.dao.UserMapper;
import com.springmvc.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hspcadmin on 2018/9/26.
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public User getUser(int id){
        User a = userMapper.selectByPrimaryKey(id);
        if(a!=null){
            return a;
        }
        return null;
    }

    public int insertAdmin(User user){
        return userMapper.insert(user);
    }

    public List<User> selectAll(int pageNo, int pageSize){
        return userMapper.selectAll();
    }

    public static void main(String[] args){
        boolean flag = 10%2 == 1 && 10 / 3 == 0 && 1 / 0 == 0 ;
        System.out.println(flag ? "mldn" : "yootk") ;

        int num = 50 ;
        num = num ++ * 2 ;
        System.out.println(num) ;

        int i = 1 ;
        int j = i++ ;
        if((i==(++j))&&((i++)==j))     {
            i += j ;
        }
        System.out.println("i = "+i);

        int sum = 0 ;
        for (int x = 0 ; x < 10 ; x ++) {
            sum += x ;
            if (x % 3 == 0) {
                break ;
            }
        }
        System.out.println(sum) ;
    }
}
