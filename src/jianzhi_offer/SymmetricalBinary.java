package jianzhi_offer;

/**
 * Created by kentorvalds on 2018/5/9.
 * 判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的
 */
public class SymmetricalBinary {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public class Solution {
        boolean isSymmetrical(TreeNode r1,TreeNode r2) {
            if (r1 == null&&r2 == null)
                return true;
            if (r1 == null||r2 == null)
                return false;
            return r1.val==r2.val&&isSymmetrical(r1.left,r2.right)&&isSymmetrical(r1.right,r2.left);
        }
        boolean isSymmetrical(TreeNode pRoot)
        {
            return isSymmetrical(pRoot,pRoot);
        }
    }
}
