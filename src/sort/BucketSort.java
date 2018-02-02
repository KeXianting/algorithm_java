package sort;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by kentorvalds on 2017/6/28.
 */
/*
1.将待排数据按一个映射函数f(x)分为连续的若干段。理论上最佳的分段方法应该使数据平均分布；实际上，通常采用的方法都做不到这一点。显然，对于一个已知输入范围在【0，10000】的数组，最简单的分段方法莫过于x/m这种方法，例如，f(x)=x/100。
“连续的”这个条件非常重要，它是后面数据按顺序输出的理论保证。
2.分配足够的桶，按照f(x)从数组起始处向后扫描，并把数据放到合适的桶中。对于上面的例子，如果数据有10000个，则我们需要分配101个桶（因为要考虑边界条件：f(x)=x/100会产生【0，100】共101种情况），理想情况下，每个桶有大约100个数据。
3.对每个桶进行内部排序，例如，使用快速排序。注意，如果数据足够大，这里可以继续递归使用桶排序，直到数据大小降到合适的范围。
4.按顺序从每个桶输出数据。例如，1号桶【112，123，145，189】，2号桶【234，235，250，250】，3号桶【361】，则输出序列为【112，123，145，189，234，235，250，250，361】。
 */
public class BucketSort {
    /**
     * 桶排序算法，对arr进行桶排序，排序结果仍放在arr中
     * @param arr
     */
    static void bucketSort(double arr[]){
        int n = arr.length;
        ArrayList arrList[] = new ArrayList [n];
        //把arr中的数均匀的的分布到[0,1)上，每个桶是一个list，存放落在此桶上的元素
        for(int i =0;i<n;i++){
            int temp = (int) Math.floor(n*arr[i]);
            if(null==arrList[temp])
                arrList[temp] = new ArrayList();
            arrList[temp].add(arr[i]);
        }
        //对每个桶中的数进行插入排序
        for(int i = 0;i<n;i++){
            if(null!=arrList[i])
                insert(arrList[i]);
        }
        //把各个桶的排序结果合并
        int count = 0;
        for(int i = 0;i<n;i++){
            if(null!=arrList[i]){
                Iterator iter = arrList[i].iterator();
                while(iter.hasNext()){
                    Double d = (Double)iter.next();
                    arr[count] = d;
                    count++;
                }
            }
        }
    }
    /**
     * 用插入排序对每个桶进行排序
     * @param list
     */
    static void insert(ArrayList list){
        if(list.size()>1){
            for(int i =1;i<list.size();i++){
                if((Double)list.get(i)<(Double)list.get(i-1)){
                    double temp = (Double) list.get(i);
                    int j = i-1;
                    for(;j>=0&&((Double)list.get(j)>(Double)list.get(j+1));j--)
                        list.set(j+1, list.get(j));
                    list.set(j+1, temp);
                }
            }
        }
    }
    /**
     * 测试.....
     * 这里的测试数据是一个含n个元素的数组，且每个元素满足0<=arr[i]<1
     */
    public static void main(String[] args) {
        double arr[] = {0.78,0.17,0.39,0.26,0.72,0.94,0.21,0.12,0.23,0.68};
        bucketSort(arr);
        for(int i = 0;i<arr.length;i++)
            System.out.println(arr[i]);
    }
}
