package methd_of_programing.array;

/**
 * Created by kentorvalds on 2017/10/24.
 给定一个n*n(0<n<=100)的矩阵，请找到此矩阵的一个子矩阵，并且此子矩阵的各个元素的和最大，输出这个最大的值。
 Example：
  0 -2 -7  0
  9  2 -6  2
 -4  1 -4  1
 -1  8  0 -2
 最大子矩阵为：
  9 2
 -4 1
 -1 8

 最大子矩阵和是最大子序列和的二维扩展
 */
public class SumOfMaxMatrix {

    public static void main(String[] args){
        //{{0,-2,-7,0},{9,2,-6,2},{-4,1,-4,1},{-1,8,0,-2}};
        int[][] matrix = {{0,-2,-7,0},{9,2,-6,2},{-4,1,-4,1},{-1,8,0,-2}};

        System.out.println("动态规划:" + sumOfMaxMatrixMethod1(matrix));
    }

    //方法1:穷举法
    //方法2:动态规划
    public static int sumOfMaxMatrixMethod1(int[][] arr){

        //假设原始矩阵是arr, 它每一层上下相加后得到的矩阵是total
        int[][] total = arr;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                total[i][j] += total[i-1][j];
            }
        }

        int maximum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {//子矩阵的初始行
            for (int j = i; j < arr.length; j++) {//子矩阵的结束行
                //result 保存的是从 i 行 到第 j 行 所对应的矩阵上下值的和
                /*假设子矩阵如下(前三行),则此时i=1,j=3对应对行求和得到result={4,11,-10,1}
                然后对result数组求最大子数组和,得到15最大,列数为第一,第二列构成....
                列举出所有的行对应的情况:只有一行的情况;两行;....
                9  2 -6  2
                -4  1 -4  1
                -1  8  0 -2
                 */
                int[] result = new int[arr[0].length];
                for (int f = 0; f < arr[0].length; f++) {
                    if (i == 0) {
                        result[f] = total[j][f];
                    } else {
                        result[f] = total[j][f] - total[i - 1][f];
                    }
                }

                int maximal = maxSubsequence(result);

                if (maximal > maximum) {
                    maximum = maximal;
                }


            }
        }

        return maximum;
    }

    //找到一个数组中最大子数组和
    private static int maxSubsequence(int[] array){
        if (array.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int[] maxSub = new int[array.length];
        maxSub[0] = array[0];

        for (int i = 1; i < array.length; i++) {
            maxSub[i] = (maxSub[i-1] > 0) ? (maxSub[i-1] + array[i]) : array[i];
            if (max < maxSub[i]) {
                max = maxSub[i];
            }
        }
        return max;
    }




    //动态规划

}
