package jianzhi_offer.XunLei;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by kentorvalds on 2018/9/28.
 */
public class TestMain {
    public static void main(String[] args) {

        int a, b;
        Scanner in = new Scanner(System.in);
        int count = 0;
        int testNumber = in.nextInt();
        ArrayList<Integer> res = new ArrayList<Integer>();
        while(in.hasNextInt()) {
            a = in.nextInt();
            b = in.nextInt();
            //
            System.out.println("++++ " + findCommonValue(a, b));
            res.add(findCommonValue(a, b));
            count ++;
            if(count == testNumber){
                return;
            }
        }
        for(Integer r : res){
            System.out.println(r);
        }
    }

    public static int findCommonValue(int m, int n){
        //
        while(m > 0 && n > 0){
            if(m == n){
                return m;
            }else{
                if(m % 2 == 0){
                    m = m / 2;

                }else{
                    m = (m - 1) / 2;
                }
                if(m % 2 == 0){
                    n = n >> 1;
                }else{
                    n = (n - 1) >> 1;
                }
            }
        }
        return -1;
    }
}
