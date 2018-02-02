package data_struct.array.test;

import data_struct.array.Matrix;

/**
 * Created by kentorvalds on 2017/6/11.
 */
//矩阵测试
public class MatrixTest {
    public static void main(String[] args) {
        int m1[][] = { { 1, 2, 3 }, { 4, 5, 6, 7, 8, 9 }, { 9, 10, 11 } };
        //System.out.println(m1[2][3]); //第3行第四列没有给初值, ArrayIndexOutOfBoundsException
//        for (int i = 0; i < m1.length; i ++){
//            for (int j = 0; j < m1[i].length; j ++){
//                System.out.println(m1[i][j]);
//            }
//        }
        Matrix mata = new Matrix(3, 4, m1);
        System.out.println("A" + mata.toString());


        Matrix matb = new Matrix(3, 4);
        matb.set(0, 0, 1);
        matb.set(1, 1, 1);
        matb.set(2, 2, 1);
        System.out.println("B" + matb.toString());

        mata.add(matb);
        System.out.println("A+=B" + mata.toString());
    }

}
