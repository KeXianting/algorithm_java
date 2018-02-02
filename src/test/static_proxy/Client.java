package test.static_proxy;

/**
 * Created by kentorvalds on 2017/8/3.
 */
public class Client {

    public static void main(String[] args){
        Subject proxy = SubjectStaticFactory.getInstance();
        proxy.dealTask("DBQueryTask");
    }
}
