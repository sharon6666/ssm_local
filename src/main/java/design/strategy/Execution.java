package design.strategy;


import java.io.*;
import java.util.Random;

/**
 * @author wangrx23694
 * @date
 * @description
 */
public class Execution {
    private Function function;

    public Execution(Function function) {
        this.function = function;
    }

    public int execute(int a, int b) {
        return function.function(a, b);
    }

    public void onClick() {
        Execution execution = new Execution(new Add());
        System.out.println(execution.execute(1, 2));

        execution = new Execution(new Division());
        System.out.println(execution.execute(1, 2));

        execution = new Execution(new Multiple());
        System.out.println(execution.execute(1, 2));

        execution = new Execution(new Sub());
        System.out.println(execution.execute(1, 2));
    }
}
