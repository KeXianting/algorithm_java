package methd_of_programing.array;

/**
 * Created by kentorvalds on 2017/12/20.
 * 有N个鸡蛋和M个篮子，把鸡蛋放到M个篮子里，每个篮子都不能为空。
 * 另外，需要满足：任意一个小于N的正整数，都能由某几个篮子内蛋的数量相加的和得到。
 * 写出程序，使得输入一个(N,M)，输出所有可能的分配情况。
 *
 * 分析: 对于前n个篮子，其鸡蛋数量总和为sum，那么对于第n+1个篮子
 * ，其鸡蛋数量应该满足：save[n+1] <= sum + 1，如果save[n+1] > sum + 1，
 * 那么sum + 1这个数将无法通过相应的篮子鸡蛋数相加来获得(因为如果save[n+1]>sum+1, 前n个篮子的和为sum, 则前n+1个篮子的和大于2*sum+1
 * 那么sum这个数可以根据前n个篮子中的鸡蛋和得到, sum+1这个数不能满足, 因为save[n+1]>sum+1)。
 */
public class NEggMBasket {
    public static void main(String[] args){
        int N=9,M=5,index=1;

        int[] save = new int[M + 1];

        save[0] = 0;//前0个篮子的和为0

        reserveegg(N,M,save,index);
    }

    private static int sumEgg(int save[],int index) {//前index个篮子中鸡蛋的总数
        int sum=0;
        for(int i=1;i<=index;i++)
            sum+=save[i];
        return sum;
    }
    private static void reserveegg(int N,int M,int save[],int index)//这里index是表示放在save哪一个篮子里面
    {
        if(N ==0 && M == 0)  //输出结果
        {
            for(int i=1; i<index; i++)
                System.out.print(save[i] + "  ");
            System.out.println();
        }
        if(N >= M && M != 0)
        {
            for(int i=1;i <= N;i++)  //每个篮子从放1到N个鸡蛋，判断这个鸡蛋是否大于前一个篮子
            //这是为了防止输出重复情况，而本篮子的鸡蛋数应该小于等于前边所有篮子鸡蛋总数sum加1
            //否则i大于sum+1，则sum+1这个数就没法通过篮鸡蛋数表示
            {
                int k=index;
                if(i >= save[k-1] && (sumEgg(save,index-1)+1) >= i )
                {
                    save[k++]=i;
                    reserveegg(N-i,M-1,save,k);
                }
            }
        }

    }
}
