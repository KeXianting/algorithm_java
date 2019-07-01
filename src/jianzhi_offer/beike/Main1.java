package jianzhi_offer.beike;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by kentorvalds on 2018/8/18.
 */
public class Main1 {
    static class Date implements Comparable<Date>{
        int start;
        int index;
        int end;
        @Override
        public int compareTo(Date o) {
            if(this.start>o.start){
                return 1;
            }
            return -1;
        }
        public boolean isIleague(Date o){
            if(this.end<=o.start){
                return true;
            }
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        Date timeData[]=new Date[n];
        for(int i=0;i<n;i++){
            timeData[i]=new Date();
            timeData[i].start=in.nextInt();
            timeData[i].end=in.nextInt();
            timeData[i].end=i+1;
        }
        Arrays.sort(timeData);
        int count=0;
        int indexList[]=new int[n];
        int k=0;
        for(int i=0;i<n;i++){
            if(isIleague(i,timeData)){
                count++;
                indexList[k++]=timeData[i].end;
            }
        }
        Arrays.sort(indexList,0,k);
        System.out.println(count);
        for(int i=0;i<count;i++){
            if(i==count-1){
                System.out.println(indexList[i]);
            }else {
                System.out.print(indexList[i]+" ");
            }

        }
    }
    public static boolean isIleague(int expectIndex, Date timeData[]){
        Date firstDate=new Date();
        boolean isFirstTime=true;
        boolean result=true;
        for(int i=0;i<timeData.length;i++){
            if(i!=expectIndex){
                if(isFirstTime){
                    firstDate=timeData[i];
                    isFirstTime=false;
                }else{
                    if(firstDate.isIleague(timeData[i])){
                        firstDate=timeData[i];
                    }else {
                        result=false;
                    }
                }
            }
        }
        return result;
    }
}
