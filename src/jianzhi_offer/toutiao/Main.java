package jianzhi_offer.toutiao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by kentorvalds on 2018/8/25.
 */
public class Main {

    public static void main(String[] args){
//        String s = "kenan";
//        System.out.println(s.substring(1,3));
        /*
        3
2
helloworld
hdlrowolle
2
helloworld
worldhello
2
abcde
acbde

         */
       // StringBuilder s;s.append()
       // question3();

        String[] str1= new String[2];
        //Scanner in = new Scanner(System.in);
        str1[0] = "helloworld";
        str1[1] = "hdlrowolle";
        //System.out.println(str1.length);
        boolean res = isDoubleLive(str1);
        System.out.println(res);
    }

    public static int question2(){
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int n = in.nextInt();


        }

        return 0;
    }



    public static String question3(){
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int n = in.nextInt();
            ArrayList r = new ArrayList();
            for(int i = 0; i < n; i ++){
                int m = in.nextInt();
                String[] strs = new String[m];
                for (int j = 0; j < m; j ++){
                    strs[i] = in.nextLine();
                    //System.out.println(strs[i]);
                }

                //判断是否双生
                //String[] str1= {"helloworld","hdlrowolle"};
                boolean res = isDoubleLive(strs);
                if (res){
                    r.add(i, "Yeah");
                }else {
                    r.add(i, "Sad");
                }
            }
            for (int i = 0; i < r.size(); i ++){
                System.out.println(r.get(i));
            }


        }

        return "";
    }

    public static boolean isDoubleLive(String[] strs){

        HashMap hashMap = new HashMap();
        for (int i = 0; i < strs.length; i ++){
            hashMap.put(i, strs[i]);
        }

       // String[] strings = new String[2*strs.length];
        ArrayList strTemp = new ArrayList();
        for (int i = 0; i < strs.length ; i++){
            //System.out.println(strs[i]);
            for (int j = 1; j < strs[i].length(); j ++){//不包含自己
                String tepStr = strs[i].substring(j,strs[i].length()) + strs[i].substring(0,j);
                //String tempStr = new StringBuilder(tepStr).reverse().toString();
                strTemp.add(strs[i].substring(j,strs[i].length()) + strs[i].substring(0,j));
                strTemp.add(new StringBuilder(tepStr).reverse().toString());
            }

        }
        System.out.println("=============");
        for (int i = 0; i<hashMap.size(); i ++){
            System.out.println(hashMap.get(i));
        }
        System.out.println("================");
        System.out.println("+=+++++++++++++");
        for (int i = 0; i < strTemp.size(); i ++){
            System.out.println(strTemp.get(i));
        }
        System.out.println("+=+++++++++++++");

        for (int i = 0; i < strTemp.size(); i ++){
            if (hashMap.containsValue(strTemp.get(i))){
                return true;
            }
        }
        return false;
    }
}
