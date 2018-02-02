package methd_of_programing.string;

/**
 * Created by kentorvalds on 2017/9/9.
 */
/*
最长回文子串: 给定一个字符串求出最长回文子串长度
 */
public class LongestPalindrome {

    public static void main(String[] args){
        System.out.println("中心扩展法:" + longestPalindromeMethod1("eABCCBAg"));//babcbabcbaccba

        System.out.println("Mancher法:" + longestPalindromeMethod2("xeABCCBAg"));//babcbabcbaccba

        System.out.println("动态规划法: " + longestPalindromeMethod3("xeABCCBAg"));

    }

    //中心扩展法:因为回文字符串是以中心轴对称的，所以如果我们从下标 i 出发，用2个指针向 i 的两边扩展判断是否相等，那么只需要对0到
    //n-1的下标都做此操作，就可以求出最长的回文子串。但需要注意的是，回文字符串有奇偶对称之分，即"abcba"与"abba"2种类型，
    //因此需要在代码编写时都做判断
    public static String longestPalindromeMethod1(String str){
        if (str.isEmpty()) {
            return null;
        }
        if (str.length() == 1) {
            return str;
        }
        //初始化最长回文为首字符
        String longest = str.substring(0, 1);
        //str="eABCCBAg"
        for (int i = 0; i < str.length(); i++) {
            // 得到以i为中心的最长回文(回文长度为奇数)
            String tmp = helper(str, i, i);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }

            // 得到以i, i + 1为中心的回文(回文长度为偶数)
            tmp = helper(str, i, i + 1);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
        }
        return longest;
    }
    //以i为中心
    public static String helper(String s, int begin, int end){
        while (begin >= 0 && end <= s.length() - 1
                && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        String subS = s.substring(begin + 1, end);
        return subS;
    }


    //Manacher算法:
    public static String longestPalindromeMethod2(String str){
        // 1.构造新的字符串
        // 为了避免奇数回文和偶数回文的不同处理问题，在原字符串中插入'#'，将所有回文变成奇数回文
        StringBuilder newStr = new StringBuilder();
        newStr.append('#');
        for (int i = 0; i < str.length(); i ++) {
            newStr.append(str.charAt(i));
            newStr.append('#');
        }

        // rad[i]表示以i为中心的回文的最大半径，i至少为1，即该字符本身
        int [] rad = new int[newStr.length()];
        // right表示已知的回文中，最右的边界的坐标
        int right = -1;
        // id表示已知的回文中，拥有最右边界的回文的中点坐标
        int id = -1;
        // 2.计算所有的rad
        // 这个算法是O(n)的，因为right只会随着里层while的迭代而增长，不会减少。
        for (int i = 0; i < newStr.length(); i ++) {
            // 2.1.确定一个最小的半径
            int r = 1;
            if (i <= right) {
                r = Math.min(rad[id] - i + id, rad[2 * id - i]);
            }
            // 2.2.尝试更大的半径
            while (i - r >= 0 && i + r < newStr.length() && newStr.charAt(i - r) == newStr.charAt(i + r)) {
                r++;
            }
            // 2.3.更新边界和回文中心坐标
            if (i + r - 1> right) {
                right = i + r - 1;
                id = i;
            }
            rad[i] = r;
        }

        // 3.扫描一遍rad数组，找出最大的半径
        int maxLength = 0;
//        for (int r : rad) {
//            if (r > maxLength) {
//                maxLength = r;
//
//            }
//            System.out.print(r + ",");
//        }
//       return maxLength - 1; //最长回文的长度

        int index=0;
        for (int i = 0; i < rad.length; i ++){
            if (rad[i] > maxLength){
                maxLength = rad[i]; //源字符串最长回文的长度
                index = i; //对应在扩展字符串中的下标
            }
        }

//        System.out.println("banjing" + maxLength);
     //   System.out.println("xiabiao"+index);
        int subIndex = index/2;
        return str.substring(subIndex - (maxLength - 1)/2, maxLength + 1);
        //return maxLength - 1;

       // return str.substring(index-maxLength, index+maxLength-1);
    }


    //动态规划:
    public static  String longestPalindromeMethod3(String str){
        int len = str.length();

        if (len <= 1)
            return str;
        boolean[][] dp = new boolean[len][len];// dp[i][j]表示s[i..j]是否是回文

        int resLeft = 0, resRight = 0;
        dp[0][0] = true;
        for (int i = 1; i < len; i++) {
            dp[i][i] = true;
            dp[i][i - 1] = true;// 这个初始化容易忽略，当k=2时要用到，
            // 例如如果字符为串为addf，s[1]==s[2]但是dp[2][1]不为真，这样下面的if语句无法执行这种情况进适合于最后有两个相连字符串的判断
        }
        for (int k = 2; k <= len; k++)
            // 枚举子串长度
            for (int i = 0; i <= len - k; i++)// 枚举子串起始位置
            {
                if (str.charAt(i) == str.charAt(i + k - 1) && dp[i+1][i+k-2])
                {
                    dp[i][i + k - 1] = true;//如果s[i]==s[i+k-1]给对应的dp里面相应的位置置为true,这里true主要是来判断字符相等的
                    if (resRight - resLeft + 1 < k) {
                        resLeft = i;
                        resRight = i + k - 1;
                    }
                }
            }
        return str.substring(resLeft, resRight + 1);



    }
}
