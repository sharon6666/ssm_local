package com.qiangdan;

import org.springframework.web.bind.annotation.RequestMapping;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author wangrx23694
 * @date
 * @description
 */
public class RedisLockTest {
    private long nkuCun = 0;
    private String keyName = "computer_key";
    private int timeout = 30*1000;

    @RequestMapping
    public List<String> getUser(){
        List<String> shopUsers = new ArrayList<>();
        List<String> users = new ArrayList<>();
        IntStream.range(0, 100000).parallel().forEach(b->{
            users.add("用户--" +b);
        });
        nkuCun = 10;

        users.parallelStream().forEach(b->{
            String shopUser = getGood(b);
            if(shopUser != null){
                shopUsers.add(shopUser);
            }
        });
        return shopUsers;
    }

    public String getGood(String user){
        long startTime = System.currentTimeMillis();
        while((startTime + timeout) > System.currentTimeMillis()){
            if(nkuCun <= 0){
                break;
            }
        }
        return null;
    }
}
