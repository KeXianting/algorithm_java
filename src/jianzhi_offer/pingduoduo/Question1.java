package jianzhi_offer.pingduoduo;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by kentorvalds on 2018/8/30.
 */
public class Question1 {
    private static final int LENGTH = 4000;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int a = in.nextInt();
            int b = in.nextInt();
            BigDecimal demical = new BigDecimal(Integer.toString(a));
            int[] res = getCycle(demical, b);
//            //
//            int[] res = getRepetend(a, b);
            System.out.println(res[0] + " " + res[1]);

        }
//        int d = 1;
//        int limit = 1000;
//        BigDecimal demical = new BigDecimal("2");
//        int maxCycle = 0;



       // int[] res = getCycle(demical, 3);
    }
    private static int[] getCycle(BigDecimal demical, int divisor) {
        int cycle = 0;
        int cycletmp = 0;
        int start = 0;
        String cyclePart = "";
        String cyclePartTmp = "";
        BigDecimal small = demical.divide(BigDecimal.valueOf(divisor), LENGTH, BigDecimal.ROUND_DOWN);
        String digits = small.toString().substring(2);//取小数部分
        System.out.println(digits);
//		System.out.println(digits);
        for (int i = 0; i < digits.length(); i++) {
            for (int j = i, k = 1; k < (digits.length() - i) / 2; k++) {
                if (digits.substring(j, j + k).equals(digits.substring(j + k, j + 2 * k))) {
                    cycletmp = k;
                    cyclePartTmp = digits.substring(j, j + k);
                    break;
                }
            }
            if (cycletmp > cycle) {
                cycle = cycletmp;
                cyclePart = cyclePartTmp;
                start = i;
            }
            cyclePartTmp = "";
            cycletmp = 0;

        }
        //System.out.println(small.toString());
       // System.out.println(small.toString().substring(0, start + 2) + "(" + cyclePart + ")");
        //System.out.println("cyclePartLength: " + cycle + "; start: " + start);
        int[] res = new int[2];
        res[0] = start;
        if (start == digits.length()){
            res[1] = 0;
        }else {
            res[1] = cycle;
        }

        return res;
    }
}
