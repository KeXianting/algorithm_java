package methd_of_programing.array;

/**
 * Created by kentorvalds on 2017/10/27.
 * 长度为 n 的整数数组，对数组进行整理，使得所有的奇数都在数组的前面，
 * 而所有的偶数都在数组的后面。例如数组为 {1,2,3,4,5,6}. 整理后为 {1,3,5,2,4,6}.
 */
public class OddEnenSort {

    private static int[] arr = {1,2,3,4,5,6};
    public static void main(String[] args){

        //
        System.out.println("一头一尾指针往中间访问: ");
        oddEvenSortMethod1(arr);

        int[] a = {1,2,3,4,5,6};
        System.out.println("一前一后指针从左向右访问: ");
        oddEvenSortMethod2(a);
    }

    //方法1: 一头一尾指针往中间访问
    public static void oddEvenSortMethod1(int[] a){
        if (a == null || a.length == 0){
            System.err.println("your input data is wrong");
        }

        int start = 0;
        int end = a.length - 1;

        while (start < end){
            //如果a[start]是奇数
            if (isOddNumber(a[start])){
                start ++;
            }else if (!isOddNumber(a[end])){//如果[end]是偶数
                end --;
            }else {
                //交换二者
                swap(a, start, end);
            }
        }
        for (int i = 0; i < a.length; i ++){
            System.out.print(a[i] + " , ");
        }

    }
    //判断是否是奇数
    private static boolean isOddNumber(int data){
        return (data & 1)==1;
    }
    private static void swap(int[] a, int left, int right){
        if (left == right){
            a[left] = a[left];
            a[right] = a[right];
        }else {
            a[left]=a[left]^a[right];
            a[right]=a[right]^a[left];
            a[left]=a[right]^a[left];
        }

    }
    //方法2:一前一后指针往后遍历
    public static void oddEvenSortMethod2(int[] a){
        int low = 0;
        int i = -1; //后指针
        //j为前指针
        for (int j = low; j < a.length; j++){
            if (isOddNumber(a[j])){
                i = i + 1;
                swap(a, i,j);
            }
        }
        swap(a, i+1, a.length-1);
        for (int m = 0; m < a.length; m ++){
            System.out.print(a[m] + " , ");
        }
    }
}
