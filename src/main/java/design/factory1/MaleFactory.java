package design.factory1;

/**
 * @author wangrx23694
 * @date
 * @description
 */
public class MaleFactory implements Provider {
    @Override
    public PersonAction produce() {
        return new Male();
    }

    // 工厂方法
    public static void main(String[] args) {
        MaleFactory factory = new MaleFactory();
        PersonAction action = factory.produce();
        action.eat();
    }
}
