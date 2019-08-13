package com.springbase;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.springframework.jdbc.support.nativejdbc.OracleJdbc4NativeJdbcExtractor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.springbase
 * @Description: note
 * @Author:
 * @CreateDate: 2019-8-7 13:45
 * @UpdateUser:
 * @UpdateDate: 2019-8-7 13:45
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class ClassPathXmlApplicationContext implements BeanFactory {

    private Map<String, Object> map = new HashMap<>();
    public ClassPathXmlApplicationContext(String configLocation) throws Exception{
        SAXBuilder sb = new SAXBuilder();//使用jdom的SAXBuilder读取xml文件
        //加载xml文件进内存
        Document doc = sb.build(this.getClass().getClassLoader().getResourceAsStream(configLocation));

        //获取根节点 beans
        Element root = doc.getRootElement();
        //获取根节点的孩子节点
        List<Object> childList = root.getChildren("bean");

        for(Object obj : childList){
            Element child = (Element) obj;
            //获取id属性
            String id = child.getAttributeValue("id");

            //获取class
            String clazz = child.getAttributeValue("class");

            Object finalObj = Class.forName(clazz).newInstance();
            map.put(id, finalObj);
        }
    }

    @Override
    public Object getBean(String name){
        return map.get(name);
    }
}
