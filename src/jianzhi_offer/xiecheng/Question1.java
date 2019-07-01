package jianzhi_offer.xiecheng;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by kentorvalds on 2018/9/5.
 */
public class Question1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

//            long a = in.nextLong();
//            long count = getBinaryCount(a);
//            System.out.println(count);
       while (in.hasNext()){

       }
        int count = in.nextInt();
        long time = in.nextLong();
       // Data[] datas = new Data[count];
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String number = in.next();
            long startTime = in.nextLong();
            long endTime = in.nextLong();
            //Data data = new Data(number, startTime, endTime);
            if (time >= startTime && time < endTime) {
                res.add(number);
            }
        }
        if (res == null || res.size() == 0) {
            System.out.println("null");

        } else {
            Collections.sort(res);
        }
        for (String r : res) {
            System.out.println(r);
        }
    }


//        ArrayList<String> res = getNumbers(count, time, datas);
//        if (res == null || res.size() == 0){
//            System.out.println("null");
//        }else {
//            for (String r : res){
//                System.out.println(r);
//            }
//        }

 //}

//    public static ArrayList<String> getNumbers(int count, long time, Data[] datas){
//        ArrayList<String> res = new ArrayList();
////        for (int i = 0; i < datas.length; i ++){
////            if (time > datas[i].startTime && time < datas[i].endTime){
////                res.add(datas[i].number);
////            }
////        }
//        if (datas == null || datas.length == 0 ){
//            return null;
//        }
//        int low = 0;
//        int high = datas.length - 1;
//        while (low <= high){
//            int mid = (low + high)>>>1;
//            Data tempValue = datas[mid];
//            if (time < tempValue.startTime){
//                high = mid - 1;
//            }else if(time > tempValue.endTime){
//                low = mid + 1;
//            }else {
//                res.add(datas[mid].number);
//                high --;
//                low ++;
//            }
//        }
//        Collections.sort(res);
//        return res;
//    }


//    public static long getBinaryCount(long num){
//
//        long count = 0;
//        while (num != 0){
//            count ++;
//            num = num&(num-1);
//        }
//        return count;
////        long count = 0;
////        String str = Long.toBinaryString(num);
////        for (int i = 0; i < str.length(); i ++){
////            if (str.charAt(i) == '1'){
////                count ++;
////            }
////        }
////        return count;
//    }
}
