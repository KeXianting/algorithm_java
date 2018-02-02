package methd_of_programing.array;

import data_struct.list.Node;

/**
 * Created by kentorvalds on 2018/1/4.
 * n个数字（0,1,…,n-1）形成一个圆圈，从数字0开始，
 * 每次从这个圆圈中删除第m个数字（第一个为当前数字本身，第二个为当前数字的下一个数字）。
 * 当一个数字删除后，从被删除数字的下一个继续删除第m个数字。 求出在这个圆圈中剩下的最后一个数字。
 */
public class JosephRemoveM {

    public static void main(String[] arg){
        Node node = cycleList(10);
        josephusList(node, 10, 3);
    }

    //运用单循环链表解决
    /*
    假设已经建立了一个不带头节点的单循环链表，
    设置计数器count(初始化为1)统计在扫描循环链表的过程中是否技术到m,
    如果count=m,则输出该节点的编号并删除该节点,遍历的指针往后移动，count复位为1；否则遍历的指针往后移动，count++
     */
    private static void josephusList(Node first, int n, int m){
        if(n < 1 || m < 1)
            return;
        if(n==1){
            System.out.print(first.data+" ");
        }
        else{
            Node pre = first;  //当前节点的前驱
            Node p = first.next; //当前节点
            int count = 2;
            while(p!=pre){
                if(count==m){
                    System.out.print(p.data+" ");
                    Node r = p.next;  //删除当前节点
                    pre.next = r;
                    p=r;
                    count = 1;
                }
                else{
                    pre = p;
                    p = p.next;
                    count++;
                }
            }
            System.out.println("\n最后一个删除的元素:"+p.data);
        }
    }
    //创建带头节点的无环单链表,真正的节点有m个
    private static Node cycleList(int n){
        Node first = new Node(0,null);    //头节点
        Node r = first;   //指向链表的尾节点
        for(int i=0;i<n;i++){
            Node node = new Node(i,null);
            r.next = node;
            r = node;
        }
        first = first.next;
        r.next = first;       //若是构建无环单链表，此处   r.next = null;
        return first;
    }

    /*方法2:
    运用数学分析找出规律,快速求解。

　　首先：定义最初的n个数字（0,1,…,n-1）中最后剩下的数字是关于n和m的方程为f(n,m)。 在这n个数字中，第一个被删除的数字是m%n-1，为简单起见记为k。那么删除k之后的剩下n-1的数字为0,1,…,k-1,k+1,…,n-1，并且下一个开始计数的数字是k+1。相当于在剩下的序列中，k+1排到最前面，从而形成序列k+1,…,n-1,0,…k-1。该序列最后剩下的数字也应该是关于n和m的函数。由于这个序列的规律和前面最初的序列不一样（最初的序列是从0开始的连续序列），因此该函数不同于前面函数，记为f’(n-1,m)。最初序列最后剩下的数字f(n,m)一定是剩下序列的最后剩下数字f’(n-1,m)，所以   f(n,m)=f’(n-1,m)   。
　　然后：来我们把剩下的的这n-1个数字的序列k+1,…,n-1,0,…k-1作一个映射，映射的结果是形成一个从0到n-2的序列：

　　k+1     ->     0
　　k+2     ->     1
　　…
　　n-1     ->     n-k-2
　　0        ->     n-k-1
　　…
　　k-1     ->     n-2

　　1）把这个映射定义为p，则p(x)= (x-k-1)%n，即如果映射前的数字是x，则映射后的数字是(x-k-1)%n。

　　2）对应的逆映射是p逆(x)=(x+k+1)%n，即如果映射后的数字是x，则映射前的数字是(x-k-1)%n。

　　由于映射之后的序列和最初的序列有同样的形式，都是从0开始的连续序列，因此仍然可以用函数f来表示，记为f(n-1,m)。根据我们的映射规则，映射之前的序列最后剩下的数字f’(n-1,m)= p逆 [f(n-1,m)]=[f(n-1,m)+k+1]%n。把k=m%n-1代入得到f(n,m)=f’(n-1,m)=[f(n-1,m)+m]%n。
　　经过上面复杂的分析，我们终于找到一个递归的公式。要得到n个数字的序列的最后剩下的数字，只需要得到n-1个数字的序列的最后剩下的数字，并可以依此类推。当n=1时，也就是序列中开始只有一个数字0，那么很显然最后剩下的数字就是0。我们把这种关系表示为：

         　　　　　　 0                  　　　 　　　　 n=1
　　　　f(n,m)={
          　　　　　　[f(n-1,m)+m]%n    　　  　　n>1

　　注意：f(n,m)这个函数只能用于返回最后一个输出的数字，而不能用于求出过程中每次输出的数字。f(n,m)表示求出[0,1,2...,n-1]中最后一个输出的元素，f(n-1,m)表示求出[0,1,2...,n-2]中最后一个输出的元素.
     */
    //递归的思想 ,省去了m和n的检查
    private static int LastRemaining(int n,int m)  {
        if(n == 1 ) {
            return 0;
        }
        else
            return (LastRemaining(n-1,m)+m)%n;
    }
    //非递归的思想 ,省去了m和n的检查
    private static int lastRemain1(int n,int m)  {
        int last = 0;
        for(int i=2;i<=n;i++){
            last = (last+m)%i;
        }
        return last;
    }

}
