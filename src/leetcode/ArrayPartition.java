package leetcode;

import java.util.Arrays;

/**
 * Created by kentorvalds on 2017/6/23.
 */
/*
Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

Example 1:
Input: [1,4,3,2]

Output: 4
Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
Note:
n is a positive integer, which is in the range of [1, 10000].
All the integers in the array will be in the range of [-10000, 10000].
 */
public class ArrayPartition {

    public static void main(String[] arg){
        int[] num = {1,4,3,2,7,9};
        Arrays.sort(num);
//        for (int i = 0; i < num.length; i ++){
//            System.out.println(num[i]);
//        }
        //先对数组排序, 则排序后每两个前一个最小, 这样能保证所求的和最大
        //{1,2,3,4,7,9}, min{1,2} + min{3,4} + min{7,9} = 1 + 3 + 7
        int sum = 0;
        for (int i = 0; i < num.length; i+=2) {
            sum += num[i];
        }

        System.out.println(sum);
    }
}
