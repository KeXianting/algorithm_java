package jianzhi_offer;

/**
 * Created by kentorvalds on 2018/4/14.
 * 数组A中，除了某一个数字x之外，其他数字都出现了三次，而x出现了一次。请给出最快的方法找到x。
 */
public class OnlyOneRepeated {

    public static void main(String[] args){
        //int a[] = {2, 3, 1, 2, 3, 5, 1, 2, 3, 1, 4, 4, 4};
        int a[] = {1,5,1,5,1,5,3};
        System.out.println(findX(a));
    }

    /*
    如果数组中没有x，那么数组中所有的数字都出现了3次，在二进制上，每位上1的个数肯定也能被3整除。如{1, 5, 1, 5, 1, 5}从二进制上看有：

    1：0001

    5：0101

    1：0001

    5：0101

    1：0001

    5：0101

    二进制第0位上有6个1，第2位上有3个1.第1位和第3位上都是0个1，每一位上的统计结果都可以被3整除。而再对该数组添加任何一个数，如果这个数在二进制的某位上为1都将导致该位上1的个数不能被3整除。因此通过统计二进制上每位1的个数就可以推断出x在该位置上是0还是1了，这样就能计算出x了。
     */
    public static int findX(int[] a){
        if (a == null || a.length <= 0){
            return -1;
        }
        int result = 0;

        //位数组,统计每一位的和
        int bits[] = new int[32];
        for(int i = 0; i < a.length; i++)
        {
            for(int j = 0; j < 32; j++)
            {
                //统计每一位上为1的个数和
                bits[j] += ((a[i] >> j) & 1);
            }
        }

        for(int j = 0; j < 32; j++)
        {
            System.out.println("bits: " + bits[j]);
            if(bits[j] % 3 != 0) //如果该位上为1的个数不是3的倍数,那么那个单独出现的数的该位上为1, 然后利用下面公式求出该数
            {
                result = result + (1 << j);
            }
        }

        return result;
    }
}
