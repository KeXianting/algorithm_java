package methd_of_programing.array;

/**
 * Created by kentorvalds on 2018/1/23.
 * 在一亿个整数中寻找1000个最大的
 * 最小堆实现: 1.建立1000个元素的最小堆;
 *            2.遍历剩余的元素, 如果比堆顶元素小,则舍去,如果比堆顶元素大,则替换堆顶元素,并重新构建最小堆
 *            3.输出堆中元素
 */
public class TopK {

    /*
    创建k个节点的小根堆
     */
    public static int[] createHeap(int[] a, int k){
        int[] result = new int[k];
        for (int i = 0 ; i < k; i ++){
            result[i] = a[i];
        }
        for (int i = 1; i < k; i++) {
            int child = i;
            int parent = (i - 1) / 2;
            int temp = a[i];
            while (parent >= 0 &&child!=0&& result[parent] >temp) {
                result[child] = result[parent];
                child = parent;
                parent = (parent - 1) / 2;
            }
            result[child] = temp;
        }
        return result;
    }

    //维护堆的性质
    public static void insert(int a[], int value) {
        a[0]=value;
        int parent=0;

        while(parent<a.length){
            int lchild=2*parent+1;
            int rchild=2*parent+2;
            int minIndex=parent;
            if(lchild<a.length&&a[parent]>a[lchild]){
                minIndex=lchild;
            }
            if(rchild<a.length&&a[minIndex]>a[rchild]){
                minIndex=rchild;
            }
            if(minIndex==parent){
                break;
            }else{
                int temp=a[parent];
                a[parent]=a[minIndex];
                a[minIndex]=temp;
                parent=minIndex;
            }
        }

    }
    //得到所有元素的Top K结果到堆中
    public static int[] getTopKByHeap(int input[], int k) {
        int heap[] = createHeap(input, k);
        for(int i=k;i<input.length;i++){
            if(input[i]>heap[0]){
                insert(heap, input[i]);
            }


        }
        return heap;

    }
    public static void main(String[] args) {
        int a[] = { 4, 3, 5, 1, 2,8,9,10};
        int result[] = getTopKByHeap(a, 3);
        for (int temp : result) {
            System.out.println(temp);
        }
    }
}
