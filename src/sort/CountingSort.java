package sort;

/**
 * Created by kentorvalds on 2017/6/27.
 */
public class CountingSort {

    public static void main(String[] args) {

        //首位加0，同步伪代码
        int[] A = {8,3,5,1,2,7,4,3,2,1,6,7,2,0};
        System.out.println("排序前:");
        for(int i:A) {
            System.out.print(i + " ");
        }
        System.out.println("\n排序后:");
        CountingSort countingSort = new CountingSort();
        int[] B = countingSort.sort(A);
        for(int i:B) {
            System.out.print(i + " ");
        }
    }


    /**
     * 计数排序实现，注意这里的实现和伪代码不同的是，数组是从0开始的
     *
     * @param A
     */
    public int[] sort(int[] A) {
        int k = findMax(A);
        int[] C = new int[k+1]; //长度加1，同步伪代码
        int[] B = new int[A.length];

        //初始化
        for(int i=0;i<C.length;i++) {
            C[i] = 0;
        }
        //将带排序数组元素重复个数映射到辅助数组中
        for(int i=0;i < A.length;i++) {
            C[A[i]] = C[A[i]] + 1;
        }
        //处理辅助数组，使c[j]表示待排序数组中小于等于j的元素个数
        for(int i=1;i<C.length;i++) {
            C[i] = C[i] + C[i-1];
        }
        //从后往前还原排序数组元素到一个新的数组
        int i = A.length-1;
        for(;i >= 0; i --) {
            B[C[A[i]]-1] = A[i];
            C[A[i]] = C[A[i]] - 1;
        }
        return B;
    }

    public int findMax(int[] A) {
        int temp = 0;
        for(int i:A) {
            if(i > temp) {
                temp = i;
            }
        }
        return temp;
    }
}
