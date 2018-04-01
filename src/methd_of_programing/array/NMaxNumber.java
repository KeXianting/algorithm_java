package methd_of_programing.array;

import java.util.Arrays;

/**
 * Created by kentorvalds on 2018/3/30.
 */
/*
打印从1到最大的n位数
 */
public class NMaxNumber {

    public static void main(String[] args){

//        char a = '9';
//        System.out.println((int) a);
//        System.out.println(a+'0');
//        System.out.println(a-'0');
        int n = 4;
        printMaxNNumber(n);
    }

    //直接计算可能导致当n太大的时候溢出

    //转换为字符串
    public static void printMaxNNumber(int n){
        if(n < 0)
            return;
        char[] number = new char[n];
//      初始化
//      for(int i = 0; i < n; i++)
//          number[i] = '0';
        Arrays.fill(number, '0');
        while(!increment(number)){
            printNumber(number);
        }
        return;
    }
    public static boolean increment(char[] num){
        boolean isOverflow = false;
        int size = num.length;
        int carry = 0;
        for(int i = size - 1; i >= 0; i--){
            int temp = num[i] - '0' + carry; //num[i]-'0'结果为num[i]的整型数
            if(i == size - 1)
                temp++;
            if(temp >= 10){
                if(i == 0) //最高位溢出
                    isOverflow = true;
                else{
                    temp -= 10;
                    carry = 1;
                    num[i] = (char) ('0' + temp);
                }
            }else{
                num[i] = (char)('0' + temp);
                break;
            }
        }
        return isOverflow;
    }

    public static void printNumber(char[] num){
        int size = num.length;
        int i = 0;
        while(i < size && num[i] == '0') //i < size在前，否则越界
            i++;
        //char[] printNum = new char[size - i];
        //System.arraycopy(num, i, printNum, 0, size - i);//复制数组
        if(i == size)//不打印全0
            return;
        char[] printNum = Arrays.copyOfRange(num, i, size);//复制数组
        System.out.println(printNum);
    }
}
