package test.class_interface;

/**
 * Created by kentorvalds on 2017/7/13.
 */
public interface InterfaceD extends InterfaceA {

    default void foo(){
        System.out.println("InterfaceD foo");
    }
}
