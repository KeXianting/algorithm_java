package test.shift_logical_operation;

/**
 * Created by kentorvalds on 2017/9/13.
 */
/*
常用位操作:
&      与         两个位都为1时，结果才为1
|      或         两个都为0时,结果才为0
^      异或       两个位相同为0，相异为1
~      取反       0变1，1变0
<<     左移       各二进位全部左移若干位，高位丢弃，低位补0
>>     右移       各二进位全部右移若干位，对无符号数，高位补0，有符号数，各编译器处理方法不一样，有的补符号位（算术右移），有的补0（逻辑右移）
 */
public class BitOperator {
    public static void main(String[] args){

        //isEvenOrOdd();
        //swapNumbers();
        //changeSymbol();
        //getAbs();

        charSwap();




/*
        // 1. 获得int型最大值
        System.out.println((1 << 31) - 1);// 2147483647， 由于优先级关系，括号不可省略
        System.out.println(~(1 << 31));// 2147483647

        // 2. 获得int型最小值
                System.out.println(1 << 31);
                System.out.println(1 << -1);

        // 3. 获得long类型的最大值
                System.out.println(((long)1 << 127) - 1);

        // 4. 乘以2运算
                System.out.println(10<<1);

        // 5. 除以2运算(负奇数的运算不可用)
                System.out.println(10>>1);

        // 6. 乘以2的m次方
                System.out.println(10<<2);

        // 7. 除以2的m次方
                System.out.println(16>>2);

        // 8. 判断一个数的奇偶性
                System.out.println((10 & 1) == 1);
                System.out.println((9 & 1) == 1);

        // 9. 不用临时变量交换两个数（面试常考）(a==b的情况要除开)
//                a ^= b;
//                b ^= a;
//                a ^= b;
//
        // 10. 取绝对值（某些机器上，效率比n>0 ? n:-n 高）
                int n = -1;
                System.out.println((n ^ (n >> 31)) - (n >> 31));*/
        /* n>>31 取得n的符号，若n为正数，n>>31等于0，若n为负数，n>>31等于-1
        若n为正数 n^0-0数不变，若n为负数n^-1 需要计算n和-1的补码，异或后再取补码，
        结果n变号并且绝对值减1，再减去-1就是绝对值 */

        // 11. 取两个数的最大值（某些机器上，效率比a>b ? a:b高）
        //        System.out.println(b&((a-b)>>31) | a&(~(a-b)>>31));

        // 12. 取两个数的最小值（某些机器上，效率比a>b ? b:a高）
         //       System.out.println(a&((a-b)>>31) | b&(~(a-b)>>31));

        // 13. 判断符号是否相同(true 表示 x和y有相同的符号， false表示x，y有相反的符号。)
        //        System.out.println((a ^ b) > 0);

        // 14. 计算2的n次方 n > 0
           //     System.out.println(2<<(n-1));

        // 15. 判断一个数n是不是2的幂
          //      System.out.println((n & (n - 1)) == 0);
        /*如果是2的幂，n一定是100... n-1就是1111....
        所以做与运算结果为0*/

        // 16. 求两个整数的平均值
          //      System.out.println((a+b) >> 1);

        // 17. 从低位到高位,取n的第m位
         //       int m = 2;
         //       System.out.println((n >> (m-1)) & 1);

        // 18. 从低位到高位.将n的第m位置为1
          //      System.out.println(n | (1<<(m-1)));
        /*将1左移m-1位找到第m位，得到000...1...000
        n在和这个数做或运算*/

        // 19. 从低位到高位,将n的第m位置为0
         //       System.out.println(n & ~(0<<(m-1)));
        /* 将1左移m-1位找到第m位，取反后变成111...0...1111
        n再和这个数做与运算*/



    }

    /*
    判断奇偶:
    只要根据最未位是0还是1来决定，为0就是偶数，为1就是奇数。因此可以用if ((a & 1) == 0)代替if (a % 2 == 0)来判断a是不是偶数
     */
    public static void isEvenOrOdd() {
        for (int i = 0; i < 100; i ++) {
            if ((i & 1) == 0) { // 偶数
                System.out.println(i);
            }
        }

    }


    /*交换两个数 : 不用临时变量
    第一步 a^=b 即a=(a^b)； 第二步 b^=a 即b=b^(a^b)，由于^运算满足交换律，
    b^(a^b)=b^b^a。由于一个数和自己异或的结果为0并且任何数与0异或都会不变的，
    所以此时b被赋上了a的值； 第三步 a^=b 就是a=a^b，由于前面二步可知a=(a^b)，b=a，
    所以a=a^b即a=(a^b)^a。故a会被赋上b的值； ###变换符号### 变换符号就是正数变成负数，负数变成正数

    int a = 13, b = 6;

    a的二进制为 13=8+4+1=1101(二进制)

    b的二进制为 6=4+2=110(二进制)

    第一步 a^=b  a = 1101 ^ 110 = 1011;

    第二步 b^=a  b = 110 ^ 1011 = 1101;即b=13

    第三步 a^=b  a = 1011 ^ 1101 = 110;即a=6
     */
    public static void swapNumbers(){
        int a = 1, b = 2;
        a ^= b; // a=(a^b)
        b ^= a; //b=b^(a^b) = b^b^a=a
        a ^= b; //a=(a^b)=((a^b)^b)=(a^b)^a=b; 或者: a = (a^b)
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }


    /*
    变换符号:
    变换符号就是正数变成负数，负数变成正数。

    如对于-11和11，可以通过下面的变换方法将-11变成11

      1111 0101(二进制) –取反-> 0000 1010(二进制) –加1-> 0000 1011(二进制)

    同样可以这样的将11变成-11

      0000 1011(二进制) –取反-> 0000 0100(二进制) –加1-> 1111 0101(二进制)

    因此变换符号只需要取反后加1即可。
     */
    public static void changeSymbol(){
        int a = -11, b = 11;
        System.out.println("a变换符号后: " + (~a + 1));
        System.out.println("b变换符号后: " + (~b + 1));
    }

    /*
    求绝对值:
      方法1: 位操作也可以用来求绝对值，对于负数可以通过对其取反后加1来得到正数。对-6可以这样：

            1111 1010(二进制) –取反->0000 0101(二进制) -加1-> 0000 0110(二进制)

            来得到6。

            因此先移位来取符号位，int i = a >> 31;要注意如果a为正数，i等于0，为负数，i等于-1。然后对i进行判断——如果i等于0，直接返回。否之，返回~a+1。

       方法2: 对于任何数，与0异或都会保持不变，
             与-1即0xFFFFFFFF异或就相当于取反。
             因此，a与i异或后再减i（因为i为0或-1，所以减i即是要么加0要么加1）也可以得到绝对值。
     */
    public static void getAbs(){
        int a = -6; //负数转换为二进制: 先取6的32位二进制数, 然后取反码, 最后再反码的基础上加1
        System.out.println(Integer.toBinaryString(a));
        int i = a >> 31; //右移后绝对值为1, 符号位为1, 因此为-1
        System.out.println(Integer.toBinaryString(i));
        System.out.println(i);
        //符号位为0则为整数, 返回自身, 符号位为1则为负数, 返回相反数
        int abs = i == 0 ? a : (~a + 1);
        System.out.println(abs);


        int abs1 = ((a ^ i) - i);
        System.out.println(abs1);
    }

    /*高地位交换
    给出一个16位的无符号整数。称这个二进制数的前8位为“高位”，后8位为“低位”。现在写一程序将它的高低位交换。例如，数34520用二进制表示为：

      10000110 11011000

    将它的高低位进行交换，我们得到了一个新的二进制数：

      11011000 10000110

    它即是十进制的55430。

    这个问题用位操作解决起来非常方便，设x=34520=10000110 11011000(二进制) 由于x为无符号数，
    右移时会执行逻辑右移即高位补0，因此x右移8位将得到00000000 10000110。而x左移8位将得到11011000 00000000。
    可以发现只要将x>>8与x<<8这两个数相或就可以得到11011000 10000110。
     */




    //字符串异货
    public static void charSwap(){
        char a = 'a';
        char b = 'b';
        a ^= b;
        b ^= a;
        a ^= b;
        System.out.println(a);
        System.out.print(b);
    }


}
