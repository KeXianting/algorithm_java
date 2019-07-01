package jianzhi_offer.DIANXIN;

/**
 * Created by kentorvalds on 2018/9/10.
 */
public class Question2 {

    private final static int[] t = {2, 3, 5};
    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {//注意while处理多个case
//            int N = in.nextInt();
//            int res = getUglyNumber(N);
//            System.out.println(res);
//        }
        System.out.println(getUglyNumber(3));
    }


    public static int getUglyNumber(int n){
        if (n == 0){
            return 0;
        }
        int[] arr = new int[n];
        arr[0] = 1;
        int[] prr = {0, 0, 0};
        int[] num = {2, 3, 5};
        int current = 1;

        while (current < n){
            int min = getMinValue(num[0], num[1], num[2]);
            if (arr[current - 1] < num[min]){
                arr[current ++] = num[min];
            }
            prr[min] += 1;
            num[min] = arr[prr[min]]*t[min];
        }
        return arr[n - 1];
//        if(n == 0)
//            return 0;
//        int arr[] = new int[n];
//        arr[0] = 1;
//        int prr[] = { 0, 0, 0 };
//        int num[] = { 2, 3, 5 };
//        int current = 1;
//
//        while (current < n) {
//            int min = getMinValue(num[0], num[1], num[2]);
//            if (arr[current - 1] < num[min]) {
//                arr[current++] = num[min];
//            }
//            prr[min] += 1;
//            num[min] = arr[prr[min]] * t[min];
//        }
//        return arr[n - 1];
    }

    public static int getMinValue(int a, int b, int c){
        int min = Math.min(a, Math.min(b, c));
        return min == a ? 0 : min == b ? 1 : 2;
    }
}
