package jianzhi_offer;

/**
 * Created by kentorvalds on 2018/5/9.
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则返回true，否则返回false。假设输入的数组的任意两个数字都互不相同
 *
 * 例如输入数组｛5，7，6，9，11，10，8｝则返回true，因为这个整数序列是下图二叉树的后序遍历的结果。
 * 如果输入的数组是｛7，4，6，5｝，由于没有哪颗二叉搜索树的后续遍历的结果是这个序列，因此返回false
 *
 * 以数组｛5，7，6，9，11，10，8｝为例，后序遍历结果的最后一个数字8就是根节点的值。在这个数组中，前3个数字5，7和6都比8小，是值为8的结点的左子树结点；后3个数字9，11和10都比8 大，是值为8的结点的右子树结点。

 我们接下来用同样的方法确定与数组每一部分对应的子树的结构。这其实就是一个递归的过程。对于序列5，7，6，最后一个数字6是左子树的根节点的值。数字5比6小，是值为6的结点的左子结点，而7则是它的右子节点。同样，在序列9，11，10中，最后一个数字10是右子树的根节点，数字9比10小，是值为10的结点的左子结点，而11则是它的右子节点。

 我们再来分析一下另一个数组｛7，4，6，5｝。后序遍历的最后一个树是根节点，因此根节点的值是5.由于第一个数字7比5大，因此对应的二叉搜索树中，根节点上是没有左子树的，数字7，4，和6都是右子树结点的值。但我们发现在右子树中有一个结点的值是4，比根节点的值5小，这违背了二叉搜索树的定义。因此不存在一颗二叉搜索树，它的后序遍历的结果是7，4，6，5
 */
public class VerifySquenceOfBST {
    public boolean verifySequence(int[] array,int start,int end) throws Exception{
        if(array == null || array.length < 2)
            return true;
        if(start < 0){
            throw  new Exception("first can't be less than 0");
        }
        if(end > array.length){
            throw new Exception("last can't be greater than the count of the element.");
        }
        int root = array[end];
        //在二叉搜索树中左子树的结点小于根节点
        int i = start;
        for(; i < end;i++){
            if(array[i]>root)
                break;
        }
        //在二叉搜索树中右子树的结点大于根节点
        int j = i;
        for(;j < end;j++){
            if(array[j] < root)
                return false;
        }
        //判断左子树是不是二叉搜索树
        boolean left = true;
        if(i >start)
            left =verifySequence(array ,start,i-1);
        //判断右子树是不是二叉搜索树
        boolean right = true;
        if(i < end)
            right = verifySequence(array,i,end-1);
        return (left && right);
    }
    public static void main(String[] args) throws Exception{
        int[] arr={5,7,6,9,11,10,8};
        int[] brr = {7,4,6,5};
        VerifySquenceOfBST test = new VerifySquenceOfBST();
        System.out.println(test.verifySequence(brr, 0, brr.length-1));
    }
}
