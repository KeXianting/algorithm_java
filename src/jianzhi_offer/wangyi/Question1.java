package jianzhi_offer.wangyi;

import java.util.Scanner;

/**
 * Created by kentorvalds on 2018/9/8.
 */
public class Question1 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//注意while处理多个case
            String s = in.nextLine();
            //System.out.println(s);
            //不同的反转后的所有字符串
            String[] strs = getAllStr(s);

            //判断所有字符串中满足黑白相交的最长字符串
            int maxCount = getMaxCount(strs);

            System.out.println(maxCount);
        }

//        String s = in.nextLine();
//        System.out.println(s);
//        //不同的反转后的所有字符串
//        String[] strs = getAllStr(s);
//
//        //判断所有字符串中满足黑白相交的最长字符串
//        int maxCount = getMaxCount(strs);
//        System.out.println(maxCount);

    }

    public static String[] getAllStr(String s){
        String[] strs = new String[s.length()];
        for (int i = 0; i < s.length(); i ++){
            String temp = new StringBuilder(s.substring(0, i)).reverse().toString() + new StringBuilder(s.substring(i, s.length())).reverse().toString();
            strs[i] = temp;

        }
        return strs;
    }

    public static int getMaxCount(String[] strs){
        int maxCount = 0;
        for (int i = 0; i < strs.length; i ++){
            String s = strs[i];
            int len = 1;
            int maxLen = 0;
            for (int j = 0; j < s.length() - 1; j ++){
                if (s.charAt(j) != s.charAt(j + 1)){
                    len = len + 1;
                }else {
                    len = 1;
                }

                if (maxLen < len){
                    maxLen = len;
                }
            }
            if (maxCount < maxLen){
                maxCount = maxLen;
            }
        }
        return maxCount;
    }
}
