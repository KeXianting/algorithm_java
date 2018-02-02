package methd_of_programing.string;

import data_struct.list.Node;

import java.util.Stack;

/**
 * Created by kentorvalds on 2017/9/5.
 */
/*
回文判断: 正读和反读都一样的字符串, 如madam, 我爱我
 */
public class IsPalindrome {

    public static void main(String[] args){

        String str = "abcmadamcb";
       // System.out.println(isPalindromeMethod1(str));
        System.out.println("两遍往中间扫:" + isPalindromeMethod2(str));

        String str1 = "我爱你爱我";
        String str2 = "";
//        System.out.println(isPalindromeMethod1(str1));
//        System.out.println(isPalindromeMethod1(str2));
        System.out.println("中间往两遍扫: " + isPalindromeMethod2(str1));
       // System.out.println(isPalindromeMethod2(str2));
        System.out.println("中间往两遍扫改变: " + isPalindromeMethod22(str));


    }


    //方法一:两头往中间扫
    public static boolean isPalindromeMethod1(String str){

        if (str == null || str.length() <= 0 || "".equals(str)){
            return false;
        }

        int start = 0;
        int end = str.length() - 1;
        while (start < end){
            if (str.charAt(start) != str.charAt(end)){
                return false;
            }
            ++ start;
            -- end;
        }
        return true;

    }


    //方法二:从中间往两头扫
    public static boolean isPalindromeMethod2(String str){
        if (str == null || str.length() <= 0 || "".equals(str)){
            return false;
        }

        int n = str.length() - 1;
        //找到中间位置: 整数右移在高位补0
        int mid = (( n >> 1) - 1) >= 0 ? (n >> 1) - 1 : 0;
        System.out.println(mid);



        int start = mid;
        int end = n - mid;

        while (start >= 0){
            if (str.charAt(start) != str.charAt(end)){
                return false;
            }
            -- start;
            ++ end;
        }

        return true;
    }

    //方法二修改:从中间往两头扫
    public static boolean isPalindromeMethod22(String str){
        if (str == null || str.length() <= 0 || "".equals(str)){
            return false;
        }

        int n = str.length() - 1;
        //找到中间位置: 整数右移在高位补0
        int mid = n/2;
        int start ;
        int end ;
        if (n%2 == 0){
            start = mid;
            end = mid;
        }else {
            start = mid;
            end = mid + 1;
        }





        while (start >= 0 && end <= n){
            if (str.charAt(start) != str.charAt(end)){
                return false;
            }
            -- start;
            ++ end;
        }

        return true;
    }


    //方法1:判断单链表是否是回文:时间复杂度O(N)，空间复杂读O(N)。
    //方法2:只保存前一半元素，然后和后一半对比即可。时间复杂度O(N)，空间复杂度O(N/2)
    //方法3:利用链表逆序思想，将链表后半部分逆序。然后从前到中和从后到中一一对比即可。
    // 这种情况要注意将中间指针next指向要赋一次空，不然会导致死循环。同时我们得出结果后，不论真与假，都应该还原链表，函数尾部返回
    public static boolean isPalindromeList(Node head) {
        if (head == null)
            return false;
        Stack<Node> stack = new Stack<Node>();
        Node p = head;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }
        p = head;
        while (p != null) {
            if (p.data != stack.pop().data)
                return false;
            p = p.next;
        }
        return true;
    }
}
