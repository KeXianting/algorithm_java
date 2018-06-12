package jianzhi_offer;

/**
 * Created by kentorvalds on 2018/4/11.
 * 在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数

 例如在数组｛7，5，6，4｝中，一共存在5对逆序对，分别是｛7，6｝，｛7，5｝，｛7，4｝，｛6，4｝，｛5，4｝。
 */
public class InversePairs {
    //static int count = 0;

    public static void main(String[] args){
        int[] a = {1,2,3,4,5,6,7,0};
       // mergeSort(a);
       // System.out.println(count);
        int count = InversePairs(a);
        System.out.println(count);
    }
    // 将有二个有序数列a[first...mid]和a[mid...last]合并。
//    static void mergearray(int a[], int first, int mid, int last, int temp[]) {
//        int i = first%1000000007, j = mid + 1;
//        int m = mid, n = last%1000000007;
//        int k = 0;
//        while (i <= m && j <= n) {
//            if (a[i] > a[j]) {
//                // 左数组比右数组大
//                temp[k++] = a[j++];
//                // 因为如果a[i]此时比右数组的当前元素a[j]大，
//                // 那么左数组中a[i]后面的元素就都比a[j]大
//                // 【因为数组此时是有序数组】
//                count += mid - i + 1;
//                if(count>=1000000007)//数值过大求余
//                 {
//                   count%=1000000007;
//                   }
//            } else {
//                temp[k++] = a[i++];
//            }
//        }
//        while (i <= m) {
//            temp[k++] = a[i++];
//        }
//        while (j <= n) {
//            temp[k++] = a[j++];
//        }
//        for (i = 0; i < k; i++)
//            a[first + i] = temp[i];
//    }
//
//    static void mergesort(int a[], int first, int last, int temp[]) {
//        if (first < last) {
//            int mid = (first + last) / 2;
//            mergesort(a, first, mid, temp); // 左边有序
//            mergesort(a, mid + 1, last, temp); // 右边有序
//            mergearray(a, first, mid, last, temp); // 再将二个有序数列合并
//        }
//    }
//
//    static void mergeSort(int a[]) {
//        int[] p = new int[a.length];
//        mergesort(a, 0, a.length - 1, p);
//
//    }


    public static int InversePairs(int [] array) {
        if(array==null||array.length==0){
            return 0;
        }
        int[] copy = new int[array.length];
        for(int i=0;i<array.length;i++){
            copy[i] = array[i];
        }
        int count = InversePairsCore(array,copy,0,array.length-1);//数值过大求余
        return count;
    }

    private static int InversePairsCore(int[] array,int[] copy,int low,int high){
        if(low==high) {
            return 0;
        }
        int mid = (low+high)>>1;
        //左边部分数组的元素个数
        int leftCount = InversePairsCore(array,copy,low,mid)%1000000007;
        //右边部分数组元素的个数
        int rightCount = InversePairsCore(array,copy,mid+1,high)%1000000007;
        //count为大的在左边,小的在右边的数量
        int count = 0;
        //左边数组的最后一个数字的下标
        int i=mid;
        //右边数组最后一个数字的下标
        int j=high;
        int locCopy = high;
        while(i>=low&&j>mid){
            if(array[i]>array[j]){
                count += j-mid;
                copy[locCopy--] = array[i--];
                if(count>=1000000007){//数值过大求余
                    count%=1000000007;
                }
            }else {
                copy[locCopy--] = array[j--];
            }
        }
        for(;i>=low;i--) {
            copy[locCopy--]=array[i];
        }
        for(;j>mid;j--) {
            copy[locCopy--]=array[j];
        }
        for(int s=low;s<=high;s++) {
            array[s] = copy[s];
        }
        return (leftCount+rightCount+count)%1000000007;
    }
}

