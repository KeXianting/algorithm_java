package test.class_interface;

/**
 * Created by kentorvalds on 2017/7/13.
 */
//InterfaceA和InterfaceC方法之间存在冲突, 需要解决, 用InterfaceA.super.foo()确定是掉用InterfaceA还是InterfaceC的foo()方法
public class ClassB implements InterfaceA, InterfaceC {

    @Override
    public void foo() {
        InterfaceA.super.foo();
    }
}
