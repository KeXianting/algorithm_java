package test.class_interface;

/**
 * Created by kentorvalds on 2017/7/13.
 */
public interface InterfaceB extends InterfaceA {
    @Override
    void foo();

    default void bar(){
        System.out.println("InterfaceB bar");
    }

}
