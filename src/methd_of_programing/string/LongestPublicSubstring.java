package methd_of_programing.string;

/**
 * Created by kentorvalds on 2017/10/10.
 */
/*
最长公共子串(区别与最长公共子序列): A="pabcni", B="wepiabc"; 则输出为"abc"
 */
public class LongestPublicSubstring {

    public static void main(String[] args){
        String s1 = "pabcdenkenxia";
        String s2 = "wekenxipiabcdef";
        System.out.println("暴力搜索结果为:" + getLongestPublicSubstringMethod1(s1,s2));

        System.out.println("动态规划结果为:" + getLongestPublicSubstringMethod2(s1, s2));
    }

    //方法1:暴力搜索
    public static String getLongestPublicSubstringMethod1(String s1, String s2){
        if (s1.equals("") || "".equals(s2)){
            return "";
        }
        int count = 0, len = 0;
        int start = 0;
        for (int i = 0; i < s1.length(); i ++){
            for (int j = i+1; j <= s1.length(); j ++){
                //因为要求连续所有只有等于一个判断
                if (s2.indexOf(s1.substring(i,j)) != -1){
                    count = s1.substring(i,j).length();


                }
                if (count > len){
                    len = count;
                    start = i;
                }
            }
        }

        //System.out.println(len);
        return s1.substring(start, start + len);
    }

    //方法2:动态规划
    public static String getLongestPublicSubstringMethod2(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        //初始化数组
        for (int i = 0; i <= s1.length(); i ++){
            for (int j = 0; j <= s2.length(); j ++){
                dp[i][j] = 0;
            }
        }

        int len = 0;
        int start = 0;
        for (int i = 1; i <= s1.length(); i ++){
            for (int j = 1; j <= s2.length(); j ++){
                if (s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    if (dp[i][j] > len){
                        len = dp[i][j];
                        start = i;
                    }
                }
            }
        }

        return s1.substring(start - len, start);

    }


}
