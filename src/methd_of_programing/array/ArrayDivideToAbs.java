package methd_of_programing.array;

/**
 * Created by kentorvalds on 2017/12/20.
 *
 数组中的数分为两组，给出一个算法，使得两个组的和的差的绝对值最小。数组中的数的取值范围是0<x<100，元素个数也是大于0，小于100
 比如a[]={2,4,5,6,7},得出的两组数{2，4,，6}和{5，7}，abs(sum(a1)-sum(a2))=0;
 比如{2，5，6，10}，abs(sum(2,10)-sum(5,6))=1,所以得出的两组数分别为{2，10}和{5,6}。

 实际上为背包问题。
 背包大小为数组所有元素和的一半。
 这里将需要装进背包的物品的体积与价值设置为相同的即可，为每个数组元素的值。
 */
public class ArrayDivideToAbs {



    public static void main(String[] args) {
        //向背包中添加5个物品
        int[] weight = {-1,2,4,5,6,7}; //第0个元素不算，下标都从1开始;测试{2,5,6,10}
        int[] value = {-1,2,4,5,6,7}; //第0个元素不算，下标都从1开始
        int num = weight.length; //计算物品数量
        int CAP = 12; //设置背包容量为12,和的一半
        int[] x = new int[num];//第0个元素不算，下标都从1开始
        int maxvalue = KnapSack(num,weight,value,x,CAP);
        System.out.println("\n最大价值："+maxvalue);
    }

    /**
      * @param num 物品数
      * @param weight 物品重量数组
      * @param value 物品价值数组
      * @param x 物品的选取状态
      * @param C 背包容量
      * @return
      */
    public static int KnapSack(int num, int weight[], int value[], int x[], int C){
        int V[][] = new int[C+1][C+1];
        for(int i = 0 ; i <= num ; i++ ){
            V[i][0] = 0; //第一列都为0；
        }
        for(int j = 0 ; j <=C ; j++){
            V[0][j]=0;//第一行都为0
        }
        for(int i = 1 ; i <= num-1 ; i++){
            for(int j = 1 ; j <=C ; j++){
                //想要向包中添加第i个物品，若物品体积大于当前体积，是无论如何都加不进去的
                if(j < weight[i])
                    V[i][j] = V[i-1][j];
                else{
                    V[i][j] = Math.max(V[i-1][j], V[i-1][j-weight[i]]+value[i]);
                }
                System.out.print(V[i][j]+"\t");
            }
            System.out.println();
        }
        int j =C;
        for(int i = num-1 ; i>0; i--){
            if(V[i][j]>V[i-1][j]){
                x[i]=1;
                j=j-weight[i];
            }else {
                x[i] = 0;
            }
        }
        System.out.println("选中的物品是:");//1代表第一个子数组选中的位置,0代表第二个
        for(int i = 1 ; i < num ; i++){
            System.out.print(x[i]+" ");
        }
        return V[num-1][C];
    }
}
