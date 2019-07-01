package jianzhi_offer.pingduoduo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by kentorvalds on 2018/8/30.
 */
public class Question4 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();

        String[] strs = new String[a+1];
        for (int i = 0; i < a+1; i ++){
            strs[i] = in.nextLine();
        }
        String res = getMinStr(strs);

        //System.out.println("MMMM: ");
        System.out.println(res);

    }

    public static String getMinStr(String[] strs){

        StringBuilder sbb = new StringBuilder();
        for (int i = 0; i < strs[1].length(); i ++){
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j < strs.length; j ++){
                sb.append(strs[j].charAt(i));
                //System.out.println(strs[i]);
            }
            String temp = getSortedMinStr(sb);
          //  System.out.println("TEMP: " + temp);
            sbb.append(temp);
        }
        return sbb.toString();
    }

    public static String getSortedMinStr(StringBuilder sb){
        String s = sb.toString();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        return String.valueOf(chars[0]);
    }
}
