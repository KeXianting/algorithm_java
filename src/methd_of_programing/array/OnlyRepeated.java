package methd_of_programing.array;

/**
 * Created by kentorvalds on 2017/11/2.
 * 1-1000放在含有1001个元素的数组中，只有唯一的一个元素值重复，
 * 其它均只出现一次．每个数组元素只能访问一次，设计一个算法，将它找出来；不用辅助存储空间
 */
public class OnlyRepeated {

    private static int N = 10;

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,7,8,9,10};//1-10存放在有11个元素的数组中

        //
        System.out.println("方法1: " + getOnlyRepeatedMethod1(arr));

        //
        System.out.println("方法2: " + getOnlyRepeatedMethod2(arr));

        //
        System.out.println("方法3: " + getOnlyRepeatedMethod3(arr));
    }

    //方法1:将1001个元素相加减去1,2,3,……1000数列的和，得到的差即为重复的元素
    public static int getOnlyRepeatedMethod1(int[] arr){
        int sum = 0;
        for (int i = 0; i <= N; i ++ ){
            sum += arr[i];
        }

        int sumN = N*(N+1)/2;

        return (sum-sumN);
    }


    //方法2:用两个速度不同的过程来访问。Slow每次前进一步，fast每次前进两步。在有环结构中，它们总会相遇。
    public static int getOnlyRepeatedMethod2(int[] arr){
        int slow = 0;
        int fast = 0;
        int i = 0;
        int ret = -1;
        while (i < arr.length){
            fast = arr[i+2];
            slow = arr[i + 1];
            i++;
            if (fast == slow){
                ret = fast;
                break;
            }
        }
        return ret;
    }

    //方法3: 异或操作
    //一个数和0异或还是自己，一个数和自己异或是0
    public static int getOnlyRepeatedMethod3(int[] arr){
        int result = 0;

        for(int i=1;i<=N;i++){
            result ^=  i;
            //System.out.println(result);
        }

        System.out.println(result);
        for(int i=0;i<=N;i++)
            result ^=  arr[i];

        return result;
    }

    /*
    用异或解答
    现在给你2n+1个正整数，其中有n对数和1个单独的数，（这里规定一对数的意思是这两个数相等），
    然后让你设计一种算法，把这个单独的数给找出来，要求时间复杂度为O(n)。比如说这2n+1个数是1 2 3 2 1，那么这个单独的数就是3。
     */

}
