package methd_of_programing.string;

import java.util.ArrayList;

/**
 * Created by kentorvalds on 2018/1/15.
 * 给定一个源串和目标串，能够进行如下操作：
     在任意位置上插入一个字符；
     替换掉任意字符；
     删除任意字符。
     写一个程序，实现返回最小操作次数，使得对源串进行上述这些操作后等于目标串。
 */
public class StringEditDistance {
    public static void main(String[] args) {

        String A = "ALGORITHM";
        String B = "ALTRUISTIC";
        getResult(A, B);

        int[] a = {1,2,3,41,5,6,7,8,9,10,23234344};
        int target = 4;
        ArrayList<Integer> arrayList = findNumberModLQ3(a, target);
        System.out.println();
        for (Integer temp:arrayList){
            System.out.print(temp + " ");
        }
        System.out.println();
    }
    public static void getResult(String A, String B) {
        if (A.equals(B)) {
            System.out.println(0);
            return;
        }
        //dp[i][j]表示源串A位置i到目标串B位置j处最低需要操作的次数
        int[][] dp = new int[A.length() + 1][B.length() + 1];
        //边界条件
        for (int i = 1; i <= A.length(); i++)
            dp[i][0] = i;
        for (int j = 1; j <= B.length(); j++)
            dp[0][j] = j;
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1,
                            Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1));
                }
            }
        }
        System.out.println(dp[A.length()][B.length()]);
        return;
    }

    public static ArrayList<Integer> findNumberModLQ3(int[] a, int target){
        int len = a.length;
        ArrayList<Integer> arrayList = new ArrayList<>();

        if (a==null || a.length==0){
            return null;
        }
        for (int i = 0; i < len; i ++){
            if (isVaild(a[i]^target)){
                arrayList.add(a[i]);
            }
        }
        return arrayList;
    }

    //计算二进制中1的个数
    private static int findOneNumsInBin(int num){
        int count = 0;
        while (num!=0){
            num = num & (num-1);
            count ++;
        }
        return count;
    }
    private static boolean isVaild(int n){
        int count = 0;
        while (n != 0){
            if (count == 3){
                return false;
            }
            n = n & (n-1);
            count ++;
        }
        return true;
    }
}
