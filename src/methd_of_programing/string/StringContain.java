package methd_of_programing.string;

import java.util.Arrays;

/**
 * Created by kentorvalds on 2017/7/17.
 */

//字符串包含: 字符串a: 'ABCD'; 字符串b: 'BAD'; 则字符串a包含字符串b(因为a里面还有字符BAD)
public class StringContain {

    public static void main(String[] arg){
        char[] a = {'A','D','C','B'};
        char[] b = {'B','A','D','F'};

        //方法1
        System.out.println("轮训法是否包含: " + stringContain1(a, b));




        //方法2:
        System.out.println("排序后轮询: " + stringContain2(a, b));


        //方法3:
        System.out.println("素数相乘: " + stringContain3(a, b));



        //方法4:
        System.out.println("移位运算: " + stringContain4(a, b));
    }

    //方法1: 蛮力轮询
    public static boolean stringContain1(char[] a, char[] b){
        for (int i = 0; i < b.length; i ++){
            int j;
            for (j = 0; (j < a.length) && (a[j] != b[i]); j ++); //;表示for循环体为空, 不做操作
            if (j >= a.length){
                return false;
            }
        }
        return true;
    }


    //排序后轮询
    public static boolean stringContain2(char[] a, char[] b){
        Arrays.sort(a);
        Arrays.sort(b);
        for (int pa = 0, pb = 0; pb < b.length;)
        {
            while ((pa < a.length) && (a[pa] < b[pb]))
            {
                ++pa;
            }
            if ((pa >= a.length) || (a[pa] > b[pb]))
            {
                return false;
            }
            //a[pa] == b[pb]
            ++pb;
        }
        return true;
    }


    //素数相乘
    public static boolean stringContain3(char[] a, char[] b){
        int[] p= {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59,61, 67, 71, 73, 79, 83, 89, 97, 101};
        int f = 1;
        for (int i = 0; i < a.length; ++i)
        {
            int x = p[a[i] - 'A'];
            if (f % x != 0)
            {
                f *= x;
            }
        }
        for (int i = 0; i < b.length; ++i)
        {
            int x = p[b[i] - 'A'];
            if (f % x != 0)
            {
                return false;
            }
        }
        return true;

    }


    //位运算
    public static boolean stringContain4(char[] a, char[] b){
        int hash = 0;
        for (int i = 0; i < a.length; i ++){
            hash |= (1 << (a[i] - 'A'));
        }
        for (int i = 0; i < b.length; i ++){
            if ((hash & (1 << (b[i] - 'A'))) == 0){
                return false;
            }
        }

        return true;
    }




}
