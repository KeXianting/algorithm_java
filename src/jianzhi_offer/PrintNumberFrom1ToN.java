package jianzhi_offer;

/**
 * Created by kentorvalds on 2018/6/8.
 * 输入数字n,按顺序打印出从1到最大的n位十进制数，比如输入3,则打印出1,2,3一直到最大的3位数即999
 * (考虑大数问题)
 */
public class PrintNumberFrom1ToN {

    public static void main(String[] args){
        System.out.println("test:");
        String str = "123";
        //System.out.println(str.charAt(1) - '0');
        Print1ToMaxOfNDigits(3);
    }

    public static void Print1ToMaxOfNDigits(int n){

        if(n <= 0){
            return;
        }
        StringBuffer number = new StringBuffer();

        for(int i = 0; i < n; i++){
            number.append('0');

        }

        while(!Increment(number)){
            PrintNumber(number);
        }
    }
    public static boolean Increment(StringBuffer s){
        boolean isOverflow = false;
        int nTakeOver = 0;
        int nLength = s.length();
        for(int i = nLength - 1; i >= 0; i--){
            int nSum = s.charAt(i) - '0' + nTakeOver;
            if( i == nLength - 1){
                nSum++;
            }
            if(nSum >= 10){
                if(i == 0){
                    isOverflow = true;

                }else{
                    nSum -= 10;
                    nTakeOver = 1;
                    s.setCharAt(i, (char) ('0' + nSum));
                }

            }else{
                s.setCharAt(i, (char) ('0' + nSum));
                break;
            }
        }
        return isOverflow;
    }

    public static void PrintNumber(StringBuffer s){
        boolean isBeginning0 = true;
        for(int i = 0; i < s.length(); i++){
            if(isBeginning0 && s.charAt(i) != '0'){
                isBeginning0 = false;
            }
            if(!isBeginning0){
                System.out.print(s.charAt(i));
            }
        }

        System.out.println();
    }
}
