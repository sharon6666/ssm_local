package design.single;

/**
 * 文件描述
 *  懒汉单例模式  懒汉式线程不安全，需要加上同步锁，同步锁影响了程序执行效率。
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: design
 * @Description: note
 * @Author:
 * @date: 2019-10-29 16:16
 * @UpdateUser:
 * @UpdateDate: 2019-10-29 16:16
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class Lazier {
    public static Lazier lazier;

    public static Lazier getInstance(){
        if(lazier == null) {
            synchronized (Lazier.class){
                lazier = new Lazier();
            }
        }
        return lazier;
    }

    public static void main(String[] args) {

        Lazier teacher1 = Lazier.getInstance();
        Lazier teacher2 = Lazier.getInstance();
        System.out.println(teacher1==teacher2);

    }
}
