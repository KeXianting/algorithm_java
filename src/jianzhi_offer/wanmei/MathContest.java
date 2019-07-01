package jianzhi_offer.wanmei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by kentorvalds on 2018/8/28.
 */
public class MathContest {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
//        int score[] = new int[num];
//        int time[] = new int[num];
        /*
        5
        5 4 3 5 2
        2 2 3 5 1
        10
         */
        Score[] scores = new Score[num];
        int i ;
        for (i = 0; i < num; i++) {
            scores[i] = new Score();
            scores[i].score = scanner.nextInt();

        }
        for (i = 0; i < num; i++) {
            scores[i].time = scanner.nextInt();
        }
        Arrays.sort(scores);
        int totalTime = scanner.nextInt();
        System.out.println(getScore(scores, totalTime));
    }
    public static int getScore(Score[] scores, int totalTime) {
        int sum = 0;
        int tempSum = 0;
        for (int i = 0; i < scores.length ; i ++){
            tempSum += scores[i].time;

            if (tempSum <= totalTime){
                sum += scores[i].score;
            }else {
                break;
            }
        }
        return sum;
    }

    static class Score implements Comparable<Score>{
        int score;
        int time;
        public Score(){

        }
        @Override
        public int compareTo(Score o) {
            if (o.score < score){
                return 1;
            }else {
                return -1;
            }

        }
    }
}