package com.javese.tekv;

import com.javese.Book;
import com.ssm.model.User;

import java.io.ObjectOutputStream;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.javese.tekv
 * @Description: note
 * @Author:
 * @date: 2019-11-12 16:47
 * @UpdateUser:
 * @UpdateDate: 2019-11-12 16:47
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class Box<T> {
    private T Object;

    public T getObject() {
        return Object;
    }

    public void setObject(T object) {
        Object = object;
    }

    private void trans(){
        //不带泛型写法：
        Box box = new Box();
        box.setObject(new User());
        User u = (User)box.getObject();

        //泛型写法：
        Box<User> bb = new Box<>();
        bb.setObject(new User());
        User uu = bb.getObject();
        // 省去了强制转换，可以在编译时候检查类型安全，可以用在类，方法，接口上
    }


    public static void main(String[] args){
        MyMap<String, String> mm = new MyMapImpl<String, String>("my", "key");
        MyMap<String, Integer> mmm = new MyMapImpl<String, Integer>("key",111);
        MyMap<Integer, Integer>  mmmm = new MyMapImpl<Integer, Integer>(111, 222);
        Test tt = new Test();
        tt.eee(mm, mmm, mmmm);
    }
}

class Test<T1, T2, T3>{
    public void eee(T1 t1, T2 t2, T3 t3){
        System.out.println(t1.getClass());
        System.out.println(t2.getClass());
        System.out.println(t3.getClass());
    }
}