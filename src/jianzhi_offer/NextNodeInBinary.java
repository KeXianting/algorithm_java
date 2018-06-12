package jianzhi_offer;

/**
 * Created by kentorvalds on 2018/5/8.
 */
public class NextNodeInBinary {
    static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
    public TreeLinkNode getNext(TreeLinkNode pNode) {
        if (pNode == null)
            return null;
        TreeLinkNode tmp = null;
        // 如果pNode的右子树为空
        if (pNode.right == null) {
            tmp = pNode;
            // 如果该节点是某个最右节点
            while (tmp.next != null && tmp == tmp.next.right)
                tmp = tmp.next;
            return tmp.next == null ? null : tmp.next;
        }
        // 如果右子树不为空，找到右子树中的最左节点
        tmp = pNode.right;
        while (tmp.left != null) {
            tmp = tmp.left;
        }
        return tmp;
    }

    public static void main(String[] args){

    }
}
