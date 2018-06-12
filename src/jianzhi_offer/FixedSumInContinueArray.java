package jianzhi_offer;

/**
 * Created by kentorvalds on 2018/4/16.
 * 和为s的连续正数序列: 输入s=15, 则有1+2+3+4+5=4+5+6=7+8=15
 *
 */
public class FixedSumInContinueArray {

    public static void main(String[] args){
        findContinueSequence(15);
    }

    /*
    用两个指针samll, big; small指向1, big指向2, 然后判断small+big与s的大小
    如果大于s,则去掉small, 即samll后移; 如果和小于s, 则增大big,big后移
     */
    public static void findContinueSequence(int sum){
        if (sum < 3){
            return;
        }

        int small = 1;
        int big = 2;
        int curSum = small + big;
        int middle = (1+sum)/2;//small的最大值为(1+sum)/2;因为small+big=(1+sum)/2+((1+sum)/2 + 1) = s+1>2(至少两个连续的数)
        while (small < middle){
            if (curSum == sum){
                printSequence(small, big);
            }
            while (curSum > sum && small < middle){
                curSum -= small;
                small ++;
                if (curSum == sum){
                    printSequence(small, big);
                }
            }

            big ++;
            curSum += big;
        }
    }

    public static void printSequence(int small, int big){
        System.out.println();
        for (int i = small; i <= big; i ++){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
