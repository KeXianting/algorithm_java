package methd_of_programing.array;

/**
 * Created by kentorvalds on 2017/12/29.
 * 一个环形公路，上面有Ｎ个站点，A1, ..., AN，
 * 其中Ai和Ai+1之间的距离为Di,AN和A1之间的距离为D0。 高效的求第i和第j个站点之间的距离，空间复杂度不超过O(N)
 */
public class StationDistance {

    public static void main(){
        int[] d = {2,4,6,3,8,10}; //
        int n = d.length;
        int[] a = new int[n];
        //A1到A2的距离, a记录a[1]到每个点的距离
        a[1] = d[1];
        for (int i = 2; i < n; i ++){
            a[i] = a[i-1] + d[i];
        }
        //全长
        a[0] = a[n-1] + d[0];



    }

    private static int getDisIandJ(int[] a, int i, int j){
        int disI = i == 0 ? 0 : a[i - 1];
        int disJ = j == 0 ? 0 : a[j - 1];
        int dis = Math.abs(disI - disJ);
        //环形公路,每个点存在2条路径,取最短的
        return (dis > a[0] / 2) ? a[0] - dis : dis;
    }
}
