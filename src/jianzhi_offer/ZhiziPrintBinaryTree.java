package jianzhi_offer;

import java.util.*;

/**
 * Created by kentorvalds on 2018/5/15.
 * 之字形打印二叉树
 */
public class ZhiziPrintBinaryTree {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

    }
    public static ArrayList<ArrayList<Integer>> printZigZag(TreeNode pRoot) {
        if(pRoot == null) {
            return null;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        s1.push(pRoot);
        while(!s1.isEmpty() || !s2.isEmpty()) {
            if(!s1.isEmpty()) {
                ArrayList<Integer> arr1 = new ArrayList<>();
                while(!s1.isEmpty()) {
                    TreeNode t1 = s1.pop();
                    arr1.add(t1.val);
                    //注意，一定要保证你插入到栈中的值不为空
                    if(t1.left!=null) {
                        s2.push(t1.left);
                    }

                    if(t1.right!=null) {
                        s2.push(t1.right);
                    }
                }

                res.add(arr1);
            } else if(!s2.isEmpty()){
                ArrayList<Integer> arr2 = new ArrayList<>();
                while(!s2.isEmpty()) {
                    TreeNode t2 = s2.pop();
                    arr2.add(t2.val);
                    if(t2.right!=null) {
                        s1.push(t2.right);
                    }
                    if(t2.left!=null) {
                        s1.push(t2.left);
                    }
                }
                res.add(arr2);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.right.left = new TreeNode(5);
        head.right.right = new TreeNode(6);
        head.right.left.left = new TreeNode(7);
        head.right.left.right = new TreeNode(8);

        ArrayList<ArrayList<Integer>> res = printZigZag(head);

        for(int i=0; i<res.size(); i++) {
            ArrayList<Integer> res1 = res.get(i);
            for(int j=0; j<res1.size(); j++) {
                System.out.print(res1.get(j)+" ");
            }
            System.out.println();
        }
    }
}
