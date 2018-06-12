package methd_of_programing.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by kentorvalds on 2017/10/19.
 * 输入两个整数n和sum, 要求从1,2,3,4...,n中随机取出几个数,使得他们的和等于sum
 * 输出所有可能的组合
 *
 *
 *
 */
public class FixedSumOfManyNumbers {
     
    private static int[] res = new int[100];
    private static int k = 0;
    private static ArrayList<Integer> list = new ArrayList<>();
    private static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args){
        int n = 10;
        int sum = 6;

        int[] x = new int[n+1];
        int pos = 0;//记录x数组中的位置
        int sum1 = 0;//求解过程中的和，初始化为0
        sumOfNumberMethod3(sum, n, x, pos, sum1, 1);
        sumOfNumberMethod1(sum, n);

        sumOfNumberMethod2(sum, n);

        System.out.println("和为定值的多个数");
        int[] a = {1,2,1,3,0,1};
        sumOfNumber4(a, 6, 3);

        System.out.println("和为定值的k个数的组合:");
        System.out.println(sumOfNumber5(a, 2, 3));
    }

    //n问题转换为n-1问题:动态规划
    //1.如果取第n个数,那么问题就转换为使得和为sum-n的n-1个数
    //2.如果不去第n个数,那么问题就转换为取前n-1个数使得和为sum
    public static void sumOfNumberMethod1(int sum, int n){
        if (n <= 0 || sum <= 0){
            return;
        }

        if (sum == n){
            list.add(n);
            System.out.println("一次结果开始: ");

            for (Integer a:list){
                System.out.print(a + " + " );
            }
            System.out.println();
            System.out.println("一次结果结束");
        }

        //如果包含n
        list.add(0,n);
        //queue.offer(n);
        sumOfNumberMethod1(sum - n, n - 1);
        //如果不包含n
        removeTarget(list, n);
        //queue.remove(n);
        sumOfNumberMethod1(sum, n - 1);
    }

    public static void removeTarget(List<Integer> list, Integer target){
        for(int i = list.size() - 1; i >= 0; i--){
            Integer item = list.get(i);
            if(target.equals(item)){
                list.remove(item);

            }
        }

    }


    //方法2:回溯剪枝
    public static String[] getAllGroup(int n){
        int len = (int) Math.pow(2, n);
        String[] result = new String[len];
        if(n == 1){
            result[0] = "0";
            result[1] = "1";
            return result;
        }
        String[] temp = getAllGroup(n-1);
        for(int i = 0;i < temp.length;i++){
            result[i] = "0" + temp[i];
            result[len-1-i] = "1" + temp[i];
        }
        return result;
    }
    /*
     * 参数n:代表有1~n的n个不同整数
     * 函数功能：打印出1~n中所有随机组合的几个数，其相加的和等于sum
     */
    public static void sumOfNumberMethod2(int sum,int n){
        System.out.println("1~"+n+"个数中，相加之和等于"+sum+"的所有组合数为：");
        String[] allGroup = getAllGroup(n);
        for(int i = 0;i < allGroup.length;i++){
            char[] temp = allGroup[i].toCharArray();
            int tempSum = 0;
            for(int j = 0;j < temp.length;j++){
                if(temp[j] == '1')
                    tempSum += (j+1);
            }
            if(tempSum == sum){
                for(int j = 0;j < temp.length;j++){
                    if(temp[j] == '1')
                        System.out.print((j+1)+" ");
                }
                System.out.println();
            }
        }
    }

    public static void backTrack(int m,int n,int[] x,int pos,int sum,int cur)
    {
        if(sum == m)//如果sum==m则递归结束，打印组合
        {
            for(int i = 0;i < pos;++i)
            {
               System.out.print(x[i] + "  ");
            }
            System.out.println();

        }
        //将数列从当前位置cur向后遍历到n
        for(int i = cur;i <= n;++i)
        {
            if(sum > m)//剪枝，递归结束
                return;
            if(sum < m)//和小于m，继续递归
            {
                x[pos++] = i;
                backTrack(m,n,x,pos,sum+i,i+1);
                pos--;//回溯控制,因为这里涉及到是否要添加i这个树节点
            }
        }
    }

    public static void sumOfNumberMethod3(int m, int n, int[] x, int pos, int sum, int cur){
        backTrack(m, n, x, pos, sum, cur);
    }

    /*
    寻找和为定值的任意多个数
    算法思想：考虑是否取第n个数，问题可以转化为前n-1个数和为sum-a[n-1]的问题，也可以转化为后n-1个数的求和问题。使用递归思想解决。
    如果取第n个数，即求得前n-1个数满足和为sum-a[n-1]的问题
    如果不取第n个数，即求得前n-1个数满足和为sum的问题
     */
    public static void sumOfNumber4(int[] a, int n, int sum){
        if(n <= 0 || sum <= 0)
            return;

        if(k > 0)
        {
            if(sum == a[n-1])
            {

                for(int i = k-1; i >= 0; --i)
                    System.out.print(res[i] + " + ");
                //System.out.println("aa");
                System.out.println(a[n-1]);//特别注意，输出时，该元素还未加入数组
            }
        }

        //考虑是否取第n个数
        res[k++] = a[n-1];
        //包含第n个数
        sumOfNumber4(a, n-1, sum-a[n-1]);
        k--;
        //不包含第n个数
        sumOfNumber4(a, n-1, sum);


    }


    //k个和为定值的个数: 给出n个数,输出其中所有和为s的k个数的组合
    //给出[1,2,3,4]，k=2， target=5，[1,4] and [2,3]是2个符合要求两个数(k=2)的方案
    public static int sumOfNumber5(int A[], int k, int target) {
        // write your code here

        int len = A.length;
        int [][][] dp = new int[len+1][k+1][target+1];

        if(target < 0)
            return 0;

        for(int i = 0; i <= len; ++i)
            for(int j = 0; j <= k; ++j)
                for(int p = 0; p <= target; ++p)
                {
                    if(j == 0 && p == 0)
                        dp[i][j][p] = 1;
                    else if(i != 0 && j != 0 && p!= 0)
                    {
                        dp[i][j][p] = dp[i-1][j][p];
                        if(p >= A[i-1])
                            dp[i][j][p] += dp[i-1][j-1][p-A[i-1]];
                    }

                }

        return dp[len][k][target];
    }
}



