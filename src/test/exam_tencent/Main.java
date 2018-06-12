package test.exam_tencent;

import java.util.Scanner;

/**
 * Created by kentorvalds on 2018/4/5.
 */
public class Main {
    private static int count = 0;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int sum = in.nextInt();
        int[] arr = new int[4];
        for (int i = 0; i < 4; i ++){
            arr[i] = in.nextInt();
        }

        int[] temp = new int[arr[1]+arr[3]];
        for (int i = 0; i < arr[1]; i ++){
            temp[i] = arr[0];
        }
        for (int j = 0;j<arr[3]; j++){
            temp[arr[1]+j] = arr[2];
        }
        int result = getCount(temp,sum)%1000000007;

        System.out.println(result);


    }
    static int getCount(int[] array,int sum) {
        quickSort(array, 0, array.length-1);
        sum(array.length-1, array, sum);
        return count;
    }

    private  static int[] sum(int n, int[] array, int sum) {
        if(n == 0){
            return new int[]{array[0]};
        }

        int length = (int)Math.pow(2, (n+1))-1;
        int a[] = new int[length];
        int b[] = sum(n-1, array, sum);

        int i=0;
        for(i=0; i<(length-1)/2; i++) {
            a[i] = b[i];
            int temp = b[i] + array[n];
            if(temp == sum){
                count++;
            }
            a[i+(length+1)/2] = temp;
        }
        if(array[n] == sum) {
            count++;
        }
        a[(length-1)/2] = array[n];

        return a;
    }

    private static void quickSort(int []array, int left, int right) {
        if(left >= right) {
            return;
        }
        int q = pagenation(array, left, right);
        quickSort(array, left, q-1);
        quickSort(array, q+1, right);
    }

    private static int pagenation(int []array, int left, int right) {
        int i=left, j=right+1;
        int p = (int)Math.random()*(right-left+1)+left;
        swap(array,left, p);
        int x = array[left];

        while(true) {
            while(i<right && array[++i] < x);
            while(j>left && array[--j] > x);
            if(i > j) {
                break;
            }
            swap(array,i,j);
        }
        return j;
    }

    private static void swap(int [] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
