package methd_of_programing.array;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by kentorvalds on 2017/11/21.
 * 寻找n个数组的公共部分: 给定一个数组, 每个数组的元素都是递增的, 现在要找出这n个数组中的公共元素, 要求不能用额外辅助空间
 */
public class SimilarPartsOfNArrarys {

    public static void main(String[] args){
        Integer[] a = {2,3,5,6,7,100};
        Integer[][] others = {{3,5,7,9,14,100},{2,4,5,7,20,100},{4,5,6,7,90,100}};
        Collection<Integer> result = new ArrayList<>();
        result = intersect(a, others);
        System.out.println("数组公共部分为: ");
        for (Integer aa:result){
            System.out.print(aa + " , ");
        }

    }

    /*
    假设 m={1,2,3} n={2,3,4} 那么 m 交 n = {2,3}

    假设我们从n开始遍历，n[0]是2，那么我们可以知道交集中的结果，最小也就是2，
    不可能比2再小；当然如果看n[2]是4，我们也可以知道交集中的结果不可能比4再大。
    现在基于刚才那个原理，如果以n为基准，从小到大遍历，先检测n[0]，
    那么m集合从小往大开始遍历，碰到比待检测的数小的都丢弃，碰到和待检测数一样的就说明这个数是交集，
    碰到比待检测数大的，说明n需要向后移动一个指针。当m或者n任何中的一个数组遍历完毕的时候找交集就算结束了。

    这种方法充分利用了两个数组的有序，m和n中的两个指针都是向前移动，没有回溯，时间复杂度最坏也是O(m+n)


    知道两个数组取交集，那么我们看多个数组取交集的情况，其实和两个是完全一样的，只不过，待检测的元素放入交集的条件是，每个集合遍历的时候都要有这个元素。

    还有一个问题需要考虑的就是选取哪个为基准数组，我们之前说退出的条件是其中任何一个数组遍历完毕，就都算退出了，所以选取的根据是让其中任何一个数组快速能遍历完。

    所以我觉得选取策略有两方面

    如果是想让基准数组快点退出，那么我们肯定是选基准数组长度最小的。

    如果是想让待检测的数组快点退出，那么我们应该选取基准数组中第一个元素最大的，这样第一个能跳过的数字能特别多。

    还有，一种选法是基准数组中的数据十分离散，这样也可以跳过很多数。

    具体哪种策略最快，还要看数组的特性。
     */
    //head是作为比较的基准, others是其他的数组
    public static Collection<Integer> intersect(Integer[] head, Integer[][] others) {
        Collection<Integer> result = new ArrayList<Integer>();
        int i;
        // 其他数组的工作指针位置
        int[] othersPoint = new int[others.length];//others.length:其他数组的行数
        for (i = 0; i<head.length; i++) {
            int doc = head[i];
            boolean allIn = true;
            boolean otherExit = false;
            for (int j=0; j<others.length; j++) {
                Integer[] other = others[j];//第一个其他数组
                while (othersPoint[j] < other.length && other[othersPoint[j]] < doc) {
                    othersPoint[j]++;
                }
                if (othersPoint[j] == other.length) {
                    otherExit = true;
                    allIn = false;
                    break;
                }
                if (other[othersPoint[j]] != doc) {
                    allIn = false;
                }
            }
            if (allIn) {
                result.add(doc);
            }
            if (otherExit) {
                return result;
            }
        }

        return result;
    }

    /*

    链接：https://www.nowcoder.com/questionTerminal/159a019c9a6f4ca6914bc6d40da6ebff
来源：牛客网

//1.1、如果两个数组均有序，如果交集包括重复节点
vector<int> intersect_21(vector<int>& nums1, vector<int>& nums2)
{
    vector<int> res;
    if (nums1.empty() || nums2.empty())
        return res;
    int index1 = 0, index2 = 0;
    while (index1 < nums1.size() && index2 < nums2.size())
    {
        if (nums1[index1] == nums2[index2])
        {
            res.push_back(nums1[index1]);
            ++index1, ++index2;
        }
        else if (nums1[index1] < nums2[index2])
            ++index1;
        else
            ++index2;
    }
    return res;
}
 
//1.2、如果两个数组均有序，如果交集不包括重复节点
vector<int> intersect_22(vector<int>& nums1, vector<int>& nums2)
{
    vector<int> res;
    if (nums1.empty() || nums2.empty())
        return res;
    int index1 = 0, index2 = 0;
    while (index1 < nums1.size() && index2 < nums2.size())
    {
        if (nums1[index1] == nums2[index2])
        {
            if (res.empty() || nums1[index1] != res.back())
                res.push_back(nums1[index1]);
            ++index1, ++index2;
        }
        else if (nums1[index1] < nums2[index2])
            ++index1;
        else
            ++index2;
    }
    return res;
}
     */
}
