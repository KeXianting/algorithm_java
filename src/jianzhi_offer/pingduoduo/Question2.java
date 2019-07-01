package jianzhi_offer.pingduoduo;

import java.util.*;

/**
 * Created by kentorvalds on 2018/8/30.
 */
public class Question2 {

    public static void main(String[] args){
        /*
        3 4
        . o x o
        o . . o
        . x o x
        .oxo
        o..o
        .xo.
         */
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();
        if (a <= 0 || b <= 0){
            return;
        }
        char[][] matrix = new char[a][b];
        String[] strs = new String[a+1];
        for (int i = 0; i <= a; i ++){
//            for (int j = 0; j < b; j ++){
//                matrix[i][j] = in.next().charAt(0);
//            }
            strs[i] = in.nextLine();
        }

        for (int i = 0; i < a; i ++){
            for (int j = 0; j < b; j ++){
                matrix[i][j] = strs[i+1].charAt(j);
            }
        }

        for (int i = 0; i < a - 1; i ++){
            getFinal(matrix, a, b);
        }

        //getFinal(matrix, a, b);
        for (int i = 0; i < a; i ++) {
            String temp = "";
            for (int j = 0; j < b; j++) {
                //System.out.print(matrix[i][j] + " ");
                temp += matrix[i][j];
            }
            System.out.println(temp);
        }
    }

    public static void getFinal(char[][] matrix, int a, int b){

        for (int i = 0; i < a - 1; i ++) {
            for (int j = 0; j < b; j++) {
                if (matrix[i][j] == 'o'){
                    if (matrix[i+1][j] == '.'){
                        matrix[i+1][j] = 'o';
                        matrix[i][j] = '.';
                    }
                }

            }

        }

        for (int j = 0; j < b; j ++){
            if (matrix[a-1][j] == 'o'){
                matrix[a-1][j] = '.';
            }
        }
    }
}
