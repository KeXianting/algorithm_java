package methd_of_programing.string;

/**
 * Created by kentorvalds on 2017/9/4.
 */
/*
经常会遇到字符串全排列的问题。例如：输入为{‘a’,’b’,’c’}，
则其全排列组合为abc,acb,bac,bca,cba,cab。对于输入长度为n的字符串数组，全排列组合为n!种
 */
public class StringPermutation {

    public static void main(String[] args){
        char[] s = {'a','b','c'};
        //递归
        System.out.println("递归法:");
        recursionMethod(s, 0, 2);

        //字典序
       // System.out.println("字典排序");
       // dicSortMethod(s);
    }


    //递归实现
    /*
    从字符串数组中每次选取一个元素，作为结果中的第一个元素。
    然后，对剩余的元素全排列，步骤跟上面一样。
    很明显这是个递归处理的过程，一直到最后即可
     */
    public static void recursionMethod(char[] ch, int from , int to){

        if (to <= 1){
            return;
        }
        if (from == to){
            //String s = Arrays.toString(ch);

            System.out.println(ch);
        }else {
            for(int i=from; i<=to; i++) {
                swap(ch,i,from); //交换前缀，使其产生下一个前缀; 先固定第一个元素,后面的排列
                recursionMethod(ch, from+1, to);
                swap(ch,from,i); //将前缀换回，继续做上一个前缀的排列
            }
        }




    }
    //字典排序
    /**
     *字典序全排列
     *字符串的全排列
     *比如单词"too" 它的全排列是"oot","oto","too"
     *1，从右端开始扫描，若出现前一个比后一个小，记录前一个的元素下表index
     *2,再找出index以后比该元素大的中的最小值的下标(见getMin方法)
     *3,index以后的元素实现反转（实现 见下面的reverse方法）
     *结束条件：前一个都比后一个大的情况
     */
    public static  void dicSortMethod(char[] c){

        System.out.println(new String(c));
        //boolean flag=true;
        int i=0;
        int j = c.length - 1;
        while(true){
            i=c.length-1;

            for(;i>0;i--){
                //从右向左找到第一个非递增的元素
                if(c[i-1]<c[i])
                    break;
            }

            if(i==0)break;

            //如果最后一个元素比所有的都小, 则继续找倒数第二个比较, 依次往前
            for (j = c.length - 1; j >= 0; --j){
                //从右向左找到第一个比非递增元素大的元素
                if(c[j]>c[i-1])
                    break;

            }


            //int minIndex=getMin(c,i-1);

            swap(c,i-1,j);

            reverse(c,i,c.length-1);

            System.out.println(new String(c));
        }

    }






    //交换
    public static void swap(char[] s,int i,int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }

    //翻转
    public static void reverse(char input[],int first,int end) {
        while(first<end){
            swap(input,first,end);
            first++;
            end--;
        }
    }



    //
    static int getMin(char[]input,int index){
        char min=input[index];
        int minIndex=index+1;
        char result='z';
        for(int i=index+1;i<input.length;i++){
            if(input[i]>min&&input[i]<result){
                result=input[i];
                minIndex=i;
            }
        }
        return minIndex;
    }

}
