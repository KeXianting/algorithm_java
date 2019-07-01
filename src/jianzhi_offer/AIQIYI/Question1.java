package jianzhi_offer.AIQIYI;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by kentorvalds on 2018/9/15.
 * 3 4 2
 5 3 1
 B 1
 A 2
 A 2
 A 3
 */
public class Question1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int P = in.nextInt();
        int[] arr = new int[N];
        Food[] foods = new Food[N];
        for (int i = 0; i < N; i ++){
            Food f = new Food();
            f.name =  (char) i;
            arr[i] = in.nextInt();
            f.count = arr[i];
            foods[i] = f;
        }
        for (int i = 0; i < M; i ++){
            char c = in.next().charAt(0);
            int number = in.nextInt();
            if (c == 'B'){
                foods[number-1].count = foods[number-1].count --;
            }
            if (c == 'A'){
                foods[number-1].count  = foods[number-1].count ++;
            }

        }
        Arrays.sort(foods);
        for(int i = 0; i < foods.length; i ++){
            if (foods[i].count == foods[P].count){
                System.out.println(i-1);
            }
        }
       // System.out.println(foods[P].count);

    }

    static class Food implements Comparable<Food>{
        int count;
        char name;
        Food(){}

        @Override
        public int compareTo(Food o) {
            if (this.count > o.count){
                return 1;
            }else {
                return -1;
            }
        }
    }

}
