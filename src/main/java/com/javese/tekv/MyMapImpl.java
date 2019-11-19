package com.javese.tekv;

import com.javese.origin.Inter;
import com.practiceThread.thread1.P;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.javese.tekv
 * @Description: note
 * @Author:
 * @date: 2019-11-12 17:06
 * @UpdateUser:
 * @UpdateDate: 2019-11-12 17:06
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class MyMapImpl<K,V> implements MyMap<K,V> {

    private K key;
    private V value;

    public MyMapImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

}
