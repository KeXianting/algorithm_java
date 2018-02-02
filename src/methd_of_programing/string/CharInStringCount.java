package methd_of_programing.string;

import java.util.Arrays;

/**
 * Created by kentorvalds on 2017/9/15.
 */

/*
给定一个字符串，请写出一个函数，查找出每个字符的个数，要求区分大小写，且时间复杂度是O(n)。
 */
public class CharInStringCount {
    public static void main(String[] args){

        String str = "abccddakfiehfdljfdfddf**&##000122";
        charInStringCountMethod1(str);



    }
    public static int[] charInStringCountMethod1(String str){
        int[] a = new int[256];
        Arrays.fill(a, 0);
        int i = 0;
        while (i < str.length()){
            a[str.charAt(i)] ++ ;
            i ++;
        }

        for (int aa:a){
            if (aa != 0){
                System.out.print("每个字符的次数为: " + aa);
            }

        }
        return a;
    }

}
