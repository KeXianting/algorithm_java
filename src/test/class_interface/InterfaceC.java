package test.class_interface;

/**
 * Created by kentorvalds on 2017/7/13.
 */
public interface InterfaceC {

    default void foo() {
        System.out.println("InterfaceC foo");
    }

    default void bar(){
        System.out.println("InterfaceC bar");
    }
}
