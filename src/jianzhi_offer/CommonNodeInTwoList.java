package jianzhi_offer;

import java.util.Stack;

/**
 * Created by kentorvalds on 2018/4/11.
 * 两个链表的第一个公共节点
 */
public class CommonNodeInTwoList {
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
        public Node(){
            this.data = 0;
            this.next = null;
        }

    }
    public static void main(String[] args){
        Node head1=new Node();
        Node second1=new Node();
        Node third1=new Node();
        Node forth1=new Node();
        Node fifth1=new Node();
        Node head2=new Node();
        Node second2=new Node();
        Node third2=new Node();
        Node forth2=new Node();
        head1.next=second1;
        second1.next=third1;
        third1.next=forth1;
        forth1.next=fifth1;
        head2.next=second2;
        second2.next=forth1;
        third2.next=fifth1;
        head1.data=1;
        second1.data=2;
        third1.data=3;
        forth1.data=6;
        fifth1.data=7;
        head2.data=4;
        second2.data=5;
        third2.data=6;
        forth2.data=7;

        Node node = findFirstCommonNode3(head1, head2);
        System.out.println(node.data);

    }

    //方法1:暴力遍历, O(n^2)
    public static Node findFirstCommonNode1(Node head1, Node head2){
        Node n1 = head1;
        Node n2 = head2;
        while (n1 != null){
            while (n2 != null){
                if (n1.data == n2.data){
                    return n1;
                }else {
                    n2 = n2.next;
                }
            }
            n1 = n1.next;
        }
        return null;
    }


    //方法2:两个辅助栈:先分别入栈,然后弹出,当弹出元素遇到不相等的时候,则前一个为第一个公共节点
    public static Node findFirstCommonNode2(Node head1, Node head2){
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        Node n1 = head1;
        Node n2 = head2;
        while (n1 != null){
            s1.push(n1);
        }
        while (n2 != null){
            s2.push(n2);
        }

        Node temp = new Node();

        while (!s1.empty()){
            Node node1 = s1.pop();
            Node node2 = s2.pop();
           if (node1.data == node2.data){
               temp = node1;
           }else {
               break;
           }

        }
        return temp;
    }


    //快慢指针: 计算链表1的长度len1, 链表2的长度len2, 如果len1-len2=k,则链表1先走k步,然后二者同时遍历,当第一次相等时就是公共节点
    public static Node findFirstCommonNode3(Node head1, Node head2){
        if (head1 == head2){
            return head1;
        }
        int len1 = 0;
        int len2 = 0;
        Node n1 = head1;
        Node n2 = head2;
        Node n3 = head1;
        Node n4 = head2;
        while (n1 != null){
            len1 ++;
            n1 = n1.next;
        }
        while (n2 != null){
            len2 ++;
            n2 = n2.next;
        }
        if (len1 > len2){
            for (int i = 0; i < (len1 - len2); i ++){
                n3 = n3.next;
            }
        }
        if (len1 < len2){
            for (int i = 0; i < (len2 - len1); i ++){
                n4 = n4.next;
            }
        }

        Node node = null;

        boolean flag = true;
        while (flag){
            if (n3 == null || n4 == null){
                return null;
            }else {
                if (n3.data == n4.data){
                    node = n3;
                    flag = false;
                }else {
                    n3 = n3.next;
                    n4 = n4.next;
                }
            }
        }
        return node;
    }

}
