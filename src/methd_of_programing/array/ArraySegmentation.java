package methd_of_programing.array;

/**
 * Created by kentorvalds on 2017/12/3.
 * 数组分割: 给定一个数组, 长度为n, 将其分为m份, 使各份的和相等, 求m的最大值
 *
 划分为m块时，需要具备的条件：
 m的取值为1~n
 每一部分之和为 sum/m; （sum为数组元素之和）
 sum % m == 0，否则不可能平分

 递归思想：
 假设分为m块，每一块之和即为subSum = sum / m。subSum即为每一块元素之和。
 如果array[i]在某一个块中，则需要在数组的其中元素中找出和值为(subSum - array[i])的组合。
 利用bool数组标记元素是否已分配到每一块中。
 */
public class ArraySegmentation{

    /*
                  一个整数数组，长度为n，将其分为m份，使各份的和相等，求m 的最大值 比如{3，2，4，3，6}
	 *            可以分成{3，2，4，3，6} m=1; {3,6}{2,4,3} m=2 {3,3}{2,4}{6} m=3 所以m
	 *            的最大值为3
     */
    public static void main(String[] args) {

        int[] a = { 3, 2, 4, 3, 6 };
        int n = a.length;
        System.out.println("原数组：");
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
        getMax(a, n);
    }

    /*
 * 既然要分成m等份，则数组的和对m取余数肯定为0，且m的取值范围为1<m<=n，既然
 * 求m的最大值，则让m从n开始递减，第一个满足条件的即为m的最大取值。设数组为a,
 * 数组的和为sum，设一临时数组temp来存储分组情况，groupID表示分组编号
 * 比如temp[i]=1，则说明a[i]分在第一组。
 * 当sum%m不等于0时，跳过，m递减；当sum%m等于0时，遍历数组中每个元素，若当前
 * 元素状态为未选择，即temp[i]=0，将其分配到相应组中，进行如下判断：
 * a.若组内元素和>sum/m,则说明当前元素不适合加入该组，令temp[i]=0;
 * b.若组内元素和=sum/m,则令groupID++，继续遍历,判断下一组;
 * c.若组内元素和<sum/m,则将当前元素状态改为已选，temp[i]=组号，继续进行下
 * 一个元素的判断;
 * 则满足条件的第一个m值即为最大的。
     */
    private static void getMax(int[] a, int n) {

        int sum = 0;
        int[] temp = new int[n];// 用于记录数组中当前元素的分组状态
        for (int i : a) {
            sum += i;//数组的和为18
        }
        for (int m = n; m > 1; m--) { //先分n组, 如果不满足, n-1, 满足则为最大
            if (sum % m != 0)
                continue;
            for (int j = 0; j < n; j++) {
                temp[j] = 0;
            }
            //a={3, 2, 4, 3, 6}, n=5, m = 3, temp={0,0,0,0,0}, sum/m=18/3=6
            if (getMaxGroup(a, n, m, sum / m, temp, sum / m, 1)) {
                System.out.println("The Max m is: " + m); //m最大为3
                break;
            }
        }
    }
    private static boolean getMaxGroup(int[] a, int n, int m, int groupSum,
                                int[] temp, int total, int groupID) {

        if (total < 0) {// 说明加上当前元素后数小组元素的和过大
            return false;
        }
        if (total == 0) {
            groupID++;
            total = groupSum;
            if (groupID == m + 1) {
                return true;
            }
        }
        for (int i = 0; i < n; i++) {
            if (temp[i] != 0)
                continue;
            temp[i] = groupID;
            if (getMaxGroup(a, n, m, groupSum, temp, total - a[i], groupID))
                return true;
            temp[i] = 0;// 当前元素分配失败，置回初始状态
        }
        return false;
    }

}
