package jianzhi_offer;

/**
 * Created by kentorvalds on 2018/4/9.
 * 数字序列中的某一位数字:
 * 数字以0123456789101112131415····的格式序列化到一个字符序列中
 * 。在这个序列中，第5位（从0开始计数）是5，第13位是1，第19位是4，等等。请写一个函数，求任意第n位对应的数字。
 */
public class NumberOfNumberStr {

    public static void main(String[] args){
        int index = 1001;
        int number = getNumber(index);
        System.out.println("第"+ index + "位为: " + number);
    }

    public static int getNumber(int index){
        if (index < 0){
            return -1;
        }
        int digits = 1;
        while (true){
            int numbers = countOfIntegers(digits);
            if (index < numbers*digits){
                return digitsAtIndex(index, digits);
            }
            index -= digits*numbers;
            digits ++;
        }
      //  return -1;
    }
    //返回digits位数的个数,例如digits=2,则两位数的个数为90, 从10~99共90个
    public static int countOfIntegers(int digits){
        if (digits == 1){
            return 10;
        }
        int count  = (int) Math.pow(10, digits - 1);
        return count*9;
    }
    //返回最终结果, 即要找的数位于digits位数之后,digits+1位数之前
    public static int digitsAtIndex(int index, int digits){
        int number = beginNumber(digits) + index/digits;
        int indexFromRight = digits - index%digits;
        for (int i = 1; i < indexFromRight; i ++){
            number /= 10;
        }
        return number%10;
    }

    //返回digits位数的第一个, 例如digits=2, 则返回2位数的第一个数字
    public static int beginNumber(int digits){
        if (digits == 1){
            return  0;
        }
        return (int) Math.pow(10, digits - 1);
    }
}
