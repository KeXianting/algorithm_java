package jianzhi_offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by kentorvalds on 2018/5/9.
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶结点所经过的所有的结点形成一条路径。
 */
public class FixedSumInBinaryTree {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
        public TreeNode(){}

    }

    public void findPath(TreeNode root,int k){
        if(root == null)
            return;
        Stack<Integer> stack = new Stack<Integer>();
        //最终路径存储在list中返回
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        findPath(root,k,stack, arrayList);
//        for (ArrayList<Integer> list:arrayList){
//            System.out.println("路径开始");
//            for (Integer i:list){
//                System.out.print(i + " , ");
//            }
//            System.out.println();
//            System.out.println("路径结束");
//        }
    }
    public void findPath(TreeNode root,int k,Stack<Integer> path, ArrayList<ArrayList<Integer>> arrayList){
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            if(root.val == k){
                System.out.println("路径开始");
                ArrayList<Integer> arrayList1 = new ArrayList<>();
                for(int i :path) {
                    System.out.print(i + ",");
                    arrayList1.add(i);
                }
                System.out.print(root.val);
                arrayList1.add(root.val);
                arrayList.add(arrayList1);
                System.out.println();
            }
        }
        else{
            path.push(root.val);
            findPath(root.left,k-root.val,path, arrayList);
            findPath(root.right,k-root.val,path, arrayList);
            path.pop();
        }
    }
    public static void main(String[] args){
        TreeNode root1 = new TreeNode();
        TreeNode node1 = new TreeNode();
        TreeNode node2 = new TreeNode();
        TreeNode node3 = new TreeNode();
        TreeNode node4 = new TreeNode();
        TreeNode node5 = new TreeNode();
        TreeNode node6 = new TreeNode();
        root1.left = node1;
        root1.right = node2;
        node1.left = node3;
        node1.right = node4;
        node4.left = node5;
        node4.right = node6;
        root1.val = 8;
        node1.val = 8;
        node2.val = 7;
        node3.val = 9;
        node4.val = 2;
        node5.val = 4;
        node6.val = 7;
        FixedSumInBinaryTree test = new FixedSumInBinaryTree();
        test.findPath(root1, 25);
        //ReentrantLock
    }

}
