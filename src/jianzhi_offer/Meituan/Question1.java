package jianzhi_offer.Meituan;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * Created by kentorvalds on 2018/9/6.
 */
public class Question1 {



    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        int T = in.nextInt();
        int data[]=new int[N];
        for(int i = 0;i < N;i++){
            data[i] = in.nextInt();
        }
        int count=0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i=0;i <= N - K;i++){
            if(isRight(data,i, K, T, hashMap)){
                count++;
            }
        }
        System.out.println(count);

        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(1,2);
    }
    public static boolean isRight(int data[], int start, int num, int t, HashMap<Integer, Integer> hashMap){
        //HashMap<Integer,Integer> hashMap = new HashMap<>();
        boolean flag = false;
        for(int i = 0; i < num; i ++){

            if(hashMap.keySet().contains(data[start+i])){
                if(hashMap.get(data[start+i]) + 1 >= t){
                    flag = true;
                    break;
                }
                hashMap.put(data[start+i], hashMap.get(data[start+i]) + 1);
            }else {
                hashMap.put(data[start+i], 1);
            }
        }
        hashMap.clear();
        return flag;
    }
}
