package jianzhi_offer;

import java.util.Arrays;

/**
 * Created by kentorvalds on 2018/4/16.
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子， 即这5张牌是不是连续的。2～10为数字本身， A为1。 J为11、Q为12、 为13。小王可以看成任意数字。
 */
public class OrderFiveInPork {

    public static void main(String[] args){
        int[] numbers1 = {1, 3, 2, 5, 4};
        System.out.println("1, 3, 2, 5, 4" + isContinuous(numbers1));
        int[] numbers2 = {1, 3, 2, 6, 4};
        System.out.println("1, 3, 2, 6, 4" + isContinuous(numbers2));
        int[] numbers3 = {0, 3, 2, 6, 4};
        System.out.println("0, 3, 2, 6, 4" + isContinuous(numbers3));
        int[] numbers4 = {0, 3, 1, 6, 4};
        System.out.println("0, 3, 1, 6, 4" +isContinuous(numbers4));
        int[] numbers5 = {1, 3, 0, 5, 0};
        System.out.println("1, 3, 0, 5, 0" +isContinuous(numbers5));
        int[] numbers6 = {1, 3, 0, 7, 0};
        System.out.println("1, 3, 0, 7, 0" +isContinuous(numbers6));
        int[] numbers7 = {1, 0, 0, 5, 0};
        System.out.println("1, 0, 0, 5, 0" +isContinuous(numbers7));
        int[] numbers8 = {1, 0, 0, 7, 0};
        System.out.println("1, 0, 0, 7, 0" +isContinuous(numbers8));
        int[] numbers9 = {3, 0, 0, 0, 0};
        System.out.println("3, 0, 0, 0, 0" +isContinuous(numbers9));
        int[] numbers10 = {0, 0, 0, 0, 0};
        System.out.println("0, 0, 0, 0, 0" +isContinuous(numbers10));
        int[] numbers11 = {1, 0, 0, 1, 0};
        System.out.println("1, 0, 0, 1, 0" +isContinuous(numbers11));



        int i = 3; String s = "ni";
        //s += i;
       // s = i + s;
        s.length();

        System.out.println(s);


    }

    public static boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length != 5) {
            return false;
        }

        // 对元素进行排序
        Arrays.sort(numbers);
        int numberOfZero = 0;
        int numberOfGap = 0;
        for (int i = 0; i < numbers.length && numbers[i] == 0; i++) {
            numberOfZero++;
        }

        // 一副牌中不可能有两个以上的王
        if(numberOfZero > 2) {
            return false;
        }

        // 第一个非0元素的位置
        int small = numberOfZero;
        int big = small + 1;

        while (big < numbers.length) {
            if (numbers[small] == numbers[big]) {//出现对子
                return false;
            }

            numberOfGap += (numbers[big] - numbers[small] - 1);
            small = big;
            big++;
        }

        return numberOfGap <= numberOfZero;
    }

}
