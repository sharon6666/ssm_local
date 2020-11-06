package design.abstractFactory;

import org.apache.ibatis.scripting.LanguageDriver;

/**
 * @author wangrx23694
 * @date
 * @description
 */
public class Cat implements LandAnimal {

    @Override
    public void crawl() {
        System.out.println(" cat is running");
    }
}
