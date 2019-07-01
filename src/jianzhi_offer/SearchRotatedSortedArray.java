package jianzhi_offer;

import java.util.Arrays;

/**
 * Created by kentorvalds on 2018/8/20.
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 Output: 4
 */
public class SearchRotatedSortedArray {

    public static void main(String[] args){
       // int[] nums = {4,5,6,7,0,1,2};
        //System.out.println(search(nums, 0));
        test();
    }

    public static void test(){
        //a < b > c < d > e < f
        //先对数组排序
        int[] input = {1, 4, 3, 2};
        Arrays.sort(input);
        for(int i = 1; i < input.length-1;){
            int temp = input[i];
            input[i] = input[i+1];
            input[i+1] = temp;
            i = i + 2;
        }

        //按照要求输出
        for(int i = 0; i < input.length; i ++){
            System.out.print(input[i]);
        }
    }
    public static int search(int[] nums, int target) {
        if (null == nums || nums.length == 0){
            return -1;
        }

        int low = 0;
        int hight = nums.length - 1;


        while (low <= hight){
            int mid = (low + hight)/2;

            if(target < nums[mid]){
                if(nums[mid] < nums[hight]){
                    hight = mid -1;
                }else {
                    if(target < nums[low]){
                        low = mid + 1;
                    }else {
                        hight = mid - 1;
                    }
                }
            }else if (target > nums[mid]){
                if(nums[low] < nums[mid]){
                    low = mid + 1;
                }else {
                    if(target > nums[hight]){
                        hight = mid - 1;
                    }else {
                        low = mid + 1;
                    }
                }
            }else {
                return mid;
            }

        }
        return -1;
    }
}
