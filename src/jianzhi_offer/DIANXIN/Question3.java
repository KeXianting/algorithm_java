package jianzhi_offer.DIANXIN;

import java.util.Scanner;

/**
 * Created by kentorvalds on 2018/9/10.
 */
public class Question3 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//注意while处理多个case
            String s1 = in.next();
            String s2 = in.next();
            int maxLen = 0;
            if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0){
                maxLen = 0;
            }else if (s1.length() >= s2.length()){
                maxLen = getMaxValue(s1, s2);
            }else {
                maxLen = getMaxValue(s2, s1);
            }
            System.out.println(maxLen);

        }
    }

    public static int getMaxValue(String s1, String s2){

        int len1 = s1.length();
        int len2 = s2.length();
        int maxLen = 0;
        int start = 0;
        if (len1 > len2){
            start = len1 - len2;
        }
        for (; start < len1; start ++){
            int temp = len1 - start;
            String sA = s1.substring(start);
            String sB = s2.substring(0, temp);
            if (sA.equals(sB)){
                if (temp > maxLen){
                    maxLen = temp;
                    break;
                }
            }
        }


        return maxLen;

    }
}
