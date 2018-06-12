package jianzhi_offer;

/**
 * Created by kentorvalds on 2018/4/9.
 * 求出从1~n中数字1出现的次数, 如: 1~12, 出现的1
 * 的数有1, 10 ,11(两次), 12一共出现5次
 *
 */
public class OneShowTimes {
    public static void main(String[] args){
        getNumberOfOne1(12);
    }

    public static void getNumberOfOne1(int n){
        int number = 0;
        for (int i = 1; i <= n; i++){
            number += findNumberOfOne(i);
        }
        System.out.println(number);

    }
    public static int findNumberOfOne(int n){
        int number = 0;
        while (n != 0){
            if (n%10 == 1){
                number ++;
            }
            n = n/10;
        }
        return number;
    }
}
