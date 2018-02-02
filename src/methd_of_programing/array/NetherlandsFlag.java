package methd_of_programing.array;

/**
 * Created by kentorvalds on 2017/10/30.
 * 现有红白蓝三个不同颜色的小球，乱序排列在一起，请重新排列这些小球，使得红白蓝三色的同颜色的球在一起。
 * 这个问题之所以叫荷兰国旗问题，是因为我们可以将红白蓝三色小球想象成条状物，有序排列后正好组成荷兰国旗
 *
 *

 这个问题我们可以将这个问题视为一个数组排序问题。红白蓝分别对应数字0、1、2。红、白、蓝三色小球数量并不一定相同。
 */
public class NetherlandsFlag {

    public static void main(String[] args){

        int[] A = {1,2,2,2,1,2,1,0,2,1,0,0,0,0,1,0,1,0,2};

        //方法1
        System.out.println("方法1遍历重排 ");
        netherLandsFlagMethod1(A, A.length);

        System.out.println();
        //方法2
        System.out.println("方法2指针: ");
        netherLandsFlagMethod2(A, A.length);

        System.out.println();
        //方法2
        System.out.println("方法3移位: ");
        netherLandsFlagMethod3(A, A.length);
    }

    //方法1: 遍历数组, 统计红,白,蓝的数量, 根据个数重拍数组
    //时间复杂度：O(n)
    public static void netherLandsFlagMethod1(int[] A, int n){

        if (n <= 1){
            return;
        }

        //统计个数
        int red=0, white = 0, blue = 0;
        for (int i = 0; i < n; i ++){
            if (A[i] == 0){
                ++ red;
            }else if (A[i] == 1){
                ++ white;
            }else {
                ++ blue;
            }
        }

        // 重新布局
        for (int i = 0; i < n; i ++){
            if (red > 0){
                A[i] = 0;
                -- red;
            }else if (white > 0){
                A[i] = 1;
                -- white;
            }else {
                A[i] = 2;
            }
        }

        for (int a:A){
            System.out.print(a);
        }
    }


    /*
    我们可以把数组分成三部分，前部（全部是0），中部（全部是1）和后部（全部是2）三个部分，每一个元素（红白蓝分别对应0、1、2）必属于其中之一。

    将前部和后部各排在数组的前边和后边，中部自然就排好了。

    设置两个指针begin指向前部的末尾的下一个元素（刚开始默认前部无0，所以指向第一个位置），end指向后部开头的前一个位置（刚开始默认后部无2，所以指向最后一个位置），然后设置一个遍历指针current，从头开始进行遍历。

    （1）若遍历到的位置为1，则说明它一定属于中部，根据总思路，中部的我们都不动，然后current向前移动一个位置。

    （2）若遍历到的位置为0，则说明它一定属于前部，于是就和begin位置进行交换，然后current向前移动一个位置，begin也向前移动一个位置（表示前边的已经都排好了）。

    （3）若遍历到的位置为2，则说明它一定属于后部，于是就和end位置进行交换，由于交换完毕后current指向的可能是属于前部的，若此时current前进则会导致该位置不能被交换到前部，所以此时current不前进。而同1），end向前移动一个位置。
     */
    //方法2: 用start, end指针指向一头一尾, current指针指向当前
    public static void netherLandsFlagMethod2(int[] A, int n){
        int start = 0;
        int end = n - 1;
        int current = 0;
        while (current < end){
            if (A[current] == 0){
                swap(A, start, current);
                start ++;
                current ++;
            }else if (A[current] == 1){
                current ++;
            }else {
                swap(A, current, end);
                -- end;
            }
        }
        for (int a:A){
            System.out.print(a);
        }

    }
    private static void swap(int[] a, int left, int right){
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }

    //方法3:
    /*
    用三个变量记录red,white,blue的下标位置。起始下标都为-1
    如果A[i] == 0 ，插入red对white blue有影响，blue先整体向后移动一位，white再整体向后移动一位，如果不移动，前面插入的数据就会覆盖已有的。
    如果A[i] == 1，插入white对blue有影响，blue整体向后移动一位。
    A[i] == 2，直接插入blue
     */
    public static void netherLandsFlagMethod3(int[] A, int n){
        if(n <= 1){
            return;
        }//if
        int red = -1,white = -1,blue = -1;
        for(int i = 0;i < n;++i){
            // 插入red对white blue有影响
            if(A[i] == 0){
                // blue整体向后移动一位
                A[++blue] = 2;
                // white整体向后移动一位
                A[++white] = 1;
                // 插入red
                A[++red] = 0;
            }//if
            // 插入white blue受到影响
            else if(A[i] == 1){
                // blue整体向后移动一位
                A[++blue] = 2;
                // 插入white
                A[++white] = 1;
            }//else
            // 插入blue对其他没有影响
            else{
                // 插入blue
                A[++blue] = 2;
            }//else
        }//for

        for (int a:A){
            System.out.print(a);
        }
    }

}
