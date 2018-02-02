package data_struct.array.test;

/**
 * Created by kentorvalds on 2017/6/11.
 */

import data_struct.array.SeqSparseMatrix;
import data_struct.array.Triple;

/**
 * 进行稀疏矩阵的加法运算
 */
public class SeqSparseMatrixTest {

    public static void main(String[] args) {
        Triple[] elemsa = { new Triple(0, 2, 11), new Triple(0, 4, 17),
                new Triple(1, 1, 20), new Triple(3, 0, 19),
                new Triple(3, 5, 18), new Triple(4, 4, 50) };
        //构建稀疏矩阵(三元组的作用就是用来存储稀疏矩阵)
        SeqSparseMatrix smata = new SeqSparseMatrix(5, 6, elemsa);
        System.out.println("A" + smata.toString());

        Triple[] elemsb = { new Triple(0, 2, -11), new Triple(0, 4, -17),
                new Triple(2, 3, 51), new Triple(3, 0, 10),
                new Triple(4, 5, 99) };
        SeqSparseMatrix smatb = new SeqSparseMatrix(5, 6, elemsb);
        System.out.println("B " + smatb.toString());

        System.out.println("A+B" + smata.plus(smatb).toString());
    }
}
