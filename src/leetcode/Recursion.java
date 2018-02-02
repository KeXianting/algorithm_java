package leetcode;

/**
 * Created by kentorvalds on 2017/6/21.
 */
//递归测试
    //java是没有尾递归优化的，递归方法 是不会使用同一个栈帧，
// 每一次递归调用，都将压入新的栈帧，并且这个栈帧上又new了一个list变量，
// 引用着heap上新的一个大集合。随着栈深度的增 加，
// jvm里维持着一条长长的方法调用轨迹以便你能回来，在方法没有返回之前，这些list变量一直被各自的栈帧引用着，不能被GC
public class Recursion {

    public static void main(String[] arg){
        recursionTest1(1);
    }
    public static void recursionTest1(int n){
        System.out.println("before level location is: * " + n);
        if (n < 5){
            recursionTest1(n + 1);
        }
        System.out.println("after level location is: $ " + n);


//        before level location is: * 1
//        before level location is: * 2
//        before level location is: * 3
//        before level location is: * 4
//        before level location is: * 5
//        after level location is: $ 5
//        after level location is: $ 4
//        after level location is: $ 3
//        after level location is: $ 2
//        after level location is: $ 1

    }
}
