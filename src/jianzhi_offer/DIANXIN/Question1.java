package jianzhi_offer.DIANXIN;

import java.util.Scanner;

/**
 * Created by kentorvalds on 2018/9/10.
 */
public class Question1 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//注意while处理多个case
            int[] arr = new int[26];
            String str = in.nextLine();
            for (int i = 0; i < str.length(); i++){
                char ch = str.charAt(i);
                int n = ch - 'a';
                arr[n] ++;
            }
            int minVal = Integer.MAX_VALUE;
            for (int i = 0; i < 26; i ++){
                if(arr[i] != 0 && arr[i] < minVal){
                    minVal = arr[i];
                }
            }
            for (int i = 0; i < str.length(); i ++){
                char ch = str.charAt(i);
                int m = ch - 'a';
                if (arr[m] != minVal){
                    System.out.print(ch);
                }
            }
            System.out.println();
        }
    }


}
