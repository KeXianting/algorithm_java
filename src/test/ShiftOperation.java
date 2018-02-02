package test;

/**
 * Created by kentorvalds on 2017/6/7.
 * 移位
 */

public class ShiftOperation {

    public static void main(String[] arg){

        System.out.println("******************正数左移, 在低位补0*******************");
        int a = 3;
        a = a << 2;
        //12
        System.out.println("左移2位=>" + a);//转换为二进制, 然后地位补2个0,再转换为十进制
        //1100
        System.out.println("左移2位后的二进制=>" + Integer.toBinaryString(a)); //转换为二进制


        //正数右移
        System.out.println("******************正数右移在高位补0********************");
        a = 14;
        a = a >> 3; //高位补0后导致低位数字丢失对应的位数; 因此对于32位的int类型而言, 右移低五位才有效果
        //1
        System.out.println("右移3位=>" + a);
        //1
        System.out.println(Integer.toBinaryString(a));
        System.out.println("******从上面结果可以看出：移位是不循环的*****");
        System.out.println("看看负数的移位:");

        //负数右移
        System.out.println("***********负数的右移操作高位补1**************");
        int i = -1; //int为32位
        //移位前:-1
        System.out.println("负数移位前=>"+i + ":");
        //11111111111111111111111111111111
        System.out.println("负数移位前二进制=> "+ Integer.toBinaryString(i)); //先把-1的绝对值用32位二进制表示; 取反码; 在反码的基础上+1; 得到负数的二进制编码
        i = i >> 2;
        //移位后:-1
        System.out.println("负数移位后=>"+i);
        //11111111111111111111111111111111
        System.out.println(Integer.toBinaryString(i));

        //负数左移
        System.out.println("**********负数的左移操作低位补0*****************");
        i = i << 2;
        //-4
        System.out.println(i);
        //11111111111111111111111111111100 : 减一取反=-4=>减一:11111111111111111111111111111011; 取反:000...000100=4, 加个负号
        System.out.println(Integer.toBinaryString(i));




        //无符号移位操作
        System.out.println("*************再看看>>>操作符*************");
        System.out.println("*************负数的>>>操作高位补0***************");
        i = -1;
        //11111111111111111111111111111111
        System.out.println(Integer.toBinaryString(i));
        i = i >>> 10;
        //4194303
        System.out.println(i + ":");
        System.out.println(Integer.toBinaryString(i));
        System.out.println("*************注意：没有<<<符号**************");

        System.out.println("**********byte类型移位时要强转换*************");
        byte k = 10;
        System.out.println(Integer.toBinaryString(k));
        k = (byte) ((byte) k >>> 2);
        System.out.println(Integer.toBinaryString(k));




        //位操作
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


    }


}
