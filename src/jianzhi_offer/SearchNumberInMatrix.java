package jianzhi_offer;

/**
 * Created by kentorvalds on 2018/6/12.
 * 在一个二维数组中，每一行都是按照从左往右递增的顺序排序，每一列都是按照从上往下递增的顺序排序。
 * 请完成一个函数，输入这样一个二维数组和整数，判断数组是否有改整数。

 例如：下面的二位数组都是每行梅列递增，如果在这个数组中查找数字7，如果有就返回true，如果没有就返回fasle。

 1  2  8   9

 2  4  9   10

 4  7  10  13

 6  8  11   15
 */
public class SearchNumberInMatrix {
    public static void main(String[] args){
        int[] arr = {1,2,8,9,2,4,9,12,4,7,10,13,6,8,11,15};
        int rows = 4;
        int columns = 4;
        int number = 17;
        System.out.println(searchNumber(arr, rows, columns, number));

    }

    static boolean searchNumber(int[] arr, int rows, int columns, int number){
        boolean flag = false;
        int row = 0;
        int column = columns - 1;
        while(row < rows && column >= 0){
            if (arr[row*columns + column] == number){
                flag = true;
                break;
            }else if (arr[row*columns + column] > number){
                column --;
            }else {
                row ++;
            }
        }
        return flag;
    }
}
