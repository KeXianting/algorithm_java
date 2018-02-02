package methd_of_programing.string;

import java.util.ArrayList;

/**
 * Created by kentorvalds on 2017/9/15.
 */
/*
字符串匹配算法:
1. 朴素字符串匹配算法:把每个字符串都拿来做对比。时间复杂度是O(m*(n-m+1))
2.优先自动加
3.KMP
 */
public class StringMatch {

    public final static int NO_CHARS = 256; //假设字符有256种

    public static void main(String[] args){
        String s1 = "acaabcdeaabfgcaabfwcs";
        String s2 = "aab"; //s1中有两个偏移位, 2和8, aab

        ArrayList<Integer> arrayList = naiveStringMatch(s1, s2);
        System.out.print("朴素法的偏移位为: ");
        for (Integer offset:arrayList){
            System.out.print(offset + ",");
        }

        System.out.println();

        ArrayList<Integer> arrayList1 = stringMatchFiniteAutomaton(s2.toCharArray(), s1.toCharArray());
        System.out.println("有限自动机法的偏移位为: ");
        for (Integer offset:arrayList1){
            System.out.print(offset + ",");
        }

        System.out.println();


        String strT="abcabaabcabaacefgabaadfabaa";
        String strP="abaa";
        ArrayList<Integer> arrayList2 = RabinKarpAlogrithm(strT.toCharArray(), strP.toCharArray(),10, 13);
        System.out.println("Rabin-Karp法的偏移位为: ");
        for (Integer offset:arrayList2){
            System.out.print(offset + ",");
        }

        System.out.println();


        System.out.println("KMP法的首偏移为:");
        ArrayList<Integer> arrayList3 = KMP(s1,s2);
        for (Integer offset:arrayList3){
            System.out.print(offset + ",");

        }


        //通配符字符串匹配
        System.out.println("通配符字符串匹配:");
        String str1 = "John Smith";
        String str2 = "J*Smi??";
        String str3 = "JK*Smi??";
        System.out.println(isMatch(str1, str2));
        System.out.println(isMatch(str1, str3));




    }
    //暴力搜算算法
    //在s1中找出与s2匹配的字符串的偏移位, 可能有多个
    public static ArrayList<Integer> naiveStringMatch(String s1, String s2){
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        ArrayList<Integer> arrayList = new ArrayList<>();//存放返回偏移位结果
        int len1 = c1.length;
        int len2 = c2.length;
        for (int i = 0; i < len1 - len2 ; i ++){
            int k = i;
            for (int j = 0; j < len2; j ++){
                if (c2[j] != c1[k]){
                    break;
                }else {
                    k ++;
                    if (j == len2 - 1){
                        arrayList.add(i);
                    }
                }
            }
        }

        return arrayList;

    }


    //方法2: 有限自动机
    /*
    接下来我们看看一个文本的匹配流程，假定要查找的字符串为P=”ababaca”,
    被查找的文本为T=”abababacaba”. 一次读入T的一个字符，用S表示当前读入的T的字符，
    一开始读入一个字符，于是S=a.然后看看，从P开始，连续几个字符所构成的字符串可以成为S的后缀
    ，由于当前S只有一个字符a,于是从P开始，连续1个字符所形成的字符串”a”,可以作为S的后缀。
    把这个字符串的长度记为k,于是此时k 等于1. 继续从T中读入字符，于是S=”ab”, 此时，从P开始，
    连续两个字符所构成的字符串”ab”可以作为S的后缀，于是k = 2.反复这么操作，于是便有以下序列：

    S=a, k = 1, P[1] 是S的后缀
    S=ab, k = 2, P[1,2] 是S的后缀
    S=aba, k = 3, P[1,2,3]是S的后缀
    S=abab, k= 4, P[1,2,3,4]是S的后缀
    S=ababa, k = 5, P[1,2,3,4,5]是S的后缀
    S=ababab, k = 4, P[1,2,3,4]是S的后缀
    S=abababa, k = 5, P[1,2,3,4,5]是S的后缀
    S=abababac, k = 6, P[1,2,3,4,5,6]是S的后缀
    S=abababaca, k = 7, P[1,2,3,4,5,6,7]是S的后缀
    S=abababacab, k =2, P[1,2] 是S的后缀
    S=abababacaba, k = 3, P[1,2,3] 是S的后缀。

    注意看第9步，P的长度是7，整个字符串P成为了字符串S的后缀，
    而此时的S是文本T的前缀，这不就表明文本T含有字符串P了吗。
    在每一个步骤中，我们都需要从P的第一个字符开始，看看最多能连续读取几个字符，
    使得他们能成为S的后缀，假设P的字符个数为m, 那么这个读取过程最多需要读取m个字符，
    于是复杂度为O(m). 如果有某种办法，使得我们一次就可以知道从P开始
    ，连续读取几个字符就可以构成S 的后缀，假设文本T含有n个字符，
    那么我们就可以在O(n)的时间内判断，T是否含有字符串P.因为上面的步骤最多可以执行n次。

    于是当前问题变成，构造一个方法，使得一次运行便能知道从P开始，
    连续读取几个字符能使，得这几个字符构成的字符串是S的后缀。这个方法，就需要上面我们提到的有限状态自动机。

    用于字符串匹配的自动机

    假定字符串P和文本T只由a,b两个字符组成，也就是字符集为∑={a,b,c},
     P含有m个字母，于是，我们要构造的自动机就含有m个状态节点。
     假设我们当前处于状态节点q, 那么当下一个输入字符是a和b时，
     从当前节点q该跳转到哪一个节点呢？ 如果用Pq来表示长度为q的P的前缀，
     以q=4, p=”ababaca”, Pq=”abab”, 那么当处于状态4, 当输入为a时，
     我们构造字符串 S = Pq + ‘a’ = “ababa”, 然后看看字符串P从第一个字符开始，
     连续几个字符所构成的字符串可以成为S的后缀，就当前S为例，
     从第一个字符开始，连续5个字符，也就是P[1,2,3,4,5]可以作为S的后缀，
     于是，我们就有，当状态机处于节点4，输入为a时，跳转的下个状态就是5.
     同理，当处于状态q=4,输入为字符b时，S = Pq + ‘b’ = “ababb”,此时从P开始，
     连续读取0个字符才能形成S的后缀，于是当状态机处于状态4，如果读入字符是b,
      那么跳转的下一个状态是0，同理，如果输入字符是c, 那么S = Pq + ‘c’ = “ababc”,
      此时从P开始，连续读取0个字符所形成的空字符串才能作为S的后缀，于是当状态机处于状态节点4，
      输入字符为c时，跳转到节点0. 如果q从0开始，一直到m,反复运用刚才提到的步骤，便会产生下面这个跳转表：

    输入 	a	b	c
    状态0	1	0	0
    状态1	1	2	0
    状态2	3	0	0
    状态3	1	4	0
    状态4	5	0	0
    状态5	1	4	6
    状态6	7	0	0
    状态7	1	2	0
    利用上面的状态机，依次读入T的字符，如果状态机跳转到状态q,那就表明从P的第一个字符开始
    ，连续读取q个字符，所形成的字符串可以构成是S的后缀，也就是说，当我们的状态机跳转到状态7时，我们就可以得知文本T,包含字符串P.
     */
    public static ArrayList<Integer> stringMatchFiniteAutomaton(char[] pat, char[] txt){//pat:待匹配的字符串, txt被匹配字符串
        //返回匹配成功便宜
        ArrayList<Integer> arrayList = new ArrayList<>();

        int M = pat.length; //待匹配字符串的长度
        int N = txt.length; //被匹配字符串的长度
        int[][] TF = new int[M + 1][NO_CHARS];//状态转换表
        coumputeTF(pat, M, TF);
        int state = 0;
        for (int i = 0; i < N; i ++){
             state = TF[state][txt[i]];
            if (state == M){
                int index = i - M + 1;
                arrayList.add(index);
            }
        }

        return arrayList;

    }
    //构建自动机
    public static void coumputeTF(char[] pat, int M, int[][] TF){
        int state, x;
        for (state = 0; state <= M; ++state)
            for (x = 0; x < NO_CHARS; ++x) //TF的行数为pat的长度加1,列数为被匹配字符串中字符种类数
                TF[state][x] = getNextState(pat, M,  state, x);
    }
    //状态变迁函数
    //例如:pat=ababaca, txt=abababaca, 当前状态为4,输入字符'a',则pat的长度为q的前缀加上'a'后为S=ababa,则此时字符串pat的连续5个字符为S的后缀,
    //所以当前状态为4时,输入'a'后下一个状态是5
    //pat:待匹配字符串, M:待匹配字符串的长度; k:当前所处的状态; x:下一个状态(当前状态为k,输入一个字符后的状态)
    public static int getNextState(char[] pat, int M, int k, int x){
        // 因为:pat[0...k-1]x 和 pat 的前面都是是一样的，如果x == pat[k]可直接返回。
        if (k < M && x == pat[k])
            return k+1;
        int ns, i;  // ns 是下一个状态
        // ns 最终是最长的那个  prefix (同时也是pat[0..k-1]x)的后缀
        //从可能得最长的前缀位置开始，找到后break,即为所求
        for (ns = k; ns > 0; ns--) {
            if(pat[ns-1] == x){
                for(i = 0; i < ns-1; i++) {
                    if (pat[i] != pat[k-ns+1+i])
                        break;
                }
                if (i == ns-1)
                    return ns;
            }
        }
        return 0;
    }



    //方法3:Rabin-Kamp算法
    /*
    Rabin-Karp算法的思想：

    假设子串的长度为M,目标字符串的长度为N
    计算子串的hash值
    计算目标字符串中每个长度为M的子串的hash值（共需要计算N-M+1次）
    比较hash值
    如果hash值不同，字符串必然不匹配，如果hash值相同，还需要使用朴素算法再次判断
     */
    //T:被匹配字符串; P:带匹配字符串; d:基数; q:模
   public static ArrayList<Integer> RabinKarpAlogrithm(char[] T,char[] P, int d,int q){

       //结果偏移返回
       ArrayList<Integer> arrayList = new ArrayList<Integer>();

       int n = T.length;
       int m = P.length;
       if (n < m){
           return null;
       }

       int h = 1;
       for(int i=1; i<=m-1; i++)   // 计算高度 h
           h = h*d%q;//m-1个d相乘然后模q
       //预处理，计算p， t0
        //构造长度为m的子串的hash值
       int p=0, t=0;
       for(int i=0; i<m; i++) {
           p = (( d*p + P[i]) % q);
           t = (( d*t + T[i]) % q);
       }



       //开始匹配
       for(int s=0; s <n-m+1; s++) {
           if (p == t) {
               // 进一步验证
               int i = 0;
               for (i = 0; i < m; i++) {
                   if(P[i]!=T[s+i])
                       break;

               }
               if(i == m) arrayList.add(s);
           }
//


           if( s < n-m )
               t= (d* (t - T[s]*h%q) + T[s+m])  % q;  // 在ts的基础上计算ts+1
       }
       return arrayList;
   }



    //KMP算法
    public static ArrayList<Integer> KMP(String s1,String s2){
        char[] t = s1.toCharArray();
        char[] p = s2.toCharArray();
        int tLen = t.length;
        int pLen = p.length;
        ArrayList<Integer> arrayList = new ArrayList<>();
        //通过p构造next数组
        int[] next = getNext(p);
        int k = 0;
        do {
            k = KMPMatcher(t, p, k,next);
           // System.out.println(k);
            if (k != -1){
                arrayList.add(k-p.length);
            }
        }while (k < t.length && k != -1);

        return arrayList;
    }
    public static int KMPMatcher(char[] t, char[] p,int k, int[] next){//s1源字符串, s2位待匹配字符串

//        char[] t = s1.toCharArray();
//        char[] p = s2.toCharArray();
        int tLen = t.length;
        int pLen = p.length;
        //ArrayList<Integer> arrayList = new ArrayList<>();
        //通过p构造next数组
       // int[] next = getNext(p);

        int i = k, j = 0;


            while (i < tLen && j < pLen) {
                // 如果j = -1,或者当前字符匹配成功(src[i] = ptn[j]),都让i++,j++
                if (j == -1 || t[i] == p[j]) {
                    i++;
                    j++;
                } else {
                    // 如果j!=-1且当前字符匹配失败,则令i不变,j=next[j],即让pattern模式串右移j-next[j]个单位
                    j = next[j];

                }
            }
            if (j == pLen){
                return i;

            }

            return -1;


    }

    /**
     * 获取KMP算法中pattern字符串对应的next数组
     *
     * @param p
     *            模式字符串对应的字符数组
     * @return
     */
    public static int[] getNext(char[] p) {
        // 已知next[j] = k,利用递归的思想求出next[j+1]的值
        // 如果已知next[j] = k,如何求出next[j+1]呢?具体算法如下:
        // 1. 如果p[j] = p[k], 则next[j+1] = next[k] + 1;
        // 2. 如果p[j] != p[k], 则令k=next[k],如果此时p[j]==p[k],则next[j+1]=k+1,
        // 如果不相等,则继续递归前缀索引,令 k=next[k],继续判断,直至k=-1(即k=next[0])或者p[j]=p[k]为止
        int pLen = p.length;
        int[] next = new int[pLen];
        int k = -1;
        int j = 0;
        next[0] = -1; // next数组中next[0]为-1
        while (j < pLen - 1) {
            if (k == -1 || p[j] == p[k]) {
                k++;
                j++;
                // 修改next数组求法
                if (p[j] != p[k]) {
                    next[j] = k;// KMPStringMatcher中只有这一行
                } else {
                    // 不能出现p[j] = p[next[j]],所以如果出现这种情况则继续递归,如 k = next[k],
                    // k = next[[next[k]]
                    next[j] = next[k];
                }
            } else {
                k = next[k];
            }
        }
        return next;


    }




    //isMatch: s1无通配符，s2有通配符， '?'表示匹配任意一个字符，'*'表示匹配任意字符0或者多次
    public static boolean isMatch(String s1, String s2) {


        //动态规划设置初值
        boolean[][] dp = new boolean[s2.length()+1][s1.length()+1];
        dp[0][0] = true;

        for(int i=1; i<=s2.length(); i++) {
            char s2_char = s2.charAt(i-1);
            dp[i][0] = dp[i-1][0] && s2_char=='*'; //设置每次循环的初值，即当星号不出现在首位时，匹配字符串的初值都为false
            for(int j=1; j<=s1.length(); j++) {
                char s1_char = s1.charAt(j-1);
                if(s2_char == '*')
                    dp[i][j] = dp[i-1][j] || dp[i][j-1]; //动态规划递推式（星号） 表示星号可以匹配0个（决定于上次外循环的结果）或者多个（决定于刚才内循环的结果）
                else
                    dp[i][j] = dp[i-1][j-1] && (s2_char=='?' || s1_char == s2_char); //动态规划递推式（非星号） 表示dp值取决于上次的状态和当前状态
            }
        }
        return dp[s2.length()][s1.length()];
    }



}
