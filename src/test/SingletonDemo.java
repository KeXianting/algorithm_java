package test;

import java.io.Serializable;

/**
 * Created by kentorvalds on 2018/5/1.
 */
public class SingletonDemo implements Serializable {
    private SingletonDemo(){}

    private static class SingletonHolder{
        private static final SingletonDemo INSTANCE = new SingletonDemo();
    }

    public static SingletonDemo getInstance(){
        return SingletonHolder.INSTANCE;
    }

    private Object readResolve(){
        return SingletonHolder.INSTANCE;
    }
}
