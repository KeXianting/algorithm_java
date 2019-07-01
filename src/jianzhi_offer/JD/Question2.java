package jianzhi_offer.JD;

import java.util.Scanner;

/**
 * Created by kentorvalds on 2018/9/9.
 * 3
 1 4 2
 4 3 2
 2 5 3
 */
public class Question2 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
       // while (in.hasNext()) {//注意while处理多个case
            int N = in.nextInt();
            int[][] arr = new int[N][3];
            for (int i = 0; i < N; i++) {
                arr[i][0] = in.nextInt();
                arr[i][1] = in.nextInt();
                arr[i][2] = in.nextInt();

            }
            int res = getNotSatisfy(arr);
            System.out.println(res);
      //  }
    }

    public static int getNotSatisfy(int[][] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i ++){
            boolean flag = false;
            for (int j = 0; j < i; j ++) {
                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1] && arr[i][2] < arr[j][2]) {
                    sum++;
                    flag = true;
                    break;
                }
            }
            if (!flag){
                for (int j = i + 1; j < arr.length; j ++) {
                    if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1] && arr[i][2] < arr[j][2]) {
                        sum++;
                        break;
                    }
                }
            }

        }
        return sum;
    }

//    public static int[][] getRestArr(int[][] arr, int index){
//        //去除arr中第i行
//        int[][] temp = new int[arr.length-1][3];
//        for (int i = 0; i < index; i ++){
//            temp[i][0] = arr[i][0];
//            temp[i][1] = arr[i][1];
//            temp[i][2] = arr[i][2];
//        }
//        for (int i = index + 1; i < arr.length; i ++){
//            temp[i-1][0] = arr[i][0];
//            temp[i-1][1] = arr[i][1];
//            temp[i-1][2] = arr[i][2];
//        }
//        return temp;
//    }
}
