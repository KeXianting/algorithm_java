package test.hash_map;

import java.util.IdentityHashMap;
import java.util.Map;

/**
 * Created by kentorvalds on 2017/8/8.
 */
public class IdentityHashMapDemo {

    /*
    1.两者最主要的区别是IdentityHashMap使用的是==比较key的值，而HashMap使用的是equals()
    2.HashMap使用的是hashCode()查找位置，IdentityHashMap使用的是System.identityHashCode(object)
    3.IdentityHashMap理论上来说速度要比HashMap快一点
    4.另外一点呢就是IdentityHashMap中key能重复，但需要注意一点的是key比较的方法是==，所以若要存放两个相同的key，就需要存放不同的地址
     */

    /*
    IdentityHashMap：此类利用哈希表实现 Map 接口，比较键（和值）时使用引用相等性代替对象相等性。
    换句话说，在 IdentityHashMap 中，当且仅当 (k1==k2) 时
    才认为两个键 k1 和 k2 相等、在正常 Map 实现（如 HashMap）中
    当且仅当满足下列条件时才认为两个键 k1 和 k2 相等：(k1==null ? k2==null : e1.equals(e2))

     */
    public static void main(String[] arg){

        Map identityMap = new IdentityHashMap();
        identityMap.put("a", 1);
        identityMap.put(new String("a"), 2);
        identityMap.put("a", 3);
        String bb = new String("a");
        identityMap.put(bb, 4);
        System.out.println("Identity Map KeySet Size :: " +  identityMap.keySet().size());
        //输出结果为Identity Map KeySet Size :: 2
        System.out.println("相同key的结果为:  " + identityMap.get("a"));
        System.out.println("相同key的结果为:  " + identityMap.get(bb));


        System.out.println(identityMap.toString());//{a=2,a=3}

        System.out.println(identityMap.keySet().size());

        System.out.println(identityMap.entrySet().contains(1));

        System.out.println("===========================================================");
//        IdentityHashMap<String,Object> map =new IdentityHashMap<String,Object>();
//        map.put(new String("xx"),"first");
//        map.put(new String("xx"),"second");
//        for (Map.Entry<String, Object> entry : map.entrySet()) {
//            System.out.print(entry.getKey() +"    ");
//            System.out.println(entry.getValue());
//        }
//        System.out.println("idenMap="+map.containsKey("xx"));
//        System.out.println("idenMap="+map.get("xx"));

        System.out.println("===========================================================");
//        IdentityHashMap<String,Object> map1 =new IdentityHashMap<String,Object>();
//        String fsString =new String("xx");
//        map1.put(fsString,"first");
//        map1.put(new String("xx"),"second");
//        for(Map.Entry<String, Object> entry : map1.entrySet()) {
//            System.out.print(entry.getKey() +"    ");
//            System.out.println(entry.getValue());
//        }
//        System.out.println("idenMap="+map1.containsKey(fsString));
//        System.out.println("idenMap="+map1.get(fsString));


        System.out.println("===========================================================");


//        IdentityHashMap<String,Object> map2 =new IdentityHashMap<String,Object>();
//        String fsString =new String("xx");
//        map.put(fsString,"first");
//        map.put(fsString,"second");
//        for(Entry<String, Object> entry : map.entrySet()) {
//            System.out.print(entry.getKey() +"    ");
//            System.out.println(entry.getValue());
//        }
//        System.out.println("idenMap="+map.containsKey(fsString));
//        System.out.println("idenMap="+map.get(fsString));


        System.out.println("===========================================================");
//        IdentityHashMap<String,Object> map =new IdentityHashMap<String,Object>();
//        String fsString =newString("xx");
//        String secString =newString("xx");
//        map.put(fsString,"first");
//        map.put(secString,"second");
//        for(Entry<String, Object> entry : map.entrySet()) {
//            System.out.print(entry.getKey() +"    ");
//            System.out.println(entry.getValue());
//        }
//        System.out.println("idenMap="+map.containsKey(fsString));
//        System.out.println("idenMap="+map.get(fsString));
//
//        System.out.println("idenMap="+map.containsKey(secString));
//        System.out.println("idenMap="+map.get(secString));


        System.out.println("===========================================================");
//        IdentityHashMap<String,Object> map =new IdentityHashMap<String,Object>();
//        map.put("xx","first");
//        map.put("xx","second");
//        for(Entry<String, Object> entry : map.entrySet()) {
//            System.out.print(entry.getKey() +"    ");
//            System.out.println(entry.getValue());
//        }














        System.out.println("===========================================================");

        String a = "hh";
        String b = "hh";
        String c = new String("hh");
        if (a == b){
            System.out.println("kkk");
        }else {
            System.out.println("xx");
        }

        if (a.equals(b)){
            System.out.println("kkk1");
        }else {
            System.out.println("xx1");
        }

        if (c == b){
            System.out.println("kkk2");
        }else {
            System.out.println("xx2");
        }

        if (c.equals(a)){
            System.out.println("kkk3");
        }else {
            System.out.println("xx3");
        }
    }
}
