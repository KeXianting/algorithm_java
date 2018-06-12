package test.bishi;

import java.util.Scanner;

/**
 * Created by kentorvalds on 2018/4/6.
 * 携程笔试题
 */
public class Ctrip {
    public static void main(String[] args){
       // moveZeroToLast();
        matrixRotate();
    }

    /*
    把数组中0移到数组的末尾,其他元素保持原来的顺序:
    给定一个整数的数组，要求将数组中的所有的0元素移动到数组的最后，其他的元素保持原来的顺序。

    要求：空间复杂度不能超过O(1)

    example：

    给定数组[0,2,0,7]转换后应为[2,7,0,0]

    输入：

    第一行输入一个数组的长度

    其他的数为数组中元素。
     */
    public static void moveZeroToLast(){
        Scanner sc=new Scanner(System.in);
        int  n=sc.nextInt();         //数组长度
        int [] arr=new int[n];
        for(int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println("移动前: ");
        for (int a:arr){
            System.out.print(a+" ");
        }
        System.out.println();
        //moveZeroToLastMethod1(arr);
        moveZeroToLastMethod2(arr);
        System.out.println();
        System.out.println("移动后: ");
        for (int a:arr){
            System.out.print(a+" ");
        }


    }

    //方法1:从后往前扫描,如果遇到0则后移
    public static void moveZeroToLastMethod1(int[] arr){
        int len = arr.length;
        if (arr == null || len<=0){
            return;
        }
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
    //方法2:将非0前移,剩余的补0
    public static void moveZeroToLastMethod2(int[] arr){
        if(arr==null || arr.length<=0)
            return;
        int len=arr.length;
        int count=0;
        for(int i=0;i<len;i++) {
            if(arr[i]!=0)
                arr[count++]=arr[i];    //非0元素从开头计数储存
        }

        for(int i=count;i<len;i++) {            //非0元素开始到数组结束补0
            arr[i]=0;
        }
    }

    /*
    题目2 ： 有一个NxN整数矩阵，请编写一个算法，将矩阵顺时针旋转90度。

    给定一个NxN的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵,保证N小于等于300。
     */
    public static void matrixRotate(){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();        //读 取一行的字符串 并自动换行
        String[] str1=str.split(" ");    //切割字符串--数组
        int N=str1.length;               //矩阵长度N
        int[][] arr=new int[N][N];       //新建数组
        for(int i=0;i<N;i++) {
            arr[0][i]=Integer.valueOf(str1[i]);
        }

        for(int i=1;i<N;i++) {
            String strr=sc.nextLine();
            String[] str2=strr.split(" ");
            for(int j=0;j<N;j++) {
                arr[i][j]=Integer.valueOf(str2[j]);
            }
        }
        int[][] temp=matrixRotateMethod1(arr);
        System.out.println("方法1辅助数组旋转90度: ");
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                System.out.print(temp[i][j]+" ");
            }
            System.out.println();
        }

        matrixRotateMethod2(arr);
        System.out.println("方法2转置后对每一行逆序: ");
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }




    }
    //方法1: 借助辅助数组(分析的时候用3x3的矩阵作为分析例子)
    public static int[][] matrixRotateMethod1(int[][] arr){
        if(arr==null)                        //判断输入合法
            return null;
        int len1=arr.length;
        int len2=arr[0].length;
        int [][]temp=new int [len2][len1];
        int k=len2-1;
        for(int i=0;i<len1;i++,k--) {
            for(int j=0;j<len2;j++) {
                temp[j][k]=arr[i][j];
            }
        }
        return temp;
    }
    //方法2: 不用辅助数组, 先转置, 在逆序
    public static void matrixRotateMethod2(int[][] arr){
        if(arr==null)                            //判断输入合法
            return ;
        int len=arr.length;
        int len2=arr[0].length;
        //转置  沿主对角线对称位置上的元素进行交换
        //在原数组上操作 即交换  否则 辅助数组 arr[i][j]=a[j][i]
        for(int i=0;i<len;i++) {
            for(int j=0;j<i;j++) {            //半个二维矩阵进行交换
                int temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }
        //逆序   对一维数组而言，将每一行第i个元素与第N-i-1个元素进行交换
        for(int i=0;i<len;i++){
            for(int j=0;j<len2/2;j++) {
                int temp=arr[i][j];
                arr[i][j]=arr[i][len2-j-1];
                arr[i][len2-j-1]=temp;
            }
        }
    }

}
