package jianzhi_offer.pingduoduo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by kentorvalds on 2018/8/30.
 */
public class Question3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int a = in.nextInt();
            int b = in.nextInt();
            //
            int[] res = getRepetend(a, b);
            System.out.println(res[0] + " " + res[1]);

        }
    }
    public static int[] getRepetend(int a, int b){
        int[] res = new int[2];
        if (a == 0 || b == 0){
            res[0] = 0;
            res[1] = 0;
            return res;
        }
        if (a < 0){
            a = -a;
        }
        if (b < 0){
            b = -b;
        }
        if(a > Integer.MAX_VALUE || b > Integer.MAX_VALUE || a < Integer.MIN_VALUE || b < Integer.MIN_VALUE){
            res[0] = 0;
            res[1] = 0;
            return res;
        }
        for (; a*10<b;){
            a = a * 10;
        }
       // int[] rem = new int[255];
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, a%b);
        //rem[0] = a%b;
        for (int i = 0; i <= Integer.MAX_VALUE; i++){
            //a = rem[i]*10;
            a = (Integer) (arrayList.get(i))*10;
            //rem[i+1] = a%b;
            arrayList.add(i+1, a%b);
            if (arrayList.get(i+1).equals(0)){
                res[0] = i+1;
                res[1] = 0;
                return res;
            }
            for (int j = 0; j <= i; j++){
                if (arrayList.get(i+1).equals(arrayList.get(i))){
                    res[0] = j;
                    res[1] = i - j + 1;
                    return res;
                }
            }
        }
        return res;

    }

}
