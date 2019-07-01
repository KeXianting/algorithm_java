package methd_of_programing.string;

/**
 * Created by kentorvalds on 2017/9/5.
 */
/*
问题背景: 输入字符串"1234"转化为整数1234
 */
public class StringToInt {


    public static void main(String[] args){


        //System.out.println(Runtime.getRuntime().availableProcessors());
        //System.out.println(Runtime.getRuntime().maxMemory());
//        try {
//            //System.out.println(2+('1'-'0'));
//            //int a = strToIntMethodOne("12b3a4");
//            int a = strToIntMethodOne("1");
//            System.out.println("正数的值为: " + a);
//
////            int b = strToIntMethodOne("-1234");
////            System.out.println("负数为: " + b);
//        }catch (Exception e) {
//            e.printStackTrace();
//        }

        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("1"));

    }

    //前导字符是+或-或者没有
    //数字不能整数能表示的最大或最小数。如果超过就返回对应的最小或者最小的值。
//    public static int strToIntMethodOne(String s)throws Exception{
//
//        if (s == null || s.length() == 0){
//           // throw new NumberFormatException("Invalid input string: " + s);
//            return 0;
//        }
//
//        //字符串以空格开头
//        int start = 0;//从开始找第一个不是空格的数
//        boolean positive = true;// 是否为正数默认为true
//
//
//        if (s.charAt(start) == ' ') {
//            while (s.charAt(start) == ' ') {
//                start++;
//                if (start >= s.length()) { // 输入的全是空格
//                  //  throw new NumberFormatException("Invalid input string: " + s);
//                    return 0;
//                }
//            }
//        }
//        if (s.charAt(start) == '-') { // 第一个非空白字符中-
//            positive = false;
//            start++;
//        } else if (s.charAt(start) == '+') {// 第一个非空白字符是+
//            start++;
//        } else if (s.charAt(start) >= '0' && s.charAt(start) <= '9') { // 第一个非空白字符是数字
//            return cal(s, start, true);
//        } else { // 其它情况就抛出异常
//           // throw new NumberFormatException("Invalid input string: " + s);
//            return 0;
//        }
//
//
//        if (start >= s.length()) { // 第一个非空白字符是+或者-但也是最后一个字符
//          //  throw new NumberFormatException("Invalid input string: " + s);
//            return 0;
//        }
//
//        if (s.charAt(start) > '9' || s.charAt(start) < '0') { // +或者-后面接的不是数字
//         //   throw new NumberFormatException("Invalid input string: " + s);
//            return 0;
//        } else {
//            return cal(s, start, positive);
//        }
//
//
//
//    }
//
//
//    public static int cal(String s, int start, boolean positive)throws Exception{
//
//        long result = 0;
//
//        while ((start < s.length()) && (s.charAt(start) >= '0') && (s.charAt(start) <= '9')){
//            if(!Character.isDigit(s.charAt(start))){//判断是否为数字
//                System.out.println("bbb");
//                throw new Exception("wrong string");
//            }
//            result = result*10 + (s.charAt(start) - '0');
//            //System.out.println("aa: " + result);
//            if (positive) { // 如果是正数
//                if (result > Integer.MAX_VALUE) {
////                    throw new NumberFormatException("Invalid input string: " + str);
//                    return Integer.MAX_VALUE;
//                }
//
//            } else {
//                if (-result < Integer.MIN_VALUE) {
////                    throw new NumberFormatException("Invalid input string: " + str);
//                    return Integer.MIN_VALUE;
//                }
//            }
//
//            start++;
//        }
//
//        if (positive) {
//            return (int) result;
//        } else {
//            return (int) -result;
//        }
//
//    }
    public static int myAtoi(String str) {
        if(null == str || "".equals(str)){
            return 0;
        }
        //第一个非空格的位置
        int start = 0;
        boolean positive = true;
        if(str.charAt(start) == ' '){
            while(str.charAt(start) == ' '){
                start ++;
                if (start >= str.length()) { // 输入的全是空格
                    return 0;
                }
            }
        }
        if (str.charAt(start) == '-') { // 第一个非空白字符中-
            positive = false;
            start++;
        } else if (str.charAt(start) == '+') {// 第一个非空白字符是+
            start++;
        }else if(str.charAt(start) >= '0' && str.charAt(start) <= '9'){//第一个数是数字
            return cal(str, start, positive);
        }else{
            return 0;
        }
        if (start >= str.length()) { // 第一个非空白字符是+或者-但也是最后一个字符
            return 0;
        }

        if (str.charAt(start) > '9' || str.charAt(start) < '0') { // +或者-后面接的不是数字
            return 0;
        } else {
            return cal(str, start, positive);//当为-时调用此处
        }
    }
    public static int cal(String s, int start, boolean positive){

        long result = 0;
        while ((start < s.length()) && (s.charAt(start) >= '0') && (s.charAt(start) <= '9')){
            result = result*10 + (s.charAt(start) - '0');
            if (positive) { // 如果是正数
                if (result > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }

            } else {
                if (-result < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }
            if(!Character.isDigit(s.charAt(start))){//判断是否为数字
                if (start == s.length()){
                    return 0;
                }else {
                    if(positive){
                        return (int) result;
                    }else{
                        return (int) -result;
                    }
                }

            }
            start++;

        }

        if (positive) {
            return (int) result;
        } else {
            return (int) -result;
        }

    }
}
