package methd_of_programing.string;

/**
 * Created by kentorvalds on 2017/10/12.
 */
/*
均分01: 有字符串只有0和1两种字符, 切0和1的个数为偶数, 对改字符进行切割,然后分给两个人,是的两个人分的的0和1一样多
例如，输入串是010111,我们可以把串切位01, 011,和1， 把第1段和第3段放在一起分给一个人，第二段分给另外一个人，这样每个人都得到了1个0和两个1。我们要做的是让切分的次数尽可能少。
输入是这样一个字符串，输出是最少的切分次数，保证输入合法。
 */
public class AverageDistribution01 {

    public static void main(String[] args){
        String str = "0101010100001010100111100011";
        System.out.println(cutZeroAndOne(str));
    }

    public static int cutZeroAndOne(String str){

        int i, m =0, n=0, tmpm=0, tmpn=0;
        for(i=0;i<str.length();i++)
        {
            if(str.charAt(i)=='0')
                m++;
            else
                n++;
        }
        for(i=0;i<(m+n)/2;i++)
        {
            if(str.charAt(i)=='0')
                tmpm++;
            else
                tmpn++;
        }
        if(tmpm==m/2 && tmpn==n/2)
                return 1;
        else
                return 2;
  }
}
