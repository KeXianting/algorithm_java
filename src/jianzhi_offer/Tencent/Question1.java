package jianzhi_offer.Tencent;

import java.util.*;

/**
 * Created by kentorvalds on 2018/9/16.
 */
public class Question1 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        ArrayList<Integer> nLCM = new ArrayList<>();
        ArrayList<Integer> mLCM = new ArrayList<>();
        for (int i = 1; i <= Math.pow(10, 6) - N; i ++){

            for (int j = 1; j <= i - N; j ++){
                nLCM.add(N + j);
            }
            for (int k = 1; k <= i; k ++){
                mLCM.add(k);
            }
            if (nLCM.size() > 0 && mLCM.size() > 0){
                Integer[] nlcm = nLCM.toArray(new Integer[nLCM.size()]);
                Integer[] mlcm = mLCM.toArray(new Integer[mLCM.size()]);
                int nMin = getMinLCM(nlcm, nlcm.length);
                int mMin = getMinLCM(mlcm, mlcm.length);
                if (nMin == mMin){
                    System.out.println(i);
                    return;
                }
            }
        }

    }

    public static int getMinLCM(Integer[] a, int n){
       if (n == 1){
           return a[0];
       }else {
           return getTwoLCM(a[n-1], getMinLCM(a, n -1));
       }
    }

    public static int getTwoLCM(int a, int b){
        return a/getGCD(a, b)*b;
    }
    public static int getGCD(int a, int b){
        if (b == 0){
            return a;
        }
        return getGCD(b, a%b);
    }
}
