package jianzhi_offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Created by kentorvalds on 2018/4/16.
 * 题目描述
 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。

 思路
 我们可以用一个队列来存储每个窗口的数，然后选出最大的，不过这样代价有点大
 其实不必每个窗口的每个数都存下来，我们用一个双向队列deque来存储，注意：我们在这存的是数组元素的索引
 如果新来的值比队列尾部的数小，那就追加到后面，因为它可能在前面的最大值划出窗口后成为最大值
 如果新来的值比尾部的大，那就删掉尾部（因为有更大的在后面，所以它不会成为最大值，划出也是它先划出，不影响最大值），再追加到后面，循环下去直到小于
 如果追加的值比的索引跟队列头部的值的索引超过窗口大小，那就删掉头部的值
 其实这样每次队列的头都是最大的那个
 */
public class MaxValueInWindow {

    public static void main(String[] args){
        int[] a = {2,3,4,2,6,2,5,1};
        //窗口大小为3
        ArrayList<Integer> result = maxInWindows(a, 3);
        //当窗口大小为数组长度时,求队列的最大值
        ArrayList<Integer> maxInQueue = maxInWindows(a, a.length);

        System.out.println("滑动窗口最大值: ");
        for (Integer r:result){
            System.out.print(r + " ");
        }
        System.out.println();
        System.out.println("队列最大值: ");
        for (Integer m:maxInQueue){
            System.out.println(m);
        }

        //System.out.println(Runtime.getRuntime().maxMemory());
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= 5; i ++){
            deque.offer(i);
        }
        System.out.println("pollFirst: ");
        while (! deque.isEmpty()){
            System.out.print(deque.pollFirst() + " , ");
        }
        System.out.println();
        System.out.println("pollLast: ");
        while (! deque.isEmpty()){
            System.out.print(deque.pollLast() + " , ");
        }
        //Stack

    }
    //滑动窗口求最大值
    public static ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (num == null || num.length < size || size == 0) {
            return result;
        }

        //双端队列
        Deque<Integer> deque = new ArrayDeque<Integer>();
        for (int i = 0; i < num.length; i++) {
            if (!deque.isEmpty() && (i - deque.peekFirst()) == size) {
                // 如果队列头部的元素已经超出滑动窗口的范围，就将头部元素退出
                deque.pollFirst();
            }
            while (!deque.isEmpty() && num[i] >= num[deque.peekLast()]) {
                // 如果新来的元素比队列最后一个元素大，则将最后一个元素退出
                deque.pollLast();
            }
            deque.offer(i);
            if (i >= (size - 1)) {
                // 如果遍历的元素已经达到一个滑动窗口的大小，就开始提取窗口的最大值了
                result.add(num[deque.peekFirst()]);
            }

        }
        return result;
    }


}
