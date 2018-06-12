package jianzhi_offer;

/**
 * Created by kentorvalds on 2018/6/8.
 * 将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class SpaceReplace {
    public static void main(String[] args){
        System.out.println(replaceSpace(new StringBuffer("We are happy.")));
        System.out.println(replaceSpace(new StringBuffer("We are happy. ")));
        System.out.println(replaceSpace(new StringBuffer(" We are happy.")));
        System.out.println(replaceSpace(new StringBuffer("Wearehappy.")));
        System.out.println(replaceSpace(new StringBuffer("")));
        System.out.println(replaceSpace(new StringBuffer(" ")));
    }

    public static String replaceSpace(StringBuffer str) {
        int spacenum = 0;//spacenum为计算空格数
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' ')
                spacenum++;
        }
        int indexold = str.length()-1; //indexold为为替换前的str下标
        int newlength = str.length() + spacenum*2;//计算空格转换成%20之后的str长度(没替换一个空格,长度增加2)
        int indexnew = newlength-1;//indexold为为把空格替换为%20后的str下标
        str.setLength(newlength);//使str的长度扩大到转换成%20之后的长度,防止下标越界
        for(;indexold>=0 && indexold<newlength;--indexold){
            if(str.charAt(indexold) == ' '){  //
                str.setCharAt(indexnew--, '0');
                str.setCharAt(indexnew--, '2');
                str.setCharAt(indexnew--, '%');
            }else{
                str.setCharAt(indexnew--, str.charAt(indexold));
            }
        }
        return str.toString();
    }
}
