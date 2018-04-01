package data_struct.list.test;

import data_struct.list.Node;
import data_struct.list.SinglyLinkedList;

/**
 * Created by kentorvalds on 2017/6/13.
 */
//单链表逆转操作
public class SingleReverseTest {

    //泛型方法
    public static <T> void reverse(SinglyLinkedList<T> list) {
        Node<T> p = list.head.next, succ = null, front = null;
        while (p != null) {//p为当前节点
            succ = p.next;// 设置succ是p节点的后继节点,为临时节点
            //System.out.println(succ.data);
            p.next = front;// p.next指向p节点的前驱节点
            front = p; //front向后移一步
            p = succ;// p向后走一步

        }
        list.head.next = front;//将head移到尾部
    }

    public static void main(String[] args) {
        //String values[] = { "A", "B", "C", "D", "E", "F" };
        //String values[] = {"A"};
        String values[] = {};
        //创建单链表
        SinglyLinkedList<String> list = new SinglyLinkedList<String>(values);
        System.out.println("list :  " + list.toString());
        //单链表的逆转
        reverse(list);
        System.out.println("逆转后 : " + list.toString());


    }

}
