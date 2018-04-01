package methd_of_programing.array;

/**
 * Created by kentorvalds on 2017/10/23.
 * 一个整数数组中的元素有正有负，在该数组中找出一个连续子数组，要求该连续子数组中各元素的和最大，
 * 这个连续子数组便被称作最大连续子数组。比如数组{2,4,-7,5,2,-1,2,-4,3}的最大连续子数组为{5,2,-1,2}，
 * 最大连续子数组的和为5+2-1+2=8。
 */
public class MaxSubArray {

    public static void main(String[] args){

        int a[] = {1,-2,3,10,-4,7,2,-5};

        System.out.println("暴力搜索:" + maxSubArrayMethod1(a));

        System.out.println("动态规划:"+ maxSubArrayMethod2(a));


      //  System.out.println("改进暴力法: " + maxSubArrayMethod3(a));

    }

    //方法1:暴力解决
    public static int maxSubArrayMethod1(int[] arr){
        int maxSum = arr[0];
        int currentSum = 0;
        for(int i = 0; i < arr.length; i ++){
            for(int j = i; j < arr.length; j ++){
                for (int k = i; k <= j; k ++){
                    currentSum += arr[k];
                }
                if (currentSum > maxSum){
                    maxSum = currentSum;
                }
                currentSum = 0;//每一次循环后得到所有子数组的和清零
            }
        }

        return maxSum;
    }

//    public static int maxSubArrayMethod3(int[] arr){
//        int len = arr.length;
//        int maxSum = Integer.MIN_VALUE;
//        for (int i = 0; i < len; i ++){
//            int sum = 0;
//            for (int j = i; j < len; j++){
//                sum += arr[i];
//                if (sum > maxSum){
//                    maxSum = sum;
//                }
//            }
//        }
//        return maxSum;
//    }

    //方法2:动态规划: currentSum=max{a[i], currentSum[i-1]+a[i]}
    public static int maxSubArrayMethod2(int[] arr){
        int currentSum = 0;
        int maxSum = arr[0];
        for (int i = 0; i < arr.length; i ++){
            if (currentSum > 0){
                currentSum = currentSum + arr[i];
            }else {
                currentSum = arr[i];
            }
            if (currentSum > maxSum){
                maxSum = currentSum;
            }
        }
        return maxSum;
    }



}
