package methd_of_programing.array;

import data_struct.heap.Heap;
import sort.QuickSort;

import java.util.Arrays;

/**
 * Created by kentorvalds on 2017/11/10.
 * 给定3个数,请找出3个数的中位数
 *
 * 求两个无序数组的中位数
 * 给定两个无序数组分别叫A和B,长度分别是m和n, 求这两个无序数组的中位数, 要求时间复杂度
 * 为O(m+n), 空间复杂度为O(1)
 *
 *
 */
public class Medium {

    public static void main(String[] args){

        int[] a = {3, 10, 8};
        System.out.println("三个数的中位数: " + getMediumOfThreeNumbers(a));

        int arr1[] = { 2, 12,11, 5, 10, 43, 24, 33};//12
        int arr2[] = { 10, 23, 41, 70, 84, 29, 6 };//29

        double medium = getUnOderArraysMedium(arr1, arr2);
        System.out.println("两个无序数组的中位数: " + medium);
        //两个有序数组的中位数
        System.out.println("两个有序数组的中位数: ");
        int b1[] = {1,3,6,9};
        int b2[] = {2, 4, 10, 12,13};
        System.out.println("方法1: " + findMedianSortedArraysMethod1(b1, b2));
        System.out.println("方法2: " + findMedianSortedArraysMethod2(b1, b2));

    }

    //给定3个数,请找出3个数的中位数
    public static int getMediumOfThreeNumbers(int[] a){
        if (a.length < 3){
            return a[0];
        }

        QuickSort.sort(a, 0, a.length - 1);
        return a[1];
    }

    //两个无序数组的中位数
    //1.将前(n+1)/2个元素调整为一个小顶堆(或者大顶堆)
    //2.对后续的每一个元素，和堆顶比较，如果小于等于堆顶，丢弃之，取下一个元素。 如果大于堆顶，用该元素取代堆顶，调整堆，取下一元素。重复此步骤
    //3.当遍历完所有元素之后，堆顶即是中位数
    public static double getUnOderArraysMedium(int[] a, int[] b){
        //对a建立最大堆
        int mediumA = getArrayMedium(a);
        int mediumB = getArrayMedium(b);

        return (mediumA + mediumB)/2;

    }

    private static int getArrayMedium(int[] a){
        Heap heap = new Heap(Arrays.copyOf(a, a.length/2 + 1),a.length/2 + 1);

        for (int i = a.length/2 + 1; i < a.length; i ++){
            int temp = heap.extractMax();
            if (a[i] < temp){
                heap.insert(a[i]);
            }else {
                heap.insert(temp);
            }
        }

        int medium = heap.extractMax();
        System.out.println("aa " + medium);
        return medium;
    }

    //两个有序数组的中位数
    //方法1: 时间O(n) 空间O(1)
    /*

    如果数组a的中位数小于数组b的中位数，那么整体的中位数只可能出现在a的右区间加上b的左区间之中；
    如果数组a的中位数大于等于数组b的中位数，那么整体的中位数只可能出现在a的左区间加上b的右区间之中
     */
    //方法1: 如果对时间复杂度没有要求，这个方法是实现起来最简单的，我们只需要从下往上依次数(n+m)/2个元素即可。
    // 由于两个数组都已经排序，我们可以使用两个指针指向数组“底部”，通过比较两个数组“底部”的元素大小来决定计哪一个元素
    // ，同时将其所在数组的指针“向上”移一位。为了方便处理总元素为偶数的情况，这里将找中位数变成找第k小的元素
    public static double findMedianSortedArraysMethod1(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int total = len1 + len2;
        if(total % 2==0){
            //若总长度为偶数, 则中位数为中间两个数和的一半
            return (findKth(nums1,nums2,total/2)+findKth(nums1,nums2,total/2+1))/2.0;
        } else {
            //若总长度为奇数, 则去中间的数
            return findKth(nums1,nums2,total/2+1);
        }
    }
    //返回数组nums1和nums2中第k大的数
    //{1,3,6,9};{2, 4, 10, 12,13}
    /*
    计数的循环是用来找到第k-1个元素的，最后return的时候再判断第k个元素是哪一个
    在每次计数的循环中要先判断两个数组指针是否超界，在最后return之前也要判断一次
     */
    private static int findKth(int[] nums1, int[] nums2, int k){
        int p = 0, q = 0;//p为nums1的指针, q为nums2的指针
        for(int i = 0; i < k - 1; i++){
            //判断p是否越界
            if(p>=nums1.length && q<nums2.length){
                q++;
            } else if(q>=nums2.length && p<nums1.length){//判断q是否越界
                p++;
            } else if(nums1[p]>nums2[q]){//如果nums1中的当前元素比nums2中的大, 则nums2后移一位
                q++;
            } else { //nums1[p]<=nums2[q], 否则nums1前移一位
                p++;
            }
        }
        //p,q以前的元素都比nums1[p],nums2[q]小
        if(p>=nums1.length) {
            return nums2[q];
        } else if(q>=nums2.length) {
            return nums1[p];
        } else {
            return Math.min(nums1[p],nums2[q]);
        }
    }

    //方法2: 分治法 Divide and Conquer,时间O(log(m+n)) 空间O(1)
    /*
    题目要求O(log(m+n))的时间复杂度，一般来说都是分治法或者二分搜索。首先我们先分析下题目，假设两个有序序列共有n个元素（根据中位数的定义我们要分两种情况考虑），当n为奇数时，搜寻第(n/2+1)个元素，当n为偶数时，搜寻第(n/2+1)和第(n/2)个元素，然后取他们的均值。进一步的，我们可以把这题抽象为“搜索两个有序序列的第k个元素”。如果我们解决了这个k元素问题，那中位数不过是k的取值不同罢了。

    那如何搜索两个有序序列中第k个元素呢，这里又有个技巧。假设序列都是从小到大排列，对于第一个序列中前p个元素和第二个序列中前q个元素，我们想要的最终结果是：p+q等于k-1,且一序列第p个元素和二序列第q个元素都小于总序列第k个元素。因为总序列中，必然有k-1个元素小于等于第k个元素。这样第p+1个元素或者第q+1个元素就是我们要找的第k个元素。

    所以，我们可以通过二分法将问题规模缩小，假设p=k/2-1，则q=k-p-1，且p+q=k-1。如果第一个序列第p个元素小于第二个序列第q个元素，我们不确定二序列第q个元素是大了还是小了，但一序列的前p个元素肯定都小于目标，所以我们将第一个序列前p个元素全部抛弃，形成一个较短的新序列。然后，用新序列替代原先的第一个序列，再找其中的第k-p个元素（因为我们已经排除了p个元素，k需要更新为k-p），依次递归。同理，如果第一个序列第p个元素大于第二个序列第q个元素，我们则抛弃第二个序列的前q个元素。递归的终止条件有如下几种：

    较短序列所有元素都被抛弃，则返回较长序列的第k个元素（在数组中下标是k-1）
    一序列第p个元素等于二序列第q个元素，此时总序列第p+q=k-1个元素的后一个元素，也就是总序列的第k个元素

    每次递归不仅要更新数组起始位置（起始位置之前的元素被抛弃），也要更新k的大小（扣除被抛弃的元素）
     */
    public static double findMedianSortedArraysMethod2(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int k = (m + n) / 2;
        if((m+n)%2==0){
            return (findKth1(nums1,nums2,0,0,m,n,k)+findKth1(nums1,nums2,0,0,m,n,k+1))/2;
        }   else {
            return findKth1(nums1,nums2,0,0,m,n,k+1);
        }

    }

    private static double findKth1(int[] arr1, int[] arr2, int start1, int start2, int len1, int len2, int k){
        // 保证arr1是较短的数组
        if(len1>len2){
            return findKth1(arr2,arr1,start2,start1,len2,len1,k);
        }
        if(len1==0){
            return arr2[start2 + k - 1];
        }
        if(k==1){
            return Math.min(arr1[start1],arr2[start2]);
        }
        int p1 = Math.min(k/2,len1) ;
        int p2 = k - p1;
        if(arr1[start1 + p1-1]<arr2[start2 + p2-1]){
            return findKth1(arr1,arr2,start1 + p1,start2,len1-p1,len2,k-p1);
        } else if(arr1[start1 + p1-1]>arr2[start2 + p2-1]){
            return findKth1(arr1,arr2,start1,start2 + p2,len1,len2-p2,k-p2);
        } else {
            return arr1[start1 + p1-1];
        }
    }

}
