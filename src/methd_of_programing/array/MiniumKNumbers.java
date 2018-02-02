package methd_of_programing.array;

import data_struct.heap.Heap;
import sort.QuickSort;

import java.util.Arrays;

/**
 * Created by kentorvalds on 2017/10/16.
 * 寻找最小的K个数:
 * 有n个数,找出其中最小的k个数,要求时间负责副尽可能低
 */
public class MiniumKNumbers {


    public static void main(String[] args){

        int[] arr = {323,21,5,9,10,29,38,47,100,88,0,12};


        System.out.println("整体排序法:");
        int[] array = getMiniumKNumbersMethod1(arr, 5);
        for (int i:array){
            System.out.print(i + ",");
        }
        System.out.println();

        System.out.println("部分排序法:");
        int[] array1 = getMinimuKnumberMethod2(arr, 5);
        for (int i:array1){
            System.out.print(i + ",");
        }
        System.out.println();

        System.out.println("最大堆实现:");
        int[] array2 = getMinimuKnumberMethod3(arr, 6);
        for (int i:array2){
            System.out.print(i + ",");
        }
        System.out.println();
        System.out.println("BFPRT法");
        BFPRT(arr, 0, arr.length - 1, 5);
        for (int i=0;i < 5; i ++){
            System.out.print(arr[i] + ",");
        }


    }

    //方法1:整体排序:O(nlogn)
    public static int[] getMiniumKNumbersMethod1(int[] arr, int k){

        //快速排序
        QuickSort.sort(arr, 0, arr.length - 1);

        int[] newData;
        newData = Arrays.copyOfRange(arr, 0, k);
        //ArrayList<int[]> minimumK = new ArrayList<>(Arrays.asList(newData));
        int[] minimumK = newData;
        return minimumK;
    }


    //方法2:部分排序:O(nk)
    //step1:遍历n个数,把最先遍历到的k个数存到大小为k的数组中,假设就是最小的k个数
    //step2:利用选择排序找到上一步中k个数中最大的数记为K_max
    //step3:遍历剩余的n-k个数,如果有比K_max小的数,则交换二者,并回到第二部继续
    public static int[] getMinimuKnumberMethod2(int[] arr, int k){

        //截取k个数
        int[] newData = Arrays.copyOfRange(arr, 0, k);

        int[] restDate = Arrays.copyOfRange(arr, k + 1, arr.length - 1);

        for (int i = 0; i < restDate.length; i ++){
            //找到k个数中最大的kMax,可以不用排序,比较久可以
            QuickSort.sort(newData, 0, newData.length - 1);
            int kMax = newData[newData.length - 1];
            //如果剩余的数中有比这k个数中最大的小,就交换
            if (restDate[i] < kMax){
                newData[newData.length - 1] = restDate[i];
            }
        }

        return newData;
    }



    //方法3:用堆代替数组:O(nlogk),创建堆为O(k), 更新堆为O(logk),则O(k)+O((n-k)logk)=O(nlogk)
    //维护一个容量为k的最大堆
    //step1:取前k个数到创建最大堆,堆顶元素最大
    //step2:遍历剩余n-k个数,与堆顶元素比较,如果比堆顶元素小则替换,同时更新最大堆
    //最终得到的最大堆就是所有前k个最小数
    public static int[] getMinimuKnumberMethod3(int[] arr, int k){
        //截取k个数
        int[] newData = Arrays.copyOfRange(arr, 0, k);
        //创建k个元素的最大堆
        Heap heap = new Heap(newData, k);
        int[] restDate = Arrays.copyOfRange(arr, k + 1, arr.length - 1);
        for (int i = 0 ; i < restDate.length ; i ++){
            int kMax = (heap.getData())[1];
            if (restDate[i] < kMax){
                heap.extractMax();
                heap.insert(restDate[i]);
            }
        }
        int[] array = new int[k];
        for (int i = 0; i < heap.size(); i ++){
            array[i] = heap.getData()[i+1];
        }

        return array;
    }


    //第一步:将n个元素划分为⌊n/5⌋个组，每组5个元素，若有剩余，舍去
    //第二步:使用插入排序找到⌊n/5⌋个组中每一组的中位数
    //第三步: 对于第二步中找到的所有中位数，调用BFPRT算法求出它们的中位数，作为主元
    //第四步:以第三步选取的主元为分界点，把小于主元的放在左边，大于主元的放在右边
    //第五步:判断主元的位置与k的大小，有选择的对左边或右边递归
    //方法4:线性选择算法
    //arr原数组,left左边开始位置,right右边结束位置,k个最小的数
    public static int BFPRT(int[] arr, int left, int right, int k){

        int pivot_index = getPivotIndex(arr, left, right);            //得到中位数的中位数下标

        int divide_index = partition(arr, left, right, pivot_index);  //进行划分，返回划分边界
        int num = divide_index - left + 1;
        if (num == k)
            return divide_index;
        else if (num > k)
            return BFPRT(arr, left, divide_index - 1, k);
        else
            return BFPRT(arr, divide_index + 1, right, k - num);
    }

    //利用中位数的中位数进行划分
    private static int partition(int[] arr, int left, int right, int pivotIndex){
        swap(arr, pivotIndex, right);  //把基准放置于末尾

        int divide_index = left;  //跟踪划分的分界线
        for (int i = left; i < right; i++)
        {
            if (arr[i] < arr[right])
                swap(arr, divide_index++, i);  //比基准小的都放在左侧
        }

        swap(arr, divide_index, right);  //最后把基准换回来
        return divide_index;
    }
    //返回中位数(每五个数一划分,有n/5组,每组一个中位数)的中位数的下标
    private static int getPivotIndex(int[] arr, int left, int right){
        if (right - left < 5)
            return insertSort(arr, left, right);

        int sub_right = left - 1;
        for (int i = left; i + 4 <= right; i += 5)
        {
            int index = insertSort(arr, i, i + 4);  //找到五个元素的中位数的下标
            swap(arr, ++sub_right, index);   //依次放在左侧
        }

        return BFPRT(arr, left, sub_right, ((sub_right - left + 1) >> 1) + 1);
    }
    //插入排序:找到中位数下标
    private static int insertSort(int[] arr, int left, int right){
        int temp;
        int j;
        for (int i = left + 1; i <= right; i++)
        {
            temp = arr[i];
            j = i - 1;
            while (j >= left && arr[j] > temp)
                arr[j + 1] = arr[j--];
            arr[j + 1] = temp;
        }

        //返回中位数下标
        return ((right - left) >> 1) + left;
    }
    //交换两个数
    private static void swap(int[] arr, int left, int right ){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }








    //最大堆法2:
    public static void headSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        buildMaxHeap(array);
    }
    /**
     * 创建堆
     *
     * */
    public static void buildMaxHeap(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        //从最后的一个非叶子节点向上开始排,避免迭代没有意义的叶子节点
        int half = (array.length-1) / 2;
        for (int i = half; i >= 0; i--) {
            maxHeap(array, array.length, i);
        }
    }
    /**
     *
     * 调整堆(沉降法)
     * logn
     * */
    public static void maxHeap(int[] array, int heapSize, int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        int largest = index;
        //判断有没有左节点,如若有则比较替换largest
        if (left < heapSize && array[left] > array[largest]) {
            largest = left;
        }
        //判断有没有右节点,如若有则largest和右节点比较,注意largest有可能是left也有可能是index
        if (right < heapSize && array[right] > array[largest]) {
            largest = right;
        }

        if (index != largest) {
            int temp = array[index];
            array[index] = array[largest];
            array[largest] = temp;
            //被替换的largest节点所在的堆,需要重新调整,使小值/大值一直下沉
            maxHeap(array, heapSize, largest);
        }

    }
    /**
     * 思路二 最大堆法
     * 利用树形的特点保存前面比较的结果,可以减少比较次数s
     */
    public static void scheme2(int[] ins, int k) {
        int[] ks = new int[k];
        // 最先遍历的k个数放入数组中 o(k)
        for (int i = 0; i < k; i++) {
            ks[i] = ins[i];
        }
        //构建前k个数的最大堆
        headSort(ks);
        //n-k个数和前面和k中最大数比较
        for (int i =k; i < ins.length; i++) {
            //如果堆顶大于n-k中数,则交换位置
            if(ks[0]>ins[i]){
                ks[0]=ins[i];
                //调整堆,堆顶被替换了,加入被替换的值非常小,会一直下沉到叶子节点.
                maxHeap(ks,ks.length,0);
            }

        }
        // 输出最小的K个数
        for (int i = 0; i < k; i++) {
            System.out.print(ks[i] + " ");
        }
    }





}
