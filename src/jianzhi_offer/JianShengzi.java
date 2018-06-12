package jianzhi_offer;

/*
 * 面试题14：剪绳子
 * 题目：给你一根长度为n的绳子，请把绳子剪成m段(m和n都是整数，n>1并且m>1)每段绳子的长度记为k[0],k[1],...,k[m].
 * 请问k[0]*k[1]*...*k[m]可能的最大乘积是多少？
 * 例如，当绳子的长度为8时，我们把它剪成长度分别为2,3,3的三段，此时得到的最大乘积是18.
 */
public class JianShengzi {

    public static void main(String[] args) {
        System.out.println(maxAfterCutting(8));
    }
    /**
     * 常规的需要O(n2)的时间复杂度和O(n)的空间复杂度的动态规划思路
     * 题目的意思是:绳子至少是2米，并且必须最少剪一刀。
     */
    public static int maxAfterCutting(int length){
        if(length<2)
            return 0;
        if(length==2)
            return 1;
        if(length==3)
            return 2;
        // 子问题的最优解存储在f数组中，数组中的第i个元素表示把长度为i的绳子剪成若干段后各段长度乘积的最大值。
        int[] f = new int[length+1];
        f[0] = 0;
        f[1] = 1;
        f[2] = 2;
        f[3] = 3;
        int result = 0;
        for(int i = 4;i<=length;i++){
            int max = 0;
            for(int j = 1;j<=i/2;j++){
                int num = f[j]*f[i-j];
                if(max<num)
                    max = num;
                f[i] = max;
            }
        }
        result = f[length];
        return result;
    }
}
