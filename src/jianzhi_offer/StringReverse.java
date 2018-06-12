package jianzhi_offer;

/**
 * Created by kentorvalds on 2018/4/16.
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student."，则输出"student. a am I"。
 */
public class StringReverse {

    public static void main(String[] args){
        String str = "I am a student.";
        String str1 = "abcdefg";
        String result = reverseSentence(str);
        System.out.println("整个翻转" + result);
        String ss = leftRotateString(str1, 2);
        System.out.println("左旋操作: " + ss);
    }

    //第一步翻转句子中所有的字符。比如翻转"I am a student."中所有的字符
    // 得到".tneduts a ma I"，此时不但翻转了句子中单词的顺序，连单词内的字符顺序也被翻转了。
    public static void reverse(char[] array, int start , int end){
        if (array == null || start < 0 || end > array.length - 1)
        {
            return;
        }

        while (start < end)
        {
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;

            start++;
            end--;
        }
    }

    //第二步再翻转每个单词中字符的顺序，就得到了"student.a am I"
    public static String reverseSentence(String str){
        if (str == null)
        {
            return null;
        }

        char[] array = str.toCharArray();
        int start = 0;
        int end = array.length - 1;

        // Step1.先翻转整个句子
        reverse(array, start, end);
        // Step2.再翻转句中的每个单词
        start = end = 0;
        while (start < array.length)
        {
            if (array[start] == ' '){
                start++;
                end++;
            }
            else if (end == array.length || array[end] == ' ') {
                reverse(array, start, --end);
                start = end + 1;
                end++;
            }else {
                end++;
            }
        }

        return new String(array);
    }

    /*
    字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
    请定义一个函数实现字符串左旋转操作的功能。比如输入字符串"abcdefg"和数字2，该函数将返回左旋转2位得到的结果"cdefgab"。
     */
    public static String leftRotateString(String str, int num)
    {
        if (str == null)
        {
            return null;
        }

        int strLength = str.length();
        char[] array = str.toCharArray();

        if (strLength > 0 && num > 0 && num < strLength)
        {
            int firstStart = 0;
            int firstEnd = num - 1;
            int secondStart = num;
            int secondEnd = strLength - 1;

            // 翻转字符串的前面n个字符
            reverse(array, firstStart, firstEnd);
            // 翻转字符串的后面部分
            reverse(array, secondStart, secondEnd);
            // 翻转整个字符串
            reverse(array, 0, strLength - 1);
        }

        return new String(array);
    }
}
