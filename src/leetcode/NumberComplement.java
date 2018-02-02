package leetcode;

/**
 * Created by kentorvalds on 2017/6/24.
 */
/*
Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

Note:
The given integer is guaranteed to fit within the range of a 32-bit signed integer.
You could assume no leading zero bit in the integer’s binary representation.
Example 1:
Input: 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
Example 2:
Input: 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 */
public class NumberComplement {

    public static void main(String[] arg){
        //最高位后面全部为0: 6=110 -> 100 = 4
        int temp = Integer.highestOneBit(6);
        System.out.println("+++++ " + temp);
        //负数最高位为1, 后面全部为0后是一个定值
        System.out.println("负数为:" + Integer.highestOneBit(-9)); //-2147483648


        //|: 按位取或
        System.out.println(3|5);
        int ii = 5;
        ii |= 6;
        System.out.println("|操作" + ii);
        //&:按位取且
        System.out.println("&操作" + (3&5));



        /*
        正数取~：-（a+1）
        负数取~：(a+1)
        */

        /*
        是对存于计算机的补码进行操作的。
        6是正数，补码与其源码相同。为：0(符号位)...0000110（因为默认是int型所以32位）
        对其~操作后为：1（符号位）...1111001
        显霸气编程源码：取反加1（除去符号位）
        1) 1（符号位）...0000110
        2) 1（符号位）...0000111
        所以最后是-7

        */
                System.out.println(~6);//-7
        /*
        是对存于计算机的补码进行操作的。
        -6是负数。1（符号位）...0000110
        显霸气编程源码：取反加1（除去符号位）
        1) 1（符号位）...1111001
        2) 1（符号位）...1111010
        对其~操作后为：0（符号位）...0000101
        正数的补码与源码相同故为：0（符号位）...0000101

        所以最后是5
        */
        //~:正数取~：-（a+1）
        //~:负数取~：(a+1)
        System.out.println("~操作" + (~9));


        int num = getComplement(1);
        System.out.println(num);
    }


    public static int getComplement(int num){
        //Integer.highestOneBit(num): 最高位为1的后面全部为0: 6=110 -> 100 = 4
        //然后左移一位减1
        //~num: 如果num为正数, 则~num=-(num+1), 如果num为负数, 则num=(num+1)
       return  ~num & ((Integer.highestOneBit(num) << 1) - 1);
    }
}
