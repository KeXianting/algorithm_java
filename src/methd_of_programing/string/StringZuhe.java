package methd_of_programing.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by kentorvalds on 2018/4/7.
 */
public class StringZuhe {
    public static void main(String[] args) {
        String[] a = new String[] { "a", "b", "c", "d" };

        //method1(a);
        char[] aa = {'a','b','c','d'};
        combiantion(aa);

    }

    public static void method1(String[] a){
        List<String> list = Arrays.asList(a);
        List<List<Object>> aa = str(list);
        for(List<Object> ss:aa){
            for(Object s:ss){
                System.out.print(s+",");
            }
            System.out.println();
        }
    }
    public static List<List<Object>> str(List<String> list) {
        List<List<Object>> result = new ArrayList<List<Object>>();
        long n = (long)Math.pow(2,list.size());
        List<Object> combine;
        for (long l=0L; l<n; l++) {
            combine = new ArrayList<Object>();
            for (int i=0; i<list.size(); i++) {
                if ((l>>>i&1) == 1)
                    combine.add(list.get(i));
            }
            result.add(combine);
        }
        return result;
    }

    public static void combiantion(char chs[]){
        if(chs.length == 0) return ;

        Stack<Character> stack = new Stack<Character>();
        for(int i = 1; i <= chs.length; i++){
            combine(chs, 0, i, stack);
        }
    }
    //从字符数组中第begin个字符开始挑选number个字符加入list中
    public static void combine(char []chs, int begin, int number, Stack<Character> stack){
        if(number == 0){
            System.out.println(stack.toString());
            return ;
        }
        if(begin == chs.length){
            return;
        }
        stack.push(chs[begin]);
        combine(chs, begin + 1, number - 1, stack);
        stack.pop();
        combine(chs, begin + 1, number, stack);
    }
}
