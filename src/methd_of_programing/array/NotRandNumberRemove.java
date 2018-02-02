package methd_of_programing.array;

import java.util.BitSet;
import java.util.Random;

/**
 * Created by kentorvalds on 2018/1/4.
 * 现在有1千万个随机数，随机数的范围在1到1亿之间。现在要求写出一种算法，将1到1亿之间没有在随机数中的数求出来
 *
 * 利用位图法求解(java中的bitSet)
 */
public class NotRandNumberRemove {

    private static int N = 10000000;
    private static int M = 100000000;
    public static void main(String[] arg){
        int[] randomNums = new int[N];
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            randomNums[i] = random.nextInt(M);//随机1-20之间的数
        }
        System.out.println("产生的在[1," + M + "]之间的" + N + "个随机数:");
        for (int i = 0; i < N; i ++){
            System.out.print(randomNums[i] + " ");
        }

        //设置一个1亿位的位图
        BitSet bitSet = new BitSet(M);
        for (int i = 0; i < N; i ++){
            bitSet.set(randomNums[i]);
        }


        //
        System.out.println();
        System.out.println("其中不包括的随机数:");
        for (int i = 1; i < M; i ++){
            if (!bitSet.get(i)){
                System.out.print(i + " ");
            }
        }
    }
}
