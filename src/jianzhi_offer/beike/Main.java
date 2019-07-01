package jianzhi_offer.beike;

import java.util.*;

/**
 * Created by kentorvalds on 2018/8/18.
 */
public class Main {

    public static void main(String[] args){
        //int[] arr = {4,1,8,2,5};
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()){
//            int N = in.nextInt();
//            int[] t = new int[N];
//            for (int i = 0; i < N; i++){
//                t[i] = in.nextInt();
//            }
//            int sum = question1(t);
//            System.out.println(sum);
//        }

        //question2
        /*
        3
        3 10
        20 30
        1 3

        4
        3 10
        20 30
        1 3
        1 39
         */
        question2();

    }

    public static Integer question1(int[] arr){
        Arrays.sort(arr);
        int sum = 0;
        for (int i = 1; i < arr.length; i ++){
            sum += arr[i];
        }
        return sum;
    }

    public static void question2(){

        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int N = in.nextInt();
            ArrayList<Integer> start = new ArrayList<>();
            ArrayList<Integer> end = new ArrayList<>();
            Activity[] activities = new Activity[N];
            Activity[] startB = new Activity[N];
            for (int i = 0; i < N; i ++){
                activities[i] = new Activity();
                activities[i].start = in.nextInt();
                activities[i].end = in.nextInt();
                activities[i].index = i;
            }
            Arrays.sort(activities);
            int count = 0;
            ArrayList<Integer> result = new ArrayList<>();
            for (int i = 0; i < N; i ++){
                boolean[] A = new boolean[N-1];
                Activity[] newAct = getNewArray(activities, i);
                ArrayList<Integer> startL = new ArrayList<>();
                ArrayList<Integer> endL = new ArrayList<>();
                for (int k = 0; k < newAct.length; k ++){
                    startL.add(newAct[k].start);
                    endL.add(newAct[k].end);
                }
                select(N-1, startL, endL, A);
                int flag = 0;
                for (int j = 0; j < N-1; j ++){
                    //System.out.println(A[j]);
                        if (!A[j]){
                            flag = 1;
                            break;
                    }

                }
                if (flag == 0){
                    count ++;
                    result.add(i);
                }
            }
            System.out.println(count);
            for (int i = 0; i < result.size(); i ++){
                System.out.print((result.get(i) + 1) + " ");
            }
            System.out.println();
        }

    }

    public static void select(int n,ArrayList<Integer> start, ArrayList<Integer> end, boolean A[]){
        Integer s[] = start.toArray(new Integer[start.size()]);
        Integer f[] = end.toArray(new Integer[end.size()]);

        A[0]=true;
        int index=0;
        for(int i=1;i<n;i++)
        {
            if(s[i]>=f[index])
            {
                A[i]=true;
                index=i;
            }
            else A[i]=false;
        }
    }

    public static Activity[] getNewArray(Activity[] activities, int index){
        int len = activities.length;
        Activity[] newAct = new Activity[len-1];
        for (int i = 0; i < newAct.length; i ++){
            if (index == 0){
                newAct[i] = activities[i + 1];
            }else if(i > 0 && i < activities.length - 1){
                if (i < index){
                    newAct[i] = activities[i];
                }else {
                    newAct[i] = activities[i + 1];
                }

            }else {
                newAct[i] = activities[i];
            }
        }
        return newAct;
    }
    static class Activity implements Comparable<Activity>{
        int start;
        int end;
        int index;
        public Activity(){

        }

        @Override
        public int compareTo(Activity o1) {
            if (this.end < o1.end ){
                return -1;
            }else {
                return 1;
            }

        }

        @Override
        public String toString() {
            return "[" + this.start + "," + this.end + "]";
        }
    }
}
