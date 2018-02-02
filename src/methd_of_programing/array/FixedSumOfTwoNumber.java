package methd_of_programing.array;

import sort.MergeSort;

import java.util.HashMap;

/**
 * Created by kentorvalds on 2017/10/17.
 * 和为定值的两个数:
 * 输入一个整数数组和一个整数,在数组中查找出一对数,满足他们的和正好是输入的那个整数,如果有多对则输出任意一对即可
 * 例如:输入数组[1,2,4,5,7,11,15]和整数15
 * 则输出:4和11
 */
public class FixedSumOfTwoNumber {


    public static void main(String[] args){
        int[] arr = {1,2,4,5,7,11,15,9,6};

        System.out.println("散列映射法:");
        sumIsFixedMethod1(arr, 15);

        System.out.println("排序夹逼法:");
        sumIsFixedMethod2(arr, 15);

        System.out.println("暴力法:");
        sumIsFixedMethod3(arr, 15);



    }



    //方法1:散列映射
    public static void sumIsFixedMethod1(int[] arr, int sum){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i ++){
            hashMap.put(i, arr[i]);
        }

        for (int i = 0; i < arr.length; i ++){
            if (hashMap.containsValue(sum - hashMap.get(i))){
                System.out.println("the two numbers are : " + hashMap.get(i) + " , " + (sum - hashMap.get(i)));
            }
        }
    }

    //方法2:排序夹逼
    public static void sumIsFixedMethod2(int[] arr, int sum){
        //第一步排序:归并排序 O(nlogn)
        MergeSort.sort(arr, 0, arr.length - 1);
        //第二步:夹逼 O(n)
        int start = 0;
        int end = arr.length - 1;
        while (start < end){
            int currSum = arr[start] + arr[end];
            if (currSum == sum){
                System.out.println("the two numbers are : " + arr[start] + " , " + arr[end]);
                start ++;
            }else {
                if (currSum < sum){
                    start ++;
                }else {
                    end --;
                }
            }
        }

    }


    //暴力解决
    public static void sumIsFixedMethod3(int[] arr, int sum){
        for (int i = 0; i < arr.length - 1; i ++){
            for (int j = i + 1; j < arr.length; j ++ ){
                if ((arr[i] + arr[j]) == sum){
                    System.out.println("the two numbers are : " + arr[i] + " , " + arr[j]);
                }
            }
        }
    }
}
