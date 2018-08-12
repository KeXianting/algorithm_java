package leetcode;

import java.util.Stack;

/**
 * Created by kentorvalds on 2018/8/11.
 */
public class ValidParentheses {
    public static void main(String[] arg){
        String s1 = "()[]{}";
        String s2= "([)]";
        System.out.println(isValid(s1));
        System.out.println(isValid(s2));
    }

    public static boolean isValid(String s) {
        String left = "({[";
        String right = ")}]";
        Stack st = new Stack();
        if("".equals(s)){
            return true;
        }
        if(s.length() == 1){
            return false;
        }
        for(int i = 0; i < s.length(); i++){
            if(left.indexOf(s.charAt(i)) != -1){
                st.push(s.charAt(i));
            }
            if(!st.empty()){
                if(right.indexOf(s.charAt(i)) != -1){
                    if((Character)st.peek() == left.charAt(right.indexOf(s.charAt(i)))){
                        st.pop();
                    }else {
                        return false;
                    }
                }
            }else{
                st.push(s.charAt(i));
            }

        }
        if (st.empty()){
            return true;
        }
        return false;
    }
}
