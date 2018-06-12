package jianzhi_offer;

/**
 * Created by kentorvalds on 2018/4/7.
 * 二叉搜索树转换为双向链表
 */
public class SearchBinaryTreeConcertDoubleList {
    static class BinaryTreeNode{
        int data;
        BinaryTreeNode leftNode;
        BinaryTreeNode rightNode;
        public BinaryTreeNode(int value){
            this.data = value;
        }
    }
    public static void main(String[] args) {


        BinaryTreeNode root = new BinaryTreeNode(10);

        BinaryTreeNode six = new BinaryTreeNode(6);

        BinaryTreeNode four = new BinaryTreeNode(4);

        BinaryTreeNode eight = new BinaryTreeNode(8);

        BinaryTreeNode fourteen = new BinaryTreeNode(14);

        BinaryTreeNode twelve = new BinaryTreeNode(12);

        BinaryTreeNode sixteen = new BinaryTreeNode(16);

        root.leftNode = six;

        root.rightNode = fourteen;

        six.leftNode = four;

        six.rightNode = eight;

        four.leftNode = null;

        four.rightNode = null;

        eight.leftNode = null;

        eight.rightNode = null;

        fourteen.leftNode = twelve;

        fourteen.rightNode = sixteen;

        twelve.leftNode = null;

        twelve.rightNode = null;

        sixteen.rightNode = null;

        sixteen.leftNode = null;

        BinaryTreeNode result = convert(root);

//                BinaryTreeNode result=baseconvert(root, null);

        while (result != null) {

            System.out.println(result.data);

            result = result.rightNode;

        }
    }
        public static BinaryTreeNode convert(BinaryTreeNode root) {

            BinaryTreeNode lastNode = null;

            lastNode=baseconvert(root, lastNode);

            BinaryTreeNode headNode = lastNode;

            while (headNode.leftNode != null)

                headNode = headNode.leftNode;

            return headNode;

        }

    public static BinaryTreeNode baseconvert(BinaryTreeNode root, BinaryTreeNode lastNode) {

        if (root == null)

            return lastNode;

        BinaryTreeNode current = root;

        if (current.leftNode != null)

            lastNode=baseconvert(current.leftNode, lastNode);

        current.leftNode = lastNode;

        if (lastNode != null)

            lastNode.rightNode = current;

        lastNode = current;

        if (current.rightNode != null)

            lastNode=baseconvert(current.rightNode, lastNode);

        return lastNode;

    }
}
