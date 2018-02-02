package methd_of_programing.array;

import data_struct.tree.BinaryNode;
import data_struct.tree.BinaryTree;

import java.util.Stack;

/**
 * Created by kentorvalds on 2017/10/19.
 *
 输入一个整数和一棵二元树。从树的根结点开始往下访问一直到叶结点所经过的所有结点形成一条
 路径。打印出和与输入整数相等的所有路径。
 例如输入整数 22 和如下二元树
    10
   / \
  5  12
 / \
 4  7
 则打印出两条路径:10, 12 和 10, 5, 7。
 */
public class FixedSumOfBinaryTree {

    public static void main(String[] args){
        //构造二叉树
        Integer[] list = {10,5,4,7,12};
        Integer[] list1 = {4,5,7,10,12};
        //以先跟遍历和中跟遍历构建二叉树
        BinaryTree<Integer> binaryTree = new BinaryTree<>(list, list1);
//        binaryTree.preOrder();
//        binaryTree.inOrder();
//        binaryTree.postOrder();
        findPath(binaryTree.root, 22);
    }

    /*
    当用前序遍历的方式访问到某一节点时，我们把该结点添加到路径上，
    并累加该结点的值。如果该结点为叶结点并且路径中结点值的和刚好为输入的整数，
    则当前的路径符合要求，我们把它打印出来。如果当前的结点不是叶结点，则继续访问它的子节点。
    当前结点访问结束后，递归函数将自动回到它的父节点。因此我们在函数退出之前要在路径上删除当前结点并减去当前结点的值，
    以确保返回父节点时路径刚好是从根节点到父节点的路径。我们不难看出保存路径的数据结构实际上是一个栈，
    因此路径要与递归调用状态一致，而递归调用的本质上是一个压栈和出栈的过程
     */
    public static void findPath(BinaryNode<Integer> root, int sum){
        if (root == null){
            return;
        }
        //路径栈
        Stack<Integer> stack = new Stack<>();
        findPath(root, sum, stack);
    }

    public static void findPath(BinaryNode<Integer> root, int sum, Stack<Integer> path){
        if (root == null){
            return;
        }
        //如果是叶子节点且和满足sum(每次的和都会减去上一个节点的值)
        if (root.left == null && root.right == null){//叶子节点
            if (root.data == sum){
                System.out.println("路径为: ");
                for (Integer i:path){
                    System.out.print(i + " , ");
                }
                System.out.println(root.data);
            }
        }else {

            path.push(root.data);
            if (root.left != null){
                findPath(root.left, sum - root.data, path);
            }
            if (root.right != null){
                findPath(root.right, sum - root.data, path);
            }

            path.pop();
        }
    }

}
