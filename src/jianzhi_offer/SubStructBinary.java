package jianzhi_offer;

/**
 * Created by kentorvalds on 2018/5/8.
 * 输入两颗二叉树A，B，判断B是不是A的子结构
 * (1)在树A中找到和数B的根节点相同的节点；

 可以利用前序遍历A树中的节点，找到和B树的根节点相同的节点。

 (2)在树A中找到和树B根节点相同的节点设为R；

 再对比节点R在树B中的左孩子和右孩子是否和树B中的节点相同。

 如果R节点的值和树B中的节点的值不同，则不是子结构，如果相同，递归去判断他们的各自的左孩子和右孩子是否相同。

 递归的出口是到达树A或者树B的叶节点
 */
public class SubStructBinary {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    public boolean hasSubtree(TreeNode root1,TreeNode root2){
        boolean result = false ;
        if(root1 != null && root2 != null)
        {
            //前序遍历找到相等的值
            if(root1.val == root2.val)
                result = isSubTree(root1,root2);
            if(result == false)
                result = hasSubtree(root1.left,root2);
            if(result == false)
                result = hasSubtree(root1.right,root2);

        }
        return result;
    }
    private boolean isSubTree(TreeNode root1,TreeNode root2){
        if(root2 == null)
            return true;
        if(root1 == null)
            return false;
        if(root1.val != root2.val)
            return false;
        return isSubTree(root1.left,root2.left)&&isSubTree(root1.right,root2.right);

    }
}
