package jianzhi_offer.beike;

import java.util.Scanner;

/**
 * Created by kentorvalds on 2018/9/3.
 */
public class Question2 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {//注意while处理多个case
           int N = in.nextInt();
            int M = in.nextInt();

            int res = getTimes(N, M);
            System.out.println(res);
        }



    }

    //
    public static int getTimes(int N, int M){


        if (N > M){
            return N - M;
        }
        if (N < M && M%N==0){
            return M/N;
        }

        if (N < M && M%N != 0 ){
            int temp = M%N;
            int a = N - temp;
            int count1 = 0;
            while (a < M && a > 0){
                a *= 2;
                count1 ++;
            }
            if (a > M){
                count1 = count1 + a - M + 1;
            }

            int count2 = 0;
            while (N < M){
                N *= 2;
                count2 ++;
            }
            if (N > M){
                count2 = count2 + N - M + 1;
            }
            return Math.min(count1, count2);

        }
        if (M == N){
            return 0;
        }

        if (N < 0 && M > 0){
            return 0;
        }


        return 0;
    }


}
