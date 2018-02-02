package methd_of_programing.array;

/**
 * Created by kentorvalds on 2017/11/28.
 * 数组中的最小绝对值
 * 给定一个数组(从小到大排序), 数组中的数有正有负, 求这个数组中元素的最小绝对值
 *
 */
public class MinimumAbs {

    public static void main(String[] args){
        int[] a = {-3, -2, 3,4,7,10};
        System.out.println("遍历法获取最小绝对值: " + getMinimumAbsMethod1(a));
        System.out.println("二分法获取最小绝对值: " + getMinimumAbsMethod2(a));
    }

    //方法1: 遍历数组，找到绝对值最小值，时间复杂度O（n），n为元素个数。
    public static int getMinimumAbsMethod1(int[] arr){
        //如果只有一个元素,直接返回
        if (arr.length == 1){
            return Math.abs(arr[0]);
        }
        //当数组没有负数时返回第一个
        if (arr[0] >= 0){
            return arr[0];
        }
        //当没有正数时返回最大的一个
        if (arr[arr.length-1] <= 0){
            return Math.abs(arr[arr.length - 1]);
        }

        int min = Math.abs(arr[0]);
        for (int i = 0; i < arr.length; i ++){
            min = Math.min(min, Math.abs(arr[i]));
        }
        return min;
    }

    //方法2:
    /*二分查找，因为数组有序，可以利用二分查找，时间复杂度O（logn）。

    分析步骤：

    如果第一个数为正数，说明整个数组没有负数，直接返回第一个数
    如果最后一个数为负数，说明整个数组没有正数，直接返回最后一个数
    数组元素有正有负，说明绝对值最小的元素肯定在正负数交界处，需要二分查找上场：
    如果a[mid]<0，因为数组是升序，说明绝对值最小的数不会出现在a[mid]左边，同时判断a[mid+1]元素的正负，如果为负数，那么需要在mid右侧区间进行查找，如果a[mid-1]不为负，那么说明这两个数是数组中正负交界点，返回这两个数的绝对值较小的。
    如果a[mid]>0，因为数组是升序，说明绝对值最小的数不会出现在a[mid]右边，同时判断a[mid-1]元素的正负，如果为负数，那么说明这两个数是数组中正负交界点，返回这两个数的绝对值较小的，如果a[mid-1]不为负，那么需要在mid以左的区间进行查找。
    如果a[mid] == 0，那么a[mid]即为绝对在最小的元素。
    */
    public static int getMinimumAbsMethod2(int[] arr){
        //如果只有一个元素,直接返回
        if (arr.length == 1){
            return Math.abs(arr[0]);
        }
        //当数组没有负数时返回第一个
        if (arr[0] >= 0){
            return arr[0];
        }
        //当没有正数时返回最大的一个
        if (arr[arr.length-1] <= 0){
            return Math.abs(arr[arr.length - 1]);
        }
        //当数组有正有负时，返回最大的负数与最小的非负数中较小的那一个
        int low = 0, high = arr.length-1, mid = (low + high)/2;
        while (low < high){
            //如果a[mid]<0，因为数组是升序，说明绝对值最小的数不会出现在a[mid]左边，
            // 同时判断a[mid+1]元素的正负，如果为负数，那么需要在mid右侧区间进行查找，
            // 如果a[mid-1]不为负，那么说明这两个数是数组中正负交界点，返回这两个数的绝对值较小的
            if (arr[mid] < 0){
                low = mid + 1;
            }else if (arr[mid] > 0){//如果a[mid]>0，因为数组是升序，说明绝对值最小的数不会出现在a[mid]右边，同时判断a[mid-1]元素的正负，如果为负数，那么说明这两个数是数组中正负交界点，返回这两个数的绝对值较小的，如果a[mid-1]不为负，那么需要在mid以左的区间进行查找。
                if (arr[mid-1] < 0){
                    return Math.min(Math.abs(arr[mid]), Math.abs(arr[mid-1]));
                }
                high = mid -1;
            }else {
                return arr[mid];
            }
            mid = (low + high) / 2;
        }
        return 0;
    }

}
