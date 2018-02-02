package test.abstract_test;

/**
 * Created by kentorvalds on 2017/6/22.
 */
public class Dog extends Animal implements Sex,Heat{
    public Dog(String val) {

        super(val);
    }


    //接口和抽象类作用类似, 但是通常用抽象类体现自身的行为, 而接口体现外在行为, 解决多继承问题

    //来自抽象类
    @Override
    public void cry() {
        System.out.println("dog cry....");
    }
    //来自抽象类
    @Override
    public void run() {
        System.out.println("dog run....");
    }


    //来自接口Sex
    @Override
    public boolean male() {
        return false;
    }
    //来自接口Heat
    @Override
    public void bit() {

    }
}
