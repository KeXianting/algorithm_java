package jianzhi_offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by kentorvalds on 2018/5/15.
 * 从上往下打印二叉树的每个结点，同一层的结点按照从左到右的顺序打印
 */
public class PrintBinaryTreeUpToDown {
    static class TreeNode<T> {
        public T val;
        public TreeNode<T> left;
        public TreeNode<T> right;

        public TreeNode(T val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

    }
    public static void printTreeInLine(TreeNode<Integer> root){
        if(root==null)
            return;
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode<Integer> temp;
        while (!queue.isEmpty()){
            for(int size=queue.size();size>0;size--){
                temp = queue.poll();
                System.out.print(temp.val);
                System.out.print("\t");
                if(temp.left!=null)
                    queue.offer(temp.left);
                if(temp.right!=null)
                    queue.offer(temp.right);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        //            1
        //          /   \
        //         2     3
        //       /  \   / \
        //      4    5 6   7
        TreeNode<Integer> root = new TreeNode<Integer>(1);
        root.left = new TreeNode<Integer>(2);
        root.right = new TreeNode<Integer>(3);
        root.left.left = new TreeNode<Integer>(4);
        root.left.right = new TreeNode<Integer>(5);
        root.right.left = new TreeNode<Integer>(6);
        root.right.right = new TreeNode<Integer>(7);
        printTreeInLine(root);

    }


}
