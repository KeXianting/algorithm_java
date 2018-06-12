package test.bishi;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by kentorvalds on 2018/4/9.
 * 明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机生成了N个1到1000之间的随机整数（N≤1000），对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。然后再把这些数从小到大排序，按照排好的顺序去找同学做调查。请你协助明明完成“去重”与“排序”的工作。





 Input Param

 n               输入随机数的个数

 inputArray      n个随机整数组成的数组



 Return Value

 OutputArray    输出处理后的随机整数




 注：测试用例保证输入参数的正确性，答题者无需验证。测试用例不止一组(意味着可以多次输入)。







 输入描述:
 输入多行，先输入随机整数的个数，再输入相应个数的整数



 输出描述:
 返回多行，处理后的结果


 输入例子1:
 11
 10
 20
 40
 32
 67
 40
 20
 89
 300
 400
 15

 输出例子1:
 10
 15
 20
 32
 40
 67
 89
 300
 400
 */
public class HUAWEI2 {

    public static void main(String[] args){
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        do {
            int N = sc.nextInt();
            if (N > 1000 || N <= 0){
                return;
            }
            int[] inputArray = new int[N];
            for (int i = 0; i < N; i ++){
                inputArray[i] = sc.nextInt();
            }
            for (int i = 1; i < N; i ++){
                for (int j = 0; j < i; j++){
                    if (inputArray[j] == inputArray[i]){
                        inputArray[i] = 0;
                    }
                }
            }
            quickSort(inputArray, 0, inputArray.length - 1);
            for (int i = 0 ;i < inputArray.length; i ++){
                if (inputArray[i] != 0){
                    System.out.println(inputArray[i]);
                }
            }
        }while (sc.hasNext());
        sc.close();




    }

    public static void quickSort(int[] num, int left, int right){
        if (left < right) {
            int index = partition(num, left, right);//基准元素的下标, 数组的划分调用
            quickSort(num, left, index-1);
            quickSort(num, index, right);
        }

    }
    public static int partition(int[] num, int left, int right){
        if(num==null || num.length<=0 || left<0 || right>=num.length){
            return 0;
        }
        int prio = num[left + (right - left) / 2]; //基准元素, 中间位置, 可以是第一个或者最后一个
        while(left<=right){
            while (num[left] < prio)
                left++; //如果比基准元素小的位置不动
            while (num[right] > prio)
                right--; //如果比基准元素大的位置不动
            if (left<=right) { //如果有左边的元素大于右边的元素, 则进行交换
                swap(num, left, right);
                left++;
                right--;
            }
        }
        return left;
    }
    public static void swap(int[] num, int left, int right) {
        int temp = num[left];
        num[left] = num[right];
        num[right] = temp;
    }
}
/*
11
10
20
40
32
67
40
20
89
300
400
15

10
15
20
32
40
67
89
300
400
 */