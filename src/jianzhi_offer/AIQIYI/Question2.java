package jianzhi_offer.AIQIYI;

import java.util.Scanner;

/**
 * Created by kentorvalds on 2018/9/15.
 */
public class Question2 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        String str = in.next();
        int len = str.length();
        int sumL = 0;
        int sumR = 0;
        for (int i = 0; i < len - 3; i ++){
            char left = str.charAt(i);
            char right = str.charAt(i+3);
            Integer leftI = Integer.parseInt(String.valueOf(left));
            Integer rightI = Integer.parseInt(String.valueOf(right));
            sumL += leftI;
            sumR += rightI;

        }
        if (sumL == sumR){
            System.out.println(0);
            return;
        }
        int abs = sumL > sumR ? (sumL - sumR) : (sumR - sumL);
        if (abs > 0 && abs <= 9){
            System.out.println(1);
        }else if (abs > 9 && abs <= 18){
            System.out.println(2);
        }else {
            System.out.println(3);
        }
    }
}
