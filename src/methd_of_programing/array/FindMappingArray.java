package methd_of_programing.array;

/**
 * Created by kentorvalds on 2017/12/3.
 * 根据上排给出十个数，在其下排填出对应的十个数
 要求下排每个数都是先前上排那十个数在下排出现的次数。
 上排的十个数如下：
 【0，1，2，3，4，5，6，7，8，9】
 举一个例子，
 数值: 0,1,2,3,4,5,6,7,8,9
 分配: 6,2,1,0,0,0,1,0,0,0
 0 在下排出现了 6 次，1 在下排出现了 2 次，
 12
 2 在下排出现了 1 次，3 在下排出现了 0 次....
 以此类推..



 思路：


 设上排的数字用 a[i]表示, 下排的数字用b[i]表示，每排有n个数字。则应满足条件：

 ① ∑b[i] = n   下排所有数字的和为n

 ②∑a[i]*b[i] = n  上下排对应的数字乘积相加的和为n

 ③ 下排出现了 b[i] 个 a[i]

 ④b[i] 一定小于 n

 方法是暴力查找，从全0开始 尝试所有的0-n的数字组合

 在每次选择一个数字后，先用∑a[i]*b[i] <= n 和 ∑b[i] <= n 的条件去掉一大部分不符合条件的 相当于截枝 加快速度

 然后对每次选定所有下排的数后，验证是否满足条件① 和 ③(满足这两个条件 其他的条件一定满足) 满足则返回。
 */
public class FindMappingArray {

    public static void main(String[] args){
        int a[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] b = new int[a.length];
        boolean isFind = findMapppingArray(a, b, a.length, b.length);

        System.out.println("输出原数组: ");
        for (int i = 0; i < a.length; i ++){
            System.out.print(a[i] + " , ");
        }
        System.out.println();
        System.out.println("数组映射数组: ");
        if (isFind){
            for (int i = 0; i < b.length; i ++){
                System.out.print(b[i] + " , ");
            }
        }else {
            System.out.println("can not find....");
        }
    }

    ////检查，已有数字加起来的和是否超过n
    //∑b[i] = n   下排所有数字的和为n
    private static boolean checkSum(int[] a, int n){
        int sum = 0;
        for (int j = 0; j < n; j++)
        {
            sum += a[j];
        }
        return (sum == n) ;
    }
    //检查组成是否满足 “下排每个数都是先前上排那十个数在下排出现的次数。”
    //∑a[i]*b[i] = n  上下排对应的数字乘积相加的和为n
    private static boolean checkComponet(int[] a, int[] b, int n){
        for (int i = 0; i < n; i++)
        {
            int num = 0;
            for (int j = 0; j < n;j++)
            {
                if (b[j] == a[i])
                {
                    num++;
                }
            }
            if (num != b[i])
            {
                return false;
            }
        }
        return true;
    }
    //a: 输入数组; b: 输出数组; n: 一共有多少个数字; num:当前要确定第几个数字
    public static boolean findMapppingArray(int[] a, int[] b, int n, int num){
        boolean isFind = false;
        for (int i = 0; i < n; i++)
        {
            b[num - 1] = i; //设当前数为i

            //根据和 与 积 不能大于n 去掉大部分错误的尝试
            int product = 0;
            int sum = 0;
            for (int j = num - 1; j < n; j++)
            {
                product += b[j]*a[j];//乘积的和
                sum += b[j];
            }
            if (sum > n || product > n)
            {
                break;
            }


            if (num == 1)
            {
                if (checkComponet(a, b, n) && checkSum(b, n))
                {
                    isFind = true;
                }
            }
            else
            {
                isFind = findMapppingArray(a, b, n, num - 1);
            }

            if (isFind == true)
            {
                break;
            }

        }
        return isFind;
    }
}
