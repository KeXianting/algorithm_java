package methd_of_programing.string;

/**
 * Created by kentorvalds on 2017/9/14.
 */
/*
字符串反转: July变化后为yluJ
 */
public class StringReverse {

    public static void main(String[] args){
        String str="ILoveYou";
       // method1(str);
       // method2(str);
        String s1 = "";
       s1 =  method3(str);
        System.out.println(s1);

    }

    //方法1: 第一个与最后一个交换, 依次类推
    public static String method1(String str){
        char[] strArray=str.toCharArray();
        int len=strArray.length;
        char temp;

        for(int i=0;i<len/2;i++){
            temp=strArray[i];
            strArray[i]=strArray[len-i-1];
            strArray[len-i-1]=temp;
        }
        String strAfter=String.valueOf(strArray);
       // System.out.println("Before:"+str);
       // System.out.println("After:"+strAfter);
        return strAfter;
    }

    //方法2: 不增加临时空间, 异或运算
    public static void method2(String str){
        char[] strArray=str.toCharArray();
        int len=strArray.length;
        char temp;

        for(int i=0;i<len/2;i++){
//            temp=strArray[i];
//            strArray[i]=strArray[len-i-1];
//            strArray[len-i-1]=temp;
            strArray[i] ^= strArray[len-i-1];
            strArray[len-i-1] ^= strArray[i];
            strArray[i] ^= strArray[len-i-1];

        }
        String strAfter=String.valueOf(strArray);
        System.out.println("Before:"+str);
        System.out.println("After:"+strAfter);
    }

    //方法3:递归实现
    public static String method3(String str){
//        int len = str.length;
//        if (end <= len/2 || start >= len/2){
//            return str;
//        }
//
//        end = end -start - 1;
//
//        str[start] ^= str[end];
//        str[end] ^= str[start];
//        str[start] ^= str[end];
//
//       // System.out.println("str: " + String.valueOf(str));
//
//        str1 = String.valueOf(str);
//        System.out.println("str1: " + str1);
//
//
//
//        return (method3(str,str1, ++start, end));
        if(str.isEmpty()) return str;
        //str.substring(1):从下标1一直到最后
        return method3(str.substring(1))+str.charAt(0);






    }
}
