package jianzhi_offer.XunLei;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by kentorvalds on 2018/9/12.
 */
public class Question2 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int B = in.nextInt();
        //System.out.println(28);
        int res = getSum(A, B);
        System.out.println(res);
    }

    public static int getSum(int m, int n){

        int max = 0;
        for (int i = 1; i <= 16; i ++){
            int[] arr = new int[17];
            for (int j = 0; j < 17; j ++){
                if (j <= i){
                    arr[j] = m;
                }else {
                    arr[j] = n;
                }
            }
            ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
            recursionMethod1(arr, 0, arr.length - 1, arrayLists);
            for (ArrayList<Integer> arrs : arrayLists){
                int curSum = 0;
                int curSeven = 0;
                for (Integer t : arrs){
                    curSum += t;
                }
                boolean flag = false;
                for (int k = 0; k < arrs.size() - 7; k ++){
                    for (int l = k; l <= k + 7; l ++){
                        curSeven += arrs.get(l);
                    }
                }
                if (curSeven < 0){
                    if (curSum > max){
                        max = curSum;
                    }
                }

            }
        }
        return max;
    }
    public static void recursionMethod1(int[] arr, int from , int to, ArrayList<ArrayList<Integer>> arrayLists){

        if (to <= 1){
            return;
        }
        if (from == to){
            //String s = Arrays.toString(ch);
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < arr.length; i ++){
                temp.add(arr[i]);
            }
            arrayLists.add(temp);
            //System.out.println(ch);
        }else {
            for(int i=from; i<=to; i++) {
                swap(arr,i,from); //交换前缀，使其产生下一个前缀; 先固定第一个元素,后面的排列
                recursionMethod1(arr, from+1, to, arrayLists);
                swap(arr,from,i); //将前缀换回，继续做上一个前缀的排列
            }
        }




    }

//    public static void recursionMethod(char[] ch, int from , int to){
//
//        if (to <= 1){
//            return;
//        }
//        if (from == to){
//            //String s = Arrays.toString(ch);
//
//            System.out.println(ch);
//        }else {
//            for(int i=from; i<=to; i++) {
//                swap(ch,i,from); //交换前缀，使其产生下一个前缀; 先固定第一个元素,后面的排列
//                recursionMethod(ch, from+1, to);
//                swap(ch,from,i); //将前缀换回，继续做上一个前缀的排列
//            }
//        }
//
//
//
//
//    }
    public static void swap(int[] s,int i,int j) {
        int tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}
