package leetcode;

/**
 * Created by kentorvalds on 2017/7/15.
 */
public class TopKTest {

    public static void main(String[] arg){
        int[] a = {1,4,3,7,8,0,3,10,32,56,34,89,37,72,107};
        int[] b= {107,8,7,4,3};
        for (int i = 0; i < b.length; i ++){
            int temp = b[i];
            int index = 0;
            for (int j = 0; j < a.length; j ++){
                if (temp <= a[j]){
                    temp = a[j];
                    index = j;


                }
            }
           a[index] = -1;
            b[i] = temp;

        }

        for (int i = 0; i < b.length; i ++){
            System.out.print(b[i] + ",");
        }


        //或者循环交换
        for (int i = 0; i < a.length; i ++){

        }

    }
}
