package test.abstract_interface;

import java.io.Serializable;

/**
 * Created by kentorvalds on 2017/7/6.
 */
public abstract class BTestAbstract implements ATest {


    @Override
    public void a() {

    }


    public int d(){
        return 1;
    }

    abstract public void f();
}
