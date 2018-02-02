package leetcode;

/**
 * Created by kentorvalds on 2017/6/20.
 */

/**
          Input:
         Tree 1                     Tree 2
         1                         2
         / \                       / \
         3   2                     1   3
         /                           \   \
         5                             4   7
         Output:
         Merged tree:
         3
         / \
         4   5
         / \   \
         5   4   7
 */

//待解决
public class MergeBinaryTrees {

    private TreeNode root;


    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if(t1 == null){
            return t2;
        }
        if(t2 == null){
            return t1;
        }
        TreeNode t3 = new TreeNode(t1.val + t2.val);
        System.out.println("11111");
        //递归调用
        t3.left = mergeTrees(t1.left, t2.left);
        System.out.println("22222");
        t3.right = mergeTrees(t1.right, t2.right);
        System.out.println("33333");
        return t3;

    }

    public static void main(String[] arg){
        Integer[] data1 = {1,3,2,5};
        Integer[] data2 = {2,1,3,5,4,8,7};
        MergeBinaryTrees m1 = new MergeBinaryTrees();
        for (int i =0 ;i < data1.length; i ++){
            m1.builTree(m1.root, data1[i]);
        }

        MergeBinaryTrees m2 = new MergeBinaryTrees();
        for (int i =0 ;i < data2.length; i ++){
            m2.builTree(m2.root, data2[i]);
        }


//        TreeNode t1 = new TreeNode(1);
//        TreeNode t2 = new TreeNode(2);
        TreeNode t = mergeTrees(m1.root, m2.root);
       // System.out.println(t.toString());


    }

    public  void builTree(TreeNode treeNode, int data){
        if (root == null){
            root = new TreeNode(data);
        }else {
            if(data < treeNode.val){
                if(treeNode.left == null){
                    treeNode.left = new TreeNode(data);
                }else{
                    builTree(treeNode.left,data);
                }
            }else{
                if(treeNode.right == null){
                    treeNode.right = new TreeNode(data);
                }else{
                    builTree(treeNode.right,data);
                }
            }
        }

    }
}



class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        this.left = null;
        this.right = null;
        this.val = x;
    }
}

