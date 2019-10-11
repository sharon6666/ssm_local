package com.javese.anno;

import java.lang.reflect.Method;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: com.javese.anno
 * @Description: note
 * @Author:
 * @CreateDate: 2019-8-21 13:37
 * @UpdateUser:
 * @UpdateDate: 2019-8-21 13:37
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class MainTest {
//    public static void main(String[] args) throws SecurityException,
//            NoSuchMethodException {
//
//        Class<SubClass> subClassClass = SubClass.class;
//
//        if (subClassClass.isAnnotationPresent(MyAnnotation.class)) {
//            MyAnnotation cla = subClassClass.getAnnotation(MyAnnotation.class);
//            System.out.println("子类继承到父类类上Annotation,其信息如下：" + cla.value());
//        } else {
//            System.out.println("子类没有继承到父类类上Annotation");
//        }
//
//        // 实现抽象方法测试
//        Method method = subClassClass.getMethod("abstractMethod", new Class[]{});
//        if (method.isAnnotationPresent(MyAnnotation.class)) {
//            MyAnnotation ma = method.getAnnotation(MyAnnotation.class);
//            System.out.println("子类实现父类的abstractMethod抽象方法，继承到父类抽象方法中的Annotation,其信息如下：" + ma.value());
//        } else {
//            System.out.println("子类实现父类的abstractMethod抽象方法，没有继承到父类抽象方法中的Annotation");
//        }
//
//        //覆盖测试
//        Method methodOverride = subClassClass.getMethod("doExtends", new Class[]{});
//        if (methodOverride.isAnnotationPresent(MyAnnotation.class)) {
//            MyAnnotation ma = methodOverride
//                    .getAnnotation(MyAnnotation.class);
//            System.out
//                    .println("子类继承父类的doExtends方法，继承到父类doExtends方法中的Annotation,其信息如下：" + ma.value());
//        } else {
//            System.out.println("子类继承父类的doExtends方法，没有继承到父类doExtends方法中的Annotation");
//        }
//
//        //继承测试
//        Method method3 = subClassClass.getMethod("doHandle", new Class[]{});
//        if (method3.isAnnotationPresent(MyAnnotation.class)) {
//            MyAnnotation ma = method3
//                    .getAnnotation(MyAnnotation.class);
//            System.out
//                    .println("子类覆盖父类的doHandle方法，继承到父类doHandle方法中的Annotation,其信息如下：" + ma.value());
//        } else {
//            System.out.println("子类覆盖父类的doHandle方法，没有继承到父类doHandle方法中的Annotation");
//        }
//    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Hello ");
        System.out.println("before change, sb is "+sb.toString());
        change(sb);
        System.out.println("after change, sb is "+sb.toString());
    }
    public static void change(StringBuffer stringBuffer){
        stringBuffer = new StringBuffer("Hi ");
        stringBuffer.append("world !");
    }

}
