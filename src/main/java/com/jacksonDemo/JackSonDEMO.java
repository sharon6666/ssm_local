package com.jacksonDemo;

import com.ssm.model.User;
import org.apache.commons.collections.map.HashedMap;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.jacksonDemo
 * @Description: note
 * @Author:
 * @CreateDate: 2019-8-3 12:46
 * @UpdateUser:
 * @UpdateDate: 2019-8-3 12:46
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class JackSonDEMO {
    private static ObjectMapper objectMapper = new ObjectMapper();
    public static void main(String[] args) throws Exception{
        PostVoiceInfo postVoiceInfo = new PostVoiceInfo();
        String voiceJson = objectMapper.writeValueAsString(postVoiceInfo);//对象转json
        System.out.println(voiceJson);

        PostVoiceInfo postVoiceInfo1 = objectMapper.readValue(voiceJson, PostVoiceInfo.class);
        System.out.println(postVoiceInfo1.toString());//json转对象

        Map<String, String> map = new HashMap();
        map.put("stateId", "12");
        map.put("onlineCompose", "1");
        map.put("md5", "vcdsfesdczdgrtesdws");
        String mapJson = objectMapper.writeValueAsString(map);//map转json
        System.out.println(mapJson);

        Map<String, String> stringMap = objectMapper.readValue(mapJson, HashedMap.class);
        System.out.println(stringMap);//json转map

        Map<String, PostVoiceInfo> mapPost = new HashMap<>();
        mapPost.put("post1", new PostVoiceInfo("name", '1', "dwefwrfdwer"));
        String mapJson1 = objectMapper.writeValueAsString(mapPost);
        System.out.println(mapJson1);//map对象转json

        JavaType jvt = objectMapper.getTypeFactory().constructParametricType(HashMap.class,String.class,PostVoiceInfo.class);
        Map<String,User> urMap = objectMapper.readValue(mapJson1, jvt);
        System.out.println(urMap);//json转map对象


        //list<String>转json
        ArrayList<String> list = new ArrayList<String>();
        list.add("jack");
        list.add("tom");
        String ljson = objectMapper.writeValueAsString(list);
        System.out.println(ljson);
        //json转list<String>
        ArrayList<String> sList = objectMapper.readValue(ljson, ArrayList.class);
        System.out.println(sList);

        //list<User>转json
        List<User> ulist = new ArrayList<User>();
        User user = new User();
        user.setId(213);
        user.setName("ffssfd");
        user.setPassword("fwdsfg");
        ulist.add(user);
        String ujson = objectMapper.writeValueAsString(ulist);
        System.out.println(ujson);
        //json转list<User>
        JavaType jt = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, User.class);
        List<User> urlist = objectMapper.readValue(ujson, jt);
        System.out.println(urlist);


    }
}
