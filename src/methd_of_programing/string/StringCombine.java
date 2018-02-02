package methd_of_programing.string;

import java.util.*;

/**
 * Created by kentorvalds on 2017/9/29.
 */
/*
并查集(算法导论21章)
字符串合并:给定一些字符串的集合,要求将其中交集不为空的集合合并,并且合并完成后的集合之间无交集.例如:
{aaa,bbb,ccc},{bbb,ddd},{eee,fff},{ggg},{ddd,hhh}和操作后为:
{aaa,bbb,ccc,ddd,hhh},{eee,fff},{ggg}
 */


 /*
    题目：给定一个字符串的集合，格式如：{aaa bbb ccc}， {bbb ddd}，{eee fff}，{ggg}，{ddd hhh}要求将其中交集不为空的集合合并，要求合并完成后的集合之间无交集，例如上例应输出{aaa bbb ccc ddd hhh}，{eee fff}， {ggg}。
（1）请描述你解决这个问题的思路；
（2）请给出主要的处理流程，算法，以及算法的复杂度
（3）请描述可能的改进。
解答：
1. 假定每个集合编号为0，1，2，3...
2. 创建一个hash_map，key为字符串，value为一个链表，链表节点为字符串所在集合的编号。遍历所有的集合，将字符串和对应的集合编号插入到hash_map中去。
3. 创建一个长度等于集合个数的int数组，表示集合间的合并关系。例如，下标为5的元素值为3，表示将下标为5的集合合并到下标为3的集合中去。开始时将所有值都初始化为-1，表示集合间没有互相合并。在集合合并的过程中，我们将所有的字符串都合并到编号较小的集合中去。
    遍历第二步中生成的hash_map，对于每个value中的链表，首先找到最小的集合编号（有些集合已经被合并过，需要顺着合并关系数组找到合并后的集合编号），然后将链表中所有编号的集合都合并到编号最小的集合中（通过更改合并关系数组）。
4.现在合并关系数组中值为-1的集合即为最终的集合，它的元素来源于所有直接或间接指向它的集合。
0: {aaa bbb ccc}
1: {bbb ddd}
2: {eee fff}
3: {ggg}
4: {ddd hhh}
生成的hash_map，和处理完每个值后的合并关系数组分别为
aaa: 0          [-1, -1, -1, -1, -1]
bbb: 0, 1       [-1, 0, -1, -1, -1]
ccc: 0          [-1, 0, -1, -1, -1]
ddd: 1, 4       [-1, 0, -1, -1, 0]
eee: 2          [-1, 0, -1, -1, 0]
fff: 2          [-1, 0, -1, -1, 0]
ggg: 3          [-1, 0, -1, -1, 0]
hhh: 4          [-1, 0, -1, -1, 0]
所以合并完后有三个集合，第0，1，4个集合合并到了一起，
第2，3个集合没有进行合并。
     */
public class StringCombine {
    //并查集的数据结构: 数据子集个数; 子集的对应的子树的根
    private final int SIZE=7;//输入7个集合
    private int[] father;//the root in disjion set.

    private static List<Set<String>> resultList=new ArrayList<Set<String>>();

    public static void main(String[] args) {
        String[] str0={
                "aaa",
                "bbb",
                "ccc",};
        String[] str1={
                "bbb",
                "ddd",};
        String[] str2={
                "eee",
                "fff",};
        String[] str3={
                "ggg",};
        String[] str4={
                "ddd",
                "hhh",};
        String[] str5={
                "xx",
                "yy",};
        String[] str6={
                "zz",
                "yy",};
        String[][] strs={str0,str1,str2,str3,str4,str5,str6};
//        for (String str:strs[0]){
//            System.out.print(str+",");
//        }
//        System.out.println();
        //change String[][] to List<Set>
        for(String[] str:strs){
            //when I write--"Arraylist list=Arrays.asList(strArray)","addAll()" is unsupported for such a arraylist.
            Set<String> set=new HashSet<String>();
            set.addAll(Arrays.asList(str));
            resultList.add(set);
        }
        StringCombine disjointSet=new StringCombine();
        disjointSet.disjoin(strs);
    }

    public void disjoin(String[][] strings){
        if(strings==null||strings.length<2)return;
        //第一步:假定每个集合编号为0，1，2，3...初始化,
        initial();
        //第二步: 创建一个hash_map，key为字符串，value为一个链表，链表节点为字符串所在集合的编号。遍历所有的集合，将字符串和对应的集合编号插入到hash_map中去
        Map<String,List<Integer>> map = storeInHashMap(strings);
        //第三部
        union(map);
    }

    //in the beginning,each element is in its own "group".
    public void initial(){
        father = new int[SIZE];
        for(int i=0;i<SIZE;i++){
            father[i]=i; //假定每个集合编号为0，1，2，3...
        }
    }

    /*Map<k,v>
     * key:String
     * value:List<Integer>-in which sets the string shows up.
     * 创建一个hash_map，key为字符串，value为一个链表，链表节点为字符串所在集合的编号。遍历所有的集合，将字符串和对应的集合编号插入到hash_map中去
     */
    public Map<String,List<Integer>> storeInHashMap(String[][] strings){
        Map<String,List<Integer>> map = new HashMap<String,List<Integer>>();
        //i=0; strings[0]={"aaa","bbb","ccc"}
        for(int i=0;i<SIZE;i++){
            for(String each:strings[i]){
                if(!map.containsKey(each)){
                    List<Integer> list=new ArrayList<Integer>();
                    list.add(i);
                    map.put(each, list);
                }else{
                    map.get(each).add(i);
                }
            }
        }
        /*
        list中值相同的合并, [0],[0],[0,1],[1,4],[4]合并后为:{aaa,bbb,ccc,ddd,hhh}
                          [2],[2]合并后为:{eee,fff}
                          [3]合并后为:{ggg}
                          [5],[5,6],[6]合并后为:{xx,yy,zz}
        aaa:[0]:在第一个只出现在一个集合里
        xx:[5]
        yy:[5, 6]
        zz:[6]
        ccc:[0]
        bbb:[0, 1]:在第一个和第二个集合里出现
        eee:[2]
        ddd:[1, 4]:在第二个和第四个集合里出现
        ggg:[3]
        fff:[2]
        hhh:[4]
         */
        //traverse the hashmap:
        //HashMap散列图、Hashtable散列表是按“有利于随机查找的散列(hash)的顺序”。
        //并非按输入顺序。遍历时只能全部输出，而没有顺序。甚至可以rehash()重新散列，来获得更利于随机存取的内部顺序。
        //遍历HashMap或Hashtable时不要求顺序输出，即与顺序无关
        //可以用java.util.LinkedHashMap 就是按加入时的顺序遍历了
        Iterator<Map.Entry<String, List<Integer>>> it=map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, List<Integer>> entry=it.next();
            String key=entry.getKey();
            List<Integer> value=entry.getValue();
            System.out.println(key+":"+value);

        }
        return map;
    }

    //并查集
    public void union(Map<String,List<Integer>> map){
        Iterator<Map.Entry<String, List<Integer>>> it=map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, List<Integer>> entry=it.next();
            List<Integer> value=entry.getValue();
//            System.out.println("ken...");
//            for (Integer v:value){
//                System.out.print(v);
//            }
            //value为map中对应的值,第一个对应为0;第二个为5;第三个为5,6; 第四个为6...
            unionHelp(value);//the arrays whose indexes are in the same list should be merged to one set.
        }
        //[0, 0, 2, 3, 0, 5, 5]; 原来的father={0,1,2,3,4,5,6}
        System.out.println("the father array is "+Arrays.toString(father));
        //merge two sets
        for(int i=0;i<SIZE;i++){
            //
            if(i!=father[i]){
                Set<String> dest=resultList.get(father[i]);
                Set<String> source=resultList.get(i);
                dest.addAll(source);//集合合并
            }
        }
        System.out.println("合并后未删除重复的:" + resultList);
        //clear a set which has been added.
        for(int i=0;i<SIZE;i++){
            if(i!=father[i]){
                resultList.get(i).clear();
            }
        }
        System.out.println("after merge:"+resultList);
    }

    //产生并查集:合并
    public void unionHelp(List<Integer> list){
        //father:{0,1,2,3,4,5,6,7}为每个子集的编号
        int minFather=getFather(list.get(0));//list[0] is the smaller.
        for(int i=0,size=list.size();i<size;i++){
            father[list.get(i)]=minFather;
        }
    }

//    //general union in disjoin set.But we overload it in this case.
//    public void unionHelp(int x,int y){
//        if(father[x]!=father[y]){
//            int fx=getFather(x);
//            int fy=getFather(y);
//            //merge two arrays to the array that has a smaller index.
//            if(fx<fy){
//                father[y]=fx;
//            }else{
//                father[x]=fy;
//            }
//
//        }
//    }

    public int getFather(int x){
        while(x!=father[x]){
            x=father[x];
        }
        return x;
    }
}
