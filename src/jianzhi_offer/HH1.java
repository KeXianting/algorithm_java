package jianzhi_offer;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kentorvalds on 2018/4/18.
 * 华为实习笔试题
 */
public class HH1 {

    public static void main(String[] args)throws UnsupportedEncodingException{
       test();

    }

    public static void test1()throws UnsupportedEncodingException{
        Scanner sc = new Scanner(System.in);
        String str = splitString(sc.next());
        if ("".equals(str)){
            System.out.println("");
            return;
        }


        int N = sc.nextInt();
        if (N == 0){
            System.out.println("");
            return;
        }
        if (N > str.length()){
            System.out.println(str);
            return;
        }
        int count = 0;
        byte[] b = str.getBytes("gbk");
        //System.out.println(b[2]);
        if (b[N-1] > 0){//最后一个不是汉字, 是字符, 直接截取
            String s = new String(b, 0, N, "gbk");
            String ss = splitString(s);
            System.out.println(ss);
        }else {//最后一个是汉字
            for (int j = 0; j < N; j ++){//汉子的字符数组为负数
                if (b[j] < 0){
                    count ++;
                    count %=2;
                }
            }

            System.out.println(splitString(new String(b, 0, N - count, "gbk")));
        }
    }

    public static String splitString(String str){
        String regEx = "[0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }

    public static void test(){
        Scanner sc = new Scanner(System.in);
        int years = sc.nextInt();
        int weeks = sc.nextInt();
        int[] a = new int[7];
        int year = 1900;
        int week = 6;
        if (weeks > 6 || weeks < 0){
            System.out.println(-1);
            return;
        }
        if (years > 400 || years < 1){
            System.out.println(-1);
            return;
        }
        for (int i = year; i <= year + years - 1; i ++){
            for (int j = 1; j <=12; j ++){
                a[week%7] ++;
                week += getDays(i,j);
            }
        }
        System.out.println("星期日,星期一.....星期六");
        for (int i = 0; i < 7; i ++){
            System.out.print(a[i] + ", ");
        }
        System.out.println();
        System.out.println(a[weeks]);
    }

    public static int getDays(int y, int m){
        int i;
        if ((y%4==0 && y%100 != 0) || (y%400==0)){
            i = 1;
        }else{
            i = 0;
        }
        if (m==1 || m==3 || m==5 || m==7 || m==8 || m==10 || m==12){
            return 31;
        }else if (m == 2){
            if (i == 1){
                return 29;
            }else {
                return 28;
            }
        }
        return 30;

    }

    public static void test2(){
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if(number <= 0){
            System.out.println("");
            return;
        }
        //printProbability(number);
        PrintProbability_1(number);

    }
    private static final int g_maxValue = 6;
    public static void printProbability(int number){
        if(number<1) return;
        int maxSum = number*g_maxValue;
        int[] pProbabilities = new int[maxSum-number+1];
        for(int i=number;i<=maxSum;i++){
            pProbabilities[i-number] = 0;
        }
        double total = Math.pow(g_maxValue,number);

        probability(number,pProbabilities);
        System.out.print("[");
        for(int i=number;i<maxSum;i++){
            double ratio = pProbabilities[i-number]/total;
           // System.out.println("i: "+i+" ratio: "+ratio);

            System.out.print("["+i+", "+String.format("%.5f",ratio) + "], ");
        }
        double rr = pProbabilities[maxSum-number]/total;
        System.out.print("["+maxSum+", "+String.format("%.5f",rr) + "]]");

    }



    public static void probability(int number,int[] pProbabilities){
        for(int i=1;i<=g_maxValue;i++){//从第一个骰子开始
            probability(number,number,i,pProbabilities);
        }
    }

    public static void probability(int original,int current,int sum,int[] pProbabilities){
        if(current==1){
            pProbabilities[sum-original]++;
        }else{
            for(int i=1;i<=g_maxValue;i++){
                probability(original,current-1,sum+i,pProbabilities);
            }
        }
    }


    public static void PrintProbability_1(int number){
        if(number<1){
            return;
        }
        int[][] pProbabilities = new int[2][g_maxValue*number +1];
        for(int i=0;i<g_maxValue;i++){
            pProbabilities[0][i] = 0;
            pProbabilities[1][i] = 0;
        }
        int flag = 0;
        for(int i=1;i<=g_maxValue;i++){
            pProbabilities[flag][i] = 1;
        }

        for(int k =2;k<=number;k++){
            for(int i=0;i<k;i++){
                pProbabilities[1-flag][i] = 0;
            }
            for(int i=k;i<=g_maxValue*k;i++){
                pProbabilities[1-flag][i] = 0;
                for(int j=1;j<=i&&j<=g_maxValue;j++){
                    pProbabilities[1-flag][i] += pProbabilities[flag][i-j];
                }
            }
            flag = 1-flag;
        }
        double total = Math.pow(g_maxValue, number);
        //DecimalFormat decimalFormat = new DecimalFormat("0.00000");
        System.out.print("[");
        for(int i=number;i<g_maxValue*number;i++){
            double ratio = pProbabilities[flag][i]/total;
            //System.out.println(ratio);
            String temp = String.format("%.5f",ratio);
            if (temp.charAt(0) == '-'){
                temp = temp.substring(1);
            }
            System.out.print("["+i+", "+temp + "], ");
        }
        double rr = pProbabilities[flag][g_maxValue*number]/total;
        String tr = String.format("%.5f",rr);
        if (tr.charAt(0) == '-'){
            tr = tr.substring(1);
        }
        System.out.print("["+g_maxValue*number+", "+tr + "]]");
    }
}
