package data_struct.list;

/**
 * Created by kentorvalds on 2017/6/6.
 */
/**
 * 单链表节点类，T表示指定节点的元素类型, next表示指向下一节点的指针
 */
public class Node<T> {

    public T data;// 数据域，保存数据元素
    public Node<T> next;// 地址域，引用后继节点

    //初始化单链表
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    //空的单链表
    public Node() {
        this(null, null);
    }
}

