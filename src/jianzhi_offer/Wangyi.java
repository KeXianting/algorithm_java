package jianzhi_offer;

import java.util.Scanner;

/**
 * Created by kentorvalds on 2018/8/11.
 */
public class Wangyi {
    public static void main(String[] arg){
        Scanner in = new Scanner(System.in);
//        while (in.hasNext()){
//            int n = in.nextInt();
//            int k = in.nextInt();
//            int[] a = new int[n];
//            int[] t = new int[n];
//            for(int i = 0; i < n; i ++){
//                a[i] = in.nextInt();
//            }
//            for (int i = 0; i < n; i ++){
//                t[i] = in.nextInt();
//            }
//
//            int temp = 0;
//            for (int i = 0; i < n; i ++){
//                if (t[i] == 0){
//                    temp = i;
//                    break;
//                }
//            }
//            int sum = 0;
//            for (int i = temp; i < k + temp; i ++){
//                sum = sum + a[i];
//            }
//            for (int i = 0; i < temp; i ++){
//                if (t[i] == 1){
//                    sum = sum + a[i];
//                }
//            }
//            for(int i = temp + k; i < n; i ++){
//                if (t[i] == 1){
//                    sum = sum + a[i];
//                }
//            }
//
//            System.out.println("sum: " + sum);
//        }
//        while(in.hasNext()){
//            int n=in.nextInt();
//            int k=in.nextInt();
//            int interest[]=new int[n];
//            for(int i=0;i<n;i++){
//                interest[i]=in.nextInt();
//            }
//            int state[]=new int[n];
//            for(int i=0;i<n;i++){
//                state[i]=in.nextInt();
//            }
//            int sumK=0;
//            int maxSumK=-1;
//            int t=0,index=0;
//            for(int i=0;i<n;i++){
//                sumK=0;
//                t=0;
//                if(state[i]==0){
//                    for(int j=i;j<n&&t<k;t++,j=i+t){
//                        sumK+=interest[j];
//                    }
//                    if(sumK>maxSumK){
//                        maxSumK=sumK;
//                        index=i;
//                    }
//                }
//            }
//            int result=0;
//            for(int i=0;i<n;i++){
//                if(state[i]==1&&(i<index||i>index+k)){
//                    result=result+interest[i];
//                }
//            }
//            System.out.println(result+maxSumK);
//        }
        StringBuilder sb = new StringBuilder();
        sb.append("aa");

        while (in.hasNext()){
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i ++){
                a[i] = in.nextInt();
            }
            int m = in.nextInt();
            int[] b = new int[m];
            for (int i = 0; i < m; i ++){
                b[i] = in.nextInt();
            }
            for (int i = 0; i < m; i ++ ){
                int res = 0;
                int sum = a[0];
                for (int j = 1; j < n; j ++){
                    if (b[i] > sum){
                        sum = sum + a[j];
                        res = j + 1;
                        if (j == n){
                            break;
                        }
                    }else {
                        res = j;
                        break;
                    }
                }
                System.out.println(res);
            }
        }


    }


//
//    int main() {
//            int n, k;
//            cin >> n >> k;
//            vector<int> a(n), t(n);
//            for (int i = 0; i < n; i++)
//                cin >> a[i];
//            int now = 0;
//            for (int i = 0; i < n; i++)
//                cin >> t[i], now += t[i] * a[i];
//            int res = now;
//            for (int i = 0; i < n;) {
//                    now += (!t[i]) * a[i];
//                    if (++i >= k) {
//                            res = max(res, now);
//                            now -= (!t[i - k]) * a[i - k];
//                        }
//                }
//            cout << res << endl;
//            return 0;
//    }
}
