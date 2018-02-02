package leetcode;

/**
 * Created by kentorvalds on 2017/7/10.
 * 微软一面笔试题 求数组中两个元素差的最大值（后面的元素减去前面的元素）O(N)时间复杂度O(1)空间复杂度
 题目：在数组中找到两个元素，计算后面的元素减去前面的元素的差。求出所有差的最大值。
 （你可以认为你在炒股票，买入价格和卖出价格就是你的盈利）
 当时想到的方法是，如果一遍遍历这个数组，找到MAX,MIN元素，如果恰好，
 MAX在MIN的后面，这个问题就解决了，关键是如果这种情况不出现怎么办，
 我给出了递归的方法，回来自己想想发现不行，递归不靠谱，对一些测试用例来说很难有很高的效率。
 潜意识告诉我，求数组中连续元素的最大和的方法对这个问题有很大的启发，那个问题在本博客中已经解决过了，
 而且我反复做了两遍，太好了。那个问题的解决思路是将全部元素的问题，看成是从两个元素大小的数组开始的问题。
 当这个包含两个元素的问题解决了，那么加一个新的元素会造成什么影响？要改变哪些值？每次都添加一个元素，
 每次都将这些可能的改变考虑进来，这样就能做到遍历整个数组的时候，问题就结局了。达到了最快的速度O（N）
 有了上面的思路，这个问题居然更简单，其实现如下：

 */

//数组A[0...n] , 对于0<=i<j<=n, 找出A[j]-A[i]的最大值
public class MaxDifference {

    public static void main(String[] arg) {

        int[] a = {12, 20, 23, 1, 2, 5, 7, 10};
        //动态规划
        System.out.println(maxDifference(a)); //后面减前面, 最大差值
        //动态规划
        int[] b = {13, 20, 23, 1, 2, 5, 7, 10};
        System.out.println("动态规划" + maxDifference1(b));

        //暴力搜索
        System.out.println("暴力搜索: " + maxDifference2(a));
        System.out.println("暴力搜索: " + maxDifference2(b));


        //转化法
        System.out.println("转化法: " + maxDifference4(a));
    }


    //自底向上动态规划: O(n)
    //后面的数减去前面的数
    public static int maxDifference(int[] a){


        int minLeft = a[0];//默认最小的值

        int maxDiff = a[1] - a[0]; //初始最大差值

        for(int i = 2; i < a.length; i++)
        {
            if(a[i - 1] < minLeft)//得到i之前数组的最小值
            {
                minLeft = a[i - 1];
            }
            if(a[i] - minLeft > maxDiff)//获取最大差值
            {
                maxDiff = a[i] - minLeft; //用当前值减去当前值之前的最小值, 得到最大差值
            }
        }
        return maxDiff;

    }

    //前面的数减去后面的数
    public static int maxDifference1(int[] a){
        int maxLeft = a[0];//默认最大的值

        int maxDiff = a[0] - a[1]; //初始最大差值

        for(int i = 2; i < a.length; i++)
        {
            if(maxLeft < a[i - 1])//得到i之前数组的最大值
            {
                maxLeft = a[i - 1];
            }
            if(maxLeft - a[i] > maxDiff)//获取最大差值
            {
                maxDiff = maxLeft - a[i]; //用当前值之前的最大值减去当前值, 得到最大差值
            }
        }
        return maxDiff;
    }



    //分治法: 最大值和最小值都在左边数组中, 最大值最小值都在右边数组中, 最大值最小值分别位于左边数组或者右边数组中
    //O(nlgn)
    public static int maxDifference3(int[] a){


        return 0;
    }


    //转换法
    /*
    1、有一数组array[n]，数组长度为n

    2、构建一个长度为n-1的辅助数组array2[n-1]，且array2[i] = array[i] - array[i+1]; （0<=i<n-1）

    3、如果累加辅助数组array2从i到j（j>i），即array[i] + array2[i+1] + ... + array2[j]，

    有(array[i] - array[i+1]) + (array[i+1] -array[i+2]) + ... + (array[j] - array[j+1]) = array[i] - array[j+1]

    分析至此，发现数组中最大的数对之差（即array[i] - array[j+1]）其实是辅助数组array2中最大的连续子数组之和。
     */
    public static int maxDifference4(int[] a){
        //int[] b = Arrays.copyOf(a, a.length); //对a进行深拷贝, 长度可以自定义
        int[] temp = new int[a.length - 1];
        for (int i = 0; i < temp.length; i ++){
            temp[i] = a[i+1] - a[i];
        }

        int sum = 0;
        for (int i = 0; i < temp.length; i ++){
            if (sum <= 0){
                sum = temp[i];
            }else {
                sum += temp[i];
            }

        }

        return sum;
    }


    //暴力搜索 O(n^2)
    public static int maxDifference2(int[] a){
        int max = 0;
        for (int i = 0; i < a.length - 1; i ++){
            for (int j = i + 1; j < a.length; j ++){
                if (a[j] - a[i] > max){
                    max = a[j] - a[i];
                }
            }
        }
        return max;
    }

    //寻找下标差值最大的两个数
    //动态规划

}
