package jianzhi_offer;

/**
 * Created by kentorvalds on 2018/4/14.
 * 0~n-1中缺失的数字: 一个长度为n-1的递增排序数组,范围从0到n-1,找出缺失的那个数字
 */
public class MissingNumber {
    public static void main(String[] args){

        int[] a = {0,1,2,3,4,5,6,8,9,10,11};

        System.out.println("相减: " + getMissingNumber(a,12));

        System.out.println("二分: " + getMissingNumber1(a));

    }

    //数组求和,然后相减
    public static long getMissingNumber(int[] a, int n){
        long sum = n*(n-1)/2;
        long sum1 = 0;
        for (int i = 0; i < a.length; i ++){
            sum1 += a[i];
        }
        return sum - sum1;
    }

    //二分查找
    public static int getMissingNumber1(int[] a){
        int len = a.length;
        int left = 0;
        int right = len - 1;
        while (left <= right){
            int middle = (right + left)>>1;
            if (a[middle] != middle){
                if (middle == 0 || a[middle - 1] == middle - 1){
                    return middle;
                }
                right = middle - 1;
            }else {
                left = middle + 1;
            }
        }
        if (left == len){
            return len;
        }
        return -1;
    }
}
