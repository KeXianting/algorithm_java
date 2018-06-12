package jianzhi_offer;

/**
 * Created by kentorvalds on 2018/4/16.
 * 把n个骰子扔到地上，所有骰子朝上一面的点数之后为s. 输入n，打印出s所有可能的值出现的概率。（每个骰子6个面，点数从1到6）
 */
public class ProbabilityOfFixedSum {
    public static void main(String[] args){
        int number = 10; //5个骰子
        //PrintProbability(number);
        //PrintProbability_1(number);
        System.out.println("动态规划");
        getProbabilities(number);
    }
    /*
    基于递归，时间效率不高

    递归的思想一般是分而治之，把n个骰子分为第一个和剩下的n-1个。
    先计算第一个骰子每个点数出现的次数，再计算剩余n-1个骰子出现的点数之和。
    求n-1个骰子的点数之的方法和前面讲的一样，即再次把n-1个骰子分成两堆------第一个和剩下的n-2个。
    n个骰子，每个骰子6个面，总共有6n个组合。这6n个组合之中肯定有重复的，我们知道其范围是n~6n,
    对于每种情况我们可以用缓存机制记录下来，每当其发生一次我们令其对应的单元加1。

    我们定义一个长度为6n-n+1的数组，和为s的点数出现的次数保存到数组第s-n个元素里。
    为什么是6n-n+1呢？因为n个骰子的和最少是n，最大是6n，介于这两者之间的每一个情况都可能会发生，总共6n-n+1种情况
     */
    private static final int g_maxValue = 6;
    //基于递归求骰子点数，时间效率不高
    public static void PrintProbability(int number){
        if(number<1) return;
        int maxSum = number*g_maxValue;
        int[] pProbabilities = new int[maxSum-number+1];
        //初始化，开始统计之前都为0次
        for(int i=number;i<=maxSum;i++){
            pProbabilities[i-number] = 0;
        }
        double total = Math.pow(g_maxValue,number);
        //probability(number,pProbabilities);这个函数计算n~6n每种情况出现的次数
        probability(number,pProbabilities);
        for(int i=number;i<=maxSum;i++){
            double ratio = pProbabilities[i-number]/total;
            System.out.println("i: "+i+" ratio: "+ratio);
        }
    }
    public static void probability(int number,int[] pProbabilities){
        for(int i=1;i<=g_maxValue;i++){//从第一个骰子开始
            probability(number,number,i,pProbabilities);
        }
    }
    //总共original个骰子，当前第 current个骰子，sum当前的和，贯穿始终的数组
    public static void probability(int original,int current,int sum,int[] pProbabilities){
        if(current==1){
            pProbabilities[sum-original]++;
        }else{
            for(int i=1;i<=g_maxValue;i++){
                probability(original,current-1,sum+i,pProbabilities);
            }
        }
    }

    /*基于循环，时间性能好

    递归一般是自顶向下的分析求解，而基于循环的方法则是自底向上。基于循环的一般需要更少的空间和更少的时间，性能较好，但是一般代码比较难懂
    */
    //基于循环求骰子点数
    public static void PrintProbability_1(int number){
        if(number<1){
            return;
        }
        int[][] pProbabilities = new int[2][g_maxValue*number +1];
        for(int i=0;i<g_maxValue;i++){//初始化数组
            pProbabilities[0][i] = 0;
            pProbabilities[1][i] = 0;
        }
        int flag = 0;
        for(int i=1;i<=g_maxValue;i++){//当第一次抛掷骰子时，有6种可能，每种可能出现一次
            pProbabilities[flag][i] = 1;
        }
        //从第二次开始掷骰子，假设第一个数组中的第n个数字表示骰子和为n出现的次数，
        //在下一循环中，我们加上一个新骰子，此时和为n的骰子出现次数应该等于上一次循环中骰子点数和为n-1,n-2,n-3,n-4,n-5，
        //n-6的次数总和，所以我们把另一个数组的第n个数字设为前一个数组对应的n-1,n-2,n-3,n-4,n-5，n-6之和
        for(int k =2;k<=number;k++){
            for(int i=0;i<k;i++){//第k次掷骰子，和最小为k，小于k的情况是不可能发生的！所以另不可能发生的次数设置为0！
                pProbabilities[1-flag][i] = 0;
            }
            for(int i=k;i<=g_maxValue*k;i++){//第k次掷骰子，和最小为k，最大为g_maxValue*k
                pProbabilities[1-flag][i] = 0;//初始化，因为这个数组要重复使用，上一次的值要清0
                for(int j=1;j<=i&&j<=g_maxValue;j++){
                    pProbabilities[1-flag][i] += pProbabilities[flag][i-j];
                }
            }
            flag = 1-flag;
        }
        double total = Math.pow(g_maxValue, number);
        for(int i=number;i<=g_maxValue*number;i++){
            double ratio = pProbabilities[flag][i]/total;
            System.out.println("sum: "+i+" ratio: "+ratio);
        }
    }


    //动态规划: 当有k-1个骰子, 点数和为n, 在增加一个骰子, 则第k个骰子的可能点数为1,2,3,4,5,6
    //那k个骰子得到点数和为n的情况有:(k-1,n-1)：第k个骰子投了点数1;(k-1,n-2)：第k个骰子投了点数2;....
    //在k-1个骰子的基础上，再增加一个骰子出现点数和为n的结果只有这6种情况！
    //所以：f(k,n)=f(k-1,n-1)+f(k-1,n-2)+f(k-1,n-3)+f(k-1,n-4)+f(k-1,n-5)+f(k-1,n-6)
    //有1个骰子，f(1,1)=f(1,2)=f(1,3)=f(1,4)=f(1,5)=f(1,6)=1
    public static void getProbabilities(int n){
        int[][] f = new int[6*n+1][n+1];
        for (int j = 1; j <= n; j++){
            for (int i = j; i <= 6*j; i ++){
                if(j == 1 || i == j || i == 6*j) {
                    f[i][j] = 1;//当只有一个骰子是位1, 或者骰子数等于和,也为1; 或者和等于6倍的骰子数,即所有的骰子都是6,此时也为1
                }else {
                    int k = i-1;
                    for(k = 1;k<=6;k++)
                        if(i-k>= j-1)
                            f[i][j] += f[i-k][j-1];//递推公式
                }
            }
        }

        double total = Math.pow(g_maxValue, n);
        //if (total > Double.MAX_VALUE) total = Double.MAX_VALUE;
        double[] p = new double[5*n+1];
        for (int i = n; i<=6*n; i ++){
            p[i-n] = f[i][n]/total;
//            if (p[i-n]<Double.MIN_VALUE){
//                p[i-n] = 0;
//            }
            System.out.println("和为" + i + "的概率为: " + p[i-n]);
        }

    }
}
