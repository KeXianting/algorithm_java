package jianzhi_offer;

/**
 * Created by kentorvalds on 2018/4/7.
 *
 */
public class ComplexListClone {
    static class Node{
        int value;
        Node next;
        Node sbiling;

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("value = " + value);
            sb.append(", next = " + (next == null ? "null" : next.value));
            sb.append(", sbiling = " + (sbiling == null ? "null" : sbiling.value));
            return sb.toString();
        }

    }

    public static void copyList(Node head){
        Node node = head;
        while(node != null){

            Node copyNode = new Node();
            copyNode.value = node.value;
            copyNode.next = node.next;
            copyNode.sbiling = null;
            node.next = copyNode;
            node = copyNode.next;
//            node = node.next;
//            copyNode = copyNode.next;
        }

    }

    public static void setSbiling(Node head){
        Node node = head;
        while(node != null){
            Node copyNode = node.next;
            if(node.sbiling != null){
                copyNode.sbiling = node.sbiling.next;
            }
            node = copyNode.next;
        }
    }

    public static Node disConnectList(Node head){
        Node node = head;
        Node copyHead = null;
        Node copyNode = null;

        if(node != null){
            copyHead = node.next;
            copyNode = node.next;
            node.next = copyNode.next;
            node = node.next;
        }

        while(node != null){

            copyNode.next = node.next;
            copyNode = copyNode.next;

            node.next = copyNode.next;
            node = node.next;
        }

        return copyHead;
    }
    public static Node copy(Node head){
        copyList(head);
        setSbiling(head);
        return disConnectList(head);
    }


    public static void main(String[] args) {

        Node head = new Node();
        head.value = 1;

        Node node2 = new Node();
        node2.value = 2;

        Node node3 = new Node();
        node3.value = 3;

        Node node4 = new Node();
        node4.value = 4;

        Node node5 = new Node();
        node5.value = 5;

        head.next = node2;
        head.sbiling = node3;

        node2.next = node3;
        node2.sbiling = node5;

        node3.next = node4;

        node4.next = node5;
        node4.sbiling = node2;

        Node copyHead = copy(head);

        Node node = copyHead;
        while(node != null){
            System.out.println(node);
            node = node.next;
        }
        /*
        value = 1, next = 2, sbiling = 3
        value = 2, next = 3, sbiling = 5
        value = 3, next = 4, sbiling = null
        value = 4, next = 5, sbiling = 2
        value = 5, next = null, sbiling = null

         */




    }
}
