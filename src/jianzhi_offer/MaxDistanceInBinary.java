package jianzhi_offer;

/**
 * Created by kentorvalds on 2018/5/15.
 * 求出二叉树结点的最大距离:思路如下：首先，求左子树距离根节点的最大距离，记为leftMaxDistance；其次，
 * 求右子树距根节点的最大距离，记为rightMaxDistance，
 * 那么二叉树中结点的最大距离maxDistance满足maxDistance=leftMaxDistance+rightMaxDistance
 */
public class MaxDistanceInBinary {
    static class TreeNode{
        public int data;
        public TreeNode left;
        public TreeNode right;
        public int leftMax; //左子树距离根的最大距离
        public int rightMax;//右字数距离根的最大距离
        public TreeNode(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static int maxLen = 0;
    public void findMaxDistance(TreeNode root){
        if(root==null){
            return;
        }
        if(root.left==null){
            root.leftMax=0;
        }
        if(root.right==null){
            root.rightMax=0;
        }
        if(root.left!=null){
            findMaxDistance(root.left);
        }
        if(root.right!=null){
            findMaxDistance(root.right);
        }
        if(root.left!=null){
            int nTempMax = 0;
            nTempMax = root.left.leftMax > root.left.rightMax ? root.left.leftMax : root.left.rightMax;
            root.leftMax = nTempMax+1;
        }
        if(root.right!=null){
            int nTempMax=0;
            nTempMax=root.right.leftMax > root.right.rightMax ? root.right.leftMax : root.right.rightMax;
            root.rightMax=nTempMax+1;
        }
        if(root.leftMax + root.rightMax > maxLen){
            maxLen = root.leftMax + root.rightMax;
        }
    }

    public static void main(String[] args){
        TreeNode root=new TreeNode(0);
        TreeNode p1=new TreeNode(1);
        TreeNode p2=new TreeNode(2);
        TreeNode p3=new TreeNode(3);
        TreeNode p4=new TreeNode(4);
        TreeNode p5=new TreeNode(5);
        TreeNode p6=new TreeNode(6);
        TreeNode p7=new TreeNode(7);
        TreeNode p8=new TreeNode(8);
        root.left=p1;
        root.right=p2;
        p1.left=p3;
        p3.left=p4;
        p2.left=p5;
        p2.right=p6;
        p6.right=p7;
        p7.right=p8;
        System.out.println(maxLen);
        new MaxDistanceInBinary().findMaxDistance(root);
        System.out.println(maxLen);
    }
}
