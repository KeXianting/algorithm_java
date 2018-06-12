package jianzhi_offer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kentorvalds on 2018/4/10.
 * 最长不含重复字符的子字符串
 * 例如: "arabcacfr"中最长不含重复字符的子字符为"acfr",长度为4
 */
public class LongestStrNoRepeatedChar {

    public static void main(String[]args){
        System.out.println(getLongestSubString("arabcacfre"));
    }

    //动态规划
    public static int getLongestSubString(String str) {
        //统计str中每种字符之前出现的位置
        Map<Character, Integer> charPosition = new HashMap<>();
        //preArr代表以s[i-1]结尾的情况下，最长无重复子串的长度
        int[] preArr = new int[str.length()];
        char[] strArray = str.toCharArray();
        //从头到尾遍历str2charArr，统计出以每个字符为当前位置的向前最长无重复子串的长度
        for (int i = 0; i < strArray.length; i++) {
            //字符strArray[i]出现的位置
            Integer lastPosOfChar = charPosition.get(strArray[i]);
            if (lastPosOfChar == null) {//当该字符前面没有出现过,直接+1
                //更新最长无重复子串的长度
                preArr[i] = i == 0 ? 1 : preArr[i - 1] + 1;
                //记录当前字符出现的位置
                //charPosition.put(strArray[i], i);
            } else {//当前字符不是第一次出现(既然不是第一次出现，那也不是在第一个位置),也就是之前出现过该字符
                //该字符之前出现的位置加1: arabcacfr,例如当前子串为rabc, 此时到下一个字符为a, 此时前一个a的位置为2,当前a的位置为5
                //d为当前字符和当前字符上一次出现的位置的距离,如果距离小于等于f(i-1),则当前字符最长无重复字符的长度为d,即f(i)=d;
                //当d>=f(i-1),则证明当前字符没有在f(i-1)这个最长子串中出现,因此f(i)=f(i-1)+1,其中f(i)为当前字符为结尾的最长不含重复字符的子串
                int d = i - lastPosOfChar;
                if (d <= preArr[i-1]) {
                    //当前位置的最长无重复子串长度
                    preArr[i] = d;
                } else {
                    //当前位置的最长无重复子串长度
                    preArr[i] = preArr[i - 1] + 1;
                }


            }
            //跟新当前字符出现的位置
            charPosition.put(strArray[i], i);
        }
        //遍历preArr,最大值即为所求
        int max = preArr[0];
        for(int i: preArr)
            if(i > max)
                max = i;
        return max;
    }
}
