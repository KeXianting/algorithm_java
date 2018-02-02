package methd_of_programing.array;

/**
 * Created by kentorvalds on 2017/11/2.
 * 在一个数组里, 只有三个只出现一次, 其他的数都是出现两次的, 找出这三个数
 *
 *
 * 由于3个数字出现一次，其他数字均出现两次，因此可以得到n一定为奇数。
 3个只出现一次的数字，他们的bit位肯定不可能全部相同，也就是说，
 虽然有些bit位上的数可能相等，但肯定至少存在某一个bit位，
 这三个数中，有两个数的该bit位为1，一个数的该bit位为0，
 或者两个数的该bit位为0，一个数的该bit位为1。
 我们可以通过扫面int的所有bit位，扫描每个bit位的时候，
 遍历数组，如果能找出符合上面条件的，我们就可以找出其中的一个只出现一次的数字，
 该数字与另外两个只出现一次的数的bit位不同。找到一个之后，
 就可以将其与数组的最后一个元素交换，再在前面n-1个数中找出另外两个就可以了
 */
public class ThreeOnlyRepeated {

    public static void main(String[] args){
        int a[] = {9,2,3,4,5,2,3,4,5,6,8,0};//最后一个0是无效的数,为了区分

        findThreeNumInArrayOnlyOnce(a, a.length-1);
        //System.out.println(a[a.length-1]);

    }

    public static void findThreeNumInArrayOnlyOnce(int[] arr, int len) {
        int first = 0, second = 0, third = 0;
        int countBit = 32;
        int count1=0, count0=0;//分别用来保存第一类和第零类中的元素个数。
        int temp1=0, temp0=0;//分别用来保存第一类和第零类中所有元素的异或结果。
        for (int i = 0; i < countBit; i++) {

            count1 = count0 = temp1 = temp0;//每次循环时清零
            for (int j = 0; j < arr.length; j++) {
                if (isBit1In_i(arr[j], i)!=0) {//检测arr[j]在第i位是否为1.
                    count1++;
                    temp1 ^= arr[j];
                } else {
                    count0++;
                    temp0 ^= arr[j];
                }
            }
            if (isOdd(count1)!=0) {//count1为奇数时 即出现第一种情况：有两个出现一次的数字该bit为 0，一个为1  的情况。或者全1  的情况。
                if (temp0 != 0) {//则说明有两个 出现一次的数字在bit=0的类，另一个在bit=1的类中，且值为temp1. ,否则什么也不做。
                    first = temp1;
                    //找到一个数之后，，将此数放在数组最后一个位置，然后在数组的前n+1的元素中寻找。，然后调用在数组中有两个数字出现一次的函数即可解决问题。
                    arr[len] = temp1;
                    //System.out.println("aaa");
                    System.out.println(first);
                    findTwoNumInArrayOnlyOnce(arr, len + 1, second, third);
                    return;//返回即可。
                }
            } else {//count1为偶数，即出现第二种情况：有两个出现一次的数字该bit为 1，一个为0  的情况。 或者全0 的情况。
                if (temp1 != 0) {//则说明有两个 出现一次的数字在bit=1的类，另一个在bit=0的位，且值为temp0. ,否则什么也不做。
                    first = temp0;
                    arr[len] = temp0;
                    //System.out.println("bbb");
                    System.out.println(first);
                    findTwoNumInArrayOnlyOnce(arr, len + 1, second, third);
                    return;//返回即可。
                }
            }
        }
    }
        //函数功能：检测数字a在第i为是否为  1
        private static int isBit1In_i(int a,int i){

            return a&(1<<i); //将1左移 i在进行与
        }
        //函数功能：检测数字a是否为奇数。
        private static int isOdd(int a){
            return a%2;
        }


    private static int xorArr(int arr[],int len){
        if(arr!=null&&len>0){
            int result=arr[0];
            for(int i=1;i<len;i++){
                result^=arr[i];
            }
            return result;
        }
        return 0;
    }
    /*
    返回a的最低位的1，其他各位都为0
    */
    private static int findFirstBit1Index(int a){
        return a&(-a);//
    }
    /*
    判断a中特定的位是否为1，若特定的位为 1，则返回true；
    这里的要判断的特定的位由b确定，
    b中只有一位为1，其他位均为0，由FindFirstBit1函数返回，
    而a中要判断的位便是b中这唯一的1所在的位是否为1
    */
    private static int isBit1(int a,int b){
        return a&b;
    }
    //函数功能：找出数组中只有两个只出现一次的数字。
    private static void findTwoNumInArrayOnlyOnce(int[] arr,int len,int first,int second){
        if(arr==null||len<2){
            return;
        }
        first=0;
        second=0;
        //第一步：将arr中所有的数异或。
        int xorResult=xorArr(arr,len);
        //第二步：找到异或结果中最右边为1的下标。
        int index=findFirstBit1Index(xorResult);
        //第三步：根据index将arr分成两个子数组，每个子数组中只有一个数字的次数为1，其余都为两次
        for(int i=0;i<len;i++){
            if(isBit1(arr[i],index)!=0){//此子数组中：为1
                first^=arr[i];
            }
            else{
                second^=arr[i];
            }
        }
        System.out.println(first + " , " + second);
    }
}
