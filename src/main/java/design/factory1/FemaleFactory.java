package design.factory1;

/**
 * @author wangrx23694
 * @date
 * @description
 */
public class FemaleFactory implements Provider {
    @Override
    public PersonAction produce() {
        return new Female();
    }
}
