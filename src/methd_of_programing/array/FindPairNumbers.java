package methd_of_programing.array;

import sort.QuickSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created by kentorvalds on 2017/11/13.
 * 1.给定一个数组, 输出满足2a=b(a,b为数组中的数)的数对, 要求时间复杂度尽可能低
 *
 * 2.在给定数组中找出其中和最接近0的两个值
 */
public class FindPairNumbers {

    private static Stack<Integer> stack = new Stack<Integer>();
    private static Stack<Integer> min_stack = new Stack<Integer>();
    public static int[] sumAppFix = {1,4,5,6,10}; //有序数组
    public static int min_diff = sumAppFix[sumAppFix.length-1];

    public static void main(String[] args){
        int[] a = {1,2,3,8,5,6,7,4,9,10};

        int[] b = {-2, 18, 4, -7, 9, 5};

        ArrayList<int[]> list = new ArrayList<>();
        list = getTwoNumberMethod1(a);
        System.out.println("方法1输出满足2a=b(a,b为数组中的数)的数对为: ");
        for (int i = 0; i < list.size(); i ++){
            System.out.println(list.get(i)[0] + " , " + list.get(i)[1]);
        }

        ArrayList<int[]> list1 = new ArrayList<>();
        list1 = getTwoNumberMethod2(a);
        System.out.println("方法2输出满足2a=b(a,b为数组中的数)的数对为: ");
        for (int i = 0; i < list1.size(); i ++){
            System.out.println(list1.get(i)[0] + " , " + list1.get(i)[1]);
        }

        System.out.println("给定数组中找出其中和最接近0的两个值: " + getNearZeroTwoNumbersMethod1(b));



        //
        System.out.println("从数组中找出若干个数, 满足这若干个数的和与m最为接近: ");
        sumAppFix(12, 0, 0);
        for ( int i:min_stack){
            System.out.println(i);
        }


        //
        System.out.println("输入一个正整数n, 输出所有和为n的连续正数序列方法1");
        getNSumNumbers(15);
        //
        System.out.println("输入一个正整数n, 输出所有和为n的连续正数序列方法2");
        getNSumNumbers2(15);
    }

    //给定一个数组, 输出满足2a=b(a,b为数组中的数)的数对, 要求时间复杂度尽可能低
    //方法1: O(n^2)
    public static ArrayList<int[]> getTwoNumberMethod1(int[] a){
        //int[] b = new int[2];
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < a.length; i ++){
            for (int j = 0; j < a.length; j ++){
                int[] b = new int[2];
                if (a[i] == 2*a[j]){
                    b[0] = a[j];
                    b[1] = a[i];
                    list.add(b);
                }
//
            }
        }
        return list;
    }
    //方法2:
    public static ArrayList<int[]> getTwoNumberMethod2(int[] a){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < a.length; i ++){
            hashMap.put(i, a[i]);
        }
        for (int i = 0; i < a.length; i ++){
            if (hashMap.containsValue(2*a[i])){
                int[] b = new int[2];
                b[0] = a[i];
                b[1] = 2*a[i];
                list.add(b);
            }
        }
        return list;
    }


    //在给定数组中找出其中和最接近0的两个值(和的绝对值越小越好): O(nlogn)
    //方法1: 排序, 然后有两个start, end指针分别指向第一个和最后一个, 往中间移动;
    //如果当前值(和的绝对值)比sum小, 则start后移, 如果大则end前移
    public static int getNearZeroTwoNumbersMethod1(int[] a){
        QuickSort.sort(a, 0, a.length - 1);
        int start = 0;
        int end = a.length - 1;
        int sum = Integer.MAX_VALUE;
        int currentSum = 0;
        while (start < end){
            currentSum = Math.abs(a[start] + a[end]);
            if (currentSum > sum){
                end --;
            }
            if (currentSum <= sum){
                sum = currentSum;
                start ++;
            }
        }
        return sum;
    }

    //有n个正实数, 按从小到大的顺序排列, 先给定一个实数m,请从数组中找出若干个数, 满足这若干个数的和与m最为接近
    //如果取当前值, 算法为 sumAppFix(m, sum+a[i]).
    //如果不取当前值, 算法为sumAppFix(m, sum).
    //M为接近的数, index为数组初始下标, curSum为当前和; 初始为M=12, index=0, curSum=0, {1,4,5,6,10}
    public static void sumAppFix(int M, int index, int curSum){
        // 若当前和与m的差值小于最小差值, 更新最小差值为当前差值. 并将栈内元素保存在最小栈中.
        if(Math.abs(M - curSum) < min_diff){ //min_diff为数组最大值
            min_diff = Math.abs(M - curSum);//每找到最小的差值就更新min_stack和min_diff
            min_stack = (Stack<Integer>) stack.clone();
        }

        // 若索引大于数组长度, 返回
        if( index >= sumAppFix.length){
            return;
        }

        stack.push(sumAppFix[index]);                   // 如果包含当前元素,将其压入栈中.
        sumAppFix(M, index+1, curSum+sumAppFix[index]); // 若当前元素包含在内, 判断下一个元素.
       // System.out.println("kkkkkkk: " + (index ) + " ; " + curSum);
        stack.pop();                                    // 若不包含当前元素, 将其从栈中删除.
        sumAppFix(M, index+1, curSum);                  // 若不包含当前元素, 判断下一个元素.
        //System.out.println("tttttttt: " + (index ) + " ; " + curSum);
    }

    //寻找和为定值的连续序列
    /*
    输入一个正整数n, 输出所有和为n的连续正数序列, 例如: 输入15, 则输出1+2+3+4+5, 4+5+6, 7+8
     */
    //方法1: 用small和big两个指针移动
    public static void getNSumNumbers(int n){
        if (n < 3){
            return;
        }

        int small = 1;
        int big = 2;
        int middle = (1 + n)/2;
        int sum = small + big;
        while (small < middle){
            //如果所求sum刚好满足, 则输出从small到big的序列
            if (sum == n){
                System.out.println("所求序列为: " );
                for (int i = small; i <= big; i ++){
                    System.out.print( i + " , ");
                }

                System.out.println();
            }

            //如果sum大于n, 则从sum中减去small, small右移一位
            while (sum > n){
                sum = sum - small;
                small = small + 1;
                if (sum == n){
                    System.out.println("所求序列为: " );
                    for (int i = small; i <= big; i ++){
                        System.out.print(i + " , ");
                    }
                    System.out.println();
                }
            }
            //big右移一位
            big = big + 1;
            sum = sum + big;
        }
    }
    //K个连续的正数和为N的起始数(第一个数)为x, 则x+(x+1)+(x+2)+...+(x+k-1)=N
    //则x=(N-k*(k-1)/2)/k, 当x小于等于0时退出; 例如N=15, 则可以有1+2+3+4, 4+5+6, 7+8
    //比如4+5+6: k=3, N=15, x=4, 则起始位置为4
    public static void getNSumNumbers2(int n){

        int k = 2; //起始的连续正数的个数为2
        int x, m; //x表示起始数, m用于判断是否满足条件
        while (true){
            x = (n-k*(k-1)/2)/k;
            m = (n-k*(k-1)/2)%k;
            if (x <= 0){
                break;
            }
            if (m == 0){
                System.out.println("满足条件的序列为: ");
                for (int i = x; i < x+k; i++){
                    System.out.print(i + " , ");
                }
                System.out.println();
            }
            k ++;
        }
    }



}
