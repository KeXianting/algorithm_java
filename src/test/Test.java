package test;

import java.lang.reflect.Constructor;

/**
 * Created by kentorvalds on 2018/11/22.
 */
public class Test {
    public static void main(String[] args) throws  Exception{
        Class clazz = SimulatorState.class;
        Constructor cons = clazz.getDeclaredConstructor(int.class);

        //set accessble to access private constructor
        cons.setAccessible(true);
        SimulatorState s = (SimulatorState) cons.newInstance(4);
        System.out.println(s.isFlying());


    }
}
