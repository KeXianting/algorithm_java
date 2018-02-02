package methd_of_programing.array;

/**
 * Created by kentorvalds on 2017/12/1.
 * 最长递减子序列: 求一个数组的最长递减子序列
 * 例如:{9,4,3,2,5,4,3,2}的最长递减子序列为{9,5,4,3,2}
 * 典型的动态规划题目，对每一个数计算由它开始的最大递减子序列的个数，并存放到一张映射表中
 * 然后利用求得的映射表及最大子序列个数获取原数组中的元素。对于{9,4,3,2,5,4,3,2}
 * 我们求得最大子序列个数为nMaxLen=5，表为pTable={5,3,2,1,4,3,2,1}。
 * 那么pTable中以此找出nMaxLen,nMaxLen-1,…,1对应的原数组的值即为最大递减子序列。对应的为{9,5,4,3,2}.复杂度为O(n2)
 */
public class LongestDecreasingSequence {

    public static void main(String[] args){
        int a[] = {9,4,3,2,5,4,3,2};
        int[] pTable = new int[a.length];
        int nMaxLen = getLongestDecreasingSequenceMethod1(a, pTable);
        System.out.println("动态规划: " + nMaxLen);
        printSequence(a, pTable, nMaxLen);
    }

    /*
        对pTable: i = 3时, a[3] = 2, nMax = 0, pTable[3] = 1
        由后一个的pTable值确定前一个
     */
    private static int getLongestDecreasingSequenceMethod1(int[] a, int[] pTable){
        int nMaxLen = 0;
        for(int i = a.length-1; i >= 0; --i) {
            int nMax = 0;
            for(int j = i+1; j < a.length; ++j) {
                if(a[j] < a[i]) {
                    nMax = nMax < pTable[j] ? pTable[j] : nMax;
                }
            }
            pTable[i] = 1+nMax;
            nMaxLen = nMaxLen<pTable[i] ? pTable[i] : nMaxLen;
        }

        return nMaxLen;
    }
    private static void printSequence(int[] a, int[] pTable, int nMaxLen){
        for(int i = 0; i < a.length; ++i) {
            if(pTable[i] == nMaxLen){
                System.out.print(a[i] + " ");
                nMaxLen--;
            }
        }
        System.out.println();
    }

    //方法2: 把该数B组赋给另一个数组A, 对A进行排序, 然后对A和B求最大公共子序列
}
