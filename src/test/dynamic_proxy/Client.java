package test.dynamic_proxy;

import test.static_proxy.Subject;

/**
 * Created by kentorvalds on 2017/8/3.
 */
public class Client {

    /*Proxy类的静态方法
    // 方法 1: 该方法用于获取指定代理对象所关联的调用处理器
    static InvocationHandler getInvocationHandler(Object proxy)

    // 方法 2：该方法用于获取关联于指定类装载器和一组接口的动态代理类的类对象
    static Class getProxyClass(ClassLoader loader, Class[] interfaces)

    // 方法 3：该方法用于判断指定类对象是否是一个动态代理类
    static boolean isProxyClass(Class cl)

    // 方法 4：该方法用于为指定类装载器、一组接口及调用处理器生成动态代理类实例
    static Object newProxyInstance(ClassLoader loader, Class[] interfaces, InvocationHandler h)
     */


    /*InvocationHandler的核心方法
     该方法负责集中处理动态代理类上的所有方法调用。第一个参数既是代理类实例，第二个参数是被调用的方法对象
     第三个方法是调用参数。调用处理器根据这三个参数进行预处理或分派到委托类实例上反射执行
     Object invoke(Object proxy, Method method, Object[] args)
     */
    public static void main(String[] args){

       /* 动态代理具体步骤是：
        a. 实现InvocationHandler接口创建自己的调用处理器
        b. 给Proxy类提供ClassLoader和代理接口类型数组创建动态代理类
        c. 以调用处理器类型为参数，利用反射机制得到动态代理类的构造函数
        d. 以调用处理器对象为参数，利用动态代理类的构造函数创建动态代理类对象
        */


        /*
         InvocationHandlerImpl 实现了 InvocationHandler 接口，并能实现方法调用从代理类到委托类的分派转发
         其内部通常包含指向委托类实例的引用，用于真正执行分派转发过来的方法调用
        InvocationHandler handler = new InvocationHandlerImpl(..);

         通过 Proxy 为包括 Interface 接口在内的一组接口动态创建代理类的类对象
        Class clazz = Proxy.getProxyClass(classLoader, new Class[] { Interface.class, ... });

         通过反射从生成的类对象获得构造函数对象
        Constructor constructor = clazz.getConstructor(new Class[] { InvocationHandler.class });

         通过构造函数对象创建动态代理类实例
        Interface Proxy = (Interface)constructor.newInstance(new Object[] { handler });
         */


        Subject proxy = DynProxyFactory.getInstance();
        proxy.dealTask("DBQueryTask");

    }
}
