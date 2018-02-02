package methd_of_programing.array;

/**
 * Created by kentorvalds on 2017/10/24.
 * 有一个由n个正整数组成的序列,给定一个整数s,要求出序列中长度最短的一个连续序列,满足该序列的和大于
 * 等于S的条件
 */
public class LessSeq {

    public static void main(String[] args){
        int[] a = {1,2,4,3,5,3,6,5,2,4};

        System.out.println("暴力法: " + lessSeqMethod1(a, 10));
    }

    //方法1:枚举
    public static int lessSeqMethod1(int[] arr, int s){
        int sum = 0;
        int len = arr.length;
        int k = 0;
        //子序列以i开头j结尾
        for (int i = 0; i < arr.length ; i ++){
            for(int j = i; j < arr.length ; j ++){
                for (k = i; k <= j; k ++){
                    sum += arr[k];
                    if (sum >= s){
                        len = min(len, k - i + 1);
                        break;
                    }
                }

                sum = 0;
            }

        }
        return len;
    }
    private static int min(int x, int y){
       return x<y ? x:y;
    }


    //方法2:因为都是正数,所以当从第一个数开始累加,累加到大于s的时候,开始删掉前面的数,直到小于s,每次记录下删除后小于s前的长度; 重复,并跟新长度
    public static int lessSeqMethod2(int[] arr, int s){
        int start=0, end=0,sum=0;
        int len = arr.length;

        //{1,2,4,3,5,3,6,5,2,4}
        //{1,2,4,3}>=10;
        //去掉1,{2,4,3}不满足,长度为4
        //加上5,{2,4,5}>=10,长度为3,更新最小长度
        //去掉2,{4,5}不满足
        //加上3,{4,5,3}>=10,长度为3
        //去掉4,{5,3}不满足
        //加上6,{5,3,6}>=10,满足
        //去掉5,{3,6},不满足,此时长度仍然为3
        //加上5,{3,6,5}>=10
        //去掉3,{6,5}>=10,满足,更新长度为2
        //继续...
        while (end<arr.length){
            if (sum < s){
                sum += arr[end];
            }
            while (sum > s){
                sum -= arr[start];
                len = min(len, end - start + 1);
                start ++;
            }

            end ++;

        }
        return len;
    }


}

