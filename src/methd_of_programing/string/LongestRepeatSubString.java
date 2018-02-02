package methd_of_programing.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by kentorvalds on 2017/10/10.
 */
public class LongestRepeatSubString {

    public static void main(String[] args){

        String str = "canffcancd";
        String str1 = "banana";
        System.out.println("方法1:");
        System.out.println(getLongestRepeatedSubstringMethod1(str));

        System.out.println("方法2:");
        System.out.println(getLongestRepeatedSubstringMethod2(str));


        System.out.println("方法3:");
        System.out.println(getLongestRepeatedSubstringMethod3(str1));
    }


    public static String getLongestRepeatedSubstringMethod1(String str) {
        String reg, left;
        //最长的重复字串，极端情况就比如abcabc，最长重复字串就是abc
        //即为字符串长度的一半，当然这是极端情况，通常都是小于串长一半的
        for (int len = str.length() / 2; len > 0; len--) {
            //将字符串分隔为若干“最长字串”
            for (int i = 0; i < str.length() / len; i++) {
                //获取“最长字串”,最长的开始为整个字符串的一半
                reg = str.substring(0, len + 1);
                //刨去“最长字串”剩下的串
                left = str.substring(len + 1); //从len+1开始到结束字符
                //如果剩下的串里面包含“最长字串”
                if (left.indexOf(reg) != -1)
                    //找到返回
                    return reg;
            }

        }
        //找不到就返回空
        return null;
    }

    //思路：使用两个指针，两个指针的间隔从1，2，3...依次增大， 同时向右移动两个指针，在移动的过程中判断指针位置的字符是否相同，并记录最长子串的长度
    //时间负责度:O(n*n)
    public static String getLongestRepeatedSubstringMethod2(String str){
        // 参数检查
        if (str == null || str.length() == 0) {
            return null;
        }
        // 重复子串的最长长度
        int max = 0;
        // 最长重复子串的起始位置
        int first = 0;
        int k = 0;
        //相隔一个字符是否有相等,记录长度和起始位置;相隔两个字符是否有相等,记录长度和起始位置;相隔三个字符....
        for (int i = 1; i < str.length(); i++) {
            for (int j = 0; j < str.length() - i; j++) {
                //相隔一个字符;相隔两个字符;....
                if (str.charAt(j) == str.charAt(i + j)) {
                    k++;
                } else {
                    k = 0;
                }
                if (k > max) {
                    max = k;
                    //最长重复子串的起始位置
                    first = j - k + 1;
                }
            }
        }
        if (max > 0) {
           // System.out.println(max);
            return str.substring(first, first + max);
        }
        return null;
    }


    //方法3:后缀数组实现
    public static List<String> getLongestRepeatedSubstringMethod3(String str){
        //构建后缀
        List<String> suffix = new ArrayList<>();
        for (int i = 0; i < str.length(); i ++){
            suffix.add(str.substring(i));
        }
        //按字典序排序
        Collections.sort(suffix);
        //最长子串的截取位置
        int temp = 0, maxis = 0;

        //比较排序后的后缀
        for (int i = 0; i < suffix.size() - 1; i ++){
            int len = maxlength(suffix.get(i), suffix.get(i + 1));//获取后缀数组两两比较的相同子序列长度
            if(len >= temp){
                temp = len;
                maxis = i;
            }
        }

        List<String> results = new ArrayList<String>();

        results.add(suffix.get(maxis).substring(0, temp));//根据最长的重复子序列下标和截取位置，获得最长的重复子序列

        return results;

    }
    private static int maxlength(String next, String next2) {
        char[] c1 = next.toCharArray();
        char[] c2 = next2.toCharArray();
        int maxlen = 0;
        for(int i = 0; i < (c1.length > c2.length ? c2.length : c1.length); i++){
            if(c1[i] == c2[i]){
                maxlen++;
            }
        }
        return maxlen;
    }
}
