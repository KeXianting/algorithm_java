package methd_of_programing.array;

/**
 * Created by kentorvalds on 2017/12/19.
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个排好序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3, 4, 5, 1, 2}为{1, 2, 3, 4, 5}的一个旋转，该数组的最小值为1。
 *
 *
 * 思路：这道题最直观的解法并不难。从头到尾遍历数组一次，就能找出最小的元素，时间复杂度显然是O(n)。但这个思路没有利用输入数组的特性。既然有时间复杂度更小的算法，我们容易想到二分查找，因为它的时间复杂度为O(logn)。这个问题是否可以运用二分查找呢？答案是肯定的。观察一下数组的特性，首先递增（称为递增a），然后突然下降到最小值，然后再递增（称为递增b）。当然还有一种特殊情况，就是数组递增，中间没有下降，即旋转元素个数为0。
 对于一般的情况，假设A为输入数组，left 和 right 为数组左右边界的坐标，考察中间位置的值A[mid] ，如果A[mid] <= A[right]，表明处于递增b，调整右边界 right = mid；如果A[mid] >= A[left]，表明处于递增a，因此调整左边界left = mid。当左右边界相邻时，较小的一个就是数组的最小值。其实，对于一般情况，右边界所指的元素为最小值。
 对于特殊情况，即旋转个数为0。按照上述算法，右边界会不断减少，直到与左边界相邻。这时左边界所指的元素为最小值。
 */
public class MinimumRotateArray {

    public static void main(String[] args){

        int[] a = {3, 4, 5, 1, 2};
        System.out.println("方法1: ");
        System.out.println(findMinimumMehtod1(a));
        System.out.println("=========================");
        int[] b = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(findMinimumMehtod1(b));
        System.out.println("=========================");
        int[] c = {4,5,6,7,8,9,10,1,2,3};
        System.out.println(findMinimumMehtod1(c));
        System.out.println("=========================");
        int[] d = {9,9,9,9,9,9,9,10,1,9};
        System.out.println(findMinimumMehtod1(d));



    }

    private static int findMinimumMehtod1(int[] a){
        if (a == null || a.length == 0){
            return Integer.MIN_VALUE;
        }
        int left = 0, right = a.length - 1, mid;
        while ((right - left) != 1){
            mid = left + ((right - left)>>1);
            if (a[left] <= a[mid]){
                left = mid;
            }else if (a[right] >= a[mid]){
                right = mid;
            }

        }
        //如果最后right最后为a.length-1,则数组递增,最小元素为a[0]
        if (left == 0){
            return a[a.length-1];
        }
        if (right == a.length - 1){
            return a[0];
        }
        //如果left最后为0, 则递减, 则返回a[length-1]
        return a[right] > a[left] ? a[left] : a[right];
    }


}
