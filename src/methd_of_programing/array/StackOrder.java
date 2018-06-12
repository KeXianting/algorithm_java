package methd_of_programing.array;
import java.util.*;

/**
 * Created by kentorvalds on 2018/4/4.
 *
 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class StackOrder {

    public static void main(String[] args){
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,5,3,2,1};
        int[] popA1 = {4,3,5,1,2};
        boolean b = IsPopOrder(pushA, popA1);
        System.out.println(b);
    }
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA==null || popA==null || pushA.length != popA.length)
            return false;

        //辅助栈
        Stack<Integer> stack = new Stack<>();
        boolean flag = false;
        int indexArray=0, indexTest=0;

        //遍历弹栈序列,{4,5,3,2,1}
        while(indexTest < popA.length){
            //遍历弹栈序列
            while(indexArray < pushA.length){
                //peek只查看栈顶元素,不移除,如果辅助栈栈顶中弹出的元素刚好等于弹栈元素,则退出循环
                if(!stack.empty() && stack.peek()==popA[indexTest])
                    break;

                stack.push(pushA[indexArray++]);
            }
            //如果没有等于弹栈的元素,则退出
            if(stack.peek() != popA[indexTest])
                break;
            //pop移除栈顶
            stack.pop();
            indexTest++;
        }
        //所有的元素都经历过一遍
        if(stack.empty() && indexArray-indexTest==0)
            flag = true;

        return flag;
    }
}
