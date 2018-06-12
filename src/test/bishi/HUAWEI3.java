package test.bishi;

import java.util.Scanner;

/**
 * Created by kentorvalds on 2018/4/10.
 * 写出一个程序，接受一个十六进制的数值字符串，输出该数值的十进制字符串。（多组同时输入 ）

 */
public class HUAWEI3 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        do {
            String str=sc.next().substring(2);
            System.out.println(Integer.parseInt(str,16));
        }while (sc.hasNext());
        sc.close();

    }
}
