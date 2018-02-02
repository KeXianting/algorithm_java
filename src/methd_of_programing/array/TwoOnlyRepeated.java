package methd_of_programing.array;

/**
 * Created by kentorvalds on 2017/11/3.
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 1. 首先数组中所有元素依次异或，因为相同的元素异或得到0，所以最终的答案就等于那2个唯一的元素a^b的值。

 2. 因为a,b不同，所以异或得到的答案肯定是不等于0的，那么我们就找到a^b的二进制表示中第一个为1的位，假如是第k位。而a,b两个数在第k位上是不同的，一个为0，一个为1

 3. 接下来我们将第k位是1的分成一组，第k位是0的分成一组，如果2个元素相同，那么他们第k位肯定是一样的，所以肯定被分到同一组中。而a,b则被分到2组中去了。
 */
public class TwoOnlyRepeated {

    public static void main(String[] args){

        int a[] = {1,2,3,4,5,2,3,4,5,6};

        getTwoNotRepeated(a);
    }

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
        System.out.println("两个不同的数为: " + n1 + " , " + n2);
    }
    private static int isOne(int num, int pos){
        num = num>>(pos-1);
        return num&0x01;
    }
}
