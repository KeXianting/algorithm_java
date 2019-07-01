package jianzhi_offer.XunLei;

import java.util.Scanner;

/**
 * Created by kentorvalds on 2018/9/12.
 */
public class Question1 {

    private final static boolean[] used = new boolean[1000000 + 10];
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int res = getNumberOfSu(N);
        System.out.println(res);


    }

    public static int getNumberOfSu(int n){
        int a, b, c;
        int cnt = 0;
        for (int i = 1; i < Math.sqrt(n + 0.5); i ++){
            for (int j = i + 1; j*i<= n; j += 2){
                if (getValue(i,j) == 1){
                    a = j*j -i*i;
                    b = 2*i*j;
                    c = i*i + j*j;
                    if (c <= n){
                        cnt ++;
                        if (!used[b]){
                            used[b] = true;
                        }
                        if (!used[c]){
                            used[c] = true;
                        }
                    }
                    for (int k = 2; k*c <= n; k ++){
                        if (!used[k*a]){
                            used[k*a] = true;
                        }
                        if (!used[k*b]){
                            used[k*b] = true;
                        }
                        if (!used[k*c]){
                            used[k*c] = true;
                        }
                    }
                }
            }
        }
        return cnt;
    }

    public static int getValue(int a, int b){
        if (a % b == 0){
            return b;
        }else {
            return getValue(b, a % b);
        }
    }
}
