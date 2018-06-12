package jianzhi_offer;

/**
 * Created by kentorvalds on 2018/4/19.
 * 13号又是星期五是一个不寻常的日子吗?
 13号在星期五比在其他日少吗?为了回答这个问题,写一个程序来计算在n年里13
 日落在星期一,星期二……星期日的次数.这个测试从1900年1月1日到
 1900+n-1年12月31日.n是一个非负数且不大于400.
 1900年1月1日是星期一.
 4,6,11和9月有30天.其他月份除了2月有31天.闰年2月有29天,平年2月有28天.
 年份可以被4整除的为闰年(1992=4*498 所以 1992年是闰年,但是1990年不是闰年)
 以上规则不适合于世纪年.可以被400整除的世纪年为闰年,否则为平年.所以,1700,1800,1900和2100年是平年,而2000年是闰年.
 */
public class BlackFriday {

    public static void main(String[] args){
        System.out.println("星期一的次数:  " + blackFriday(20, 1));
    }

    //计算在n年里13
    //日落在星期一,星期二……星期日的次数
    //每个月只有一天是13号, 所以一个月加1天
    public static int blackFriday(int n, int week){
        //因为1900.1.1是星期一, 所以可以从该天算起
        int[] a = new int[7]; //记录周天到周一没天出现的次数
        //int week = 1; //周天是0, 依次类推, 1表示周一,即13号落在星期一的时间
        for (int i = 1900 ; i <= 1900 + n -1; i++){//总年数
            for (int j = 1; j <= 12; j ++) {//月数
                a[week%7] ++;
                week += getDays(i,j);//得到i年j月的天数
            }

        }
        for (int i = 0 ; i < 7; i ++){
            System.out.print(a[i] + " , ");
        }
        return a[6];
    }

    /*
    一个叫基姆拉尔森计算公式：W = (d+2*m+3*(m+1)/5+(y)+(y)/4-(y)/100+(y)/400)%7; 在公式中d表示日期中的日数+1，m表示月份数，y表示年份。

    注意：用该公式时，需要把一月和二月看成是上一年的十三月和十四月，公式中的d是日期加1.所以计算结果就是实际的星期，即是：“1”为星期一，“2”为星期二。。。。“0”为星期日。

    还有另外一个公式：W = (d+2*m+3*(m+1)/5+y+y/4-y/100+y/400)%7 （其中y是四位数的，如2009。）

    注意：该公式中同样要把1月和2月分别当成上一年的13月和14月处理。而且该公式的“0”为星期一，。。。。，“6”为星期日。
     */

    public static int getDays(int year, int month){
        int days = 0;
        boolean flag = false;
        if ((year%4==0 && year%100 != 0) || (year%400==0)){
            flag = true;
        }
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                days = 31;break;
            case 2:{
                if (flag){
                    days = 29; break;
                }else {
                    days = 28; break;
                }
            }
            default:
                days = 30;
                break;
        }
        return days;
    }


}
