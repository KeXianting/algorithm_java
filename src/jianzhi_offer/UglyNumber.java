package jianzhi_offer;

/**
 * Created by kentorvalds on 2018/4/11.
 * 丑数:
 *  我们把只包含因子2，3，5的数称为丑数（Ugly Number).
 * 求按从小到大的顺序的第1500个丑数。
 * 例如6，8都是丑数，但14不是，因为它含有因子7.习惯上我们把1当作第一个丑数
 */
public class UglyNumber {


    public static void main(String[] args){

        System.out.println("逐个判断法: " + getUglyNumber1(0));

        System.out.println("辅助数组: " + getUglyNumber2(1500));
    }

    //方法1: 逐个判断
    public static int getUglyNumber1(int index){
        if (index <= 0){
            return 0;
        }
        int number = 0;
        int uglyFound = 0;
        while (uglyFound < index){
            number ++;
            if (isUglyNumber(number)){
                uglyFound ++;
            }
        }
        return number;
    }

    public static boolean isUglyNumber(int number){
        while (number % 2==0)
            number /= 2;
        while (number % 3 == 0)
            number /= 3;
        while (number % 5 == 0)
            number /= 5;
        return number == 1 ? true:false;
    }

    //创建数组保存已有的丑数,空间换时间
    public static int getUglyNumber2(int index){
        if (index <= 0){
            return 0;
        }
        int[] uglyArray = new int[index];
        uglyArray[0] = 1;
        int multiply2 = 0;
        int multiply3 = 0;
        int multiply5 = 0;
        for(int i = 1;i<index;i++){
            int min = min(uglyArray[multiply2]*2,uglyArray[multiply3]*3,uglyArray[multiply5]*5);
            uglyArray[i] = min;
            while(uglyArray[multiply2]*2 <= uglyArray[i])
                multiply2++;
            while(uglyArray[multiply3]*3 <= uglyArray[i])
                multiply3++;
            while(uglyArray[multiply5]*5 <= uglyArray[i])
                multiply5++;
        }
        return uglyArray[index-1];
    }
    public static int min(int number1,int number2,int number3){
        int min = (number1<number2)?number1:number2;
        return min <number3?min:number3;
    }
}
