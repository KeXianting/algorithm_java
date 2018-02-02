package test.class_interface;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kentorvalds on 2017/7/13.
 *
 *java接口中interface的用法: 接口继承接口; 接口中的default方法; 接口中的static方法
 *
 *
 * 不覆写默认方法，直接从父接口中获取方法的默认实现。
 覆写默认方法，这跟类与类之间的覆写规则相类似。
 覆写默认方法并将它重新声明为抽象方法，这样新接口的子类必须再次覆写并实现这个抽象方法。



 default 关键字只能在接口中使用（以及用在 switch 语句的 default 分支），不能用在抽象类中。
 接口默认方法不能覆写 Object 类的 equals、hashCode 和 toString 方法。
 接口中的静态方法必须是 public 的，public 修饰符可以省略，static 修饰符不能省略。
 即使使用了 java 8 的环境，一些 IDE 仍然可能在一些代码的实时编译提示时出现异常的提示（例如无法发现 java 8 的语法错误），因此不要过度依赖 IDE。
 *
 */


public class InterfaceDefault {

    public static void main(String[] arg){
        //ClassA 类并没有实现 InterfaceA 接口中的 foo 方法，
        //InterfaceA 接口中提供了 foo 方法的默认实现，因此可以直接调用 ClassA 类的 foo 方法。
        new ClassA().foo();


        //接口中新增方法, 实现类中不用实现, 用default
        String[] array = new String[] {
                "hello",
                ", ",
                "world",
        };
        List<String> list = Arrays.asList(array);
        list.forEach(System.out::println); // 这是 jdk 1.8 新增的接口默认方法



        new InterfaceB(){
            @Override
            public void foo() {
                System.out.println("InterfaceB foo");
            }
        }.foo();
        // 或者使用 lambda 表达式
        ((InterfaceB) () -> System.out.println("InterfaceB foo")).foo();

        new InterfaceC(){}.foo();

        System.out.println("ClassB:  ");
        new ClassB().foo();



        //接口静态方法
        InterfaceA.fullA();

    }

}
