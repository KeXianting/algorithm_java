package methd_of_programing.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kentorvalds on 2017/10/14.
 * 问题描述
 互联网搜素已经成了我们生活和工作的一部分，在输入一些关键词之后，
 搜索引擎会返回许多结果，每个结果都包含一段概括网页内容的摘要。
 例如，在百度上搜索框中输入“图的最小生成树 - heart_love”，将会显示如下内容：
xxxxx最小生成树.....heart——lovexxxxxx....

 在搜索结果中，标题和URL之间的内容就是我们所说的摘要。这些摘要是怎么样生成的呢？我们对问题做如下简化。
 给定一段描述w和一组关键字q，我们从这段描述中找出包含所有关键字的最短字符序列。需要注意两点：①最短字符序列必须包含所有的关键字②最短字符序列中关键字的顺序可以是随意的。
 2、分析与解法
 假设给定的描述序列为w0,w1,w2,w3,q0,w4,w5,q1,w6,w7,w8,q1,w9,q0，
 关键字序列为：q0,q1。我们可以观测到包含所有关键字的序列有q0,w4,w5,q1和q1,w9,q0，其中最短的字符序列为q1,w9,q0
 step1:让start,end两个标志位指向描述字符的开始位置,end往后扫描,扫描到w6时,第一次关键词找到;
 step2:让start移到q0处;
 step3:让start移到q0的下一位w4处
 step4:重复上述步骤,找到最小的序列
 */
public class ShortestAbstract {
    public static void main(String[] args){
        //关键字
        String keyword[] = { "微软", "计算机", "亚洲" ,"交流"};
        //描述序列
        String description[] = {
                "微软", "亚洲", "研究院", "成立", "于", "1998", "年", "，", "我们", "的", "使命",
                "是", "使", "未来", "的", "计算机", "能够", "看", "、", "听", "、", "学", "，",
                "能", "用", "自然语言", "与", "人类", "进行", "交流", "。", "在", "此", "基础", "上",
                "，", "微软", "亚洲", "研究院", "还", "将", "促进", "计算机", "在", "亚太", "地区",
                "的", "普及", "，", "改善", "亚太", "用户", "的", "计算", "体验", "。", "”"};

        String summary = getShortestAbstract(keyword, description);
        System.out.println(summary);
    }

    //
    public static String getShortestAbstract(String[] s1, String[] s2){
        StringBuilder sb = new StringBuilder();
        //关键字的长度
        int len1 = s1.length;
        //描述符的长度
        int len2 = s2.length;
        //标志位的初始值:用来标记每次查找到的包含所有关键字的位置
        int start = 0;
        int end = 0;
        //记录最短摘要的起始位置
        int abstractBegin = -1;
        int abstractEnd = -1;

        int shortestLen = len2 + 1;

        //记录关键字在摘要中出现的次数:key=关键字; value=关键字出现的次数
        HashMap<String, Integer> keyCount = new HashMap<>();
       for (String s:s1){
           if (!"".equals(s) && s != null){
               keyCount.put(s, 0);
           }
       }
        if (keyCount.isEmpty()){
            return null;
        }

        while (true){
            //当有关键字没有出现时且小于描述符的长度时, 当所有的关键字都出现过时结束第一次
            while (!isAllVisited(keyCount) && end < len2) {
                if (keyCount.containsKey(s2[end])) {
                    setVisited(keyCount, s2[end], 1);     //出现次数加1
                }
                end ++;
            }

            //start右移，停止条件为：已经无法包含所有关键字；
            //然后回到上面，end右移，重新初始化，使得start~end重新包含所有关键字
            while (isAllVisited(keyCount)){
                if (end - start < shortestLen){
                    shortestLen = end - start;
                    abstractBegin = start;
                    abstractEnd = end - 1;
                }

                if(keyCount.get(s2[start]) != null){
                    setVisited(keyCount, s2[start], -1);//出现次数减1
                }

                start ++;
            }

            if (end >= len2){
                break;
            }
        }

        //返回找到的最短摘要，没找到则返回null
        if (abstractBegin == -1 || abstractEnd == -1) {
            System.out.println("one or more keywords not found.");
            return null;
        } else {

            for (int i = abstractBegin; i <= abstractEnd; i++) {
                sb.append(s2[i]);
            }

        }


        return sb.toString();



    }

    //所有关键字出现次数大于0，则找到了一个摘要
    private static boolean isAllVisited(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            if (count == 0) {
                return false;
            }
        }
        return true;
    }
    private static void setVisited(Map<String, Integer> map, String key, int add) {
        int count = map.get(key);
        map.put(key, count + add);
    }
}
