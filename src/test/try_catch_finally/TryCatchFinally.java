package test.try_catch_finally;

/**
 * Created by kentorvalds on 2018/3/18.
 */
public class TryCatchFinally {

    class Test{
        int a = 20;
        int b = 10;
        public void setA(int aa){
            this.a=aa;
        }
        public void setB(int bb){
            this.b=bb;
        }
        public int getA(){
            return this.a;
        }
        public int getB(){
            return this.b;
        }
    }

    public static void main(String[] args){
        TryCatchFinally tryCatchFinally = new TryCatchFinally();
        Test t = tryCatchFinally.testFinally();
        System.out.println("引用类型的finally测试: " + t.getA() + " ; " + t.getB());

        System.out.println("========================");
        int sum = tryCatchFinally.testFinally1();
        System.out.println("基本数据类型的finally测试: " + sum);
    }
    public Test testFinally(){
        Test test = new Test();

        try{
            System.out.println("try");
            return test;
        }catch (Exception e){
            System.out.println("catch");
        }finally {
            System.out.println("finally");
            test.setA(100);
            test.setB(200);
        }
        return test;
    }
    public int testFinally1(){
        int s1 = 2;
        int s2 = 3;
        try{
            System.out.println("try");
            return s1+s2;
        }catch (Exception e){
            System.out.println("catch");
        }finally {
            System.out.println("finally");
            s1 = 100;
            s2 = 100;
        }
        return s1+s2;
    }
}
