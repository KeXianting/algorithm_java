package methd_of_programing.string;

/**
 * Created by kentorvalds on 2017/9/29.
 */
/*
最短子串:一篇文章由一个个单词组成,单词用空格分开,在一个字符数组char[] str={"hello","world","good"}
求给定文档中包含这个字符的数组的最短字符串
 */
public class SmallestSubString {

    public static void main(String[] args) {

        String source = "ADOBECODEBANC";
        String target = "ABC";
        System.out.println(getSmallestSubStr(source, target));


    }


    //方法1:对source字符串进行截取,第一次截取target长度的字符串,对source遍历截取,
    // 然后对截取的子串逐个与target比较,如果有相同的字符则删除截取子串中的该字符,知道截取的子串删除的字符个数等于target的长度则
    //子串包含target字符集,则返回改截取的子串,因为是从target长度开始截取的,所以第一次满足返回的就是最小子串
    public static String getSmallestSubStr(String source, String target){
        //
        if(source.length()<target.length()){
            return "";
        }

        //
        for(int i=target.length();i<=source.length();i++){
            //第一次遍历每三个(target的长度)一截取,第二次四个一截取,....
            for(int j=0;j+i<=source.length();j++){
                //每次取出长度为i的字符串:第一次ADO,第二次DOB....
                String s=source.substring(j, j+i);
                //System.out.println("每次截取的子串为:" + s);
                StringBuffer sb=new StringBuffer(s);
                int count=0;
                //每次对截取的target长度的字符串与target进行比较,如果有相同字符则删除该字符
                for(int k=0;k<target.length();k++){
                    if(sb.indexOf(target.charAt(k)+"")!=-1){
                        sb.deleteCharAt(sb.indexOf(target.charAt(k)+""));
                        count++;
                    }else{
                        break;
                    }
                }
                //比较计数器count如果删除的个数等于target的长度,则证明截取的字符串中包含target字符集合
                if(count==target.length()){
                    return s;
                }
            }
        }
        return "";
    }
}
