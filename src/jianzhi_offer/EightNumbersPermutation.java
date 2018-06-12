package jianzhi_offer;

/**
 * Created by kentorvalds on 2018/4/8.
 *  输入一个含有8个数字的数组，判断有么有可能把这8个数字分别放到正方体的8个顶点上，使得正方体上三组相对的面上的4个顶点的和相等。

 思路：相当于求出8个数字的全排列，判断有没有一个排列符合题目给定的条件，即三组对面上顶点的和相等。
 */
public class EightNumbersPermutation {

    public static void main(String[] args){
        int[] A = {1,2,3,1,2,3,2,2};
        int[] B = {1,2,3,1,8,3,2,2};
        if (isCub(A,0,A.length-1)){
            System.out.println("A is YES");
        }else {
            System.out.println("A is NO");
        }

        if (isCub(B, 0, B.length - 1)){
            System.out.println("A is YES");
        }else {
            System.out.println("B is NO");
        }

    }

    public static boolean isCub(int[] a, int from, int to){
        if (to <= 1){
            return false;
        }
        boolean result = false;
        if (from == to){
            //System.out.println();
            if ((a[0]+a[1]+a[2]+a[3]) == (a[4]+a[5]+a[6]+a[7]) &&
                    (a[1]+a[3]+a[5]+a[7]) == (a[0]+a[2]+a[4]+a[6])&&
                    (a[0]+a[1]+a[4]+a[5]) == (a[2]+a[3]+a[6]+a[7])) {
                for (int i = 0; i < a.length; i++) {
                    System.out.print(a[i] + " ");
                }
                System.out.println();
                return true;
            }
        }else {
            for (int j = from; j <= to; j ++){
                swap(a,j,from);
                result = isCub(a,from+1, to);
                if (result){
                    break;
                }
                swap(a,from,j);
            }
        }
        return result;
    }

    public static void swap(int[] s,int i,int j) {
        int tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}
