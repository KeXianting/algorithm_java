package jianzhi_offer;

/**
 * Created by kentorvalds on 2018/6/9.
 */
public class StringOfNumber {

    private static int inx;
    public static boolean isNumeric(char[] str) {
        if(str==null || str.length==0){
            return false;
        }
        inx = 0;
        boolean flag = scanInteger(str);
        //判断小数部分
        if(inx<str.length && str[inx]=='.'){
            inx = inx+1;
            flag = scanUInteger(str)||flag;     //解释a,见代码下方
        }
        //判断指数部分
        if(inx<str.length && (str[inx]=='e' || str[inx]=='E')){
            inx = inx+1;
            flag = flag&&scanInteger(str);
        }
        return flag&& inx>=str.length;
    }

    //判断是否是整数
    public static boolean scanInteger(char[] str){
        if(inx<str.length &&(str[inx]=='+' || str[inx]=='-')){
            inx = inx+1;
        }
        return scanUInteger(str);
    }

    //判断是否是无符号整数
    public static boolean scanUInteger(char[] str){
        int inx1=inx;
        while(inx<str.length && str[inx]>='0' && str[inx]<='9'){
            inx = inx + 1;
        }
        return inx>inx1;
    }

    public static void main(String[] args){
        String str = "3a.1416";
        char[] chs = str.toCharArray();
        System.out.println(isNumeric(chs));
    }
}
