package divide_conquer;

/**
 * Created by kentorvalds on 2017/7/3.
 * 题目：输入一个整形数组，数组里有正数也有负数。数组中连续的一个或多个整数组成一个子数组，每个子数组都有一个和。
 *         求所有子数组的和的最大值。要求时间复杂度为O(n)。 浙大数据结构课本上有 思路:
 *         求连续数字之和,当和为负值,抛弃.当和为正值,比较其与最大值,如大于,则替换之
 *         http://zhedahht.blog.163.com/blog/static/254111742007219147591/
 *         http://blog.csdn.net/v_JULY_v/article/details/6444021
 */
public class FindMaxSumOfSubArray {
    public static void main(String[] arg){
        FindMaxSumOfSubArray f = new FindMaxSumOfSubArray();
        int[] arr = { 1, -2, 3, 10, -4, 7, 2, -5 };
        System.out.println("MaxSum:" + f.findMaxSum(arr));



        int[] a = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
        int[] s = getMaxSummary(a, 0, 15);
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }



    public Integer findMaxSum(int[] arr) {
        int curSum = 0;
        int maxSum = 0;
        int len = arr.length;

        if (arr == null || len == 0) {
            return null;
        }

        for (int i = 0; i < len; i++) {
            curSum += arr[i];
            if (curSum < 0) {
                curSum = 0;
            }
            if (curSum > maxSum) {
                maxSum = curSum;
            }
        }

        // all data are negative
        if (maxSum == 0) {
            for (int i = 0; i < len; i++) {
                if (i == 0) {
                    maxSum = arr[i];
                }
                if (arr[i] > maxSum) {
                    maxSum = arr[i];
                }
            }
        }
        return maxSum;
    }






    public static int[] getMaxSummary(int[] A, int low, int high) {
        if (low == high) { // 如果長度就一個，那麼就把這個取出來
            int[] result = { low, high, A[low] };
            return result;
        } else {
            int middle = (int) Math.floor((low + high) / 2); // 获取中间值
            int[] left = new int[3]; // 保存左边部分返回结果
            int[] right = new int[3]; // 保存右边部分返回结果
            int[] cross = new int[3]; // 返回交叉部分返回结果
            left = getMaxSummary(A, low, middle);
            right = getMaxSummary(A, middle + 1, high);
            cross = getMaxCrossMid(A, low, high, middle);
            if (left[2] >= right[2] && left[2] >= cross[2]) {   // 那部分大就用了那部分
                return left;
            } else if (right[2] >= left[2] && right[2] >= cross[2]) {
                return right;
            } else {
                return cross;
            }
        }
    }

    /**
     * 獲取最大子數組（一部分在左邊，一部分在右邊）
     *
     * @param A
     * @param low
     * @param high
     * @param middle
     * @return
     */
    public static int[] getMaxCrossMid(int[] A, int low, int high, int middle) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0; // 保存和的
        int left = 0; // 记录左边位置
        for (int i = middle; i >= low; i--) {
            sum = sum + A[i];
            if (sum > leftSum) { // 证明所加数字为正数，那么符合条件（因为最大子数组内正数越多指定越大）
                leftSum = sum;
                left = i;
            }
        }

        int rightSum = Integer.MIN_VALUE;
        int sum2 = 0;
        int right = 0; // 记录右边位置
        for (int i = middle + 1; i <= high; i++) {
            sum2 = sum2 + A[i];
            if (sum2 > rightSum) {
                rightSum = sum2;
                right = i;
            }
        }

        int[] result = new int[3];
        result[0] = left;
        result[1] = right;
        result[2] = leftSum + rightSum;
        return result;
    }

}
