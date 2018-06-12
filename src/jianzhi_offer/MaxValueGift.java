package jianzhi_offer;

/**
 * Created by kentorvalds on 2018/4/10.
 * 在一个m*n的棋盘的每一个格都放有一个礼物，每个礼物都有一定价值（大于0）。从左上角开始拿礼物，每次向右或向下移动一格，
 * 直到右下角结束。给定一个棋盘，求拿到礼物的最大价值。例如，对于如下棋盘

 1    10   3    8
 12   2    9    6
 5    7    4    11
 3    7    16   5
 礼物的最大价值为1+12+5+7+7+16+5=53。

 */
public class MaxValueGift {

    public static void main(String[] args){
        int[][] arr = {{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
        int[][] brr = {{1,10,3,8}};
        int[][] crr = {{1},{10},{3},{8}};
        int[][] drr = {{2}};
        int[][] err = {};
        System.out.println("最大礼物价值为mxn: " + getMaxValue(arr));
        System.out.println("最大礼物价值为1xn: " + getMaxValue(brr));
        System.out.println("最大礼物价值为mx1: " + getMaxValue(crr));
        System.out.println("最大礼物价值为1x1: " + getMaxValue(drr));
        System.out.println("最大礼物价值为null: " + getMaxValue(err));


    }
    //动态规划: f(i,j) = max(f(i-1,j),f(i,j-1)) + gift[i][j];
    public static int getMaxValue(int[][] arr){
        if (arr == null || arr.length <= 0){
            return 0;
        }
        int[][] dp = new int[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i ++){
            for (int j = 0; j < arr[0].length; j ++){
                int left = 0;
                int up = 0;
                if (i > 0){
                    up = dp[i-1][j];
                }
                if (j > 0){
                    left = dp[i][j-1];
                }
                dp[i][j] = Math.max(left,up) + arr[i][j];
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
