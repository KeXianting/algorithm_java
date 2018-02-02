package methd_of_programing.array;

/**
 * Created by kentorvalds on 2017/11/29.
 *  从一列数中筛除尽可能少的数使得从左往右看，这些数是从小到大再从大到小的
 */
public class LIS {

    public static void main(String[] args){
        int[] arr = {2,1,5,3,6,4,8,9,7,2};
        System.out.println("LIS动态规划: " + getLIS(arr));
        System.out.println("LDS动态规划: " + getLDS(arr));
        System.out.println("LIS二分法: " + getLIS(arr, arr.length));
        int[] array = {1,4,3,5,6,7,2,0};
        System.out.println("双端LIS: " + doubleLIS(array, array.length));
    }

    //LIS: 动态规划
    private static int getLIS(int[] arr){
        int[] lis = new int[arr.length];
        for (int i = 0; i < arr.length; i ++){
            lis[i] = 1;
            for (int j = 0; j < i; j ++){
                if (arr[i] > arr[j] && lis[j] + 1 > lis[i]){
                    lis[i] = lis[j] + 1;
                }
            }
        }
        System.out.println();
        int res = max(lis, arr.length);
        return res;
    }
    private static int max(int[] lis, int len){
        int max = 0;
        for(int i = 0;i < len;++i)
        {
            //System.out.println(i + " " + lis[i]);
            if(lis[i] > max)
                max = lis[i];
        }
        return max;
    }
    //LIS: 二分法+动态规划
    private static int getLIS(int[] arr, int len){
        //LIS数组中存储的是 递增子序列中最大值最小的子序列的最后一个元素（最大元素）在array中的位置
        int[] LIS = new int[len];
        int left,mid,right;
        int max=1;
        LIS[0]=arr[0];
        for(int i = 1;i < len;++i)
        {
            left = 0;
            right = max;
            while(left <=right)
            {
                mid = (left+right)/2;
                if(LIS[mid] < arr[i])
                    left = mid +1;
                else
                    right = mid -1;
            }
            LIS[left] = arr[i];//插入
            if(left > max)
            {
                max++;
            }
        }
        return max;
    }

    //双端LIS
    /*
    *问题：从一列数中筛除尽可能少的数使得从左往右看，这些数是从小到大再从大到小的（网易）。
    *比如数列1,4,3,5,6,7,2,0 删除的最少的数的个数为1
    *求解思路：双端LIS问题，使用动态规划的思路求解，时间复杂度O(nlog(n))
     */
    private static int doubleLIS(int[] array, int len){
        int left,mid,right;
        int max=0;
        int k =0;

        //LIS数组中存储的是 递增子序列中最大值最小的子序列的最后一个元素（最大元素）在array中的位置
        int[] LIS = new int[len];
        //从左到右LIS中最长子序列中最大值最小的子序列的最后一个元素所在的位置,也就是0~i的数字序列中最长递增子序列的长度-1
        int[] B = new int[len];
        //从右到左LIS中最长子序列中最大值最小的子序列的最后一个元素所在的位置,也就是len-1~i的数字序列中最长递增子序列的长度-1
        int[] C = new int[len];
        //从左到右
        for(int i = 0;i < len;++i)//LIS数组清零
        {
            B[i] = 0;
            LIS[i] = 0;
        }
        LIS[0] = array[0];
        for(int i = 1;i < len;++i)
        {
            left = 0;
            right = B[k];
            while(left <= right)
            {
                mid = (left + right)/2;
                if(array[i] < LIS[mid])
                {
                    right = mid - 1;
                }
                else
                {
                    left = mid + 1;
                }
            }

            LIS[left] = array[i];//将array[i]插入到LIS中
            if(left > B[k])
            {
                B[k+1] = B[k] + 1;
                k++;
            }
        }
        for(int i = 0;i < k;++i)
        {
            B[i]++;
        }
        //从右到左
        for(int i = 0;i < len;++i)//LIS数组清零
        {
            C[i] = 0;
            LIS[i] = 0;
        }
        k = 0;
        LIS[0] = array[len-1];
        for(int i = len-2;i >= 0;--i)
        {
            left = 0;
            right = C[k];
            while(left <= right)
            {
                mid = (left + right)/2;
                if(array[i] < LIS[mid])
                {
                    right = mid - 1;
                }
                else
                {
                    left = mid + 1;
                }
            }
            LIS[left] = array[i];
            if(left > C[k])
            {
                C[k+1] = C[k] + 1;
                k++;
            }
        }
        for(int i = 0;i <= k;++i)
        {
            C[i]++;
        }

        //求max
        for(int i = 0;i < len;++i)
        {
            //cout<<B[i]<<" "<<C[i]<<endl;
            if(B[i]+C[i]>max)
                max=B[i] + C[i];
        }

        return len - max +1;
    }

    //LDS
    private static int getLDS(int[] arr){
        int[] lis = new int[arr.length];
        for (int i = 0; i < arr.length; i ++){
            lis[i] = 1;
            for (int j = 0; j < i; j ++){
                if (arr[i] < arr[j] && lis[j] + 1 > lis[i]){
                    lis[i] = lis[j] + 1;
                }
            }
        }
        System.out.println();
        int res = max(lis, arr.length);
        return res;
    }
}
