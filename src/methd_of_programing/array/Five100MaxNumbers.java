package methd_of_programing.array;

import data_struct.heap.Heap;
import sort.QuickSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by kentorvalds on 2017/11/9.
 * 寻找500个最大的数
 *
 * 有20个数组，每个数组里面有500个数字，降序排列，每个数字是32位的int,求出这10000个数字中最大的500个
 *
 *
 *  (1).建立大顶堆，维度为数组的个数，这里为20（第一次 插入的是每个数组中最大的值，即第一个元素）。

    (2).删除最大堆堆顶，保存到数组或者栈中，然后向最大堆插入删除的元素所在数组的下一个元素。

    (3).重复第1,2个步骤，直到删除个数为最大的K个数，这里为500.
 */
public class Five100MaxNumbers {
    public static void main(String[] args){

        //System.out.println(new Random().nextInt(500));
        List<int[]> list = new ArrayList<>();
        for (int j = 0; j < 4; j ++) {//4行, 10列, 40个数,选10个最大的
            int[] arr = new int[10];
            for (int i = 0; i < 10; i++) {
                int rand = new Random().nextInt(20);
                arr[i] = rand;

            }

            new QuickSort().sort(arr, 0, arr.length-1);
            for (int k = 0; k < arr.length; k ++){
                System.out.print(arr[k]+" , ");
            }
            System.out.println();
            list.add(arr);
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        HashMap<Integer, Integer> hashMap1 = new HashMap<>();//存储该数据来自哪个数组的哪个下标
        //创建大顶堆
        Heap heap = new Heap(4);
        for (int i = 0; i < 4; i ++){
            int[] temp = list.get(i);
            heap.insert(temp[0]);
            hashMap.put(i, temp[0]);//key:存储来自哪个数组
            hashMap1.put(i, 0);//初始化来自第i个数组的最大元素的位置(下标)
        }


        //所求数组
        int[] max = new int[10];
        System.out.println("所求数组: ");
        for (int i = 0; i < 10; i++){
            max[i] = heap.extractMax();//弹出堆顶元素
            int temp = max[i];
            System.out.print(temp + " , ");
            for (Integer k:hashMap.keySet()){//在前面记录的堆顶元素来自哪个数组
                if (hashMap.get(k) == temp){//找到堆顶元素后,把该堆顶元素所来自数组的下一个元素插入堆中
                    int tempK = hashMap1.get(k)+1;//该堆顶元素来自所属数组的下标加1,即指向后一个元素
                    hashMap1.replace(k,hashMap1.get(k),tempK);//更新下标
                    temp = list.get(k)[tempK];//获取新的元素插入大顶堆
                    hashMap.replace(k,hashMap.get(k),temp);
                    break;
                }
            }

            heap.insert(temp);
        }



    }


}