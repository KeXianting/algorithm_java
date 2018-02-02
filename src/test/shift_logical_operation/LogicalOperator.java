package test.shift_logical_operation;

/**
 * Created by kentorvalds on 2017/9/13.
 */
//&&和&以及||和|的区别
public class LogicalOperator {

    public static void main(String[] args){
       // test1(); //&
       // test2(); //&&
       // test3(); //||
        test4(); //|
    }

    /**
     验证"与" 操作
     说明："与" 操作 要求所有条件都判断一遍
     */
    public static void test1(){
        if(10!=10&10/0==0){
            /*10！=10这个条件返回false
              10/0==0这个地方会抛出异常（java.lang.ArithmeticException: /by zero）
              由于与操作所有条件都需要判断 所以在10/0的时候会出现错误
            */
            System.out.print("条件满足！");
        }
    }


    /**
     验证"短路与 &&" 操作
     说明："短路与 &&" 操作如果第一个条件不满足 那么后面的条件就不用再判断了
     */
    public static void test2(){
        if(10!=10&&10/0==0){
            /*10！=10这个条件返回false
              由于第一个条件就不满足 所以10/0==0这个条件就不必再判断了
            */
            System.out.print("条件满足！");
        }else {
            System.out.println("条件bu满足");
        }
    }

    /**
     验证"短路或 ||" 操作
     说明："短路或 ||"  如果第一个条件为true 则后面的条件则不再判断
     */
    public static void test3(){
        if(10==10||10/0==0){
            /*10==10这个条件返回true
              由于第一个条件满足 所以10/0==0这个条件就不必再判断了
            */
            System.out.print("条件满足！");
        }
    }

    /**
     验证"或 |" 操作
     说明："或 |" 所有条件都要求判断
     */
    public static void test4(){
        if(10==10|10/0==0){
            /*
            虽然10==10 返回true 但是10/0==0这个条件是会抛出异常错误
            所以当判断到第二条件是就会抛出异常
            */
            System.out.print("条件满足！");
        }
    }
}
