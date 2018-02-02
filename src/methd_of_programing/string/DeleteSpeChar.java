package methd_of_programing.string;

import java.util.Arrays;

/**
 * Created by kentorvalds on 2017/9/18.
 */
/*
输入两个字符串，从第一个字符串中删除第二个字符串中出现的所有字符。
例如：输入"they are students." 与 “aeiou”,则应该输出“thy r stdnts.”
 */
public class DeleteSpeChar {
    public static void main(String[] args){
        String s1 = "They are studentsu";
        String s2 = "aeiou";
        System.out.println("方法1中s1中删除s2后为:" + deleteCharMethod1(s1, s2));

        System.out.println("方法2中s1中删除s2后为: " + deleteCharMethod2(s1, s2));

    }

    /*
    首先我们还是以解决问题为第一要义，寻找最为直观的解决方案，很容易想到的方法就是
    ，对于在第一个字符串中的每一个字符，拿它去查找是否在第二个字符串中出现过，
    如果是，则删除，如果不是则保留。删除一个字符，要让该字符之后的所有字符逐一向前移位，所以时间复杂度为O(n)，对于长度为n的字符串，总的时间复杂度为O(N2).而对于给定的字符，在第二个字符串中查找该字符，如果遍历长度为m的第二个字符串的话，时间复杂度也为O(m)，总的时间复杂度为O(mn).
     */
    public static String deleteCharMethod1(String s1, String s2){
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int len1 = c1.length;
        int len2 = c2.length;
        for (int i  = 0; i < len2; i ++){
            char temp = c2[i];
            for (int j = 0; j < len1; j ++){
                if (j != len1 - 1){
                    if (temp == c1[j]){

                        for (int k = j + 1; k < len1; k ++){
                            c1[k-1] = c1[k];
                        }

                        len1 --;
                    }
                }
                if (j == len1 - 1){
                    if (temp == c1[j]){
                        c1[j] = ' ';
                        len1 --;
                    }
                }

            }
        }
        char[] c3 = new char[len1];
        for (int m = 0; m < len1; m ++){
            //System.out.println(c1[m]);
            c3[m] = c1[m];
        }
        return String.valueOf(c3);
    }

    /*
    有没有更为高效的方法呢？事实上我们在并没有必要在每次删除一个字符的时候都让后面的字符移动，
    我们只需要让被删除位置的字符被后面不需要被删除的字符来代替就可以了，相当于我们有一个先头哨兵，
    它只负责寻找那些不需要被删除的字符，碰到需要删除的就直接跳过，碰到不需要删除的就告诉主力哨兵，
    主力哨兵负责对于先头哨兵找到的字符给予“接收”位置就行了。
    具体来说：我们可以设置两个指针pfast（先头哨兵）和pslow（主力哨兵），
    初始时两个都指向字符串的第一个字符，pfast碰到一个需要删除的字符“视而不见”直接跳过；
    pfast如果碰到不需要删除的字符，就把该字符复制给pslow，同时pfast后移（继续寻找），
    pslow（指向下一个位置）。这样整个算法的时间复杂度就可以达到O(n)


    那这里有一个问题了，判断一个字符在字符串2中是否出现，如果用平时的方法，需要O（N）复杂度。
    显然不行。那什么方法是O（1）呢？当然只有hash算法了。“字符串hash”，
    我们可以把这个当作专有名词记住，让你在任何时候都知道用它。，我们对字符串2进行hash初始化，
    然后对字符串1就可以直接判断了。这里举一个例子吧。
    ASCII编码至于256个，每个char类型其实都是一个整数，在C语言里面我们可以定义int hash_table[256]。
    比如A的值是65，如果A存在则我们只要设置hash_table[(int)'A'] = 1即可
     */
    public static String deleteCharMethod2(String s1, String s2){
        //建立hash表
       int[] hash = new int[256];
        Arrays.fill(hash, 0);
        for (int i = 0; i < s2.length() ; i ++){
            hash[s2.charAt(i)] ++;

        }


        char next = s1.charAt(0);

        char[] chars = new char[s1.length()-s2.length()-1];
        int count = 0;
        //把属于s2的部分直接过掉, 不属于s2的部分存到chars里面, 时间复杂度为O(n)
        for (int i = 0; i < s1.length() - 1; i ++){
            char first = s1.charAt(i);
            if (hash[first] == 0){
                next = first;
                chars[count] = next;
                count ++;

            }
        }
        return String.valueOf(chars);
    }
}
