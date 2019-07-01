package jianzhi_offer.DIANXIN;

import java.util.Scanner;

/**
 * Created by kentorvalds on 2018/9/17.
 */
public class Question4 {

    private static int[] a = {1,5,10,20,50};

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int N = in.nextInt();
            int res = moneyChange(5, N);//moneyChangeMethod3(5,N);
            System.out.println(res);
        }

    }

    /*
    dp[i][j] ： 使用 i 中硬币 兑换 j 元钱的组合的种类数
    xi ： 第 i 种硬币使用的个数
    xi == j / vi then 最后求和之后的 dp[i][j] 即为使用 i 种硬币兑换 sum 元钱的组合的种类数
     */
    public static int moneyChange(int n, int N){
        int[][] dp = new int[10][1000];
        for (int m = 0; m < dp.length; m ++){
            for (int mm = 0; mm < dp[0].length; mm ++){
                dp[m][mm] = 0;
            }
        }

        dp[0][0] = 1;
        for(int i = 1; i <= n; ++i)
        {
            for(int j = 0; j <= N; ++j)
            {
                if(j == 0)
                {
                    dp[i][j] = 1;
                }
                else
                {
                    dp[i][j] = 0;
                    for(int xi = 0; xi <= j/a[i-1]; ++xi)
                    {
                        dp[i][j] += dp[i-1][j-(xi*a[i-1])];
                    }
                }
            }
        }
        return dp[n][N];

    }

    //方法2:递归
//    public static int moneyChange(int sum){
//        int num = coinChangeRecursion(sum, 4);
//        return num;
//    }
//    //m:四种类型币种;  n:总的钱数
//    public static int coinChangeRecursion(int n, int m){
//        if (n == 0)    //跳出递归的条件
//            return 1;
//        if (n < 0 || m == 0)
//            return 0;
//        //System.out.println("coinChangeRecursion(n, m-1) :" + coinChangeRecursion(n, m-1));
//        // System.out.println("coinChangeRecursion(n-a[m-1], m) :" + coinChangeRecursion(n-a[m-1], m));
//        return (coinChangeRecursion(n, m-1) + coinChangeRecursion(n-a[m-1], m));
//    }
}
