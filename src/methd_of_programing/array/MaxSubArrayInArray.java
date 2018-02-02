package methd_of_programing.array;

/**
 * Created by kentorvalds on 2018/1/14.
 * 从N个整数中找了(n-1)个元素乘积最大的那一组
 */
public class MaxSubArrayInArray {

    public static void main(String[] arg){
        int[] a = {1,2,3,4,5,1,1,90, 6,7,8};
        System.out.println("最大n-1个数的乘积为: " + getMaxSubMultiMehtod1(a));
    }

    //方法1:
    /*
    s[i]表示数组前i个元素的乘积, 1<=i<=n, s[0]=1(边界)
    t[i]表示数组后(n-1)个元素乘积
    s[i]=s[i-1]*a[i-1]
    t[i]=t[i+1]*a[i]
    p[i]表示除了第i个元素外其他元素的乘积:p[i]=t[i+1]*a[i]
     */
    public static int getMaxSubMultiMehtod1(int[] a){
        int n = a.length;
        int[] s = new int[n];
        int[] t = new int[n+1];
        int[] p = new int[n+1];
        s[0] = 1;//s的边界条件
        t[n] = 1;//t的边界条件

        for (int i = 1; i < n; i ++){
            s[i] = s[i-1]*a[i];
        }
        for (int i = n-1; i >= 1; i--){
            t[i] = t[i+1]*a[i];
        }

        int max = 1;
        int delMaxIndex = 0;
        for (int i = 1; i<=n; i ++){
            if (p[i] > max){
                max = p[i];
                delMaxIndex = i;
            }
        }

        System.out.println("取出的元素为: " + a[delMaxIndex]);
        return max;
    }
}
