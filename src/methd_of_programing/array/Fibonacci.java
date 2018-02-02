package methd_of_programing.array;

/**
 * Created by kentorvalds on 2017/10/26.
 * 一个台阶总共n级, 如果一次可以跳1级, 也可以跳两级, 求总共有多少中跳法
 */
public class Fibonacci {

    public static void main(String[] args){

        int n = 10;

        System.out.println("递归法: " + fibonacciMethod1(n));

        System.out.println("地推法: " + fibonacciMethod2(n));

    }

    //方法1:递归
    public static int fibonacciMethod1(int n){
        int[] result = {0,1,2};
        if (n <= 2){
            return result[n];
        }
        return fibonacciMethod1(n-1) + fibonacciMethod1(n-2);
    }

    //方法2:递推公式
    public static int fibonacciMethod2(int n){
        int[] result = {1,1};
        int[] dp = new int[n+1];
        dp[0] = result[0];
        dp[1] = result[1];

        if (n<2){
            return dp[n];
        }
        for (int i = 2; i <= n; i ++){
            dp[i] = dp[i - 1] + dp[i -  2];
        }
        return dp[n];
    }
}
