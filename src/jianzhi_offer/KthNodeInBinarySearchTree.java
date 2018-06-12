package jianzhi_offer;

import data_struct.tree.BinaryNode;

/**
 * Created by kentorvalds on 2018/4/14.
 * 查找二叉搜索树中第k小的数
 */
public class KthNodeInBinarySearchTree {

    public static void main(String[] args){

    }
    //二叉搜索树的中序遍历是按递增顺序的
    public static int getKthNumber(BinaryNode root, int k){
        if (root == null || k== 0){
            return -1;
        }
        return (int) kthNumber(root, k).data;
    }
    public static BinaryNode kthNumber(BinaryNode root, int k){
        BinaryNode target = null;
        if (root.left != null){
            target = kthNumber(root.left, k);
        }
        if (target == null){
            if (k == 1){
                target = root;
            }
            k --;
        }
        if (target == null && root.right != null ){
            target = kthNumber(root.right, k);
        }
        return target;
    }

    int index = 0; //计数器
    BinaryNode KthNode(BinaryNode root, int k)
    {
        if(root != null){ //中序遍历寻找第k个
            BinaryNode node = KthNode(root.left,k);
            if(node != null)
               return node;
            index ++;
            if(index == k)
               return root;
            node = KthNode(root.right,k);
            if(node != null)
               return node;
            }
        return null;
    }



    static class TreeNode {
        int data;
        static TreeNode left;
        static TreeNode right;
    }
    public boolean IsBalanced_Solution(TreeNode root) {
        return new KthNodeInBinarySearchTree().isBalanced(root);
    }
    public  boolean isBalanced(TreeNode root){
        if (null == root) return true;
        int heightDiff = getHeight(root.left) - getHeight(root.right);
        if ( Math.abs(heightDiff)  > 1 ) {
            return false;
        }
        else {
            return ( isBalanced(TreeNode.left) && isBalanced(TreeNode.right) );
        }
    }
    public  int getHeight(TreeNode root) {
        if (null == root) return 0;
        return Math.max( getHeight(root.left), getHeight(root.right) + 1 );
    }

}
