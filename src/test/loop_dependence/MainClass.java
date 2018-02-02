package test.loop_dependence;

/**
 * Created by kentorvalds on 2018/1/13.
 */
public class MainClass {

    public static void main(String[] arg){
        System.out.println("loop dependence: " + new ClassC());
        System.out.println("loop dependence: " + new ClasssA());
        System.out.println("loop dependence: " + new ClassB());
    }
}
