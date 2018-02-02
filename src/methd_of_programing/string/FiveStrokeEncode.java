package methd_of_programing.string;

/**
 * Created by kentorvalds on 2017/10/12.
 * csdn参考网址:http://blog.csdn.net/jiangnanyouzi/article/details/6827534
 *
 如果将五笔的编码按字典序排序，形成数组如下：a, aa, aaa, aaaa, aaab, aaac, ..., b, ba, baa, baaa, baab...yyyx, yyyy
 其中a的索引是0，aa的索引是1，aaa的索引是2，aaaa的索引是3，以此类推：
 1）、编写一个函数，输入是任意一个合法的字符串，输出这个字符串对应的索引；
 2）、编写一个函数，输入是任意一个合法的索引，输出这个索引对应的字符串。

 求解思路:
 注意到：如果都是4字符的定长串的话，很简单，就是25进制的一个表示法，但这里是不定长的。
 1、观察头几个串：a-->0, aa->1, aaa->2，aaaa->3：应该可以看出来，这里的索引就是：字符串长度 - 1
 2、已知a的索引，求b的索引：因为a到b之间隔了以下四种情况的字符串：a后跟1字符的串有25个（aa，ab，...ay），a后跟2字符的串有25*25个(aaa, aab, ... ayy)，a后面跟3字符的串有25*25*25个(aaaa,aaab,...ayyy)，然后才是b，所以b的索引 = a的索引 + 25+25*25+25*25*25 + 1，加1是因为b排在a和中间的字符之后1个
 3、已知aa的索引，求ab的索引：同理，ab的索引 = aa索引 + 25 + 25* 25 + 1
 4、已知aaa的索引，求aab的索引：同理，aab的索引 = aaa索引 + 25 + 1、已知aaaa的索引，求aaab的索引 = aaaa索引 + 1
 至于aaaa，aaa，aa, a的索引由1: 可归纳为 字符串长度 - 1
 所以：可用一个权重数组来表示修正后的进制：factor[4] = {1+25+25*25+25*25*25, 1+25+25*25, 1+25, 1}
 然后字符串string的索引函数为：index(string) = (string.length - 1) + sum[ factor[i] * (string[i] - 'a') ,  {i, 0, string.length-1 } ]
 */
public class FiveStrokeEncode {

    //factor[0]:已知a求b
    //factor[1]:已知aa求ab
    //factor[2]:已知aaa,求aab
    //factor[3]:已知aaaa求aaab
    private static int[] factor = {1+25+25*25+25*25*25, 1+25+25*25, 1+25, 1};
    public static void main(String[] args){
        String str = "baca";
        System.out.println("编码结果:" + encode(str));
        System.out.println("解码结果:" + decode(12345));
    }

    public static int encode(String str){
        int len = 0;
        int index = 0;
        //baca求解过程:b由a变过来需要facotr[0]+1; ba由aa到ba(不考虑b,b在前一个计算过了,即aa到aa); bac由aaa到aac(facotr[2]*2); baca由aaaa到aaaa
        for (int i = 0 ;i < str.length(); i ++){
            index += factor[len ++] * (str.charAt(i) - 'a');
        }
        return index + (len - 1);
    }

    public static String decode(int index){
        char[] str = new char[4];
        int i = 0;

        while (index >= 0){
            str[i] = (char)('a' + index / factor[i]);
            index %= factor[i++];
            --index; // 此处要减1，还原到下一个字符
        }
       // str[4] = '\0';

//        for (int j = 0; j <str.length; j ++){
//            System.out.println(str[j]);
//        }
        return String.valueOf(str);
    }
}
