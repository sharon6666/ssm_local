package design.strategy;

/**
 * @author wangrx23694
 * @date
 * @description
 */
public class Add implements Function {
    @Override
    public int function(int a, int b) {
        return a + b;
    }
}
