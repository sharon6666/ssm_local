package com.cipher;


import net.sf.ehcache.transaction.xa.EhcacheXAException;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.swing.*;
import java.util.Base64;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.cipher
 * @Description: note
 * @Author:
 * @date: 2019-11-1 17:06
 * @UpdateUser:
 * @UpdateDate: 2019-11-1 17:06
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class Base64Test {
    public static void main(String[] args) throws Exception {
        base("gr合同变更v房地产润方");

        method("hyrf会通过v发还有若干");
    }

    //method1
    public static void base(String str){
        byte[] bytes = str.getBytes();
        String encode = Base64.getEncoder().encodeToString(bytes);
        System.out.println( "加密后:" + encode);


        byte[] decode = Base64.getDecoder().decode(encode);
        String cccode = new String(decode);
        System.out.println("解密后:" + cccode);

    }

    //method2
    public static void method(String str) throws Exception{
        byte[] code = str.getBytes();
        String encode = new BASE64Encoder().encode(code);
        System.out.println( "加密:" + encode);

        byte[] decode = new BASE64Decoder().decodeBuffer(encode);
        String ss = new String(decode);
        System.out.println( "解密:" +ss);
    }

    public static void MD5method(){
        
    }
}
