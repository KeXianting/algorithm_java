package methd_of_programing.niuke;

import java.util.HashMap;

/**
 * Created by kentorvalds on 2018/3/15.
 * 时间限制：1秒

 空间限制：32768K

 小易有一些彩色的砖块。每种颜色由一个大写字母表示。各个颜色砖块看起来都完全一样。
 现在有一个给定的字符串s,s中每个字符代表小易的某个砖块的颜色。
 小易想把他所有的砖块排成一行。如果最多存在一对不同颜色的相邻砖块,
 那么这行砖块就很漂亮的。请你帮助小易计算有多少种方式将他所有砖块排成漂亮的一行。
 (如果两种方式所对应的砖块颜色序列是相同的,那么认为这两种方式是一样的。)
 例如: s = "ABAB",那么小易有六种排列的结果:
 "AABB","ABAB","ABBA","BAAB","BABA","BBAA"
 其中只有"AABB"和"BBAA"满足最多只有一对不同颜色的相邻砖块。
 输入描述:
 输入包括一个字符串s,字符串s的长度length(1 ≤ length ≤ 50),s中的每一个字符都为一个大写字母(A到Z)。


 输出描述:
 输出一个整数,表示小易可以有多少种方式。

 输入例子1:
 ABAB

 输出例子1:
 2
 */
public class ColorBlock {
    public static void main(String[] args){
        String s = "AAA";
        //转换: 如何字符串中不同字符个数大于2, 则一定存在至少两组不同颜色的字符相邻, 所以当不同字符个数大于2时不存在
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for (int i = 0; i<s.length() ; i++){
            hashMap.put(s.charAt(i),0);
        }
        if (hashMap.size() > 2){
            System.out.println(0);
        }else{
            System.out.println(hashMap.size());
        }

    }
}
