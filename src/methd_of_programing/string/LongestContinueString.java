package methd_of_programing.string;

/**
 * Created by kentorvalds on 2017/10/7.
 */
/*
最长连续字符: 例如"aaaabbcc"最长连续字符长度为4; "aabb"最长连续字符长度为2
 */
public class LongestContinueString {

    public static void main(String[] args){
        String str = "abbbbbbcccccccddd";
        System.out.println("暴力法:");
        System.out.println("暴力法最长连续字符长度为:" + getLongestContinueString1(str));
        System.out.println("改进暴力法最长连续字符长度为:" + getLongestContinueString11(str));
        System.out.println("递归法:");
        System.out.println("最长连续字符长度为" + getResult(str));
    }

    //方法1:暴力搜索O(n*n)
    public static int getLongestContinueString1(String str){
        int len = 0;
        for (int i = 0; i < str.length(); i ++){
            int count = 0;
            for (int j = i; j < str.length(); j ++ ){
                if (str.charAt(i) == str.charAt(j)){
                    count ++;
                }else {
                    break;
                }
            }
            if (count > len){
                len = count;
            }
        }
        return len;
    }
    //暴力法改进O(n)
    public static int getLongestContinueString11(String str){
        int len = 0, count = 1;
        for (int i = 0; i < str.length() - 1; i ++){
            if (str.charAt(i + 1) == str.charAt(i)){
                count ++;
                if (count > len){
                    len = count;
                }
            }else {
                count = 1;
            }
        }
        return len;
    }

    //方法2:递归
    public static int getLongestContinueString2(String str, int currentPos, int count, int len){

        if (currentPos == str.length()){
            return len;
        }
        if (str.charAt(currentPos) == str.charAt(currentPos - 1)){
            count ++;
            if (count > len){
                len = count;
            }
        }else {
            count = 1;

        }
        return getLongestContinueString2(str, currentPos + 1, count, len);
    }
    public static int getResult(String str){
        if(str == null || str.isEmpty())
            return 0;
        if(str.length() == 1)
            return 1;
        return getLongestContinueString2(str, 1, 1, 1);
    }

}
