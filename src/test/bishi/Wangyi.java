package test.bishi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by kentorvalds on 2018/4/6.
 *
 */
public class Wangyi {

    public static void main(String[] args){
        //workArrange();

        getNumbers1();
    }

    /*
    为了找到自己满意的工作，牛牛收集了每种工作的难度和报酬。
    牛牛选工作的标准是在难度不超过自身能力值的情况下，
    牛牛选择报酬最高的工作。在牛牛选定了自己的工作后，
    牛牛的小伙伴们来找牛牛帮忙选工作，牛牛依然使用自己的标准来帮助小伙伴们。
    牛牛的小伙伴太多了，于是他只好把这个任务交给了你。

    输入描述:
    每个输入包含一个测试用例。
    每个测试用例的第一行包含两个正整数，分别表示工作的数量N(N<=100000)和小伙伴的数量M(M<=100000)。
    接下来的N行每行包含两个正整数，分别表示该项工作的难度Di(Di<=1000000000)和报酬Pi(Pi<=1000000000)。
    接下来的一行包含M个正整数，分别表示M个小伙伴的能力值Ai(Ai<=1000000000)。
    保证不存在两项工作的报酬相同。

    输出描述:
    对于每个小伙伴，在单独的一行输出一个正整数表示他能得到的最高报酬。一个工作可以被多个人选择。

    输入例子1:
    3 3
    1 100
    10 1000
    1000000000 1001
    9 10 1000000000

    输出例子1:
    100
    1000
    1001
     */
    public static void workArrange(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        //保存所有工作的键值对，即<工作难度，报酬>，而且也保存每个小伙伴的能力值键值对，其报酬为0
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        //保存所有工作的难度值以及要计算的每个小伙伴的能力值
       int[] ai = new int[m + n];
        for(int i = 0; i < n; i++) {
           int di = sc.nextInt();
            ai[i] = di;
            int pi = sc.nextInt();
            map.put(di, pi);
        }
        //保存要计算的每个小伙伴的能力值, 把最后输入的m个数存在map中,初始报酬为0
        int[] bi = new int[m];
        for(int i = 0; i < m; i++) {
          ai[i + n] = sc.nextInt();
            bi[i] = ai[i + n];
            if(!map.containsKey(ai[i + n])) {
               map.put(ai[i + n], 0);
                }
        }
        //对工作难易度进行排序
        Arrays.sort(ai);
        //更新没一个难度值(工作难度值与小伙伴的能力值)对对应的最大报酬
        int ma = 0;
        for (int i = 0; i < m + n; i ++){
            ma = Math.max(ma, map.get(ai[i]));
            map.put(ai[i], ma);
        }
        //遍历每个小伙伴的能力值，从map中获取到其最大报酬（在上面的for循环中已经更新到了）
        for (int i = 0; i < m; i ++){
            System.out.println(map.get(bi[i]));
        }
    }


    /*
    牛牛以前在老师那里得到了一个正整数数对(x, y), 牛牛忘记他们具体是多少了。
    但是牛牛记得老师告诉过他x和y均不大于n, 并且x除以y的余数大于等于k。
    牛牛希望你能帮他计算一共有多少个可能的数对。
    输入描述:
    输入包括两个正整数n,k(1 <= n <= 10^5, 0 <= k <= n - 1)。
    输出描述:
    对于每个测试用例, 输出一个正整数表示可能的数对数量。
    输入例子1:
    5 2
    输出例子1:
    7
    例子说明1:
    满足条件的数对有(2,3),(2,4),(2,5),(3,4),(3,5),(4,5),(5,3)
     */
    //方法1: 双重for循环,超时
    public static void getNumbers(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int count = 0;
        for (int i = 1; i <= n; i ++){
            //余数大于等于k,则除数必行大于k
            for (int j = k+1; j <= n; j ++){
                if (i%j >= k){
                    count ++;
                }
            }
        }
        System.out.println(count);
    }
    //改进:
    /*
    //举个例子，假设 k=3,n=11
    //因为要求对y取余>=k 所以y从k+1开始 （如果y=k，那么取余最大才是k-1）
    //对于第一个y=4,来求有多少个x满足条件
    //      y       y        y
    //1 2 3 4 5 6 7 8 9 10 11
    //所以n被分成了两部分，一部分是1-(n/y)*y:1-8  另一部分：9-11 没被整除的部分
    //1-4 5-8 每一部分都有 （y-k)个取余>=k的数
    //9-11 则有 n%y-k+1 +1是因为序列n从1开始。
     */
    public static void getNumbers1(){

        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long sum = 0;
        int t = 0;
        int tt = 0;
        for(int i=k+1;i<=n;i++){
            t++;
            tt = (n%i - k + 1) >0 ? (n%i - k + 1):0;
            sum+=n/i*t+tt;
        }
        if(k == 0) sum-=n;// k=0 特殊情况  多计算了n次
        System.out.print(sum);
    }

}
