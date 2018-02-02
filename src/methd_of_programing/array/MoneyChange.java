package methd_of_programing.array;

import java.util.Arrays;

/**
 * Created by kentorvalds on 2017/10/26.
 * 想兑换100元的零钱, 有1元,2元,5元和10元的四种面值, 总共多少种换法
 */
public class MoneyChange {

    private static  int N = 100;
    private static int[] a = {1,2,5,10};
    private static int arr[] = new int[N+1];
    public static void main(String[] args){

        //int[] a = {1,2,5,10};
        //System.out.println("暴力法: 共有"+ moneyChangeMethod1(a,100) + "种兑换方法" );

        //递归法
        System.out.println("递归法: " + moneyChangeMethod2(N));

        //动态规划
        Arrays.fill(arr, 1);
        System.out.println("动态规划法: " + moneyChangeMethod3(4));

    }


    //暴力法
    public static int moneyChangeMethod1(int[] arr, int sum){
        int current = 0;
        for (int i = 0; i <= sum/arr[0]; i++)
            for (int j = 0; j <= sum/arr[1]; j ++)
                for (int k = 0; k <= sum/arr[2]; k ++)
                    for (int m = 0; m <= sum/arr[3]; m ++){
                        if (arr[0]*i + arr[1]*j + arr[2]*k + arr[3]*m == sum){
                            current += 1;
                            System.out.printf("%d 个1元, %d 个2元, %d 个5元, %d 个10元\n",i,j,k,m);

                        }
                    }
        return current;
    }

    //方法2:递归
    public static int moneyChangeMethod2(int sum){
        int num = coinChangeRecursion(sum, 4);
        return num;
    }
    //m:四种类型币种;  n:总的钱数
    public static int coinChangeRecursion(int n, int m){
        if (n == 0)    //跳出递归的条件
            return 1;
        if (n < 0 || m == 0)
            return 0;
        //System.out.println("coinChangeRecursion(n, m-1) :" + coinChangeRecursion(n, m-1));
       // System.out.println("coinChangeRecursion(n-a[m-1], m) :" + coinChangeRecursion(n-a[m-1], m));
        return (coinChangeRecursion(n, m-1) + coinChangeRecursion(n-a[m-1], m));
        //分为两种情况，如果没有换当前硬币，那么是多少？加上，如果换了当前硬币，总值减少，此时又是多少种兑换方法？
    }

    //方法3:动态规划
    /*
    dp[i][j] ： 使用 i 中硬币 兑换 j 元钱的组合的种类数
    xi ： 第 i 种硬币使用的个数
    xi == j / vi then 最后求和之后的 dp[i][j] 即为使用 i 种硬币兑换 sum 元钱的组合的种类数
     */
    public static int moneyChangeMethod3(int n){
        int[][] dp = new int[10][1000];
        for (int m = 0; m < dp.length; m ++){
            for (int mm = 0; mm < dp[0].length; mm ++){
                dp[m][mm] = 0;
            }
        }


        dp[0][0] = 1;// 使用 0 种硬币兑换 0 元的方法 有 1 种   --> 起始点
        for(int i = 1; i <= n; ++i) // 从 1 种 硬币开始，0种硬币已经初始化完成
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
                    // xi 遍历 0-j/vi
                    for(int xi = 0; xi <= j/a[i-1]; ++xi)
                    {
                        //使用 i 中硬币 兑换 j 元钱的组合的种类数
                        //i=4, j = 100, 使用4中类型的钱换100元=用3中类型的+第四种能换的数量
                        dp[i][j] += dp[i-1][j-(xi*a[i-1])];
                    }
                }
            }
        }

        //返回值四种硬币换100元的种类数
        return dp[n][N];

    }

}
