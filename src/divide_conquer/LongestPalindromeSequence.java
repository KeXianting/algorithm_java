package divide_conquer;

/**
 * Created by kentorvalds on 2017/7/5.
 */
public class LongestPalindromeSequence {

    static String longestPalindrome(String s) {
        int len = s.length();

        if (len <= 1)
            return s;
        boolean[][] dp = new boolean[len][len];// dp[i][j]表示s[i..j]是否是回文

        int resLeft = 0, resRight = 0;
        dp[0][0] = true;
        for (int i = 1; i < len; i++) {
            dp[i][i] = true;
            dp[i][i - 1] = true;// 这个初始化容易忽略，当k=2时要用到，例如如果字符为串为addf，s[1]==s[2]但是dp[2][1]不为真，这样下面的if语句无法执行这种情况进适合于最后有两个相连字符串的判断
        }
        for (int k = 2; k <= len; k++)
            // 枚举子串长度
            for (int i = 0; i <= len - k; i++)// 枚举子串起始位置
            {
                if (s.charAt(i) == s.charAt(i + k - 1) && dp[i+1][i+k-2])
                {
                    dp[i][i + k - 1] = true;//如果s[i]==s[i+k-1]给对应的dp里面相应的位置置为true,这里true主要是来判断字符相等的
                    if (resRight - resLeft + 1 < k) {
                        resLeft = i;
                        resRight = i + k - 1;
                    }
                }
            }
        return s.substring(resLeft, resRight + 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("kexiantingnitnaixe"));
    }
}
