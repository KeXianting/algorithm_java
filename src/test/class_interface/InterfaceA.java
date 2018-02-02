package test.class_interface;

/**
 * Created by kentorvalds on 2017/7/13.
 */
public interface InterfaceA {

    int a = 1;

    //在 java 8 之前，接口与其实现类之间的 耦合度 太高了（tightly coupled），
    //当需要为一个接口添加方法时，所有的实现类都必须随之修改。默认方法解决了这个问题，
    //它可以为接口添加新的方法，而不会破坏已有的接口的实现。这在 lambda 表达式作为 java 8 语言的重要特性而出现之际，
    //为升级旧接口且保持向后兼容（backward compatibility）提供了途径。
    default void foo() {
        System.out.println("InterfaceA foo");
    }


    //接口静态方法
    static void fullA(){
        System.out.println("static fullA");
    }

}
