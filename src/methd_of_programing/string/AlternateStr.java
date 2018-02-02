package methd_of_programing.string;

/**
 * Created by kentorvalds on 2018/1/17.
 * 输入三个字符串s1、s2和s3，判断第三个字符串s3是否由前两个字符串s1和s2交错而成，
 * 即不改变s1和s2中各个字符原有的相对顺序，例如当s1 = “aabcc”，s2 = “dbbca”，
 * s3 = “aadbbcbcac”时，则输出true，但如果s3=“accabdbbca”，则输出false。
 */
public class AlternateStr {

    public static void main(String[] args){
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";

        System.out.println("是否是交错形成: " + isAlternateStr(s1,s2,s3));

    }

    public static boolean isAlternateStr(String s1, String s2, String s3){
        int n = s1.length();
        int m = s2.length();
        int s = s3.length();
        if (m+n != s){
            return false;
        }
        boolean[][] dp = new boolean[n+1][m+1];

        //初始化时空串为true
        dp[0][0] = true;
        for (int i = 0; i < n+1; i ++){
            for (int j = 0; j < m +1; j ++){
                if (dp[i][j]
                        || (i - 1 >= 0 && dp[i - 1][j]
                        && s1.indexOf(i - 1) == s3.indexOf(i + j - 1)
                        || (j - 1 >= 0 && dp[i][j - 1]
                        && s2.indexOf(j - 1) == s3.indexOf(i + j - 1)))) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }
}
