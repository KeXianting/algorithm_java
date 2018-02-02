package methd_of_programing.array;

/**
 * Created by kentorvalds on 2017/11/9.
 * 一个数组中，有两个数出现了奇数次，其余的数都出现偶数次，找出这两个数。
 用异或操作可在O(n)时间复杂度和O(1)空间复杂度内找到。
 设要找的两个数为A和B，第一步让所有的数异或，结果就是A^B ，
 记为C，则C中一定有不为0的二进制位，假设第k位。则A或B的第k位不为0，
 数组中的其余的数中若有第k位不为0的数对，则A或B与这些数对异或，
 可得到A或B，及异或数组中所有第k位不为0的所有数，可得到一个结果值（A或B）。
 然后让此值和C异或，可到到另一个所找数
 */
public class OddTwoNumbers {

    public static void main(String[] args){
        //1出现3次, 7出现5次
        int a[] = {1,1,1,2,3,4,5,7,7,7,2,3,4,5,6,6,7,7};

        getTwoNotRepeated(a);
    }

    //方法与两个只出现一次的数的方法一样
    public static void getTwoNotRepeated(int[] arr){
        int p = 0 ;
        for (int i = 0; i < arr.length; i ++){
            p ^= arr[i];
        }

        //找到p的二进制中第一个为1的位置
        int pos = 1;
        while((p&0x01) == 0)
        {
            p = p>>1;//右移操作
            pos++;
        }
        int n1 = 0, n2 = 0;
        for (int i = 0; i < arr.length; i ++){

            if (isOne(arr[i],pos)==1){
                n1 ^= arr[i];
            }else {
                n2 ^= arr[i];
            }
        }
        System.out.println("出现奇数次的数为: " + n1 + " , " + n2);
    }
    private static int isOne(int num, int pos){
        num = num>>(pos-1);
        return num&0x01;
    }
}
