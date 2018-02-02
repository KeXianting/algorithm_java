package test.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by kentorvalds on 2017/10/12.
 */
/*
 (1)以@interface关键字定义
（2）注解包含成员，成员以无参数的方法的形式被声明。其方法名和返回值定义了该成员的名字和类型。
（3）成员赋值是通过@Annotation(name=value)的形式。
（4）注解需要标明注解的生命周期，注解的修饰目标等信息，这些信息是通过元注解实现。

注解目前非常的流行，很多主流框架都支持注解，而且自己编写代码的时候也会尽量的去用注解，一时方便，而是代码更加简洁。

     注解的语法比较简单，除了@符号的使用之外，它基本与Java固有语法一致。Java SE5内置了三种标准注解：

     @Override，表示当前的方法定义将覆盖超类中的方法。

     @Deprecated，使用了注解为它的元素编译器将发出警告，因为注解@Deprecated是不赞成使用的代码，被弃用的代码。

     @SuppressWarnings，关闭不当编译器警告信息。

     上面这三个注解多少我们都会在写代码的时候遇到。Java还提供了4中注解，专门负责新注解的创建。



@Target

表示该注解可以用于什么地方，可能的ElementType参数有：

CONSTRUCTOR：构造器的声明

FIELD：域声明（包括enum实例）

LOCAL_VARIABLE：局部变量声明

METHOD：方法声明

PACKAGE：包声明

PARAMETER：参数声明

TYPE：类、接口（包括注解类型）或enum声明

@Retention

表示需要在什么级别保存该注解信息。可选的RetentionPolicy参数包括：

SOURCE：注解将被编译器丢弃

CLASS：注解在class文件中可用，但会被VM丢弃

RUNTIME：VM将在运行期间保留注解，因此可以通过反射机制读取注解的信息。

@Document

将注解包含在Javadoc中

@Inherited

允许子类继承父类中的注解


 */
public class ParseAnnotation {

    /**
     * 简单打印出UserAnnotation 类中所使用到的类注解
     * 该方法只打印了 Type 类型的注解
     * @throws ClassNotFoundException
     */
    public static void parseTypeAnnotation() throws ClassNotFoundException {
        Class clazz = Class.forName("test.annotation.UserAnnotation");

        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            TestA testA = (TestA)annotation;
            System.out.println("id= \""+testA.id()+"\"; name= \""+testA.name()+"\"; gid = "+testA.gid());
        }
    }

    /**
     * 简单打印出UserAnnotation 类中所使用到的方法注解
     * 该方法只打印了 Method 类型的注解
     * @throws ClassNotFoundException
     */
    public static void parseMethodAnnotation(){
        Method[] methods = UserAnnotation.class.getDeclaredMethods();
        for (Method method : methods) {
            /*
             * 判断方法中是否有指定注解类型的注解
             */
            boolean hasAnnotation = method.isAnnotationPresent(TestA.class);
            if (hasAnnotation) {
                /*
                 * 根据注解类型返回方法的指定类型注解
                 */
                TestA annotation = method.getAnnotation(TestA.class);
                System.out.println("method = " + method.getName()
                        + " ; id = " + annotation.id() + " ; description = "
                        + annotation.name() + "; gid= "+annotation.gid());
            }
        }
    }

    /**
     * 简单打印出UserAnnotation 类中所使用到的方法注解
     * 该方法只打印了 Method 类型的注解
     * @throws ClassNotFoundException
     */
    public static void parseConstructAnnotation(){
        Constructor[] constructors = UserAnnotation.class.getConstructors();
        for (Constructor constructor : constructors) {
        	/*
             * 判断构造方法中是否有指定注解类型的注解
             */
            boolean hasAnnotation = constructor.isAnnotationPresent(TestA.class);
            if (hasAnnotation) {
                /*
                 * 根据注解类型返回方法的指定类型注解
                 */
                TestA annotation =(TestA) constructor.getAnnotation(TestA.class);
                System.out.println("constructor = " + constructor.getName()
                        + " ; id = " + annotation.id() + " ; description = "
                        + annotation.name() + "; gid= "+annotation.gid());
            }
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        parseTypeAnnotation();
       // parseMethodAnnotation();
       // parseConstructAnnotation();
    }
}
