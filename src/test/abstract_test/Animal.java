package test.abstract_test;

/**
 * Created by kentorvalds on 2017/6/22.
 */
public abstract class Animal {

    private String name;
    public Animal(String val){
        this.name = val;
    }
    public abstract void cry();
    public abstract void run();
}
