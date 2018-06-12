package jianzhi_offer;

import java.util.Stack;

/**
 * Created by kentorvalds on 2018/4/19.
 */
public class MiniElementInStack {

    static Stack<Integer> ele = new Stack();
    static Stack<Integer> min = new Stack();
    public static void main(String[] args){


    }
    public static void push(int data){
        ele.push(data);
        if (min.isEmpty()){
            min.push(data);
        }else {
            if (data < min.peek()){//peek返回栈顶元素,不删除
                min.push(data);
            }
        }
    }
    public static int pop(){
        int topData = ele.peek();
        ele.pop();
        if (topData == min()){
            min.pop();
        }
        return topData;
    }
    public static int min(){
        if (min.isEmpty()){
            return Integer.MAX_VALUE;
        }else {
            return min.peek();
        }
    }
}
