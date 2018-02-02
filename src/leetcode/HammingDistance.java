package leetcode;

/**
 * Created by kentorvalds on 2017/6/21.
 */
/*
Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.
 */
public class HammingDistance {

    public static void main(String[] arg){
        //^运算: 转换为二进制, 相同的位为0, 不同的位为1
        //3:0011
        //9:1001
        //^:1010=10
        System.out.println(3^9);
       int res = hammingDistance(1,4);
        System.out.println(res);
    }

    //二进制数对应位数不同的个数, ^操作得到的二进制数为1的都是不同的
    public static int hammingDistance(int x, int y) {
        int z = x^y;
        int res = 0;
        while(z != 0) {
            if (z%2 == 1) {
                res++;
            }
            z = z/2;
        }
        return res;
    }
}
