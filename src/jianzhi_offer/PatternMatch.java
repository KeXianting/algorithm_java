package jianzhi_offer;

import java.util.Scanner;

/**
 * Created by kentorvalds on 2018/6/8.
 * 请实现一个函数用来匹配包含'.'和'*'的正则表达式。模式中的字符‘.’表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，
 * 匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"及"ab*a"均不匹配。
 *
 * 分析：这道题的核心其实在于分析'*',对于'.'来说，它和任意字符都匹配，可把其当做普通字符。对于'*'的分析，我们要进行分情况讨论，当所有的情况都搞清楚了以后，就可以写代码了。

 在每轮匹配中，Patttern第二个字符是'*'时：

 第一个字符不匹配（'.'与任意字符视作匹配），那么'*'只能代表匹配0次，比如'ba'与'a*ba'，字符串不变，模式向后移动两个字符，然后匹配剩余字符串和模式
 第一个字符匹配，那么'*'可能代表匹配0次，1次，多次，比如'aaa'与'a*aaa'、'aba'与'a*ba'、'aaaba'与'a*ba'。匹配0次时，字符串不变，模式向后移动两个字符，然后匹配剩余字符串和模式；匹配1次时，字符串往后移动一个字符，模式向后移动2个字符；匹配多次时，字符串往后移动一个字符，模式不变；
 而当Patttern第二个字符不是'*'时，情况就简单多了：

 如果字符串的第一个字符和模式中的第一个字符匹配，那么在字符串和模式上都向后移动一个字符，然后匹配剩余字符串和模式。
 如果字符串的第一个字符和模式中的第一个字符不匹配，那么直接返回false。
 */
public class PatternMatch {
    public static boolean match(String input,String pattern){
        if(input==null||pattern==null) return false;
        return matchCore(input,0,pattern,0);
    }
    private static boolean matchCore(String input,int i,String pattern,int p){
        if((input.length()==i)&&(pattern.length()==p)){
            //出口1，input和pattern都到了字符串末尾
            return true;
        }
        if((i!=input.length())&&(pattern.length()==p)){
            //出口2，字符串input没有到末尾，pattern到了末尾
            return false;
        }
        if((input.length()==i)&&(pattern.length()!=p)){
            //出口3，字符串input到末尾，pattern还没有到末尾
            return false;
        }

        if((p+1<pattern.length())&&(pattern.charAt(p+1)=='*')){//pattern第二个字符为*
            if((input.charAt(i)==pattern.charAt(p))||(pattern.charAt(p)=='.')){
                //首字母相匹配
                return matchCore(input,i+1,pattern,p+2) //*表示出现1次
                        ||matchCore(input,i+1,pattern,p)    //*表示出现多次
                        ||matchCore(input,i,pattern,p+2);   //*表示出现0次 ， a ...  p* ...
            }else{
                //首字母不匹配
                return matchCore(input,i,pattern,p+2);
            }
        } //end pattern.charAt(p+1)=='*'

        if((input.charAt(i)==pattern.charAt(p))||(pattern.charAt(p)=='.')){
            //pattern第二个字母不是*，且首字母匹配
            return matchCore(input,i+1,pattern,p+1);
        }
        return false;  //其余情况全部不匹配
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);                       //扫描键盘输入
        System.out.println(" 请输入第一个字符串：");
        String str1 = scanner.nextLine();
        System.out.println(" 请输入第二个字符串：");
        String str2 = scanner.nextLine();
        scanner.close();

        System.out.print("匹配的结果为：");
        System.out.println(match(str1, str2));
    }
}
