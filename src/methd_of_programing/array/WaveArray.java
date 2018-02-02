package methd_of_programing.array;

import java.util.Arrays;

/**
 * Created by kentorvalds on 2017/11/30.
 * 一个数组[1,2,3,4,6,8,9,4,8,11,18,19,100] 前半部分是是一个递增数组，后面一个还是递增数组，但整个数组不是递增数组，那么怎么最快的找出其中一个数？
 首先找到两个递增序列的分界点，之后对两个递增序列分别使用二分查找
 */
public class WaveArray {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,6,8,9,4,8,11,18,19,100};
        System.out.println("波浪数组: " + getTarget(arr, 18));
    }

    private static int getTarget(int[] arr, int target){
        int index = -1,i;
        for (i = 0; i < arr.length - 1; i ++){
            if (arr[i] > arr[i+1]){//i为分界点
                break;
            }
        }
        if (arr[i] >= target){//目标在左边
            index = binarySearch(arr, 0, i, target);
        }
        if (arr[i+1] <= target ){
            index = binarySearch(Arrays.copyOfRange(arr, i + 1, arr.length-1), 0, arr.length-i-2, target);
            if (index != -1){
                index = index + i + 1;
            }
        }
        return index;

    }

    private static int binarySearch(int[] a, int low, int high, int target){

        while(low <= high){
            int mid = (low + high) >> 1;
            if (a[mid] == target){
                return mid;
            }else if (a[mid] < target){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return -1;

    }
}
