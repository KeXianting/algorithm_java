package methd_of_programing.array;

/**
 * Created by kentorvalds on 2017/12/21.
 *
 * 设子数组a[0:k-1]和a[k:n-1]已经排序（0<=k<=n-1）。
 * 请设计一个合并这两个子数组为排好序的数组a[0:n-1]的算法。
 * 要求算法在最坏情况下所用的计算时间为O(n)，且只用到O(1)的辅助空间。
 */
public class ArraysMerge {

    public static void main(String[] args){
        //这里的 k = 5，即a[0:4]、a[5:8]
        int[] a = {1, 3, 5 , 7, 9, 2, 4, 6, 8};
        System.out.println("合并之前数组");
        for (int i = 0; i < a.length; i ++){
            System.out.print(a[i] + " " );
        }
        System.out.println();
        mergeSort(a, 5, a.length);

        System.out.println("合并之后数组");
        for (int i = 0; i < a.length; i ++){
            System.out.print(a[i] + " " );
        }


    }

    //向右循环移位合并算法
    //length:数组的长度
    private static void mergeSort(int[] a, int k, int length){
        //merge a[0:k-1] and a[k:n-1]
        int i = 0;
        int j = k;
        while(i < j && j < length)
        {
            //第一次: a={1, 3, 5 , 7, 9, 2, 4, 6, 8}, i =0, j = 5, a[0]=1
            //得到p=4
            int p = binarySearch(a, a[i], j, length - 1);//查找a[i]在a中的位置,二分查找O(logn)
            //System.out.println("aaaaa" + p);
            shiftRight(a, i, p, p - j + 1);//把a[i...p]整体右移p-j+i个单位
            j = p + 1;
            i += p - j + 2;
        }
    }

    //下面函数用于在数组段中a[left:right]中搜索元素x的插入位置
    private static int binarySearch(int a[], int x, int left, int right){
        int mid = left + (right - left)/2;
        while(left <= right)
        {
            mid = left + (right - left)/2;
            if(x == a[mid])
            {
                return mid;
            }
            if(x > a[mid])
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }
        if(x > a[mid])
        {
            return mid;
        }
        else
        {
            return mid - 1;
        }
    }


    //下面函数将数组段a[s:t]中元素循环右移位k个位置
    private static void shiftRight(int a[], int s, int t, int k){
        int i = 0;
        int j = 0;
        for(i = 0; i < k; i++)
        {
            int tmp = a[t];
            for(j = t; j > s; j--)
            {
                a[j] = a[j-1];
            }
            a[s] = tmp;
        }
    }
}
