package methd_of_programing.array;

/**
 * Created by kentorvalds on 2017/12/4.
 * 输入一个正整数数组，把数组里面所有的数字拼接排成一个数，
 * 打印能拼接出的所有数字中的一个。例如输入数组｛3，32，321｝，则打印出这3个数字能排成的最小数字321323.
 *
 * 根据排列组合的方法，n个数字总共有n!排列，我们再来看一下更快的算法。
 这道题其实希望我们能够找到一个排序规则，数组根据这个规则排序之后能排成一个最小的数字。要确定排序的规则
 ，就要比较两个数字，也就是给出两个数字m和n，我们需要确定一个规则判断m和n哪个应该排在前面，而不是仅仅比较这两个数字的值哪个更大。
 根据题目的要求，两个数字m和n能拼接称数字mn和nm。如果mn<nm，那么我们应该打印出mn，
 也就是m应该拍在N的前面，我们定义此时m小于n；反之，如果nm<mn，我们定义n小于m。如果mn=nm,m等于n。
 接下来考虑怎么去拼接数字，即给出数字m和n，怎么得到数字mn和nm并比较他们的大小。直接用数值去计算不难办到，
 但需要考虑一个潜在的问题就是m和n都在int能表达的范围内，把他们拼起来的数字mn和nm用int表示就有可能溢出了，所以这还是一个隐形的大数问题。
 一个非常直观的解决大数问题的办法就是把数字转换成字符串。另外，由于把数字m和n拼接起来得到mn和nm，
 他们的位数肯定是相同的，因此比较它们的大小只需要按照字符串的大小的比较规则就可以了。
 */
public class MininumNumberInArray {

    public static void main(String[] args){
        int arr[] = {3,32,321,15, 9};
        printMin(arr);
    }
    public static void printMin(int[] arr){
        int[] clone = arr.clone();
        printMinNumber(clone,0,clone.length-1);
        for(int i : clone)
            System.out.print(i);
    }
    //核心+快排
    //用快排的划分思想, 每一次都会使得small_cur前的数字小于small_cur的数字,后面的大于small_cur的数字
    public static void printMinNumber(int[] arr,int left,int right){
        if(left < right){//左边小于右边
            int main_number = arr[right];//作为基准元素
            int small_cur = left;
            for(int j = left;j<right;j++){
                if(isSmall(String.valueOf(arr[j]),String.valueOf(main_number))){//如果arr[j]+main_number小与main_number+arr[j](字符串)
                    //arr[small_cur]与arr[j]交换
                    int temp = arr[j];
                    arr[j] = arr[small_cur];
                    arr[small_cur] = temp;
                    small_cur++;
                }
            }//循环结束后,arr[small_cur]之前的均比main_number小,arr[small_cur]作为中间元素

            //把中间与基准元素交换
            arr[right]= arr[small_cur];
            arr[small_cur] = main_number;
            //递归调用
            printMinNumber(arr,0,small_cur-1);
            printMinNumber(arr,small_cur+1,right);
        }
    }
    public static boolean isSmall(String m,String n){
        String left = m+n;
        String right = n+m;
        boolean result = false;
        for(int i = 0;i<left.length();i++){
            if(left.charAt(i)<right.charAt(i))
                return true;
            else if(left.charAt(i)>right.charAt(i))
                return false;
        }
        return result;
    }

}




