package jianzhi_offer.XIAOMI;

import java.util.*;

/**
 * Created by kentorvalds on 2018/9/20.
 * 10#15
 4#32
 4#33
 8#17
 END
 */
public class Question1 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String line = null;
        ArrayList<String> arr = new ArrayList<>();
        int i = 0;
        while (! "END".equals(line = in.nextLine())){
            arr.add(i, line);
            i ++;
        }
        LinkedHashMap<Integer, String> res= new LinkedHashMap<Integer, String>();
        res = getOutput(arr);
        if (res.size() > 0){
            for (Map.Entry<Integer, String> entry : res.entrySet()){
                System.out.println(entry.getValue());
            }
        }else {
            System.out.println("None");
        }
    }

    public static LinkedHashMap<Integer, String> getOutput(ArrayList<String> arr){
        int len = arr.size();
        int[] nums = new int[len];
        LinkedHashMap<Integer, String> res = new LinkedHashMap<Integer, String>();
        for (int i = 0 ; i < len; i ++){

            int number = changeToten(arr.get(i).split("#")[0], arr.get(i).split("#")[1]);
            nums[i] = number;

        }
        for (int i = 0; i < nums.length; i ++){
            int sum = 0;
            int t = nums[i];
            for (int j = 0; j < nums.length; j ++){
                if (t == nums[j]){
                    sum ++;
                }
            }
            if (sum == 1){
                res.put(i,arr.get(i));
            }

        }

        return res;
    }
    public static int changeToten(String k, String number){
        if (Integer.parseInt(k) == 10){
            return Integer.parseInt(number);
        }
        int kth = Integer.parseInt(k);
        int num = 0;
        for (int i = 0; i < number.length(); i ++){
            num += Integer.parseInt(String.valueOf(number.charAt(i)))*Math.pow(kth, number.length() - i - 1);
        }
        return num;
    }
}
