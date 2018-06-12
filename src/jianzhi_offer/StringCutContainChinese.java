package jianzhi_offer;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kentorvalds on 2018/4/19.
 * 编写一个截取字符串的函数，输入为一个字符串和字节数，
 * 输出为按字节截取的字符串。 但是要保证汉字不被截半个，如“我ABC”4,同时截取的字符串不包含数字
 */
public class StringCutContainChinese {

    public static void main(String[] args)throws UnsupportedEncodingException{
        String str = "abc柯贤10kdf";
        //System.out.println("长度: " + str.length());//10
        //System.out.println("字符数组长度: " + str.getBytes("gbk").length);//12:一个汉字在字符数组中占两个元素的位置
        String ss = splitString(str);
        String result = spiltString(ss, 8);
        System.out.println(result);

    }

    public static String spiltString(String str, int len){
        if (str == null || "".equals(str)){
            return null;
        }
        int count = 0; //统计中文字符
        try {
            //统一按照gbk编码来得到他的字节数组，因为不同的编码字节数组是不一样的。
            byte[] strBytes = str.getBytes("GBK");
            //如果只截取一位,第一位为中文字符
            if (len == 1) {
                if (strBytes[0] < 0) {//中文字符数组元素值小于0
                    return str.substring(0, 1);
                }
            }
            //字符串中的一个中文会使得count 加两次, count等于汉字个数的2倍
            for (int i = 0; i < len; i++) {
                int val = strBytes[i];
                if (val < 0) {
                    count++;
                }
            }
            //如果传递的这个截取的位数没有截到半个中文上面，那么就按照byteLength - (wordCount / 2个长度进行截取
            if (count % 2 == 0) {
                return str.substring(0, (len - (count / 2)));
            }
            //否则，我们就舍弃多出来的这一位 所以  -1
            return str.substring(0, (len - (count / 2) - 1));
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return null;

    }

    //去掉数字
    public static String splitString(String str){
        String regEx = "[0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }

}
