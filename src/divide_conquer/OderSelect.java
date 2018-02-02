package divide_conquer;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by kentorvalds on 2017/7/3.
 * 顺序统计量
 */
public class OderSelect {

    public static int orderSelect(int v[],int low,int high,int i)
    {
        int mid=partition(v,low,high);
        int len=mid-low+1;
        if(len==i)
            return v[mid];
        if(len>i)
            return orderSelect(v, low, mid-1, i);
        else {
            return orderSelect(v, mid+1, high, i-len);
        }
    }

    private static int partition(int v[],int low,int high)
    {
        Random random=new Random();
        int ran=random.nextInt(high-low+1);
        int n=v[ran+low];
        v[ran+low]=v[low];
        v[low]=n;
        while(low<high)
        {
            while(low<high&&v[high]>=n)
                high--;
            if(low>high)
                return low;
            v[low]=v[high];
            while(low<high&&v[low]<=n)
                low++;
            v[high]=v[low];
        }
        v[low]=n;
        return low;
    }

    public static void main(String[] args)
    {
        int v[]={3,1,5,5,8,2};
        System.out.print("请输入顺序统计量：");
        Scanner cin=new Scanner(System.in);
        int i=cin.nextInt();
        System.out.println("第"+i+"个顺序统计量为"+orderSelect(v, 0, v.length-1, i));
    }
}
