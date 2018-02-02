package methd_of_programing.string;

/**
 * Created by kentorvalds on 2017/9/15.
 */
/*
字符串空格的压缩：给定一个字符串，将其中连续出现的空格压缩为1个后，将其中已空格分隔的每个字符串逆序打印出来
例如: abc    efg  hij ef实现后变为:cba gfe jih fe
其本质是字符串逆转的变体，即在字符串逆转的基础上，还要压缩多余空格，这种情况相比单纯的字符串逆转多了一步判断连续空格的条件


重复字符串压缩: 对字符串中连续出现的重复字符进行压缩, 例如: 字符串"abcbc"没有连续重复的字符串, 因此压缩后还是原来的形式;
                                                    字符串"xxxxyyyyyyyz"压缩后为"4x6yz"

 */
public class StringCompress {

    public static void main(String[] args) {
        String str = "abc   djksa  eio";
        //compressSpace(str);

        String str1 = "xxxxyyyyyyyz";
        String str2 = "abcdef";
        char[] input = {'a','a','a','b','a','b','c','c','c','d'};
        char[] OutputStr=new char[input.length];
        System.out.println("重复字符串压缩: " + compressRepeated(str2));
        char[] out2=stringZip(input,OutputStr);
        for(int i=0;i<out2.length;i++){
            System.out.print(out2[i]);
        }


    }

    /*
    字符串空格的压缩：给定一个字符串，将其中连续出现的空格压缩为1个后，将其中已空格分隔的每个字符串逆序打印出来
    例如: abc    efg  hij ef实现后变为:cba gfe jih fe
    其本质是字符串逆转的变体，即在字符串逆转的基础上，还要压缩多余空格，这种情况相比单纯的字符串逆转多了一步判断连续空格的条件
     */
    public static void compressSpace(String str) {
        int len = str.length();
        //用二维数组记录下每一个连续的字符串, 每一行一个没有空格的字符串
        char[][] temp = new char[len][len];

        //Arrays.fill(temp,);

        int m = 0, n = 0;
        int count = 0;//临时记录每个间隔空格个数

        for (int i = 0; i < len; i++) {
            if (str.charAt(i) != ' ') {
                count = 0;
                temp[m][n] = str.charAt(i);
                n++;
            } else {
                count++;
                if (count == 1) {
                    temp[m][n] = '\0';
                    m++;
                    n = 0;
                }

            }
        }

        //对temp的每一行就行反转(temp是一个二维数组)
        for (int i = 0; i < temp.length; i++) {
            String strTemp = StringReverse.method1(String.valueOf(temp[i]));
            System.out.println(strTemp);
        }


    }


    /*
    重复字符串压缩: 对字符串中连续出现的重复字符进行压缩, 例如: 字符串"abcbc"没有连续重复的字符串, 因此压缩后还是原来的形式;
                                                    字符串"xxxxyyyyyyyz"压缩后为"4x6yz"
     */
    public static String compressRepeated(String str) {

        if (str.length() <= 1 || str == null) {
            return str;
        }

        char[] strTemp = str.toCharArray();
        char[] output = new char[strTemp.length];
        int j = 0;
        int count = 1;
        for (int i = 0; i < strTemp.length -1 ; i++) {
            if (strTemp[i] == strTemp[i + 1] && strTemp[i+1] != '\0') {
                count++;
                if (i == strTemp.length - 2) {//此时防止越界,最后两个字符
                    output[j++] = (char) (count + '0');
                    output[j++] = strTemp[i];
                    break;
                }
            } else {
                if (count > 1) {
                    output[j++] = (char) (count + '0');//(char)(count+'0');//将数字转换为char型
                    output[j++] = strTemp[i];
                    count = 1;
                } else {
                    output[j++] = strTemp[i];
                }
                if (i == strTemp.length - 2){
                    output[j++] = strTemp[i+1];
                }
            }

        }
        return String.valueOf(output);
    }

    static char[] stringZip(char InputStr[],char OutputStr[]) {
        if (InputStr == null || InputStr.length == 0) {
            return null;
        }
        int num = 1;
        int j = 0;
        int len = InputStr.length;
        for (int i = 0; i < InputStr.length - 1; i++) {
            if ((InputStr[i] == InputStr[i + 1]) && (InputStr[i] != '\0')) {
                num++;
                if (i == (len - 2)) {//防止数组越界，判断是否是最后的两个字符
                    OutputStr[j++] = (char) (num + '0');//将数字转换为char型
                    OutputStr[j++] = InputStr[i];
                    break;
                }
            } else {
                if (num > 1) {
                    OutputStr[j++] = (char) (num + '0');//将数字转换为char型
                    OutputStr[j++] = InputStr[i];
                    num = 1;
                } else {
                    OutputStr[j++] = InputStr[i];
                }
                if (i == (len - 2)){
                    OutputStr[j++] = InputStr[i + 1];
                }
            }
        }
        return OutputStr;
    }
}
