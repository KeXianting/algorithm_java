package data_struct.disjointset;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kentorvalds on 2017/10/7.
 * 并查集数据结构非常简单，基本操作也很简单。但是用途感觉很大。比如，求解无向图中连通分量的个数，生成迷宫……

 这些应用本质上就是：初始时都是一个个不连通的对象，经过一步步处理，变成连通的了。。。。。

 如迷宫，初始时，起点和终点不连通，随机地打开起点到终点路径上的一个方向，直至起点和终点连通了，就生成了一个迷宫。

 如，无向图的连通分量个数，初始时，将无向图中各个顶点视为不连通的子集合，对图中每一条边，相当于union这条边对应的两个顶点分别所在的集合，直至所有的边都处理完后，还剩下的集合的个数即为连通分量的个数。


 */
public class DisjointSet<T> {
    private List<Node> forests;//所有节点
    public DisjointSet(){
        forests=new ArrayList<Node>();
    }
    /**
     * 内部类，并查集的rooted node
     * */

    private class Node{
        Node parent;
        int rank;
        T t;
        private Node(T t){
            parent=this;
            rank=0;
            this.t=t;
        }
    }
    //向森林中添加节点
    public void makeSet(T t){
        Node node=new Node(t);
        forests.add(node);
    }
    //将包含x和包含y的两个集合进行合并
    public void union(T x,T y){
        Node xNode=isContain(x);
        Node yNode=isContain(y);
        if (xNode!=null&&yNode!=null) {
            link(findSet(xNode), findSet(yNode));
        }
    }
    //查找到节点node的根节点
    public Node findSet(Node node){
        if (node!=node.parent) {
            //路径压缩，参考《算法导论》插图21.5
            node.parent=findSet(node.parent);
        }
        return node.parent;
    }
    //查找到节点node的根节点
    public Node findSet(T t){
        Node node=isContain(t);
        if (node==null) {
            throw new IllegalArgumentException("不含该节点！");
        }else {
            return findSet(node);
        }

    }
    //将两个根节点代表的集合进行连接
    private void link(Node xNode,Node yNode){
        if (xNode.rank>yNode.rank) {
            yNode.parent=xNode;
        }else {
            xNode.parent=yNode;
            if (xNode.rank==yNode.rank) {
                yNode.rank+=1;
            }
        }
    }
    //森林是否包含这个节点
    private Node isContain(T t){
        for (Node node : forests) {
            if (node.t.equals(t)) {
                return node;
            }
        }
        return null;
    }
    @Override
    public String toString() {

        if (forests.size()==0) {
            return "并查集为空！";
        }
        StringBuilder builder=new StringBuilder();
        for (Node node : forests) {
            Node root=findSet(node);
            builder.append(node.t).append("→").append(root.t);
            builder.append("\n");
        }

        return builder.toString();
    }

    public static void main(String[] args) {


        DisjointSet<String> disjointSet=new DisjointSet<String>();
        disjointSet.makeSet("cao");
        disjointSet.makeSet("yan");
        disjointSet.makeSet("feng");
        disjointSet.union("cao", "yan");
        disjointSet.union("cao", "feng");
        System.out.println(disjointSet.toString());
    }
}
