package jianzhi_offer.Tencent;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by kentorvalds on 2018/9/16.
 */
public class Question3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[][] arr = new int[t][3];
        ArrayList<Boolean> r = new ArrayList<>();
        for (int i = 0; i < t; i ++){
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
            arr[i][2] = in.nextInt();
            boolean res = getOneNumber(arr[i]);
            r.add(res);

        }

        for (Boolean b : r){
            if (b){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }

    public static boolean getOneNumber(int[] arr){
        for (int i = 0; i < arr.length; i ++){
            if (arr[i] % arr[0] == 0){
                if (arr[i] % arr[1] == arr[2] || ((arr[0] + arr[1])%arr[1] == arr[2]) || ((arr[1] + arr[2])%arr[1] == arr[2])
                || ((arr[0] + arr[2])%arr[1] == arr[2]) || ((arr[0] + arr[1] + arr[2])%arr[1] == arr[2])){
                    return true;
                }
            }
        }
        return false;
    }


}
