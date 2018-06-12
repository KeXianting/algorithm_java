package jianzhi_offer;

/**
 * Created by kentorvalds on 2018/5/8.
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像
 */
public class MirrorBinary {
    static class BinaryTreeNode {
        public int value;
        public BinaryTreeNode leftNode;
        public BinaryTreeNode rightNode;
        public BinaryTreeNode(){

        }
        public BinaryTreeNode(int value){
            this.value = value ;
            this.leftNode = null;
            this.rightNode = null;
        }

    }
    public void MirrorRecursively(BinaryTreeNode node){
        
        if(node == null)
            return;
        //叶子节点
        if(node.leftNode == null && node.rightNode == null)
            return;
        //交换左右节点
        BinaryTreeNode temp = node.leftNode;
        node.leftNode = node.rightNode;
        node.rightNode = temp;
        //递归左右子树
        if(node.leftNode != null)
            MirrorRecursively(node.leftNode);
        if(node.rightNode != null)
            MirrorRecursively(node.rightNode);
    }
}
