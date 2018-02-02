package methd_of_programing.array;

import java.util.Stack;

/**
 * Created by kentorvalds on 2017/11/28.
 *一个直方图是由许多矩形组成，在给定的直方图中找出最大的矩形面积。为了简化问题，假定所有矩形宽度都为1个单位。
 *
 *
 * 下面给出的解决方法时间复杂度为O(n)。矩形面积的计算公式为底*高。
 * 对于直方图中的每个矩形’x’（例如图中高度为6，2或5的矩形）以该矩形的高度为高(因为在直方图中最大矩形的高必然是某个单独矩形高)，
 * 然后计算出最大矩形面积。因此接下来的问题是，若以某个矩形的高度为高，
 * 那么最终矩形的左边界和右边界在哪里？确定两个边界后就可以得到宽度，最终计算出面积。

 我们从左向右遍历每个矩形，并通过一个栈来存储这些矩形高度在输入数组中的索引。
 每个矩形（索引）仅压入栈中一次。当输入的矩形高度小于栈顶矩形的高度，
 那么栈顶矩形将会被弹出，然后计算矩形面积，其中矩形面积的高为弹出单个矩形条的高。
 现在得到了高，接下来得到左右边界后便可计算出宽度。由于当前输入的矩形i的高度小于栈顶矩形，
 那么以栈顶为高的矩形右边界为i。而在当前栈中若非空，那么栈中矩形条的高度一定是小于等于弹出的矩形的高度，
 因此左边界就确定了。(当有多个连续的高度一样的矩形条时，计算最后一个出栈的矩形时会得到最终的面积)


 总结：若输入序列是是升序，那么依次入栈，让入栈元素小于栈顶，
 以栈顶元素为高的矩形左边界必然是将高出栈后新的栈顶元素的位置(因为是按升序入栈)。
 而栈中元素是按升序排列那么以栈中任意一个元素为高，必然可以和栈顶元素构成矩形，
 所以当即将入栈元素小于栈顶元素时，那么右边界即是这个入栈元素的索引位置。
 */
public class LargestRectangleArea {


    public static void main(String[] args){
        //柱状条的高度(height), 宽度为1
        int[] height = {2,1,5,6,2,3};
        System.out.println("用栈实现: " + largestRectangleArea(height));
    }
    public static int largestRectangleArea(int[] height) {
        Stack<Integer> s = new Stack<>();
        int max_area = 0; // 最大矩形面积
        int tp; // 栈顶
        int area_with_top;

        int i = 0;
        int n = height.length;
        //从第一个矩形条开始，对每个矩形条的高度height[i] (i的取值范围是[0,n-1])执行下面两步
        while (i < n) {
            //s.peek()弹出栈顶元素
            //a) 如果栈为空，或height[i]大于等于栈顶元素，那么将矩形条i压入栈中。
            if (s.empty() || height[s.peek()] <= height[i]) {
                //把i入栈
                s.push(i++);
            } else {
                //b)如果输入的矩形条高度小于栈顶元素高度，那么将栈顶元素在输入数组中的索引tp出栈，然后计算矩形面积。
                // 矩形的高为height[tp]，而右边界为i，左边界为当前栈顶元素对应的索引，若栈为空，则宽度就是i。
                //pop: 移除栈顶元素
                tp = s.pop();
                System.out.println("aaa: " + tp);
                area_with_top = height[tp] * (s.empty() ? i : i - s.peek() - 1);
                max_area = Math.max(max_area, area_with_top);//更新最大面积
            }
        }
        //经过计算后，栈非空，然后将栈中元素逐个弹出，并按照步骤2计算矩形面积，并且更新最大值
        while (!s.empty()) {
            tp = s.pop();
            area_with_top = height[tp] * (s.empty() ? i : i - s.peek() - 1);
            max_area = Math.max(max_area, area_with_top);
        }
        return max_area;
    }
}
