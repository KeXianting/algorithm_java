package jianzhi_offer.Meituan;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by kentorvalds on 2018/9/6.
 */
public class Question2 {

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int N = in.nextInt();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < N; i ++){
            int start = in.nextInt();
            int end = in.nextInt();
            hashMap.put(start, end);
        }


    }


}
