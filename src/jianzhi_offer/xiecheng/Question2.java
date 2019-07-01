package jianzhi_offer.xiecheng;

/**
 * Created by kentorvalds on 2018/9/5.
 */
public class Question2 {

    class A{
        public int a = 1;
        public void fun(){
            System.out.println("A");
        }
    }

    class B extends A{
        public int a = 2;
        public void fun(){
            System.out.println("B");
        }
    }

    public static void main(String[] args){
       Question2 question2 = new Question2();
        question2.test();

    }

    public  void test(){
        A a = new B();
        System.out.println(a.a);
        a.fun();
    }



}
