package methd_of_programing.niuke;

import java.util.Scanner;

/**
 * Created by kentorvalds on 2018/6/14.
 */
public class BiggerThanPro {


       static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }


        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null && l2 == null){
                return null;
            }
            if (l1 != null && l2 == null){
                return l1;
            }
            if (l1 == null && l2 != null){
                return l2;
            }
            int num1 = 0;
            int num2 = 0;
            int i = 0;
            int j = 0;
            while(l1 != null){
                num1 += l1.val*Math.pow(10, i);
                l1 = l1.next;
                i++;
            }
            while(l2 != null){
                num2 += l2.val*Math.pow(10, j);
                l2 = l2.next;
                j ++;
            }
            //System.out.println(Integer.MAX_VALUE);
            int sum = num1 + num2;
            //System.out.println("sum: " + sum);
            ListNode res = new ListNode(sum % 10);
            ListNode nodeT = res;
            sum = sum /10;
            while(sum != 0){
                //System.out.println("sum: " + sum);
                ListNode node = new ListNode(sum % 10);
                //System.out.println("node: " + node.val)
                res.next = node;
                res = res.next;
                sum = sum /10;
            }
            return nodeT;
        }

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2);
//        ListNode l2 = new ListNode(4);
//        ListNode l3 = new ListNode(3);
//        l1.next = l2;
//        l2.next = l3;
//        l3.next = null;
//        ListNode l4 = new ListNode(5);
//        ListNode l5 = new ListNode(6);
//        ListNode l6 = new ListNode(4);
//        l4.next = l5;
//        l5.next = l6;
//        l6.next = null;
        System.out.println((long)(1999999999+9));
        ListNode l1 = new ListNode(9);
        l1.next = null;

        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(9);
        ListNode l4 = new ListNode(9);
        ListNode l5 = new ListNode(9);

        ListNode l6 = new ListNode(9);
        ListNode l7 = new ListNode(9);
        ListNode l8 = new ListNode(9);

        ListNode l9 = new ListNode(9);
        ListNode l10 = new ListNode(9);
        ListNode l11 = new ListNode(9);
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l9;
        l9.next = l10;
        l10.next = l11;
        l11.next = null;
        ListNode res = addTwoNumbers(l1, l2);
        //System.out.println(Math.pow(2,31)-1);
        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }


//        Scanner in = new Scanner(System.in);
//        int a = 0,b = 0,c = 0,d = 0,e=0,f=0;
//
//
//            a = in.nextInt();
//            b = in.nextInt();
//            c = in.nextInt();
//
//            d = in.nextInt();
//            e = in.nextInt();
//            f = in.nextInt();
//        if (a > 13 || a < 0 || b > 13 || b < 0 || c > 13 || c < 0|| d > 13 || d < 0 || e > 13 || e < 0 || f > 13 || f < 0){
//            return;
//        }
//
//        int sumA = a + b + c;
//        int sumB = d + e + f;
//        int diff = Math.abs((sumA - sumB));
//        double count = 0;
//        for (int i = 1; i <= 13; i ++){
//            for (int j = 1; j <= 13; j ++){
//                if ((sumA + i) > (sumB + j)){
//                    count ++;
//                }
//            }
//        }
//        DecimalFormat df = new DecimalFormat("#0.0000");
//        double p = count/(13*13);
//        System.out.println(df.format(p));
        //test();
//        int[][] A = {{1,1,0},{1,0,1},{0,0,0}};
//        System.out.println("原始矩阵: ");
//        for (int i = 0; i < A.length; i ++){
//            for (int j = 0; j < A[0].length; j ++){
//                System.out.print(A[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("=============");
//        flipAndInvertImage(A);
//        System.out.println("操作后: ");
//        for (int i = 0; i < A.length; i ++){
//            for (int j = 0; j < A[0].length; j ++){
//                System.out.print(A[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

    public static void test(){

        /*
        4
        1 1
        2 2
        3 3
        1 3
        4
        1 1 2 2
        1 1 3 3
        2 2 3 3
        1 2 2 3

         */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] star = new int[n][2];
        for (int i = 0 ; i < n; i ++){
            star[i][0] = in.nextInt();
            star[i][1] = in.nextInt();

        }
        int m = in.nextInt();
        int[][] question = new int[m][4];
        for (int i = 0; i < m; i ++){
            question[i][0] = in.nextInt();
            question[i][1] = in.nextInt();
            question[i][2] = in.nextInt();
            question[i][3] = in.nextInt();
        }

        for (int j = 0; j < m; j ++){
            int count = 0;
            for (int i = 0; i < n; i ++){
                if ((star[i][0] <= question[j][2] && star[i][0] >= question[j][0]) &&
                        (star[i][1] <= question[j][3] && star[i][1] >= question[j][1])){
                    count ++;
                }
            }
            System.out.println(count);
        }


    }

    public static int[][] flipAndInvertImage(int[][] A) {
        if(A == null || A.length <= 0){
            return null;
        }
        int rows = A.length;
        int cols = A[0].length;
        System.out.println(rows + "; " + cols);
        //first step
        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < cols/2; j ++){
                int temp = A[i][j];
                A[i][j] = A[i][cols - 1 - j];
                A[i][cols - 1 -j] = temp;
            }
        }
        System.out.println("第一步后: ");
        for (int i = 0; i < A.length; i ++){
            for (int j = 0; j < A[0].length; j ++){
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
        //second step
        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < cols; j ++){
                if(A[i][j] == 0){
                    A[i][j] = 1;
                }else{
                    A[i][j] = 0;
                }
            }
        }
        return A;

    }
}
/*
又是晴朗的一天，牛牛的小伙伴们都跑来找牛牛去公园玩。但是牛牛想呆在家里看E3展，不想出去逛公园，可是牛牛又不想鸽掉他的小伙伴们，于是找来了公园的地图，发现公园是由一个边长为n的正方形构成的，公园一共有m个入口，但出口只有一个。公园内有一些湖和建筑，牛牛和他的小伙伴们肯定不能从他们中间穿过，所以只能绕行。牛牛想知道他需要走的最短距离并输出这个最短距离。
输入描述:
第一行输入一个数字n(1≤n≤1000)表示公园的边长
接下来会给你一个n*n的公园地图，其中 . 表示公园里的道路，@表示公园的入口，*表示公园的出口，#表示公园内的湖和建筑。牛牛和他的小伙伴们每次只能上下左右移动一格位置。
输入保证公园入口个数m(1≤m≤10000)且所有的入口都能和出口相连。
输出描述:
输出牛牛需要行走的最短距离。
示例1
输入
10
.@....##@.
......#...
...@..#...
###.......
....##..#.
...####...
@...##....
#####.....
..##*####.
#.........
输出
16
 */

