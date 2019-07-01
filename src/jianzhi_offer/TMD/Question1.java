package jianzhi_offer.TMD;

import java.util.Scanner;

/**
 * Created by kentorvalds on 2018/10/8.
 */
public class Question1 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b= in.nextInt();
        int k = in.nextInt();
        int res = findBeautiNumber(a, b, k);
        System.out.println(res);
//        int temp1 = 0;
//        int start1 = 11;
//        boolean flag = true;
//        while(start1 != 0){
//            int temp = start1%10;
//            temp1 += temp;
//            start1 = start1/10;
//            if(temp != 1 && temp != 2){
//                flag = false;
//                break;
//            }
//        }
//        if (flag && (temp1 == 1 || temp1 == 2)){
//            System.out.println("aaaaaa");
//        }
    }

    public static int findBeautiNumber(int a, int b, int k){
        int start = (int)Math.pow(10, k-1);
        int end = (int)Math.pow(10, k)  - 1;

        int count = 0;
        while (start <= end){
            int temp1 = 0;
            int start1 = start;
            boolean flag = true;
            while(start1 != 0){
                int temp = start1%10;
                temp1 += temp;
                start1 = start1/10;
                if(temp != a && temp != b){
                    flag = false;
                    break;
                }
            }
            if (flag && (temp1 == a || temp1 == b)){
                count ++;
            }
            start = start + 1;
        }
        return count;
    }
}
