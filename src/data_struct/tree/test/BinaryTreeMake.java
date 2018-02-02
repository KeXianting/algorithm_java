package data_struct.tree.test;

import data_struct.tree.BinaryNode;
import data_struct.tree.BinaryTree;

/**
 * Created by kentorvalds on 2017/6/21.
 */
public class BinaryTreeMake {
    public static void main(String[] args) {
        BinaryTree<String> bitree = make();
        bitree.preOrder();//先跟便利
        bitree.inOrder();//中跟遍历
        bitree.postOrder();//后跟遍历





        System.out.println("double++++++++++++");
        BinaryTree<Double> binaryTree = new BinaryTree<>();
        BinaryNode<Double> b1, b2;
        b1 = new BinaryNode<>(9.0);
        b2 = new BinaryNode<>(20.0, new BinaryNode(15.0), new BinaryNode<>(7.0));
        binaryTree.root = new BinaryNode<>(3.0, b1, b2);
        binaryTree.preOrder();//先跟便利
        binaryTree.inOrder();//中跟遍历
        binaryTree.postOrder();//后跟遍历



    }

    /*
            C
         B      C
      D      E      F
         G

     */
    public static BinaryTree<String> make() {
        BinaryTree<String> bitree = new BinaryTree<String>();
        BinaryNode<String> child_f, child_d, child_b, child_c;
        child_d = new BinaryNode<String>("D", null, new BinaryNode<String>("G"));
        child_b = new BinaryNode<String>("B", child_d, null);
        child_f = new BinaryNode<String>("F", new BinaryNode<String>("H"), null);
        child_c = new BinaryNode<String>("C", new BinaryNode<String>("E"),
                child_f);
        bitree.root = new BinaryNode<String>("C", child_b, child_c);
        return bitree;
    }
}