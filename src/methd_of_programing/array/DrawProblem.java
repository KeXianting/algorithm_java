package methd_of_programing.array;

/**
 * Created by kentorvalds on 2017/10/23.
 你的朋友提议玩一个游戏：将写有数字的 n个纸片放入口袋中，你可以从口袋中抽取 4次纸
 片，每次记下纸片上的数字后都将其放回口袋中。如果这 4个数字的和是 m，就是你赢，否
 则就是你的朋友赢。你挑战了好几回，结果一次也没赢过，于是怒而撕破口袋，取出所有纸
 片，检查自己是否真的有赢的可能性。请你编写一个程序，判断当纸片上所写的数字是 k 1 ,
 k 2 , …, k n 时，是否存在抽取 4次和为 m的方案。如果存在，输出 Yes；否则，输出 No。

 1 ≤ n ≤ 50
 1 ≤ m ≤ 10 8
 1 ≤ k i ≤ 10 8
 输入
 n = 3
 m = 10
 k = {1, 3, 5}
 输出
 Yes（例如4次抽取的结果是1、1、3、5，和就是10）
 */
public class DrawProblem {

    public static void main(String[] args){
        int n = 3;
        int m = 10;
        int[] k = {1,3,5};

        System.out.println("暴力搜索法:" + drwaProblemMethod1(n,m,k));
        System.out.println("方法2:" + drawProblemMethod2(n,m,k));

    }

    //方法1:暴力解决
    public static boolean drwaProblemMethod1(int n, int m, int[] k){
        for (int a = 0; a < n; a ++){
            for (int b = 0; b < n; b ++){
                for (int c= 0; c < n; c ++){
                    for(int d = 0; d < n; d ++){
                       if (k[a] + k[b] + k[c] + k[d] == m){
                           return true;
                       }
                    }
                }
            }
        }
        return false;
    }

    //方法2:最内层循环即检查是否存在d，使得k[a]+k[b]+k[c]+k[d]==m,将d移到左边
    //K[d]==m-k[a]-k[b]-k[c],可以对k数组进行排序,查找速度为logn
    static boolean BinarySearch(int x, int n, int[] k)
    {
        int L=0,R=n;
        //x的存在范围是k[L],k[L+1],...k[R-1]
        while(R-L>=1){
            int mid=(L+R)/2;
            if(k[mid]==x) return true;
            else if (k[mid]<x) L=mid+1;
            else R=mid;
        }

        return false;
    }
    public static boolean drawProblemMethod2(int n, int m, int k[]){
        boolean f=false;
        for(int a=0;a<n;++a)
            for(int b=0;b<n;++b)
                for(int c=0;c<n;++c)
                    if(BinarySearch(m-k[a]-k[b]-k[c], n, k))
                        f=true;
        return f;
    }
}
