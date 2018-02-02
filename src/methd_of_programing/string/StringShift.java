package methd_of_programing.string;

/**
 * Created by kentorvalds on 2017/7/16.
 */
//字符串旋转: 字符串'abcdef', 的前3个字符'a','b','c'旋转后变为:'defabc'
public class StringShift {

    public static void main(String[] arg){

        char[] s = {'a','b','c','d','e','f'};

        //暴力法:
        System.out.println("暴力法反转后为: ");
        shift1(s, 3);
        for (int i = 0; i < s.length; i ++){
            System.out.print(s[i] + " , ");
        }
        System.out.println();

        //三步翻转
        System.out.println("三步翻转后为: ");
        shift2(s, 3);
        for (int i = 0; i < s.length; i ++){
            System.out.print(s[i] + " , ");
        }

    }


    //方法1: 暴力拉伸
    public static void shift1(char[] s, int m){//s为要旋转的字符串, m为对前m位进行旋转
        while (m > 0){
            m --;
            char t = s[0]; //记录每次开头的字符
            for (int i = 1; i < s.length; i ++){
                s[i-1] = s[i]; //s的每一个元素前移一位
            }
            s[s.length - 1] = t; //把第一个元素放到最后一位
        }

    }



    //方法2: 三步反转
    public static void shift2(char[] s, int m){
        m %= s.length;
        //翻转'abc'
        reverseString(s, 0, m -1);
        //翻转def
        reverseString(s, m, s.length -1);
        //翻转整个字符串
        reverseString(s, 0, s.length -1);


    }
    public static void reverseString(char[] s, int from, int end){
        while (from < end){
            char t= s[from]; //首元素
            s[from ++] = s[end]; //首元素等于最后一个元素
            s[end --] = t;//最后一个元素等于首元素

        }
    }

}
