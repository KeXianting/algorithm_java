package test.abstract_interface;

/**
 * Created by kentorvalds on 2017/7/6.
 */
public class CTest extends BTestAbstract {


    @Override
    public void b() {

    }

    @Override
    public void c() {

    }
    //父类抽象类没有实现的方法子类要实现, 父类实现过的子类也可以重写
    @Override
    public int d() {
        return super.d();
    }

    //必须实现父类的抽象方法
    @Override
    public void f() {

    }
}
