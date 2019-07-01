package leetcode;

import java.util.Arrays;

/**
 * Created by kentorvalds on 2018/8/20.
 */
public class NextPermutation {


    public static void main(String[] args){
        int[] nums = {1,3,2};//{6, 5, 4, 8, 7, 5, 1};
        //Arrays.sort(nums);
        nextPermutation(nums);
        for (int i:nums){
            System.out.print(i + " ");
        }
    }
    public static void nextPermutation(int[] nums) {
        /*
        6 5 4 8 7 5 1
        首先肯定从后面开始看，1和5调换了没有用。

        7、5和1调换了也没有效果，因此而发现了8、7、5、1是递减的。

        如果想要找到下一个排列，找到递增的位置是关键。

        因为在这里才可以使其增长得更大。

        于是找到了4，显而易见4过了是5而不是8或者7更不是1。

        因此就需要找出比4大但在这些大数里面最小的值，并将其两者调换。

        那么整个排列就成了：6 5 5 8 7 4 1

        然而最后一步将后面的8 7 4 1做一个递增。
        */
        int len = nums.length;
        int index = 0;
        for(int i = len -1; i > 0; i --){
            if(nums[i-1] < nums[i]){
                index = i -1;
                break;
            }
        }
//        if(index == 0){
//            Arrays.sort(nums);
//        }
        int tempIndex = len -1;
        for (int i = index + 1; i < len; i++){
            if (nums[i] > nums[index]){
                tempIndex = i;
                //System.out.println(tempIndex);
            }
        }

        //交换
        int temp = nums[index];
        nums[index] = nums[tempIndex];
        nums[tempIndex] = temp;
        //对index以后的元素排序
        Arrays.sort(nums, index + 1, len);
    }
}
