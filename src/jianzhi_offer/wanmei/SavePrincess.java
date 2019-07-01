package jianzhi_offer.wanmei;

import java.util.Scanner;

/**
 * Created by kentorvalds on 2018/8/28.
 */
public class SavePrincess {
    /*
        3
        3
        -2 -3 3 -5 10 1 0 30 -5
     */
    public static void main(String args[]) {
        Scanner reader = new Scanner(System.in);
        int x = reader.nextInt();
        int y = reader.nextInt();
        int[][] array = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                array[i][j] = reader.nextInt();
            }
        }
        System.out.println(minHP(array));
    }
    public static int minHP(int[][] m) {
        int row = m.length;
        int col = m[0].length;
        int curHP = 1 - m[row-1][col-1];
        int res = getMinHp(m, row-1, col-1, curHP);
        return res;
    }

    public static int getMinHp(int[][] m, int row, int col, int curHP){
        if (row == 0 || col == 0){
            return curHP;
        }

        for (int i = row; i >=0; i--){
            for (int j = col; j >=0; j --){
                if(curHP + m[row][col] >= 1){
                    int curHP1 = getMinHp(m, i-1, j, curHP + m[row][col]);
                    int curHP2 = getMinHp(m, i, j-1, curHP + m[row][col]);
                    curHP = Math.min(curHP1, curHP2);
                }else {
                    curHP += 1 - (curHP + m[row][col]);
                }
            }
        }
        return curHP;
    }
}