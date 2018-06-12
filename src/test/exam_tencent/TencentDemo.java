package test.exam_tencent;

import java.util.Scanner;

public class TencentDemo {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long sum = 0;
        if (m == 0){
            sum = n*(n-1)/2;
        }else {
            int group = n/m;
            long[] arr = new long[group];
            arr[0] = 1;
            for (int i = 1 ;i < group; i ++){
                arr[i] = arr[i-1] + (2*i+1);
            }
            sum = 2*arr[group];
        }

        System.out.println(sum);

//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int m = in.nextInt();
//        long sum = 0;
//        if (m == 0){
//            sum = n*(n-1)/2;
//        }else {
//            int group = n/m;
//            long arr = 0;
//            arr = 1;
//            for (int i = 1 ;i < group; i ++){
//                if (i == m){
//                    sum = sum + 2*arr;
//                    //break;
//                }
//                arr = arr + (2*i+1);
//
//            }
//           // sum = 2*arr[m-1];
//        }
//
//        System.out.println(sum);

    //System.out.println(sum(n,m));
      //  System.out.println(sum1(n,m));
    }
    static long sum(int n, int m){
        int len = n/m;
        long sum = 0;
        for (int i = 0; i < len; i++){
            for (int j = 0 ; j < m; j++){
                if (i%2 == 0){
                    sum -= i*m + (j+1);
                }else {
                    sum += i*m + (j+1);
                }
            }
        }
        return sum;

    }

    static long sum1(int n, int m){
        int nn = n/(2*m);
        int mm = m*m;
        int s = nn*mm;
        return s;
    }

//    public static int getMaxNumber(){
//        Scanner in = new Scanner(System.in);
//        int sum = in.nextInt();
//        int[] arr = new int[4];
//        for (int i = 0; i < 4; i ++){
//            arr[i] = in.nextInt();
//        }
//
//        int[] temp = new int[arr[1]+arr[3]];
//        for (int i = 0; i < arr[1]; i ++){
//            temp[i] = arr[0];
//        }
//        for (int j = 0;j<arr[3]; j++){
//            temp[arr[1]+j] = arr[2];
//        }
//
//
//        return sum%1000000007;
//    }
//    static int getCount(int[] array) {
//        quickSort(array, 0, array.length-1);
//        sum(array.length-1, array);
//        return count;
//    }
//
//    private  static int[] sum(int n, int[] array) {
//        if(n == 0){
//            return new int[]{array[0]};
//        }
//
//        int length = (int)Math.pow(2, (n+1))-1;
//        int a[] = new int[length];
//        int b[] = sum(n-1);
//
//        int i=0;
//        for(i=0; i<(length-1)/2; i++) {
//            a[i] = b[i];
//            int temp = b[i] + array[n];
//            if(temp == sum){
//                count++;
//            }
//            a[i+(length+1)/2] = temp;
//        }
//        if(array[n] == sum) {
//            count++;
//        }
//        a[(length-1)/2] = array[n];
//
//        return a;
//    }
//
//    private static void quickSort(int []array, int left, int right) {
//        if(left >= right) {
//            return;
//        }
//        int q = pagenation(array, left, right);
//        quickSort(array, left, q-1);
//        quickSort(array, q+1, right);
//    }
//
//    private static int pagenation(int []array, int left, int right) {
//        int i=left, j=right+1;
//        int p = (int)Math.random()*(right-left+1)+left;
//        swap(array,left, p);
//        int x = array[left];
//
//        while(true) {
//            while(i<right && array[++i] < x);
//            while(j>left && array[--j] > x);
//            if(i > j) {
//                break;
//            }
//            swap(array,i,j);
//        }
//        return j;
//    }
//
//    private static void swap(int [] array, int i, int j) {
//        int temp = array[i];
//        array[i] = array[j];
//        array[j] = temp;
//    }
////    public static void sort(int num[], int left, int right) {
////        if (left < right) {
////            int index = partition(num, left, right);//基准元素的下标, 数组的划分调用
////            sort(num, left, index-1);
////            sort(num, index, right);
////        }
////
////    }
////
////    public static  int partition(int[] num, int left, int right) {
////        if(num==null || num.length<=0 || left<0 || right>=num.length){
////            return 0;
////        }
////        int prio = num[left + (right - left) / 2]; //基准元素, 中间位置, 可以是第一个或者最后一个
////        while(left<=right){
////            while (num[left] > prio)
////                left++; //如果比基准元素小的位置不动
////            while (num[right] < prio)
////                right--; //如果比基准元素大的位置不动
////            if (left<=right) { //如果有左边的元素大于右边的元素, 则进行交换
////                swap(num, left, right);
////                left++;
////                right--;
////            }
////        }
////        return left;
////    }
////
////    public static void swap(int[] num, int left, int right) {
////        int temp = num[left];
////        num[left] = num[right];
////        num[right] = temp;
////    }
}
