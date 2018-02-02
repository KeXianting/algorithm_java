package methd_of_programing.string;

/**
 * Created by kentorvalds on 2017/9/14.
 */
/*
字符串移动（字符串为’*’号和26个字母的任意组合，把’*’号都移动到最左侧，把字母移到最右侧并保持相对顺序不变），要求时间和空间复杂度最小
 */
public class CharMove {

    public static void main(String[] args){
        String str = "a**b*c**d*";
        method1(str);
    }

    //方法1:
    /*
    主要问题是时间复杂度和空间复杂度,不过不考虑时间和空间复杂度,
    可以另外建立两个字符数组,把’*’和非’*’,分别放进去,再组合成字符串,就可以了.
    那么要保持时间复杂度为(n),空间复杂度为(1),就需要进一步考虑.
     思路就是设定一个下标i指向字符串第一个非’*’的位置,然后设定遍历下标k为i的前一个,
     遍历字符串,如果为’*’,那么不做处理,如果为非’*’,那么交换下标i和下标k的字符值,然后让i向前移动一个,保持指向第一个’*’.
     */
    public static void method1(String str){
        char[] arr=str.toCharArray();
        int i=arr.length-1;
        while(arr[i]!='*'){
            i--;
        }

        for(int k=i-1;k>=0;k--){
            if(arr[k]!='*'){
                arr[i]=arr[k];
                arr[k]='*';
                i--;
            }
        }
        for(int k=0;k<arr.length;k++){
            System.out.print(arr[k]);
        }
        System.out.println();
    }

}
