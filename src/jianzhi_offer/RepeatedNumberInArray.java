package jianzhi_offer;

import java.util.ArrayList;

/**
 * Created by kentorvalds on 2018/6/12.
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数字2或者3
 */
public class RepeatedNumberInArray {

    public static void main(String[] args){

        int[] arr = {2,3,1,0,2,5,3,6,4,5};
        ArrayList<Integer> brr = new ArrayList<>();
        System.out.println("是否有重复: " + duplicate(arr, brr));

        for (int i:brr){
            System.out.print(i + ", ");
        }

    }

   static boolean duplicate(int[] arr, ArrayList<Integer> brr){
        boolean flag = false;

        if (arr == null || arr.length <= 0){
            return flag;
        }
        for (int i = 0; i < arr.length; i ++){
            if (arr[i] < 0 || arr[i] > arr.length - 1){
                return flag;
            }
        }

        for (int i = 0; i < arr.length; i ++){
            while (arr[i] != i){
                if (arr[i] == arr[arr[i]]){//有重复的
                    flag = true;
                    brr.add(arr[i]);
                    //System.out.println(arr[i]);
                    //return flag;
                }
                int temp = arr[i];
                arr[i] = arr[temp];
                arr[temp] = temp;
                if (flag){
                    break;
                }



            }
        }
        return flag;
    }
}
