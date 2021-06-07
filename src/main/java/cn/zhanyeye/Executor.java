package cn.zhanyeye;


import cn.zhanyeye.common.Solution;

import java.lang.reflect.InvocationTargetException;


/**
 * Hello world!
 *
 */
public class Executor {
    public static void main(String[] args) {
        System.out.println("hello, this is my playground");
    }

    public static void execute(Class<? extends Solution> klass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Solution target = klass.getDeclaredConstructor().newInstance();
        target.run();
    }
}
