package methd_of_programing.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by kentorvalds on 2018/4/9.
 * 数组去重的方法
 */
public class ArrayDeleteRepeated {
    public static void main(String[] args){
        int[] nums = { 21, 321, 432, 213, 43, 23, 213, 4, 231, 2321, 432, 12, 3, 123, 23, 12, 3, 2, 4, 23, 1, 2312, 4,
                33, 21, 31, 23 };
        printNums(nums, nums.length);
        int len = unique4(nums);
        printNums(nums, len);

    }
    /**
     * 方法1 就是申请一个和nums大小一样的数组tmpNums，
     * 然后遍历nums中的元素，对每个元素判断是否在tmpNums出现过，
     * 如果出现过，那么就不放到新数组里面，也就是不做处理；
     * 如果没有出现过，那么就把它放到新的数组里面
     * 这种方法数组原来的相对顺序可以保证
     * 时间复杂度是n^2和空间复杂度是n
     *
     * @param nums 输入需要去重的数组
     * @return 返回去重后数组的长度
     */
    public static int unique1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] tmpNums = new int[nums.length];
        tmpNums[0] = nums[0];
        int index = 1;
        for (int i = 1, len = nums.length; i < len; i++) {
            int j = 0;
            for (; j < index; j++) {
                if (tmpNums[j] == nums[i]) {
                    break;
                }
            }
            if (j == index) {
                tmpNums[index++] = nums[i];
            }
        }
        nums = tmpNums;
        return index;
    }

    /**
     * 方法2 先对nums排序，排序后重复的元素一定相邻，
     * 然后遍历nums，并用index来表示不重复的元素应该存放的下标，
     * 如果当前遍历的元素和他的前一个元素相等，那么他是重复的，遍历下一个；
     * 如果不等，说明不是重复，那么当前元素存放到数组中下标为index的地方，index++
     * 这样遍历下来，不同的元素都放到元数组的前面去了。
     * 这种方法，得出来的是排序过得，数组原来的相对位置改变了。
     * 时间复杂度和空间复杂度都是对应排序算法的复杂度
     *
     * @param nums 输入需要去重的数组
     * @return 返回去重后数组的长度
     */
    public static int unique2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int index = 1;
        for (int i = 1, len = nums.length; i < len; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    /**
     * 方法3 利用直接插入排序的思想，把数组分成两部分，
     * 左边认为是满足要求的不重复的部分，初始为1个元素nums[0]；
     * 而右边是等待遍历的部分，不断遍历右边的元素。
     * 同样用index来表示左边部分不重复的元素应该存放的下标
     * 对于当前遍历的元素，通过第二层循环遍历左边部分0到index的元素，
     * 如果有元素和当前元素相等，说明是重复的，那么不处理；
     * 否则，说明是不重复，那么插入到下标index的地方，index++
     * 同样，遍历下来，不重复的元素被放到前面部分。
     * 这种方法没有经过排序，数组原来的相对顺序可以保证。
     * 这种方法，是对方法1的改进，用本数组的前部分替代新的数组
     * 时间复杂度是n^2,空间复杂度是1
     *
     * @param nums 输入需要去重的数组
     * @return 返回去重后数组的长度
     */
    public static int unique3(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int index = 1;
        for (int i = 1, len = nums.length; i < len; i++) {
            int j = 0;
            for (; j < index; j++) {
                if (nums[j] == nums[i]) {
                    break;
                }
            }
            if (j == index) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    /**
     * 方法4 利用Java中容器来帮助判断元素是否重复。可以使用Set Map List等
     * 这里我们利用Set容器不能存放相同的元素的特性，
     * 同样用index来表示不重复的元素应该存放的下标
     * 当前元素如果能够成功加入到Set容器中，说明这个元素还没有重复的，
     * 那么当前元素就可以放到下标index的地方，index++；
     * 如果add失败，那么说明重复了，不做操作。
     * 这种方法，同样是把不重复的数组放到数组的前面， 并可以保证元素的相对位置不变， 不过需要额外的Set容器的空间。
     * 在javascript语言中，使用map={},对象的概念来判断 通过对象的属性和值来拍段，和使用Map是同样的原理。
     * 时间复杂度是n，空间复杂度也是n
     *
     * @param nums 输入需要去重的数组
     * @return 返回去重后数组的长度
     */
    public static int unique4(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<Integer>();
        int index = 0;
        for (int i = 0, len = nums.length; i < len; i++) {
            if (set.add(nums[i])) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    /**
     * printNums 打印数组的从0到length元素
     *
     * @param nums 输入数组
     * @param length 打印长度
     */
    public static void printNums(int[] nums, int length) {
        for (int i = 0; i < length - 1; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println(nums[length - 1]);
    }

}
