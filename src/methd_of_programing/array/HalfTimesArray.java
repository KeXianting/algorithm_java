package methd_of_programing.array;

import sort.QuickSort;

import java.util.HashMap;

/**
 * Created by kentorvalds on 2018/1/11.
 * 1.数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 *2.数组中有一个数字出现的次数刚好为数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2,8}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class HalfTimesArray {
    public static void main(String[] arg){
        int[] a = {1,2,3,2,2,2,5,4,2};
        int[] b = {1,2,3,2,2,2,5,4,2,8};
        int res = getNumberOfHalf(a);

        System.out.println("超过一半的数排序: " + res);
        System.out.println("超过一半的数hash: " + getNumberOfHalf1(a));
        System.out.println("超过一半的数记录两个值: " + getNumberOfHalf2(a));
        System.out.println("刚好一半: " + getNumberOfHalf2(b));
    }

    //排序后, 找到数组长度的一半出的位置的值就是所求值
    //比如: 1,2,2,2,2,3,4,5; 一半的位置为2
    public static int getNumberOfHalf(int[] a){
        QuickSort.sort(a,0,a.length-1);
        return a[(a.length-1)/2];
    }

    //散列表实现
    public static int getNumberOfHalf1(int[] a){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < a.length; i ++){
            if (hashMap.containsKey(a[i])){
                int count = hashMap.get(a[i]);
                count = count + 1;
                hashMap.put(a[i],count);
            }else {
                hashMap.put(a[i],1);
            }
        }

        for (Integer temp:hashMap.keySet()){
            if (hashMap.get(temp) > a.length/2){
                return temp;
            }
        }
        return -1;

    }

    //方法3: 记录两个值, candidate用来保存数组中遍历到的某个数, nTimes表示当前数的出现次数
    //如果下一个数与之前candidate保存的数相同,则nTimes加1;
    //如果下一个数与之前candidate保存的数不同,则nTimes减1;
    //每次当出现次数nTimes变为0后,用candidate保存下一个数,并把nTimes重新设置为1;
    //遍历完整个数组
    //该方法同样也可以解决次数刚好为一半的情况
    public static int getNumberOfHalf2(int[] a){
        int candidate = a[0];
        int nTimes = 1;
        for (int i = 0; i < a.length; i ++){
            if (nTimes == 0){
                candidate = a[i];
                nTimes = 1;
            }else {
                if (candidate == a[i]){
                    nTimes ++;
                }else {
                    nTimes --;
                }
            }
        }

        return candidate;
    }

    //方法4: 每次删除数组中两个不同的数, 最终保留下的数就是次数超过一半的数

}
