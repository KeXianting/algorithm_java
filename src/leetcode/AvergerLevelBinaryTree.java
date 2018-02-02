package leetcode;

import data_struct.tree.BinaryNode;
import data_struct.tree.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by kentorvalds on 2017/7/16.
 */
/*
Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.

Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 */
    //二叉树的平均扥机
public class AvergerLevelBinaryTree {

    public static void main(String[] arg){
        BinaryTree<Double> binaryTree = new BinaryTree<>();

        BinaryNode<Double> b1, b2;

        b1 = new BinaryNode<>(9.0);
        b2 = new BinaryNode<>(20.0, new BinaryNode(15.0), new BinaryNode<>(7.0));
        binaryTree.root = new BinaryNode<>(3.0, b1, b2);

        //二叉树遍历
        binaryTree.preOrder();//先跟便利
        binaryTree.inOrder();//中跟遍历
        binaryTree.postOrder();//后跟遍历

        //层次均值
        System.out.println("层次均值");
        List<Double> res = averageOfLevels(binaryTree.root);
        for (Double l:res){
            System.out.print(l + ",");
        }




    }

    public static List<Double> averageOfLevels(BinaryNode root) {
        List<Double> result = new ArrayList<>();
        Queue<BinaryNode> q = new LinkedList<>();

        q.add(root);

        while (! q.isEmpty()){
           //计算每层的元素个数
            int n = q.size();
            double sum = 0;//每层节点的元素和
            for (int i = 0; i < n; i ++){
                BinaryNode t = q.poll(); //当前节点出队列
                sum = sum + (double)t.data;
                if (t.left != null){
                    q.add(t.left);
                }
                if (t.right != null){
                    q.add(t.right);
                }
            }
            result.add(sum/n);
        }

        return result;
    }


}

