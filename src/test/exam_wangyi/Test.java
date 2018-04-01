package test.exam_wangyi;

import java.util.Scanner;

/**
 * Created by kentorvalds on 2018/3/27.
 */
public class Test {
    public static void main(String[] args){
        //输入整数n
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//
//        int[] x1 = new int[n];
//        int[] y1 = new int[n];
//
//        int[] x2 = new int[n];
//        int[] y2 = new int[n];
//
//        //左下角横坐标
//        for(int i = 0; i < n; i ++){
//            x1[i] = sc.nextInt();
//        }
//
//        //左下角纵坐标
//        for (int i = 0; i < n; i ++){
//            y1[i] = sc.nextInt();
//        }
//
//        //右上角横坐标
//        for(int i = 0; i < n; i ++){
//            x2[i] = sc.nextInt();
//        }
//        //右上角纵坐标
//        for(int i = 0; i < n; i ++){
//            y2[i] = sc.nextInt();
//        }
//
//        int count = 0;
//        for (int i = 0; i < n; i ++){
//           //找出坐标(x,y)满足范围在所有(x1[i],y1[i])和(x2[i],y2[i])之间的点
//
//        }


       // print();
        //print1();
//        int arr[] = {0,7,0,2};
//        ctrip1(arr);
//        for (int i:arr){
//            System.out.println(i);
//        }

//        int[][] arr = {{1,4,7},{2,5,8},{3,6,9}};
//        for (int i = 0; i < arr.length; i ++){
//            for (int j = 0 ; j < arr[0].length; j ++){
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println("=====");
//        int[][] brr = ctrip2(arr);
//        for (int i = 0; i < arr.length; i ++){
//            for (int j = 0 ; j < arr[0].length; j ++){
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }

        /*
        1 4 7
        2 5 8
        3 6 9
         */
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int[][] arr = new int[N][N];
//        for(int i = 0 ; i < N; i ++){
//            for(int j = 0 ; j < N; j ++){
//                arr[i][j] = sc.nextInt();
//            }
//           // System.out.println();
//        }
//
//        int[][] brr = new int[N][N];
//        for (int i = 0; i < N; i ++){
//            for (int j = 0; j < N; j ++){
//                brr[j][N-1-i]=arr[i][j];
//            }
//        }
//
//        for (int i = 0; i < brr.length; i ++){
//            for (int j = 0 ; j < brr[0].length; j ++){
//                System.out.print(brr[i][j]+" ");
//            }
//            System.out.println();
//        }


        double a = powerWithExponent(2.0,8);
        System.out.println("结果: " + a);

    }
    public static void print(){
        //输入整数n
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //输入整数k
        int k = sc.nextInt();
        int count = 0;

        for (int i = 1; i <= n; i ++ ){
            for (int j = 1; j <= n ; j ++){
                if (i%j >= k){
                    count ++;
                }
            }
        }
        System.out.println(count);
    }

    public static void print1(){
        /*
        3 3
        1 100
        10 1000
        1000000000 1001
        9 10 1000000000
         */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] di = new int[N];
        int[] pi = new int[N];
        int[] ai = new int[M];
        for (int i = 0 ;i < N; i ++){
            di[i] = sc.nextInt();
            pi[i] = sc.nextInt();

        }
        for (int i = 0; i < M; i ++){
            ai[i] = sc.nextInt();
        }

        for (int j = 0; j < M; j ++){
            int temp = 0;
            for (int i = 0; i < N; i ++){
                if (ai[j]>=di[i] && pi[i]>temp){
                    //System.out.println(pi[i]);
                    temp = pi[i];
                }
            }
            System.out.println(temp);
        }
    }

    public static void ctrip1(int[] arr){
        int len = arr.length;

        for (int i = arr.length - 2; i >=0 ; i --){
            if (arr[i] == 0){
                for (int j = i; j < arr.length - 1; j ++){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    public static int[][] ctrip2(int[][] arr){
//        int n = arr.length;
//        int[][] brr = new int[n][n];
//        for (int i = 0; i < n; i ++){
//            for (int j = 0; j < n; j ++){
//                brr[j][n-1-i]=arr[i][j];
//            }
//        }
//        return brr;

        int N = arr.length;
        for(int i = 0; i<N/2; i++){

            int start = i;

            int end = N-1-i;



            for(int j = i; j<end; j++)

            {

                int offset = j-i;

                int temp = arr[start][j];

                arr[start][j] = arr[end-offset][start];

                arr[end-offset][start] = arr[end][end-offset];

                arr[end][end-offset] = arr[j][end];

                arr[j][end] = temp;

            }

        }
        return arr;
    }

    public static void ctrip3(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//房型

        int[][] arr = new int[n][3];
        for (int i = 0 ; i < n; i ++){
            for (int j = 0 ;j < 3; j ++){
                arr[i][j] = sc.nextInt();
            }
        }

        int[] b = new int[3];
        for (int i = 0; i < 3; i ++){
            b[i] = sc.nextInt();
        }
        double price = 0.0;
        for (int i = 0 ; i < n; i++){

            if (b[0]<=arr[i][0] && b[1]<=arr[i][1]){
                price = b[2]*arr[i][2];
            }
            if (i > 0){
                for (int j = i - 1; j >=0; j --){
                    System.out.print(j + ",");

                }
                System.out.print(1+","+price);
            }else {
                System.out.println(1+","+price);
            }

        }
    }

    public static double powerWithExponent(double base, int exp){
        if (exp == 0){
            return 1;
        }
        if (exp == 1){
            return base;
        }
        System.out.println("=== " + exp);
        double result = powerWithExponent(base,exp>>1);
        System.out.println("*** " + exp);
        result *= result;
        if ((exp & 1) == 1){
            System.out.println("++++++");
            result *=base;
        }
        return result;
    }
}
