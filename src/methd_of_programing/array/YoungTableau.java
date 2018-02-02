package methd_of_programing.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kentorvalds on 2018/1/10.
 *  杨氏矩阵是一个二维矩阵，特点是每一行的右边的元素比左边的大，每一列下面的元素比上面的大；
 比如

 1 2 8 9
 2 4 9 12
 4 7 10 13
 6 8 11 15
 定位法(Step-wise线性搜索解法)
 假设要查找的变量为target, 以右上角的节点为基准点，如果查找的元素比基准点小，
 那么基准点所在的列就可以排除了；如果查找的元素比基准点大，
 那么基准点所在的行就可以排除了，就这样反复排除，最后可以把时间复杂度降低到O(m+n)，从左下角开始查找也是同样的道理，但是左上角和右下角就不行了，无法做到剔除某列或某行的效果
 */
public class YoungTableau {
    private int row;
    private int column;
    private int value;

    public static void main(String args[]) {
        int matrix[][] = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 },
                { 6, 8, 11, 15 } };
        //find(rows, columns, target), 矩阵的行,列,查找的目标值
        printMatrix(matrix, 4, 4);
        find(matrix, 4, 4, -3);
        find(null, 4, 4, 88);
        find(matrix, 0, 4, 5);
        find(matrix, 4, -2, 5);
        find(matrix, 4, 4, 5);
        find(matrix, 4, 4, 7);
        find(matrix, 4, 4, 1000);
        find(matrix, 4, 4, -1);
    }
    private static boolean isValid(int[][] matrix, int rows, int columns) {
        boolean isValid = false;
        /** 判断二维矩阵每列合法性 */
        if (matrix != null && rows > 0 && columns > 0) {
            int rowLength = matrix.length;
            if (columns <= rowLength) {
                int columnLength = matrix[0].length;
                for (int i = 1; i < rowLength; i++) {
                    columnLength = columnLength > matrix[i].length ? columnLength
                            : matrix[i].length;
                    if (columnLength > columns) {
                        return isValid;
                    }
                }
                isValid = true;
            }
        } else {
            System.out.println("矩阵输入非法");
        }
        return isValid;
    }
    public static void printResult(List<YoungTableau> result) {
        System.out.println("=====Begin=====");
        if (result.size() == 0) {
            System.out.println("There is no result");
        }
        for (YoungTableau yt : result) {
            System.out.println("find value:" + yt.getValue() + " column:"
                    + yt.getRow() + " column:" + yt.getColumn());
        }
        System.out.println("=====End=====");
    }
    public static List<YoungTableau> find(int[][] matrix, int rows,
                                          int columns, int target) {
        List<YoungTableau> result = new ArrayList<YoungTableau>();
        /** 判空及异常的判断 */
        if (isValid(matrix, rows, columns)) {
            /** 先以右上角的节点为开始 */
            int row = 0;
            int column = columns - 1;
            /** 结束循环的条件 */
            while (row < rows && column >= 0) {
                if (target == matrix[row][column]) {
                    /** 节点找到，向result加入节点元素 */
                    result.add(new YoungTableau(row, column,
                            matrix[row][column]));
                    /** 如果找到，那么这行和这列都可以去掉 */
                    column--;
                    row++;
                } else if (target < matrix[row][column]) {
                    /** 节点比基准点小，target所在列可以去除 */
                    column--;
                } else {
                    /** 节点比基准点大，target所在行可以去除 */
                    row++;
                }

            }
        }
        /** 这里为了方便直接打印一下 */
        printResult(result);
        return result;
    }
    public static void printMatrix(int[][] matrix, int rows, int columns) {
        if (isValid(matrix, rows, columns)) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    System.out.print(matrix[i][j] + "\t");
                }
                System.out.println();
            }
        }
    }
    public YoungTableau(int x, int y, int value) {
        super();
        this.setRow(x);
        this.setColumn(y);
        this.setValue(value);
    }

    public YoungTableau() {
    }
    public void setRow(int row) {
        this.row = row;
    }

    public int getRow() {
        return row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getColumn() {
        return column;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }


}
