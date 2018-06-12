package jianzhi_offer;

/**
 * Created by kentorvalds on 2018/4/13.
 * 统计一个数字在排序数组中出现的次数
 */
public class SearchNumberInSortedArray {

    public static void main(String[] args){
        int[] a = {1,2,3,3,3,3,4,5};
        System.out.println("直接查找: " + getNumberOfK(a, 3));

        System.out.println("二分查找: " + getNumberOfK1(a, a.length - 1, 3));


    }

    //直接查找:O(n)
    public static int getNumberOfK(int [] array , int k) {
        if(array.length<1)
            return 0;
        int start=0;
        int end=array.length-1;
        while(start!=end)
        {
            if(array[start]<k)
                start++;
            if(array[end]>k)
                end--;
            if((array[start]==k) && (array[end]==k))
                return end-start+1;
        }
        if(array.length==1 && array[0]==k)
            return 1;
        return 0;
    }

    //二分查找:O(logn)
    public static int getNumberOfK1(int[] data, int len, int k){
        int number = 0;
        if (data != null && len > 0){
            int first = findFirst(data, len, k, 0, len - 1);
            int last = findLast(data, len, k, 0, len - 1);
            if (first > -1 && last > -1){
                number = last - first + 1;
            }
        }
        return number;
    }
    public static int findFirst(int [] array , int len, int k, int start, int end){
        if (start > end){
            return -1;
        }
        int middleIndex = (start + end)/2;
        int middleData = array[middleIndex];
        if (middleData == k){
            if ((middleIndex > 0 && array[middleIndex - 1] !=k) || middleIndex == 0){
                return middleIndex;
            }else {
                end = middleIndex - 1;
            }
        }else if (middleData > k){
            end = middleIndex - 1;
        }else {
            start = middleIndex + 1;
        }
        return findFirst(array, len, k, start, end);
    }
    public static int findLast(int [] array , int len, int k, int start, int end) {
        if (start > end){
            return -1;
        }
        int middleIndex = (start + end) / 2;
        int middleData = array[middleIndex];
        if (middleData == k){
            if ((middleIndex < len - 1 && array[middleIndex + 1] != k) || middleIndex == len - 1){
                return middleIndex;
            }else {
                start = middleIndex + 1;
            }
        }else if (middleData < k){
            start = middleIndex + 1;
        }else {
            end = middleIndex - 1;
        }
        return findLast(array, len, k, start, end);
    }
}
