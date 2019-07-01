package jianzhi_offer.beike;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * Created by kentorvalds on 2018/9/3.
 *      4
     16 5
     20 5
     10 10
     18 2
 */
public class Question1 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {//注意while处理多个case
            LinkedHashMap<Integer, Integer> hashMap = new LinkedHashMap<>();
            int N = in.nextInt();

            for (int i = 0; i < N; i ++){
                int index = in.nextInt();
                //index[i] = in.nextInt();
                //h[i] = in.nextInt();
                int h = in.nextInt();
                hashMap.put(index, h);
            }


            ArrayList<Integer> res = new ArrayList<>();

            res = getRes(hashMap);
           // System.out.println(res.size());
            for (Integer r : res ){
                System.out.print(r + " ");
            }



        }

    }

    public static ArrayList getRes(LinkedHashMap<Integer, Integer> hashMap){
        ArrayList<Integer> res = new ArrayList<>();

        for (Integer h : hashMap.keySet()){
           // System.out.println("key: " + h + "; " + "value: " + hashMap.get(h));
            int num = 0;
            int index = hashMap.get(h);
            int left = h + 1;
            int right = h + index - 1;
            for (Integer val : hashMap.keySet()){
                if (val >= left && val <= right){

                    num ++;
                }
            }
            res.add(num+1);

        }
        return res;
    }


    //
}
